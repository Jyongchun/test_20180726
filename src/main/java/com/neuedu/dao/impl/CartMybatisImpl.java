package com.neuedu.dao.impl;

import com.neuedu.dao.CartDao;
import com.neuedu.entity.Cart;

import org.apache.ibatis.session.SqlSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import java.util.List;
@Repository
public class CartMybatisImpl implements CartDao{
    @Autowired
    private SqlSession session;

   /* *//*分装一个结果*//*
    private boolean isFou(SqlSession session, int result) {
        if(result==1){
            session.close();
            System.out.println("success");
            return true;
        }else{
            session.close();
            System.out.println("Fail");
            return false;
        }
    }*/

    public boolean addCart(Cart cart) {

        /*
         * namespace+id
         * */
         session.insert("com.neuedu.entity.Cart.addCart",cart);
        return true;
    }

    @Override
    public List<Cart> findCart() {
        System.out.println("====到达dao层===");

       List<Cart> carts = session.selectList("com.neuedu.entity.Cart.findCart");
        return carts;
    }

    @Override
    public boolean updateCart(Cart cart) {

        /*
         * namespace+id
         * */
         session.update("com.neuedu.entity.Cart.updateCart",cart);
        return true;
    }

    @Override
    public boolean deleteCart(int id) {

        /*
         * namespace+id
         * */
        session.delete("com.neuedu.entity.Cart.deleteCart",id);
        return true;
    }

    @Override
    public int getOrderId() {
        return 0;
    }

    @Override
    public Cart getCartById(int id) {

        /*
         * namespace+id
         * */
        Cart cart = session.selectOne("com.neuedu.entity.Cart.findCartById",id);
        return cart;

    }

    @Override
    public void clearCart() {


        /*
         * namespace+id
         * */
        session.delete("com.neuedu.entity.Cart.clearCart");

    }

}
