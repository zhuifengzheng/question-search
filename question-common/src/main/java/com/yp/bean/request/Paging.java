package com.yp.bean.request;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @Author by yuanpeng
 * @Date 2020/7/12
 */
public class Paging<T> implements Serializable {
    private static final long serialVersionUID = 532599328364764222L;

    // 总条数
    private Long total;
    // 数据
    private List<T> data;
    // 总页数
    private Long pageCount;
    // 分页大小
    private Integer pageSize;

    public Paging() {
    }

    public Paging(Long total, List<T> data, Integer pageSize) {
        this.data = data;
        this.total = total;
        this.pageSize = pageSize;
        if (total > 0L && pageSize > 0) {
            long l = total % (long)pageSize;
            if (l == 0L) {
                this.pageCount = total / (long)pageSize;
            } else {
                this.pageCount = total / (long)pageSize + 1L;
            }
        } else {
            this.pageCount = 0L;
        }

    }

    public Paging(Long total, List<T> data) {
        this.data = data;
        this.total = total;
    }

    public List<T> getData() {
        return this.data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Long getTotal() {
        return this.total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Boolean isEmpty() {
        return Objects.equals(0L, this.total) || this.data == null || this.data.isEmpty();
    }

    public Long getPageCount() {
        return this.pageCount;
    }

    public Paging pageCount(Long pageCount) {
        this.pageCount = pageCount;
        return this;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public Paging pageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public static <T> Paging<T> empty(Class<T> clazz) {
        List<T> emptyList = Collections.emptyList();
        return new Paging(0L, emptyList);
    }

    public static <T> Paging<T> empty() {
        return new Paging(0L, Collections.emptyList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paging<?> paging = (Paging<?>) o;
        return Objects.equals(total, paging.total) &&
                Objects.equals(data, paging.data) &&
                Objects.equals(pageCount, paging.pageCount) &&
                Objects.equals(pageSize, paging.pageSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(total, data, pageCount, pageSize);
    }

    @Override
    public String toString() {
        return "Paging{" +
                "total=" + total +
                ", data=" + data +
                ", pageCount=" + pageCount +
                ", pageSize=" + pageSize +
                '}';
    }
}
