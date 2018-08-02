package com.neuedu.dao.impl;

import com.neuedu.dao.ProductDao;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductMybatisImpl implements ProductDao{
    @Override
    public boolean addProduct(Product product) {

        String resource = "mybatis-config.xml";
        Reader reader = null;
        SqlSession session;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder()
                .build(reader);
        session = sqlMapper.openSession(true);

        /*
         * 1.namespace+id
         * */
        int result= session.insert("com.neuedu.entity.Product.addProduct",product);
       if(result==1){
           System.out.println("success");
           session.close();
           return true;
       }else{
           System.out.println("Fail");
           session.close();
           return false;
       }




    }

    @Override
    public List<Product> findAll() {
        /*
       1，读取配置文件 ，读取配置文件
        2，生成 ，生成SqlSessionFactory
        为SqlSession的工厂，用于建立与数据库的会话。
        3，建立 ，建立SqlSession
                用于执行sql语句
        4，调用 ，调用MyBatis提供的 提供的api
        5，查询 ，查询MAP配置 配置
        6，返回结果 ，返回结果
        7，关闭 ，关闭SqlSession
        */

        String resource = "mybatis-config.xml";
        Reader reader = null;
        SqlSession session;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder()
                .build(reader);
        session = sqlMapper.openSession();

        /*
         * 1.namespace+id
         * */
        List<Product> products= session.selectList("com.neuedu.entity.Product.findAllProduct");
        System.out.println(products);
        session.close();



        return products;
    }

    @Override
    public boolean updateProduct(Product product) {
        String resource = "mybatis-config.xml";
        Reader reader = null;
        SqlSession session;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder()
                .build(reader);
        //事物提交
        session = sqlMapper.openSession(true);
        int result = session.update("com.neuedu.entity.Product.updateProduct",product);
        if(result==1){
            System.out.println("Success");
            session.close();
            return true;
        }else {
            System.out.println("Fail");
            session.close();
            return false;
        }
    }

    @Override
    public boolean deleteProduct(int id) {
        String resource = "mybatis-config.xml";
        Reader reader = null;
        SqlSession session;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder()
                .build(reader);
        //事物提交
        session = sqlMapper.openSession(true);
        int result = session.delete("com.neuedu.entity.Product.deleteProductById",id);
        if(result==1){
            System.out.println("Delete Success");
            session.close();
            return true;
        }else {
            System.out.println("Fail");
            session.close();
            return false;
        }

    }

    @Override
    public Product findProductById(int id) {
        return null;
    }

    @Override
    public PageModel<Product> findProductByPage(int pageNo, int pageSize) {
        return null;
    }
}
