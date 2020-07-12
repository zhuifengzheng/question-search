package com.yp.bean.reponse;

import lombok.Data;

import java.util.Date;

/**
 * @Author by yuanpeng
 * @Date 2020/7/6
 */
@Data
public class QuestionInfo extends BaseInfo{

    private Long id;

    private String name;

    private String englishName;

    private String description;

    private String content;

    private String createBy;

    private String updateBy;

    private Date createTime;

    private Date updateTime;
}
