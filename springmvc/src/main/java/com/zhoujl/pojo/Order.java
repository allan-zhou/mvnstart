package com.zhoujl.pojo;

public class Order {
	private int orderId;
	private int memberId;
	private String orderNumber;
	private String goodsName;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", memberId=" + memberId + ", orderNumber=" + orderNumber + ", goodsName="
				+ goodsName + "]";
	}
	
}
