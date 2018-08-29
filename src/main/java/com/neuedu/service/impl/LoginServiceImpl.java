package com.neuedu.service.impl;

import com.neuedu.dao.LoginDao;
import com.neuedu.entity.Account;
import com.neuedu.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDao ld;

	public Account LogonLogic(String name, String password) {

		return ld.LogonLogic(name, password);
	}


	public void addToken(Account acc, String token) {
		ld.addToken(acc, token);
	}


	public String findTokenByAccountId(int accountid) {
		
		return ld.findTokenByAccountId(accountid);
	}

}
