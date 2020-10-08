package com.yp.questionserver.builder;

import com.yp.bean.annotation.*;
import com.yp.bean.exception.ServiceException;
import com.yp.bean.request.BaseRequest;
import org.apache.commons.lang.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 查询条件构造
 * @Author by yuanpeng
 * @Date 2020/7/18
 */
public class ElasticSearchQueryBuilder {


    public static QueryBuilder build(BaseRequest request) throws IllegalAccessException {
        // 拿到查询参数类
        Class<? extends BaseRequest> zClass = request.getClass();
        ESQuery esQuery = zClass.getAnnotation(ESQuery.class);

        if (Objects.isNull(esQuery)){
            throw new ServiceException("esquery annotation is not null");
        }

        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        // 拿到所有属性
        Field[] fields = zClass.getDeclaredFields();
        for (Field field : fields) {
            // 这里处理类型为private的属性
            int modifiers = field.getModifiers();
            if (!Modifier.isFinal(modifiers) && !Modifier.isStatic(modifiers) && Modifier.isPrivate(modifiers)){
                // 设置可修改
                field.setAccessible(true);
                // 拿到该属性的值
                Object value = field.get(request);
                // 如果属性有值，并且有注解
                if(null != value && field.getAnnotations().length != 0){
                    // es数据库对应的字段名
                    String columnName;
                    String[] splitValue;
                    if (field.isAnnotationPresent(ESMatch.class)) {
                        ESMatch esMatch = field.getAnnotation(ESMatch.class);
                        columnName = StringUtils.isEmpty(esMatch.columnName())?field.getName():esMatch.columnName();

                        boolQueryBuilder.must(QueryBuilders.matchQuery(columnName,value));
                    }else if (field.isAnnotationPresent(ESQueryString.class)){
                        ESQueryString esQueryString = field.getAnnotation(ESQueryString.class);
                        columnName = StringUtils.isEmpty(esQueryString.columnName())?field.getName():esQueryString.columnName();

                        boolQueryBuilder.must(QueryBuilders.queryStringQuery(columnName+":"+value));
                    }else if (field.isAnnotationPresent(ESTerm.class)){
                        ESTerm esTerm = field.getAnnotation(ESTerm.class);
                        columnName = StringUtils.isEmpty(esTerm.columnName())?field.getName():esTerm.columnName();
                        splitValue = ((String) value).split(esTerm.separator());

                        bulidTerm(boolQueryBuilder, field, value, columnName, esTerm, splitValue);
                    }else if (field.isAnnotationPresent(ESRange.class)){
                        ESRange esRange = field.getAnnotation(ESRange.class);
                        columnName = StringUtils.isEmpty(esRange.columnName())?field.getName():esRange.columnName();

                        RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery(columnName);
                        if(esRange.from()) {
                            rangeQueryBuilder.from(value).includeLower(esRange.includeLower());
                        }else if (esRange.to()){
                            rangeQueryBuilder.to(value).includeUpper(esRange.includeUpper());
                        }
                        boolQueryBuilder.filter(rangeQueryBuilder);
                        // boolQueryBuilder.must(rangeQueryBuilder);
                    }else if (field.isAnnotationPresent(ESLike.class)){
                        ESLike esLike = field.getAnnotation(ESLike.class);
                        columnName = StringUtils.isEmpty(esLike.columnName())?field.getName():esLike.columnName();

                        boolQueryBuilder.must(QueryBuilders.wildcardQuery(columnName,(String)value));
                    }
                }

            }

        }


        return boolQueryBuilder;
    }


    /**
     * 构造term查询条件
     * @param boolQueryBuilder
     * @param field
     * @param value
     * @param columnName
     * @param esTerm
     * @param splitValue
     */
    private static void bulidTerm(BoolQueryBuilder boolQueryBuilder, Field field,
                                  Object value, String columnName, ESTerm esTerm, String[] splitValue) {
        if (esTerm.equals()){
            if (!StringUtils.isEmpty(esTerm.separator()) && field.getType() == String.class){
                boolQueryBuilder.must(QueryBuilders.termsQuery(columnName, Arrays.stream(splitValue).map(String::toString).collect(Collectors.toList())));
            }else if (Collection.class.isAssignableFrom(field.getType())){
                boolQueryBuilder.must(QueryBuilders.termsQuery(columnName,(Collection)value));
            }else {
                boolQueryBuilder.must(QueryBuilders.termQuery(columnName, value));
            }
        }else {
            if (!StringUtils.isEmpty(esTerm.separator()) && field.getType() == String.class){
                boolQueryBuilder.mustNot(QueryBuilders.termsQuery(columnName, Arrays.stream(splitValue).map(String::toString).collect(Collectors.toList())));
            }else if (Collection.class.isAssignableFrom(field.getType())){
                boolQueryBuilder.mustNot(QueryBuilders.termsQuery(columnName,(Collection)value));
            }else {
                boolQueryBuilder.mustNot(QueryBuilders.termQuery(columnName, value));
            }
        }
    }
}
