package com.dhc.ttshop.dao;

import com.zp.ttshop.pojo.po.TbItemParamItem;
import com.zp.ttshop.pojo.po.TbItemParamItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbItemParamItemMapper {
    int countByExample(TbItemParamItemExample example);

    int deleteByExample(TbItemParamItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbItemParamItem record);

    int insertSelective(TbItemParamItem record);

    List<TbItemParamItem> selectByExample(TbItemParamItemExample example);

    int updateByExampleSelective(@Param("record") TbItemParamItem record, @Param("example") TbItemParamItemExample example);

    int updateByExample(@Param("record") TbItemParamItem record, @Param("example") TbItemParamItemExample example);
}