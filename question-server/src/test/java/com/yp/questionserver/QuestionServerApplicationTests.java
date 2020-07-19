package com.yp.questionserver;

import com.yp.bean.reponse.QuestionInfo;
import com.yp.bean.request.Paging;
import com.yp.bean.request.QuestionRequest;
import com.yp.questionserver.service.ElasticSearchService;
import com.yp.questionserver.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
public class QuestionServerApplicationTests {

    @Autowired
    private ElasticSearchService elasticSearchService;

    @Autowired
    private QuestionService questionService;

    @Test
    public void contextLoads() {
        QuestionRequest request = new QuestionRequest();
//        request.setName("测试1");
//        request.setContent("测试");
//        request.setEnglishName("test");
        request.setUpdateTime("2020-07-12 16:51:54");
        request.setUpdateTime2("2020-07-12 16:51:54");
        Paging<List<QuestionInfo>> search = elasticSearchService.search(request);
        System.out.println(search.getTotal());
        System.out.println(search.toString());
    }

    @Test
    public void testSave(){
        QuestionRequest request = new QuestionRequest();
        request.setName("测试name");
        request.setEnglishName("测试englishName");
        request.setDescription("测试描述");
        request.setContent("测试内容");
        request.setCreateBy("yp");
        request.setUpdateBy("yp");

        boolean save = questionService.save(request);
        Assert.isTrue(save,"插入数据失败");

    }

    @Test
    public void testUpdate(){
        QuestionRequest request = new QuestionRequest();
        request.setName("测试name");
        request.setEnglishName("测试englishName");
        request.setDescription("测试描述");
        request.setContent("测试内容");
        request.setCreateBy("yp");
        request.setUpdateBy("yp");

        request.setId(6L);

        boolean save = questionService.update(request);
        Assert.isTrue(save,"更新数据失败");

    }


}
