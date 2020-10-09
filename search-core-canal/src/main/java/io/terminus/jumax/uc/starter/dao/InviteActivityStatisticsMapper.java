package io.terminus.jumax.uc.starter.dao;

import io.terminus.jumax.uc.starter.model.InviteActivityStatistics;
import io.terminus.jumax.uc.starter.model.InviteActivityStatisticsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InviteActivityStatisticsMapper {
    long countByExample(InviteActivityStatisticsExample example);

    int deleteByExample(InviteActivityStatisticsExample example);

    int deleteByPrimaryKey(Long inviteActivityStatisticsId);

    int insert(InviteActivityStatistics record);

    int insertSelective(InviteActivityStatistics record);

    List<InviteActivityStatistics> selectByExample(InviteActivityStatisticsExample example);

    InviteActivityStatistics selectByPrimaryKey(Long inviteActivityStatisticsId);

    int updateByExampleSelective(@Param("record") InviteActivityStatistics record, @Param("example") InviteActivityStatisticsExample example);

    int updateByExample(@Param("record") InviteActivityStatistics record, @Param("example") InviteActivityStatisticsExample example);

    int updateByPrimaryKeySelective(InviteActivityStatistics record);

    int updateByPrimaryKey(InviteActivityStatistics record);
}