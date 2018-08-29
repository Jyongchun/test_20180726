package com.neuedu.dao.impl;

import com.neuedu.dao.AccountDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountMybatis implements AccountDao {
    @Autowired
    SqlSession sqlSession;

    public void updaMoney(String name, double money){
      AccountDao ad =   sqlSession.getMapper(AccountDao.class);
      ad.updaMoney(name,money);
    }
}
