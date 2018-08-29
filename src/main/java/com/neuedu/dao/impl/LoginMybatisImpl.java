package com.neuedu.dao.impl;

import com.neuedu.dao.LoginDao;
import com.neuedu.entity.Account;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class LoginMybatisImpl implements LoginDao{
    @Autowired
    private SqlSession session;
    @Override
    public Account LogonLogic(String name, String password) {

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

        //map集合存的用户名和密码
        Map<String,String> map = new HashMap<String, String>();
        map.put("username",name);
        map.put("password",password);
        /*
        * 1.namespace+id
        * */
        Account account = session.selectOne("com.neuedu.entity.Account.findByUsernameAndPassword", map);
        System.out.println(account);

        return account;
    }

    @Override
    public void addToken(Account acc, String token) {


        /*
         * 1.namespace+id
         * */
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("token",token);
        map.put("accountid",acc.getId());
        int i = session.update("com.neuedu.entity.Account.addToken", map);
        System.out.println(i);


    }

    @Override
    public String findTokenByAccountId(int accountid) {
        /*
         * 1.namespace+id
         * */
        String token = session.selectOne("com.neuedu.entity.Account.findTokenByAccountId", accountid);
        return token;
    }
}
