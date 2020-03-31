package com.zlc.util;

import java.sql.Connection;
import java.sql.DriverManager;

//数据库连接 SqlServer
public class DBUtil {
	// 驱动类名
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/dbjavaee?useUnicode=true&characterEncoding=UTF8";// JavaTest为你的数据库名称
	String user = "root";
	String password = "364624";
	Connection coon = null;

	public Connection DBConnection() {
		Connection coon = null;
		try {
			// 加载驱动程序
			Class.forName(driver);
			coon = DriverManager.getConnection(url,user,password);
			if (!coon.isClosed()) {
				System.out.println("成功连接数据库！");
			} else {
				System.out.println("失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return coon;
	}

	public void close() {
		try {
			this.coon.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DBUtil db = new DBUtil();
		db.DBConnection();
	}
}
