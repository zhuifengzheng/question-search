package com.yp.bean.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ESLike {
    /**
     * es中的字段名
     * @return
     */
    String columnName() default "";

}
