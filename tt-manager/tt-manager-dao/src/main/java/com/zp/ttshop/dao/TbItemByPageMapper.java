package com.zp.ttshop.dao;

import com.zp.common.Page;
import com.zp.ttshop.pojo.po.TbItem;

import java.util.List;

public interface TbItemByPageMapper {
   public List<TbItem> selectItemByPage(Page page);
   public long selectItemCount();
}