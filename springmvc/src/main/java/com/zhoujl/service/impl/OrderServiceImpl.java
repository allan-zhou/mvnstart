package com.zhoujl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhoujl.mapper.MemberMapper;
import com.zhoujl.mapper.OrderMapper;
import com.zhoujl.pojo.Order;
import com.zhoujl.service.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderMapper orderMapper;
	
	@Autowired
	MemberMapper memberMapper;
	
	public Order getOrderById(int id) {
		return orderMapper.findOrderById(id);
	}

	public List<Order> getOrders() {
		return orderMapper.findAllOrders();
	}

	public void addOrder(Order order) {
		orderMapper.insertOrder(order);
		memberMapper.increaseOrderNumber(order.getMemberId());
	}

	public void updateOrder(Order order) {
		orderMapper.updateOrder(order);
	}

	public void deleteOrderById(int id) {
		orderMapper.deleteOrder(id);
	}

}
