package com.zp.ttshop;

import com.zp.common.Order;
import com.zp.common.Page;
import com.zp.common.Result;
import com.zp.ttshop.pojo.po.TbItem;
import com.zp.ttshop.pojo.vo.TbItemCatCustom;

import java.util.List;

/**
 * User: zhangpeng
 * Date: 2017/10/18
 * Time: 19:47
 * Version:V1.0
 */

public interface ItemService {
        public Result<TbItem> findItemByPage(Page page);
        public Result<TbItemCatCustom> findItemCatByPage(Page page, Order order);
        int modifyItems(List<Long> ids);
        int modifyItemsUp(List<Long> ids);
        int modifyItemsDown(List<Long> ids);
}
