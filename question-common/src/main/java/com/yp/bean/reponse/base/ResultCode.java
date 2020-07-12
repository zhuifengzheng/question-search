package com.yp.bean.reponse.base;

import lombok.AllArgsConstructor;

/**
 * @Author by yuanpeng
 * @Date 2020/7/5
 */
@AllArgsConstructor
public enum ResultCode {
    SUCCESS(200),
    UNAUTHORIZRD(401),
    NOT_FOUND(404),
    SERVER_ERROR(500);

    private int code;

    public int code(){
        return code;
    }
}
