package com.neuedu.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.CartDao;
import com.neuedu.dao.OrderDao;
import com.neuedu.dao.OrderItemDao;
import com.neuedu.dao.ProductDao;
import com.neuedu.entity.Cart;
import com.neuedu.entity.Product;
import com.neuedu.entity.UserOrder;
import com.neuedu.entity.UserOrderItem;
import com.neuedu.service.OrderService;
import com.neuedu.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderDao od;
	@Autowired
	OrderItemDao oid ;
	@Autowired
	CartDao cd ;
	@Autowired
	ProductDao pd ;

	/* �������� */
	@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED,readOnly = false)
	public boolean createOrder() {
		// temp1 ��ȡ���ﳵ��Ϣ
		List<Cart> carts = cd.findCart();
		if (carts == null || carts.size() <= 0) {
			return false;
		}
		// temp2 ���ɶ���ʵ����
		UserOrder uorder = createUserOrder();

		// temp3 ��������Ϣ����ת�ɶ�����ϸ����
		List<UserOrderItem> orderItems = new ArrayList<UserOrderItem>();
		for (int i = 0; i < carts.size(); i++) {
			Cart cart = carts.get(i);
			UserOrderItem orderItem = Utils.convertToOrderItem(oid.getOrderItemId(), uorder.getOrder_no(), cart);
			// temp4 ������
			/*if (orderItem.getQuantity() <= cart.getProduct().getStock()) {*/
				orderItems.add(orderItem);
		/*	} else {
				return false;
			}*/
		}

		// temp5 ���㶩���۸�
		uorder.setPayment(getOrderPrice(orderItems));
		// temp6 �µ�
		od.createOrder(uorder);
		oid.addOrderItem(orderItems);
		// temp7 �ۿ��

		for (int i = 0; i < carts.size(); i++) {
			Cart cart = carts.get(i);
			Product product = cart.getProduct();
			int leftStock = product.getStock() - cart.getNum();
			/*ʣ���治��Ϊ��,��������ع�*/
			int a = 5/leftStock;
			if(a<0){
				int b = a/0;
			}
			product.setStock(leftStock);
			pd.updateProduct(product);
		}
		
		
		// temp8��չ��ﳵ
		cd.clearCart();

		return true;
	}

	/*
	 * ���㶩���ܼ۸�
	 */
	private double getOrderPrice(List<UserOrderItem> items) {
		double price = 0;
		for (int i = 0; i < items.size(); i++) {
			UserOrderItem ui = items.get(i);
			price += ui.getTotal_price();
		}
		return price;
	}

	//���� ����ʵ����
	private UserOrder createUserOrder() {
		UserOrder uorder = new UserOrder();
		uorder.setId(od.getOrderId());
		uorder.setOrder_no(orderNo());
		uorder.setCreate_time(System.currentTimeMillis());

		return uorder;
	}

	// ��ȡ������
	public long orderNo() {

		return System.currentTimeMillis();
	}

	// ͨ����Ų鿴����
	public UserOrder findOrder(long order_no) {

		return od.findOrder(order_no);
	}

	@Override
	public List<UserOrder> findAll() {
		return od.findAll();
	}

}
