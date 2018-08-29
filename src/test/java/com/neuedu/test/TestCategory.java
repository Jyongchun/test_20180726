package com.neuedu.test;

import com.neuedu.dao.CartDao;
import com.neuedu.dao.impl.CartMybatisImpl;
import com.neuedu.entity.Cart;
import com.neuedu.entity.Product;
import org.junit.Test;

import java.util.List;

public class TestCategory {
    CartDao cd = new CartMybatisImpl();

    @Test
    public void TestCart(){

       List<Cart> carts =  cd.findCart();
       for (int i=0;i<carts.size();i++){
           System.out.println(carts.get(i));
       }
    }


    @Test
    public void TestAddCart(){

        Product p = new Product(24,"qingqing","222",99999,"无图",250);
        Cart c = new Cart();
        c.setNum(200);
       // c.setProduct(p);

        cd.addCart(c);

    }
}
