package com.neuedu.dao.impl;

import com.neuedu.dao.OrderDao;
import com.neuedu.entity.UserOrder;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class OrderMybatisImpl implements OrderDao{
   @Autowired
    private SqlSession session;

    @Override
    public boolean createOrder(UserOrder order) {

        OrderDao od =  session.getMapper(OrderDao.class);
        od.createOrder(order);

        return true;
    }

    @Override
    public UserOrder findOrder(long order_no) {


        OrderDao od = session.getMapper(OrderDao.class);
        UserOrder order = od.findOrder(order_no);
        System.out.println(order);
        return order;
    }

    @Override
    public int getOrderId() {
        return 0;
    }

    @Override
    public List<UserOrder> findAll() {
        OrderDao od = session.getMapper(OrderDao.class);
        List<UserOrder> orders = od.findAll();
        return orders;
    }


}
