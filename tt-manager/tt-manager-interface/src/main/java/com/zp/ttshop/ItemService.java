package com.zp.ttshop;

import com.zp.common.Page;
import com.zp.common.Result;
import com.zp.ttshop.pojo.po.TbItem;

/**
 * User: zhangpeng
 * Date: 2017/10/18
 * Time: 19:47
 * Version:V1.0
 */

public interface ItemService {
        public Result<TbItem> findItemByPage(Page page);

}
