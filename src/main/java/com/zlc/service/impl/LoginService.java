package com.zlc.service.impl;

import com.zlc.dao.ILoginDao;
import com.zlc.dao.impl.LoginDaoImpl;
import com.zlc.service.ILoginService;


//业务逻辑层
public class LoginService implements ILoginService{
	ILoginDao loginDao=new LoginDaoImpl();
	
	//登录检测，检测用户权限*****************************
	public String queryLogin(String username,String password) {
		return loginDao.queryLogin(username, password);
	}
}
