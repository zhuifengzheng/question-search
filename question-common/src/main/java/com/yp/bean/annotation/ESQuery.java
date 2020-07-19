package com.yp.bean.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ESQuery {
    /**
     * es的index
     * @return
     */
    String index() default "";

    /**
     * es的type兼容老版本es
     * @return
     */
    String type() default "";
}
