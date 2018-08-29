package com.neuedu.dao.impl;

import com.neuedu.dao.ProductDao;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class ProductMybatisImpl implements ProductDao{
    @Autowired
    private  SqlSession session;
    @Override

    public boolean addProduct(Product product) {



        /*
         * 1.namespace+id
         * */
        ProductDao pd =  session.getMapper(ProductDao.class);
       pd.addProduct(product);

       return true;

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


        /*
         * 1.namespace+id
         * */
       ProductDao pd = session.getMapper(ProductDao.class);
       List<Product> products = pd.findAll();

        return products;
    }

    @Override
    public boolean updateProduct(Product product) {

       ProductDao pd= session.getMapper(ProductDao.class);
        pd.updateProduct(product);
        return true;
    }

    @Override
    public boolean deleteProduct(int id) {


      ProductDao pd= session.getMapper(ProductDao.class);
        pd.deleteProduct(id);
        return true;
    }

    @Override
    public Product findProductById(int id) {


       ProductDao pd= session.getMapper(ProductDao.class);
       Product product = pd.findProductById(id);
        return product;
    }

    @Override
    public PageModel<Product> findProductByPage(int pageNo, int pageSize) {

        //总记录数
        int totalCount =  findTotalCount();
        //计算页数
        int totalPage = (totalCount%pageSize==0)?(totalCount/pageSize):(totalCount/pageSize+1);

        //查询页面数据
       /* Map<String,Object> map = new HashMap<String, Object>();
        map.put("offset",(pageNo-1)*pageSize);
        map.put("pageSize",pageSize);*/

         List<Product> products = findInfoByPage(pageNo,pageSize);

        PageModel<Product> pagemodel = new PageModel<Product>();
        pagemodel.setData(products);
        pagemodel.setCurrentPage(pageNo);
        pagemodel.setTotalpage(totalPage);

        return pagemodel;
    }

    @Override
    public int findTotalCount() {
        ProductDao pd = session.getMapper(ProductDao.class);

        return pd.findTotalCount();
    }

    @Override
    public List<Product> findInfoByPage(int pageNo, int pageSize) {
        ProductDao pd =  session.getMapper(ProductDao.class);
        int _pageNo = (pageNo-1)*pageSize;
        return pd.findInfoByPage(_pageNo,pageSize);
    }


}
