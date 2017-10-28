package com.zp.ttshop.service.impl;


import com.zp.common.util.IdWorker;
import com.zp.common.util.OrderStatusEnum;
import com.zp.ttshop.OrdersService;
import com.zp.ttshop.dao.FlowMapper;
import com.zp.ttshop.dao.OrdersMapper;
import com.zp.ttshop.pojo.po.Flow;
import com.zp.ttshop.pojo.po.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;



@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrdersMapper ordersMapper;
	
	@Autowired
	private FlowMapper flowMapper;

	
	@Override
	public void saveOrder(Orders order) {
		ordersMapper.insert(order);
	}

	@Override
	public Orders getOrderById(String orderId) {
		return ordersMapper.selectByPrimaryKey(orderId);
	}

	@Override
	public void updateOrderStatus(String orderId, String alpayFlowNum, String paidAmount) {
		
		Orders order = getOrderById(orderId);
		if (order.getOrderStatus().equals(OrderStatusEnum.WAIT_PAY.key)) {
			order = new Orders();
			order.setId(orderId);
			order.setOrderStatus(OrderStatusEnum.PAID.key);
			order.setPaidTime(new Date());
			order.setPaidAmount(paidAmount);
			
			ordersMapper.updateByPrimaryKeySelective(order);
			
			order = getOrderById(orderId);
			IdWorker idWorker = new IdWorker();
			long l = idWorker.nextId();
			String flowId= "p"+l;

			Flow flow = new Flow();
			flow.setId(flowId);
			flow.setFlowNum(alpayFlowNum);
			flow.setBuyCounts(order.getBuyCounts());
			flow.setCreateTime(new Date());
			flow.setOrderNum(orderId);
			flow.setPaidAmount(paidAmount);
			flow.setPaidMethod(1);
			flow.setProductId(order.getProductId());
			
			flowMapper.insertSelective(flow);
		}
		
	}

}
