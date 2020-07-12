package com.yp.questionserver.mapper;

import com.yp.bean.Question;
import com.yp.bean.request.QuestionRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author by yuanpeng
 * @Date 2020/7/5
 */
@Mapper
public interface QuestionMapper extends BaseMapper<Question> {

    //@Query("select count(*) from question")
    int getCount();

    List<Question> selectAll();

    List<Question> getAllByPage(int start, int size);

    boolean insert(Question request);

    boolean deleteByPrimaryKey(Long id);

    boolean updateByPrimaryKeySelective(Question request);
}
