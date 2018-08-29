package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.UserOrder;

public interface OrderService {

	// 创建订单
	boolean createOrder();

	// 查看订单
	UserOrder findOrder(long order_no);

	List<UserOrder> findAll();

	// 获取订单号
	long orderNo();
}
