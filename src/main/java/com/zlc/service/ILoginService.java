package com.zlc.service;

public interface ILoginService {

	// 登录检测，检测用户权限*****************************
	public String queryLogin(String username, String password);
}
