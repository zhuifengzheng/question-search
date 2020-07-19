package com.yp.bean.annotation;

import java.lang.annotation.*;

/**
 * 对应es字段类型为keyword的查询
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ESTerm {
    /**
     * es中的字段名
     * @return
     */
    String columnName() default "";

    /**
     * 分割符
     * @return
     */
    String separator() default "";

    /**
     * 等值查询还是不等,BoolQueryBuilder.must\BoolQueryBuilder.mustNot
     * @return
     */
    boolean equals() default true;
}
