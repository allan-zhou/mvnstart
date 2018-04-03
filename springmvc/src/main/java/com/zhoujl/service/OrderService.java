package com.zhoujl.service;

import java.util.List;

import com.zhoujl.pojo.Order;

public interface OrderService {
	Order getOrderById(int id);
	List<Order> getOrders();
	
	void addOrder(Order order);
	void updateOrder(Order order);
	void deleteOrderById(int id);
}
