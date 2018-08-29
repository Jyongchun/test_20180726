package com.neuedu.test;

import com.neuedu.dao.LoginDao;

import com.neuedu.dao.impl.LoginMybatisImpl;
import com.neuedu.dao.impl.OrderMybatisImpl;
import com.neuedu.entity.Account;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {


    @org.junit.Test
    public void testLogonLogic(){
        LoginDao ld = new LoginMybatisImpl();
        ld.LogonLogic("admin", "21232f297a57a5a743894a0e4a801fc3");
    }

    @org.junit.Test
    public void TestFindTokenByAccountid(){
        LoginDao ld = new LoginMybatisImpl();
        System.out.println(ld.findTokenByAccountId(19));
    }
    @org.junit.Test
    public void TestAddToken(){
        LoginDao ld = new LoginMybatisImpl();
        Account a = new Account(20,"admin","qingqing");
       ld.addToken(a,"woainiqingqing");
    }

@org.junit.Test
    public void TestFindAll(){
       /* OrderDao od = new OrderMybatisImpl();*/
         ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
     //step 2 从容器中获取bean
        OrderMybatisImpl od =  (OrderMybatisImpl)applicationContext.getBean("orderMybatisImpl");
        od.findOrder(	1533715167976L);
    }


}

