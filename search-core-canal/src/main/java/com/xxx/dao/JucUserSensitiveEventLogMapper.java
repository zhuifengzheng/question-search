package com.xxx.dao;

import com.xxx.model.JucUserSensitiveEventLog;
import com.xxx.model.JucUserSensitiveEventLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JucUserSensitiveEventLogMapper {
    long countByExample(JucUserSensitiveEventLogExample example);

    int deleteByExample(JucUserSensitiveEventLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(JucUserSensitiveEventLog record);

    int insertSelective(JucUserSensitiveEventLog record);

    List<JucUserSensitiveEventLog> selectByExample(JucUserSensitiveEventLogExample example);

    JucUserSensitiveEventLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") JucUserSensitiveEventLog record, @Param("example") JucUserSensitiveEventLogExample example);

    int updateByExample(@Param("record") JucUserSensitiveEventLog record, @Param("example") JucUserSensitiveEventLogExample example);

    int updateByPrimaryKeySelective(JucUserSensitiveEventLog record);

    int updateByPrimaryKey(JucUserSensitiveEventLog record);
}