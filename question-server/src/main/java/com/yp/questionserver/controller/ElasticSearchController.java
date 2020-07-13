package com.yp.questionserver.controller;

import com.yp.bean.reponse.base.ResultReponse;
import com.yp.bean.request.QuestionRequest;
import com.yp.bean.util.ResultGenerate;
import com.yp.questionserver.service.ElasticSearchService;
import com.yp.questionserver.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author by yuanpeng
 * @Date 2020/7/6
 */
@RequestMapping("es")
@RestController
public class ElasticSearchController {

    @Autowired
    private ElasticSearchService elasticSearchService;

    @Autowired
    private QuestionService questionService;

    @RequestMapping("search")
    public ResultReponse search(QuestionRequest request) {
        return ResultGenerate.success(elasticSearchService.search(request));
    }

    @PostMapping("add")
    public ResultReponse add(@RequestBody QuestionRequest request) {
        boolean result = questionService.save(request);
        return ResultGenerate.success(result);
    }

    @DeleteMapping("{id}")
    public ResultReponse delete(@PathVariable Long id) {
        boolean result = questionService.deleteById(id);
        return ResultGenerate.success(result);
    }

    @PutMapping("update")
    public ResultReponse update(@RequestBody QuestionRequest request) {
        boolean result = questionService.update(request);
        return ResultGenerate.success(result);
    }


}
