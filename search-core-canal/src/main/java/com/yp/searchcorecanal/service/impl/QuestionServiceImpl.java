package com.yp.searchcorecanal.service.impl;

import com.yp.bean.Question;
import com.yp.searchcorecanal.mapper.QuestionMapper;
import com.yp.searchcorecanal.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author by yuanpeng
 * @Date 2020/7/5
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

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
}
