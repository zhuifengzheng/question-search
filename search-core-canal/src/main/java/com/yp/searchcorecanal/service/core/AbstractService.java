package com.yp.searchcorecanal.service.core;


import com.yp.searchcorecanal.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 基于通用MyBatis Mapper插件的Service接口的实现
 * @Author by yuanpeng
 * @Date 2020/7/5
 */
public abstract class AbstractService<T> implements Service<T> {

    @Autowired
    protected BaseMapper<T> mapper;



}

