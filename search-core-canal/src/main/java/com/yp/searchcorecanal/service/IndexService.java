package com.yp.searchcorecanal.service;

/**
 * @Author by yuanpeng
 * @Date 2020/7/5
 */
public interface IndexService {
    /**
     * 建立索引
     */
    boolean generateIndex();

    /**
     * 数据量大时，这里采用多线程方式，通过size来限制一个线程建立索引的个数
     * @param size
     * @return
     */
    boolean generateIndex(int size);
}
