package com.zhoujl.dao;

import java.util.List;

import com.zhoujl.pojo.Order;

public interface OrderMapper {
	List<Order> findAllOrders();
	Order findOrderById(int id);
	
	void insertOrder(Order order);
    void updateOrder(Order order);
    void deleteOrder(int id);
}
