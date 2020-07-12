package com.yp.questionserver.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.yp.bean.reponse.QuestionInfo;
import com.yp.bean.request.Paging;
import com.yp.bean.request.QuestionRequest;
import com.yp.questionserver.service.ElasticSearchService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author by yuanpeng
 * @Date 2020/7/6
 */
@Service
@Slf4j
public class ElasticSearchServiceImpl implements ElasticSearchService {

    @Autowired
    private RestHighLevelClient highLevelClient;

    @Override
    public Paging<List<QuestionInfo>> search(QuestionRequest request) {
        // 创建查询请求
        SearchRequest searchRequest = new SearchRequest("question");
        searchRequest.types(new String[] {"index_question"});

        // 创建查询数据源
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // 设置查询字段与条件
        searchSourceBuilder.query(convertBuilder(request));

        if (StringUtils.hasText(request.getHighlightedField())) {
            searchSourceBuilder.highlighter(new HighlightBuilder().field(request.getHighlightedField()).preTags("<h1 style='red'>")
                    .postTags("</h1>"));
        }
        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        searchSourceBuilder.size(request.getPageSize());
        searchSourceBuilder.from(request.getPageIndex());
        //searchRequest.
        searchRequest.source(searchSourceBuilder);

        try {
            SearchResponse search = highLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            return convertResponse(search, request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 构造查询条件
     * @param request
     * @return
     */
    private QueryBuilder convertBuilder(QuestionRequest request) {
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

        if (StringUtils.hasText(request.getDescription())) {
            boolQueryBuilder.must(QueryBuilders.matchQuery("description", request.getDescription()));
        }
        if (StringUtils.hasText(request.getName())) {
            boolQueryBuilder.must(QueryBuilders.matchQuery("name", request.getName()));
        }
        if (StringUtils.hasText(request.getEnglishName())) {
            boolQueryBuilder.must(QueryBuilders.matchQuery("english_name", request.getEnglishName()));
        }
        if (StringUtils.hasText(request.getDescription())) {
            boolQueryBuilder.must(QueryBuilders.matchQuery("description", request.getDescription()));

        }
        if (StringUtils.hasText(request.getContent())) {
            boolQueryBuilder.must(QueryBuilders.queryStringQuery("content:"+request.getContent()));
        }
        if (StringUtils.hasText(request.getUpdateBy())) {
            boolQueryBuilder.must(QueryBuilders.termQuery("update_by", request.getUpdateBy()));
        }
        boolQueryBuilder.must(QueryBuilders.matchAllQuery());
        return boolQueryBuilder;
    }

    /**
     * 结果转化
     * @param response
     * @param request
     * @return
     */
    public Paging<List<QuestionInfo>> convertResponse(SearchResponse response, QuestionRequest request) {
        long totalHits = response.getHits().getTotalHits();
        if (0 == totalHits){
            return new Paging<>();
        }
        List<QuestionInfo> resultInfo = Lists.newArrayList();
        if (response != null && response.getHits() != null) {
            String result;
            QuestionInfo info;
            for (SearchHit hit : response.getHits()) {
                info = new QuestionInfo();
                result = hit.getSourceAsString();
                if (StringUtils.hasText(result)) {
                    info = JSONObject.parseObject(result, QuestionInfo.class);
                }
                if (info != null) {
                    resultInfo.add(info);
                }
            }
        }
        return new Paging(totalHits,resultInfo,request.getPageSize());
    }
}
