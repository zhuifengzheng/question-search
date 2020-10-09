package io.terminus.jumax.uc.starter.dao;

import io.terminus.jumax.uc.starter.model.InviteActivityDayStatistics;
import io.terminus.jumax.uc.starter.model.InviteActivityDayStatisticsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InviteActivityDayStatisticsMapper {
    long countByExample(InviteActivityDayStatisticsExample example);

    int deleteByExample(InviteActivityDayStatisticsExample example);

    int deleteByPrimaryKey(Long inviteActivityDayStatisticsId);

    int insert(InviteActivityDayStatistics record);

    int insertSelective(InviteActivityDayStatistics record);

    List<InviteActivityDayStatistics> selectByExample(InviteActivityDayStatisticsExample example);

    InviteActivityDayStatistics selectByPrimaryKey(Long inviteActivityDayStatisticsId);

    int updateByExampleSelective(@Param("record") InviteActivityDayStatistics record, @Param("example") InviteActivityDayStatisticsExample example);

    int updateByExample(@Param("record") InviteActivityDayStatistics record, @Param("example") InviteActivityDayStatisticsExample example);

    int updateByPrimaryKeySelective(InviteActivityDayStatistics record);

    int updateByPrimaryKey(InviteActivityDayStatistics record);
}