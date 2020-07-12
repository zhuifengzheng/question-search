package com.yp.bean.reponse.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author by yuanpeng
 * @Date 2020/7/5
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultReponse implements Serializable {
    private static final long serialVersionUID = -1346562044785889423L;

    private Integer code;
    private String message;
    private Object data;

    public ResultReponse setCode(ResultCode resultCode){
        this.code = resultCode.code();
        return this;
    }

    public ResultReponse setMessage(String message){
        this.message = message;
        return this;
    }

    public ResultReponse setData(Object data){
        this.data = data;
        return this;
    }

}
