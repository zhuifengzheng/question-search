package com.yp.bean.request;

import lombok.Data;

/**
 * @Author by yuanpeng
 * @Date 2020/7/6
 */
@Data
public class QuestionRequest extends BaseRequest{

    private Long id;

    private String name;

    private String englishName;

    private String description;

    private String content;

    private String updateBy;

    private String createBy;


}
