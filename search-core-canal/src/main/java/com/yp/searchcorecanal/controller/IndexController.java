package com.yp.searchcorecanal.controller;

import com.yp.bean.reponse.base.ResultReponse;
import com.yp.bean.util.ResultGenerate;
import com.yp.searchcorecanal.config.EsProperties;
import com.yp.searchcorecanal.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author by yuanpeng
 * @Date 2020/7/5
 */
@RequestMapping("/index")
@RestController
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping("/all")
    public ResultReponse generateIndex(){
        indexService.generateIndex();
        return ResultGenerate.success();
    }

    @RequestMapping("/all/most")
    public ResultReponse generateIndexAndSize(int size){
        indexService.generateIndex(size);
        return ResultGenerate.success();
    }
}
