package com.yp.questionserver.service.impl;

import com.yp.bean.Question;
import com.yp.bean.request.QuestionRequest;
import com.yp.questionserver.converter.QuestionConverter;
import com.yp.questionserver.mapper.QuestionMapper;
import com.yp.questionserver.service.QuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author by yuanpeng
 * @Date 2020/7/5
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private QuestionConverter questionConverter;

    @Override
    public int getCount() {
        return questionMapper.getCount();
    }

    @Override
    public List<Question> getAll() {
        // 如果数据过多，那么这里可以另写一个分页处理
        return questionMapper.selectAll();
    }

    @Override
    public List<Question> getAllByPage(int page, int size) {
        int start = (page - 1) * size;
        return questionMapper.getAllByPage(start, size);
    }

    @Override
    public boolean save(QuestionRequest request) {
        Question question = questionConverter.request2domain(request);
        question.setCreateTime(new Date());
        question.setUpdateTime(new Date());

        return questionMapper.insert(question);
    }

    @Override
    public boolean deleteById(Long id) {
        return questionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public boolean update(QuestionRequest request) {
        Question question = questionConverter.request2domain(request);
        question.setUpdateTime(new Date());

        return questionMapper.updateByPrimaryKeySelective(question);
    }
}
