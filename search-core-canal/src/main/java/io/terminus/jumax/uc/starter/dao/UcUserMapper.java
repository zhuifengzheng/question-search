package io.terminus.jumax.uc.starter.dao;

import io.terminus.jumax.uc.starter.model.UcUser;
import io.terminus.jumax.uc.starter.model.UcUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UcUserMapper {
    long countByExample(UcUserExample example);

    int deleteByExample(UcUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UcUser record);

    int insertSelective(UcUser record);

    List<UcUser> selectByExample(UcUserExample example);

    UcUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UcUser record, @Param("example") UcUserExample example);

    int updateByExample(@Param("record") UcUser record, @Param("example") UcUserExample example);

    int updateByPrimaryKeySelective(UcUser record);

    int updateByPrimaryKey(UcUser record);
}