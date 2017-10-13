package com.dhc.ttshop.dao;

import com.zp.ttshop.pojo.po.TbItemParam;
import com.zp.ttshop.pojo.po.TbItemParamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbItemParamMapper {
    int countByExample(TbItemParamExample example);

    int deleteByExample(TbItemParamExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbItemParam record);

    int insertSelective(TbItemParam record);

    List<TbItemParam> selectByExample(TbItemParamExample example);

    int updateByExampleSelective(@Param("record") TbItemParam record, @Param("example") TbItemParamExample example);

    int updateByExample(@Param("record") TbItemParam record, @Param("example") TbItemParamExample example);
}