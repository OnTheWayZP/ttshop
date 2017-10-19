package com.zp.ttshop.service.impl;

import com.zp.common.Page;
import com.zp.common.Result;
import com.zp.ttshop.ItemService;
import com.zp.ttshop.dao.TbItemByPageMapper;
import com.zp.ttshop.pojo.po.TbItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.lang.annotation.Target;
import java.util.List;

/**
 * User: zhangpeng
 * Date: 2017/10/18
 * Time: 19:50
 * Version:V1.0
 */
@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    TbItemByPageMapper tbItemByPageMapper;

    @Override
    public Result<TbItem> findItemByPage(Page page) {
        long total = tbItemByPageMapper.selectItemCount();
        List<TbItem> rows = tbItemByPageMapper.selectItemByPage(page);
        Result<TbItem> result = new Result<TbItem>();
        result.setRows(rows);
        result.setTotal(total);
       return result;
    }

}
