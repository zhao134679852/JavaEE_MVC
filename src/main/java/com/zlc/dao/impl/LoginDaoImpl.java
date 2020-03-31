
package com.zlc.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import com.zlc.dao.ILoginDao;
import com.zlc.util.CommonMethod;

public class LoginDaoImpl implements ILoginDao{

	
	/**
	 * 
	 * @Title: queryLogin查询
	 * @Description: TODO
	 * @param: @param username
	 * @param: @param password
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	public String queryLogin(String username, String password) {
		// TODO Auto-generated method stub
		String authority = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM login WHERE username=? and password=?";
		// System.out.println(sql);
		try {
			Object[] params= {username,password};
			rs=CommonMethod.executeQuery(sql, params);
			if (rs.next()) {
				authority = rs.getString("authority");
			}
			return authority;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			try {
				CommonMethod.closeAll(rs, (Statement) ps, CommonMethod.conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
		
		public static void main(String[] args) {
			LoginDaoImpl loginDao=new LoginDaoImpl();
			String authority=loginDao.queryLogin("20173628", "073610");
			System.out.println(authority);
		}
}
