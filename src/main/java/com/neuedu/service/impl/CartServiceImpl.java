package com.neuedu.service.impl;

import java.util.List;

import com.neuedu.dao.CartDao;

import com.neuedu.entity.Cart;
import com.neuedu.service.CartService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Service
public class CartServiceImpl implements CartService {

/*CartDao cd = new CartMybatisImpl();//dao的东西*/

	@Resource(name="cartMybatisImpl")
	CartDao cd;


	@PostConstruct
	public void init(){
		System.out.println("===init==");
	}


	@Override
	public boolean addCart(Cart cart) {

		return cd.addCart(cart);
	}

	@Override
	public List<Cart> findCart() {
		System.out.println("==findCart=");
		return cd.findCart();
	}

	@Override
	public boolean updateCart(Cart cart) {

		return cd.updateCart(cart);
	}

	@Override
	public boolean deleteCart(int id) {

		return cd.deleteCart(id);
	}

	@Override
	public int getOrderId() {

		return cd.getOrderId();
	}

	@Override
	public Cart getCartById(int id) {

		return cd.getCartById(id);
	}
	@PreDestroy
	public void destroy(){
		System.out.println("==destroy==");
	}

}
