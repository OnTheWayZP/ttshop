package com.zp.ttshop.dao;

import com.zp.common.Page;
import com.zp.ttshop.pojo.po.TbItem;
import com.zp.ttshop.pojo.vo.TbItemCatCustom;

import java.util.List;
import java.util.Map;

public interface TbItemByPageMapper {
   public List<TbItem> selectItemByPage(Page page);
   public long selectItemCount(Map<String,Object> map);
   List<TbItemCatCustom> selectTbItemCatByPage(Map<String,Object> map);
}