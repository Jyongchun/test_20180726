package com.neuedu.service.impl;

import com.neuedu.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountDao ad;

    public void transfer(String name1,String name2,double money){

        ad.updaMoney(name1,2000-money);
        int a=5/0;
        ad.updaMoney(name2,2000+money);
    }
}
