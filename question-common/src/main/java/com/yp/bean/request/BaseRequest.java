package com.yp.bean.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author by yuanpeng
 * @Date 2020/7/6
 */
@Data
public class BaseRequest implements Serializable {
    private static final long serialVersionUID = 1804463254718183711L;

    private Integer pageIndex = 0;

    private Integer pageSize = 5;


    private String highlightedField;

    //也可以设置or
    private String searchType = "and";

    // 数据库索引，默认question
    private String index = "question";
}
