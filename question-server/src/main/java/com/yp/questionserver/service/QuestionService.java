package com.yp.questionserver.service;

import com.yp.bean.Question;
import com.yp.bean.request.QuestionRequest;

import java.util.List;

/**
 * @Author by yuanpeng
 * @Date 2020/7/5
 */
public interface QuestionService {
    int getCount();

    List<Question> getAll();

    List<Question> getAllByPage(int page, int size);

    boolean save(QuestionRequest request);

    boolean deleteById(Long id);

    boolean update(QuestionRequest request);
}
