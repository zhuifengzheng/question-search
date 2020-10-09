package io.terminus.jumax.uc.starter.dao;

import io.terminus.jumax.uc.starter.model.JucChannelStatis;
import io.terminus.jumax.uc.starter.model.JucChannelStatisExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JucChannelStatisMapper {
    long countByExample(JucChannelStatisExample example);

    int deleteByExample(JucChannelStatisExample example);

    int deleteByPrimaryKey(Long id);

    int insert(JucChannelStatis record);

    int insertSelective(JucChannelStatis record);

    List<JucChannelStatis> selectByExample(JucChannelStatisExample example);

    JucChannelStatis selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") JucChannelStatis record, @Param("example") JucChannelStatisExample example);

    int updateByExample(@Param("record") JucChannelStatis record, @Param("example") JucChannelStatisExample example);

    int updateByPrimaryKeySelective(JucChannelStatis record);

    int updateByPrimaryKey(JucChannelStatis record);
}