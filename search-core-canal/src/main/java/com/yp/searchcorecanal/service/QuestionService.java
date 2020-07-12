package com.yp.searchcorecanal.service;

import com.yp.bean.Question;

import java.util.List;

/**
 * @Author by yuanpeng
 * @Date 2020/7/5
 */
public interface QuestionService {
    int getCount();

    List<Question> getAll();

    List<Question> getAllByPage(int page, int size);
}
