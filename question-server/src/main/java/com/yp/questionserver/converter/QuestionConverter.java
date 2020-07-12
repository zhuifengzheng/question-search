package com.yp.questionserver.converter;

import com.yp.bean.Question;
import com.yp.bean.request.QuestionRequest;
import org.mapstruct.Mapper;

/**
 * @Author by yuanpeng
 * @Date 2020/7/12
 */
@Mapper(componentModel = "spring")
public interface QuestionConverter {
    Question request2domain(QuestionRequest request);
}
