package com.neuedu.dao.impl;

import com.neuedu.dao.OrderItemDao;
import com.neuedu.entity.UserOrderItem;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class OrderItemMybatisImpl implements OrderItemDao{
    @Autowired
    private SqlSession session;

    @Override
    public boolean addOrderItem(List<UserOrderItem> orderItem) {

        OrderItemDao oid = session.getMapper(OrderItemDao.class);
        oid.addOrderItem(orderItem);

        return true;
    }

    @Override
    public List<UserOrderItem> findOrderItem() {
        return null;
    }

    @Override
    public int getOrderItemId() {
        return 0;
    }
}
