package com.lanqiao.service;

import java.util.Map;

import com.lanqiao.domain.OrderForm;
import com.lanqiao.domain.ShoppingCart;

public interface IOrderFormService {

	
	/**
	 * 	根据uid查询所有订单信息
	 * @param uid uid
	 * @return 订单集合
	 */
	public Map selectOrderFromByUid(Integer uid);
	
	/**
	 * 	根据前台订单信息创建订单
	 * @param shoppingCart 订单信息
	 */
	public void createOrderFrom(ShoppingCart shoppingCart);
	
	/**
	 * 	根据uid和订单id取消订单
	 * @param uid 用户id
	 * @param orderId 订单id
	 */
	public void cancelOrderForm(Integer uid,String orderId);
	
	/**
	 * 	付款后，提交订单
	 * @param orderForm 订单信息
	 */
	public void commitOrderForm(OrderForm orderForm);
}
