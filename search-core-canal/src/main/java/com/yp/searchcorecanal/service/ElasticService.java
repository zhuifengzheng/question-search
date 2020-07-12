package com.yp.searchcorecanal.service;

import java.util.List;
import java.util.Map;

/**
 * @Author by yuanpeng
 * @Date 2020/7/5
 */
public interface ElasticService {

	boolean addBulkIn(List<Map<String, Object>> datas,String index);

}
