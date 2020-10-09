package io.terminus.jumax.uc.starter.dao;

import io.terminus.jumax.uc.starter.model.JucUserShopProjectRelations;
import io.terminus.jumax.uc.starter.model.JucUserShopProjectRelationsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JucUserShopProjectRelationsMapper {
    long countByExample(JucUserShopProjectRelationsExample example);

    int deleteByExample(JucUserShopProjectRelationsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(JucUserShopProjectRelations record);

    int insertSelective(JucUserShopProjectRelations record);

    List<JucUserShopProjectRelations> selectByExample(JucUserShopProjectRelationsExample example);

    JucUserShopProjectRelations selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") JucUserShopProjectRelations record, @Param("example") JucUserShopProjectRelationsExample example);

    int updateByExample(@Param("record") JucUserShopProjectRelations record, @Param("example") JucUserShopProjectRelationsExample example);

    int updateByPrimaryKeySelective(JucUserShopProjectRelations record);

    int updateByPrimaryKey(JucUserShopProjectRelations record);
}