package com.zhoujl.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhoujl.constant.ApiResult;
import com.zhoujl.pojo.Order;
import com.zhoujl.service.OrderService;

@Controller
@RequestMapping("/api/orders")
public class OrderApi {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private OrderService service;

	@RequestMapping(method = RequestMethod.GET, produces = { "application/json; charset=utf-8" })
	@ResponseBody
	public String getOrders() throws JsonProcessingException {
		List<Order> orders = service.findAllOrders();

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(orders);
		return json;
	}

	/*
	 * demo: /api/orders/1
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json; charset=utf-8" })
	@ResponseBody
	public String getOrderById(@PathVariable("id") int id) throws JsonProcessingException {
		logger.debug(String.valueOf(id));

		OrderService service = new OrderService();
		Order order = service.findOrderById(id);

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(order);
		return json;
	}

	@RequestMapping(method = RequestMethod.POST, consumes = { "application/json" }, produces = {"application/json; charset=utf-8" })
	@ResponseBody
	public String createOrder(@RequestBody Order order) throws JsonProcessingException {
		logger.debug(order.toString());

		service.insertOrder(order);

		ObjectMapper mapper = new ObjectMapper();
		ApiResult apiResult = new ApiResult();
		apiResult.setResultCode(200);
		apiResult.setMessage("ok");
		String json = mapper.writeValueAsString(apiResult);
		return json;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = { "application/json" }, produces = {"application/json; charset=utf-8" })
	@ResponseBody
	public String updateOrder(@PathVariable("id") int id, @RequestBody Order order) throws JsonProcessingException {
		logger.debug(order.toString());

		Order oldOrder = service.findOrderById(id);

		if (order.getMemberId() != 0) {
			oldOrder.setMemberId(order.getMemberId());
		}
		if (order.getOrderNumber() != null) {
			oldOrder.setOrderNumber(order.getOrderNumber());
		}
		if (order.getGoodsName() != null) {
			oldOrder.setGoodsName(order.getGoodsName());
		}
		service.updateOrder(oldOrder);

		ObjectMapper mapper = new ObjectMapper();
		ApiResult apiResult = new ApiResult();
		apiResult.setResultCode(200);
		apiResult.setMessage("ok");
		String json = mapper.writeValueAsString(apiResult);
		return json;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = { "application/json" }, produces = {"application/json; charset=utf-8" })
	@ResponseBody
	public String deleteOrder(@PathVariable("id") int id) throws JsonProcessingException {

		service.deleteOrder(id);

		ObjectMapper mapper = new ObjectMapper();
		ApiResult apiResult = new ApiResult();
		apiResult.setResultCode(200);
		apiResult.setMessage("ok");
		String json = mapper.writeValueAsString(apiResult);
		return json;
	}
}
