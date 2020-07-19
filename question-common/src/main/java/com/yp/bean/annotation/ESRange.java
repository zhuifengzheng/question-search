package com.yp.bean.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ESRange {
    /**
     * es中的字段名
     * @return
     */
    String columnName() default "";

    /**
     * 范围上限 默认ture
     * @return
     */
    boolean from() default true;

    /**
     * 包不包括from()值 默认包括
     * @return
     */
    boolean includeLower() default true;

    /**
     * 范围下限 默认false
     * @return
     */
    boolean to() default false;

    /**
     * 包不包括to()值 默认包括
     * @return
     */
    boolean includeUpper() default true;
}
