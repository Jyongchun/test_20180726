package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.UserOrder;

public interface OrderDao {

	// 创建订单
	boolean createOrder(UserOrder order);

	// 根据订单编号查看订单
	UserOrder findOrder(long order_no);

	// 获取订单ID
	int getOrderId();

	List<UserOrder> findAll();
}
