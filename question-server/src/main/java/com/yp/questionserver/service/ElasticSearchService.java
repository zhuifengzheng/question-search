package com.yp.questionserver.service;

import com.yp.bean.reponse.QuestionInfo;
import com.yp.bean.request.Paging;
import com.yp.bean.request.QuestionRequest;

import java.util.List;

/**
 * @Author by yuanpeng
 * @Date 2020/7/6
 */
public interface ElasticSearchService {
    /**
     *
     * @param request
     * @return
     */
    Paging<List<QuestionInfo>> search(QuestionRequest request);
}
