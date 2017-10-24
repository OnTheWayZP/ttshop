package com.zp.ttshop.service.impl;

import com.zp.common.Order;
import com.zp.common.Page;
import com.zp.common.Result;
import com.zp.ttshop.ItemService;
import com.zp.ttshop.dao.TbItemByPageMapper;
import com.zp.ttshop.dao.TbItemMapper;
import com.zp.ttshop.pojo.po.TbItem;
import com.zp.ttshop.pojo.po.TbItemExample;
import com.zp.ttshop.pojo.vo.TbItemCatCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    TbItemMapper tbItemMapper;

    @Override
    public Result<TbItem> findItemByPage(Page page) {
        long total = tbItemByPageMapper.selectItemCount();
        List<TbItem> rows = tbItemByPageMapper.selectItemByPage(page);
        Result<TbItem> result = new Result<TbItem>();
        result.setRows(rows);
        result.setTotal(total);
       return result;
    }

    @Override
    public Result<TbItemCatCustom> findItemCatByPage(Page page, Order order) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("page",page);
        map.put("order",order);
        Result<TbItemCatCustom> rs = new Result<TbItemCatCustom>();
        long total = tbItemByPageMapper.selectItemCount();
        List<TbItemCatCustom> rows = tbItemByPageMapper.selectTbItemCatByPage(map);
        rs.setTotal(total);
        rs.setRows(rows);
        return rs;
    }

    @Override
    public int modifyItems(List<Long> ids) {
        TbItem item = new TbItem();
        item.setStatus((byte)3);
        //下面三行是准备查询条件
        TbItemExample tbItemExample = new TbItemExample();
        TbItemExample.Criteria criteria = tbItemExample.createCriteria();
        criteria.andIdIn(ids);
        return tbItemMapper.updateByExampleSelective(item,tbItemExample);
    }
    @Override
    public int modifyItemsUp(List<Long> ids) {
        TbItem item = new TbItem();
        item.setStatus((byte)1);
        //下面三行是准备查询条件
        TbItemExample tbItemExample = new TbItemExample();
        TbItemExample.Criteria criteria = tbItemExample.createCriteria();
        criteria.andIdIn(ids);
        return tbItemMapper.updateByExampleSelective(item,tbItemExample);
    }
    @Override
    public int modifyItemsDown(List<Long> ids) {
        TbItem item = new TbItem();
        item.setStatus((byte)2);
        //下面三行是准备查询条件
        TbItemExample tbItemExample = new TbItemExample();
        TbItemExample.Criteria criteria = tbItemExample.createCriteria();
        criteria.andIdIn(ids);
        return tbItemMapper.updateByExampleSelective(item,tbItemExample);
    }
}
