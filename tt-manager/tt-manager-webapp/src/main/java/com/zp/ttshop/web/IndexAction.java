package com.zp.ttshop.web;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: zhangpeng
 * Date: 2017/10/17
 * Time: 22:34
 * Version:V1.0
 */
@Controller
@Scope("prototype")
public class IndexAction {
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/{page}")
    public String page(String page){
        return page;
    }
}