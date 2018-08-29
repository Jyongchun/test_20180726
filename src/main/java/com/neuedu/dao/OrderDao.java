package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.UserOrder;

public interface OrderDao {

	// ��������
	boolean createOrder(UserOrder order);

	// ���ݶ�����Ų鿴����
	UserOrder findOrder(long order_no);

	// ��ȡ����ID
	int getOrderId();

	List<UserOrder> findAll();
}
