package com.zhoujl.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.zhoujl.dao.OrderMapper;
import com.zhoujl.pojo.Order;
import com.zhoujl.util.MyBatisSqlSessionFactory;
	
public class OrderService implements OrderMapper {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public List<Order> findAllOrders() {
		logger.debug("findAllOrders");
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		try {
			OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
			return orderMapper.findAllOrders();
		} finally {
			sqlSession.close();
		}
	}

	public Order findOrderById(int id) {
		logger.debug("findOrderById: " + id);
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		try {
			OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
			return orderMapper.findOrderById(id);
		} finally {
			sqlSession.close();
		}
	}

	public void insertOrder(Order order) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		try {
			OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
			orderMapper.insertOrder(order);
			sqlSession.commit();
			
			logger.debug("insertOrder succ!");
		} finally {
			sqlSession.close();
		}
		
	}

	public void updateOrder(Order order) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		try {
			OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
			orderMapper.updateOrder(order);
			sqlSession.commit();
			
			logger.debug("updateOrder succ!");
		} finally {
			sqlSession.close();
		}
		
	}

	public void deleteOrder(int id) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		try {
			OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
			orderMapper.deleteOrder(id);
			sqlSession.commit();
			
			logger.debug("deleteOrder succ!");
		} finally {
			sqlSession.close();
		}
	}

}
