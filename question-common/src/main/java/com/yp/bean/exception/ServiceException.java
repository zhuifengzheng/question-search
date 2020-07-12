package com.yp.bean.exception;

/**
 * @Author by yuanpeng
 * @Date 2020/7/5
 */
public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 274443827670458127L;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
