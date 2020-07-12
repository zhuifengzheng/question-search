package com.yp.bean.util;

import com.yp.bean.reponse.base.ResultCode;
import com.yp.bean.reponse.base.ResultReponse;

/**
 * @Author by yuanpeng
 * @Date 2020/7/5
 */
public class ResultGenerate {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static ResultReponse success() {
        return new ResultReponse()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static ResultReponse success(Object data) {
        return new ResultReponse()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static ResultReponse fail(String message) {
        return new ResultReponse()
                .setCode(ResultCode.SERVER_ERROR)
                .setMessage(message);
    }
}
