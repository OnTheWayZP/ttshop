package com.dhc.ttshop.dao;

import com.zp.ttshop.pojo.po.TbContent;
import com.zp.ttshop.pojo.po.TbContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbContentMapper {
    int countByExample(TbContentExample example);

    int deleteByExample(TbContentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbContent record);

    int insertSelective(TbContent record);

    List<TbContent> selectByExample(TbContentExample example);

    int updateByExampleSelective(@Param("record") TbContent record, @Param("example") TbContentExample example);

    int updateByExample(@Param("record") TbContent record, @Param("example") TbContentExample example);
}