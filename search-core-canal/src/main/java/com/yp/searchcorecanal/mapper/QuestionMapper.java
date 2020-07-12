package com.yp.searchcorecanal.mapper;

import com.yp.bean.Question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author by yuanpeng
 * @Date 2020/7/5
 */
@Mapper
public interface QuestionMapper extends BaseMapper<Question>{

    //@Query("select count(*) from question")
    int getCount();

    List<Question> selectAll();

    List<Question> getAllByPage(int start, int size);
}
