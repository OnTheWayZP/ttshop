package com.zp.ttshop.web;

import com.zp.common.Order;
import com.zp.common.Page;
import com.zp.common.Result;
import com.zp.ttshop.ItemService;
import com.zp.ttshop.pojo.vo.TbItemCatCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

//    @ResponseBody
//    @RequestMapping("/items")
//    public Result<TbItem> listItems(Page page){
//        return itemService.findItemByPage(page);
//    }
    @ResponseBody
    @RequestMapping("/items")
    public Result<TbItemCatCustom> listItemsCustom(Page page,Order order){
        return itemService.findItemCatByPage(page,order);
    }
    @ResponseBody
    @RequestMapping(value = "/items/batch",method = RequestMethod.POST)
    public int modifyItems(@RequestParam("ids[]") List<Long> ids){
        return itemService.modifyItems(ids);
    }
    @ResponseBody
    @RequestMapping(value = "/items/up",method = RequestMethod.POST)
    public int modifyItemsUp(@RequestParam("ids[]") List<Long> ids){
        return itemService.modifyItemsUp(ids);
    }
    @ResponseBody
    @RequestMapping(value = "/items/down",method = RequestMethod.POST)
    public int modifyItemsDown(@RequestParam("ids[]") List<Long> ids){
        return itemService.modifyItemsDown(ids);
    }
}