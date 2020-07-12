package com.yp.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author by yuanpeng
 * @Date 2020/7/5
 */
@Data
public class Question implements Serializable {
    private static final long serialVersionUID = 2181299677640046375L;

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
