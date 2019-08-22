package com.lanqiao.domain;

import java.io.Serializable;

public class OrderForm implements Serializable{
	private static final long serialVersionUID = 1L;

	/** 订单编号 */
	private String orderId;
	/** 订单信息 */
	private ShoppingCart shoppingCart;
	/** 订单地址 */
	private Address address;
	/** 订单总金额 */
	private Integer allMoney;
	
	/**是否付款 0 已付款 1未付款*/
	private char isPayMoney;

	public OrderForm() {
		super();
		//默认为未付款
		this.isPayMoney = '0';
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getAllMoney() {
		return allMoney;
	}

	public void setAllMoney(Integer allMoney) {
		this.allMoney = allMoney;
	}

	
	public char getIsPayMoney() {
		return isPayMoney;
	}

	public void setIsPayMoney(char isPayMoney) {
		this.isPayMoney = isPayMoney;
	}

	@Override
	public String toString() {
		return "OrderForm [orderId=" + orderId + ", shoppingCart=" + shoppingCart + ", address=" + address
				+ ", allMoney=" + allMoney + ", isPayMoney=" + isPayMoney + "]";
	}

}
