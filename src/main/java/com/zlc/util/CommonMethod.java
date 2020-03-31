package com.zlc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class CommonMethod {
	public static Connection conn = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;

	/**
	 * 
	 * @Title: createPreParedStatement
	 * @Description: PreParedStatement的创建方法
	 * @param: @param sql
	 * @param: @param params
	 * @param: @return
	 * @param: @throws SQLException   
	 * @return: PreparedStatement   
	 * @throws
	 */
	public static PreparedStatement createPreParedStatement(String sql,Object[] params) throws SQLException {
		DBUtil db = new DBUtil();
		conn = db.DBConnection();
		ps = (PreparedStatement) conn.prepareStatement(sql);
		// 查询
		// set方法的个数依赖于？的个数，而？的个数与数组的个数一致
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
		}
		return ps;
	}
	
	/**
	 * 
	 * @Title: executeUpdate
	 * @Description: 通用的增刪改查
	 * @param: @param sql 语句
	 * @param: @param params 参数
	 * @param: @return   
	 * @return: boolean   是否完成操作
	 * @throws
	 */
	public static boolean executeUpdate(String sql, Object[] params) {
		try {
			ps = createPreParedStatement(sql, params);
			// 执行查询-返回值
			int count = ps.executeUpdate();
			if (count > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				closeAll(rs, (Statement) ps, conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @Title: executeQuery
	 * @Description: 通用的查 返回值是一个集合
	 * @param: @param sql 语句
	 * @param: @param params 参数
	 * @param: @return   
	 * @return: ResultSet   返回集
	 * @throws
	 */
	public static ResultSet executeQuery(String sql, Object[] params) {
		try {
			ps = createPreParedStatement(sql, params);
			rs = ps.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 
	 * @Title: closeAll
	 * @Description: 关闭数据库连接
	 * @param: @param rs
	 * @param: @param stmt
	 * @param: @param conn
	 * @param: @throws SQLException   
	 * @return: void   
	 * @throws
	 */
	public static void closeAll(ResultSet rs,Statement stmt,Connection conn) throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (conn != null) {
			conn.close();
		}
		if (stmt != null) {
			stmt.close();
		}
	}

	/**
	 * 
	 * @Title: getTotalCount
	 * @Description: 查询数据总数
	 * @param: @param sql
	 * @param: @return   
	 * @return: int   
	 * @throws
	 */
	public static int getTotalCount(String sql) {
		int count = -1;
		try {
			ps = createPreParedStatement(sql, null);
			rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				closeAll(rs, (Statement) ps, conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
	
	
	
}
