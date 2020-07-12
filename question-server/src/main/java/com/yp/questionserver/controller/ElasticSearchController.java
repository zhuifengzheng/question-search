package com.yp.questionserver.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yp.bean.reponse.QuestionInfo;
import com.yp.bean.reponse.base.ResultReponse;
import com.yp.bean.request.QuestionRequest;
import com.yp.bean.util.ResultGenerate;
import com.yp.questionserver.service.ElasticSearchService;
import com.yp.questionserver.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResultReponse search(QuestionRequest request){
        return ResultGenerate.success(elasticSearchService.search(request));
    }

//    @GetMapping
//    public ResultReponse list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size) {
//        PageHelper.startPage(page, size);
//        List<QuestionInfo> list = questionService.findAll();
//        PageInfo pageInfo = new PageInfo(list);
//        return ResultGenerate.success(pageInfo);
//    }

    @PostMapping("add")
    public ResultReponse add(@RequestBody QuestionRequest request) {
        boolean result = questionService.save(request);
        return ResultGenerate.success(result);
    }

    @DeleteMapping("/{id}")
    public ResultReponse delete(@PathVariable Long id) {
        boolean result = questionService.deleteById(id);
        return ResultGenerate.success(result);
    }

    @PutMapping("update")
    public ResultReponse update(@RequestBody QuestionRequest request) {
        boolean result = questionService.update(request);
        return ResultGenerate.success(result);
    }
    @RequestMapping("test")
    public ResultReponse test(QuestionRequest request){
        return ResultGenerate.success("test");
    }

}
