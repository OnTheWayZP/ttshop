package com.zp.ttshop.web;

import com.zp.common.Page;
import com.zp.common.Result;
import com.zp.ttshop.ItemService;
import com.zp.ttshop.pojo.po.TbItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: zhangpeng
 * Date: 2017/10/18
 * Time: 19:56
 * Version:V1.0
 */
@Controller
@Scope("prototype")
public class ItemAction {
    @Autowired
    private ItemService itemService;

    @ResponseBody
    @RequestMapping("/items")
    public Result<TbItem> listItems(Page page){
        return itemService.findItemByPage(page);
    }

}