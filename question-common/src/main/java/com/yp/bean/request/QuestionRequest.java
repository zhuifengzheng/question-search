package com.yp.bean.request;

import com.yp.bean.annotation.ESMatch;
import com.yp.bean.annotation.ESQuery;
import com.yp.bean.annotation.ESQueryString;
import com.yp.bean.annotation.ESRange;
import lombok.Data;

/**
 * @Author by yuanpeng
 * @Date 2020/7/6
 */
@Data
@ESQuery
public class QuestionRequest extends BaseRequest{

    private Long id;

    @ESMatch(columnName = "name")
    private String name;

    @ESMatch(columnName = "english_name")
    private String englishName;

    @ESMatch(columnName = "description")
    private String description;

    @ESQueryString(columnName = "content")
    private String content;

    private String updateBy;

    private String createBy;

    @ESRange(columnName = "update_time", from = true, includeLower = true)
    private String updateTime;


    @ESRange(columnName = "update_time", to = true, includeLower = true)
    private String updateTime2;
}
