package com.yp.bean.annotation;

import java.lang.annotation.*;

/**
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ESQueryString {
    /**
     * es中的字段名
     * @return
     */
    String columnName() default "";

    /**
     * 分词器  standard、english、ik_max_word、ik_smart
     * @return
     */
    String analyzer() default "";
}
