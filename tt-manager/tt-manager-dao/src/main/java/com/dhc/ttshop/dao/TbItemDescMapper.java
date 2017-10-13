package com.dhc.ttshop.dao;

import com.zp.ttshop.pojo.po.TbItemDesc;
import com.zp.ttshop.pojo.po.TbItemDescExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbItemDescMapper {
    int countByExample(TbItemDescExample example);

    int deleteByExample(TbItemDescExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbItemDesc record);

    int insertSelective(TbItemDesc record);

    List<TbItemDesc> selectByExample(TbItemDescExample example);

    int updateByExampleSelective(@Param("record") TbItemDesc record, @Param("example") TbItemDescExample example);

    int updateByExample(@Param("record") TbItemDesc record, @Param("example") TbItemDescExample example);
}