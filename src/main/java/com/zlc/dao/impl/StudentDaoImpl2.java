package com.zlc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zlc.entity.StudentBean;
import com.zlc.util.DBUtil;

//数据访问层，原子性的增删改查、、备份
public class StudentDaoImpl2{

	Connection coon = null;
	PreparedStatement preStmt = null;

	/**
	 * 
	 * @Title: isExist
	 * @Description: 查询此人是否存在 true此人存在，false此人不存在
	 * @param: @param ID
	 * @param: @return   
	 * @return: boolean   
	 * @throws
	 */
	public boolean isExist(int ID) {
		// System.out.println(queryStudentByID(ID));
		return queryStudentByID(ID) == null ? false : true;
	}

	/**
	 * 
	 * @Title: addStudent
	 * @Description: 增加学生 true增加成功 false增加失败
	 * @param: @param student
	 * @param: @return   
	 * @return: boolean   
	 * @throws
	 */
	public boolean addStudent(StudentBean student) {
		DBUtil db = new DBUtil();
		Connection conn = db.DBConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "INSERT INTO Student(ID,name,sex,age,birthday,school,classes) VALUES(?,?,?,?,?,?,?)";
		try {
			// 预处理
			ps = (PreparedStatement) conn.prepareStatement(sql);
			// 代入参数
			System.out.println(student.getID());
			ps.setInt(1, student.getID());
			ps.setString(2, student.getName());
			ps.setString(3, student.getSex());
			ps.setInt(4, student.getAge());
			ps.setString(5, student.getBirthday());
			ps.setString(6, student.getSchool());
			ps.setString(7, student.getClasses());
			// 执行查询-返回值
			int count = ps.executeUpdate();
			if (count > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("查无此人");
			return false;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (conn != null) {
					conn.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
	}

	/**
	 * 
	 * @Title: deleteStudentByID
	 * @Description: 删除学生
	 * @param: @param ID
	 * @param: @return   
	 * @return: boolean   
	 * @throws
	 */
	public boolean deleteStudentByID(int ID) {
		// TODO Auto-generated method stub
		DBUtil db = new DBUtil();
		Connection conn = db.DBConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "DELETE FROM Student WHERE ID=?";
		// System.out.println(sql);
		try {
			// 预处理
			ps = (PreparedStatement) conn.prepareStatement(sql);
			// 代入参数
			ps.setInt(1, ID);
			// 执行查询-返回值
			int count = ps.executeUpdate();
			if (count > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (conn != null) {
					conn.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @Title: updateStudentByID
	 * @Description: 修改学生
	 * @param: @param ID
	 * @param: @param student
	 * @param: @return   
	 * @return: boolean   
	 * @throws
	 */
	public boolean updateStudentByID(int ID, StudentBean student) {
		// TODO Auto-generated method stub
		DBUtil db = new DBUtil();
		Connection conn = db.DBConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "UPDATE Student set name=?,sex=?,age=?,birthday=?,school=?,classes=? WHERE ID=?";
		// System.out.println(sql);
		try {
			// 预处理
			ps = (PreparedStatement) conn.prepareStatement(sql);
			// 代入参数
			ps.setString(1, student.getName());
			ps.setString(2, student.getSex());
			ps.setInt(3, student.getAge());
			ps.setString(4, student.getBirthday());
			ps.setString(5, student.getSchool());
			ps.setString(6, student.getClasses());
			ps.setInt(7, student.getID());
			// 执行查询-返回值
			int count = ps.executeUpdate();
			if (count > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (conn != null) {
					conn.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @Title: queryStudentByID
	 * @Description: 查询ID
	 * @param: @param ID
	 * @param: @return   
	 * @return: StudentBean   
	 * @throws
	 */
	public StudentBean queryStudentByID(int ID) {
		// TODO Auto-generated method stub
		StudentBean student = null;
		DBUtil db = new DBUtil();
		Connection conn = db.DBConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM Student WHERE ID=?";
		// System.out.println(sql);
		try {
			// 预处理
			ps = (PreparedStatement) conn.prepareStatement(sql);
			// 代入参数
			ps.setInt(1, ID);
			// 执行查询-返回值
			rs = ps.executeQuery();
			// 返回值循环
			if (rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				int age = rs.getInt("age");
				String birthday = rs.getString("birthday");
				String school = rs.getString("school");
				String classes = rs.getString("classes");
				student = new StudentBean(id, name, sex, age, birthday, school, classes);
			}
			return student;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (conn != null) {
					conn.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @Title: queryAllStudents
	 * @Description: 查询-遍历
	 * @param: @return   
	 * @return: List<StudentBean>   
	 * @throws
	 */
	public List<StudentBean> queryAllStudents() {
		// TODO Auto-generated method stub
		DBUtil db = new DBUtil();
		Connection conn = db.DBConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM Student";
		// System.out.println(sql);
		//创建StudentBean的list
		List<StudentBean> students = new ArrayList<StudentBean>();

		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			//查询
			rs = ps.executeQuery();
			while (rs.next()) {
				//实例化StudentBean
				StudentBean student = new StudentBean();
				student.setID(rs.getInt("ID"));
				student.setName(rs.getString("name"));
				student.setSex(rs.getString("sex"));
				student.setAge(rs.getInt("age"));
				student.setBirthday(rs.getString("birthday"));
				student.setSchool(rs.getString("school"));
				student.setClasses(rs.getString("classes"));
				students.add(student);
			}
			return students;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (conn != null) {
					conn.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static void main(String[] args) {
		StudentDaoImpl2 sd = new StudentDaoImpl2();
		

		/*
		 * StudentBean student = new StudentBean();
		 * student = sd.queryStudentByID(20173622); //
		 * System.out.println(student.getName());
		 * System.out.println(sd.isExist(20173622));
		 */
		sd.deleteStudentByID(20173630);
		List<StudentBean> students =sd.queryAllStudents();
		for(StudentBean student:students) {
			System.out.println(student.getName());
		}
	}
}
