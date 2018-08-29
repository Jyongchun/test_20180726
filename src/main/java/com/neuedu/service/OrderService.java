package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.UserOrder;

public interface OrderService {

	// ��������
	boolean createOrder();

	// �鿴����
	UserOrder findOrder(long order_no);

	List<UserOrder> findAll();

	// ��ȡ������
	long orderNo();
}
