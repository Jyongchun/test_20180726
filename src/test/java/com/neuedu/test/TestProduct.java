package com.neuedu.test;

import com.neuedu.dao.ProductDao;
import com.neuedu.dao.impl.ProductMybatisImpl;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.service.impl.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestProduct {
    @Test
    public void TestFindAll(){
        ProductDao pd = new ProductMybatisImpl();
        List<Product> products = pd.findAll();

    }
    @Test
    public void TestDeleteProduct(){
         ProductDao pd = new ProductMybatisImpl();
         boolean i = pd.deleteProduct(23);
        System.out.println(i);
    }

    @Test
    public void TestAddProduct(){
        ProductDao pd = new ProductMybatisImpl();
        Product p = new Product("My青青","我爱你",99999.0,"无图",250);
        pd.addProduct(p);
    }


    @Test
    public void TestUpdateProduct(){
        ProductDao pd = new ProductMybatisImpl();
        Product p = new Product(30,"My青青","我爱你",99999.0,"无图",100);
        pd.updateProduct(p);
    }
    @Test
    public void TestFindProductById(){
        ProductDao pd = new ProductMybatisImpl();
        System.out.println(pd.findProductById(24));
    }
    @Test
    public void TestFindProductByPage(){
        ProductDao pd = new ProductMybatisImpl();
        PageModel<Product> pm = pd.findProductByPage(1,3);
        System.out.println(pm.getTotalpage());
        List<Product> p = pm.getData();
        System.out.println(p);
    }

    @Test
    public void testUpdateMoney(){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        //step 2 从容器中获取bean
        AccountService amybatis =  (AccountService)applicationContext.getBean("accountService");
        amybatis.transfer("mike","july",300);

    }
}
