package com.zp.ttshop.web;

import com.zp.ttshop.UserService;
import com.zp.ttshop.pojo.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * 
 * @Title: UserController.java
 * @Package com.itzixi.controller
 * @Description: 用户controller
 * Copyright: Copyright (c) 2016
 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
 * 
 * @author leechenxiang
 * @date 2017年8月17日 下午8:39:47
 * @version V1.0
 */
@Controller
@RequestMapping("/user")
public class UserAction {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/list")
	public ModelAndView products() throws Exception {
		
		List<User> userList = userService.getUserList();
		
		ModelAndView model = new ModelAndView("user");
		model.addObject("userList", userList);
		
		return model;
	}
	
}
