package com.zlc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;
import com.zlc.dao.IStudentDao;
import com.zlc.entity.StudentBean;
import com.zlc.util.CommonMethod;

//数据访问层，原子性的增删改查
public class StudentDaoImpl implements IStudentDao{

	Connection conn = null;
	PreparedStatement ps = null;

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
		String sql = "INSERT INTO student(ID,name,sex,age,birthday,school,classes) VALUES(?,?,?,?,?,?,?)";
		Object[] params = { student.getID(), student.getName(), student.getSex(), student.getAge(),
				student.getBirthday(), student.getSchool(), student.getClasses() };
		return CommonMethod.executeUpdate(sql, params);
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
		String sql = "DELETE FROM student WHERE ID=?";
		Object[] params= {ID};
		return CommonMethod.executeUpdate(sql, params);
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
		String sql = "UPDATE student set name=?,sex=?,age=?,birthday=?,school=?,classes=? WHERE ID=?";
		Object[] params = { student.getName(), student.getSex(), student.getAge(), student.getBirthday(),
				student.getSchool(), student.getClasses(), student.getID() };
		return CommonMethod.executeUpdate(sql, params);
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
		StudentBean student = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM student WHERE ID=?";
		// System.out.println(sql);
		try {
			Object[] params = { ID };
			rs = CommonMethod.executeQuery(sql, params);
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
				CommonMethod.closeAll(rs, (Statement) ps, CommonMethod.conn);
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
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM student";
		List<StudentBean> students = new ArrayList<StudentBean>();
		// System.out.println(sql);
		try {
			rs = CommonMethod.executeQuery(sql, null);
			while (rs.next()) {
				// 实例化StudentBean
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
				CommonMethod.closeAll(rs, (Statement) ps, CommonMethod.conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 
	 * <p>Title: queryStudentsByPage</p>
	 * <p>Description: 遍历当前页的学生数据</p>
	 * @param currentPage
	 * @param PageSize
	 * @return
	 * @see com.zlc.dao.IStudentDao#queryStudentsByPage(int, int)
	 */
	@Override
	public List<StudentBean> queryStudentsByPage(int currentPage, int pageSize) {
		String sql="SELECT * FROM student limit "+(currentPage-1)*pageSize+","+pageSize;
		//System.out.println(sql);
		ResultSet rs = null;
		rs=CommonMethod.executeQuery(sql, null);
		List<StudentBean> students=new ArrayList<StudentBean>();
		try {
			while(rs.next()) {
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
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				CommonMethod.closeAll(rs, (Statement) ps, conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return students;
	}

	/**
	 * 
	 * <p>Title: getTotalCount</p>
	 * <p>Description: 查询学生总数</p>
	 * @return
	 * @see com.zlc.dao.IStudentDao#getTotalCount()
	 */
	@Override
	public int getTotalCount() {
		String sql="SELECT count(1) from student";
		return CommonMethod.getTotalCount(sql);
	}
	
	public static void main(String[] args) {
		StudentDaoImpl sd = new StudentDaoImpl();
		

		/*
		 * StudentBean student = new StudentBean();
		 * student = sd.queryStudentByID(20173622); //
		 * System.out.println(student.getName());
		 * System.out.println(sd.isExist(20173622));
		 */
		//sd.deleteStudentByID(20173630);
		
//		StudentBean student=new StudentBean(20173628,"赵路仓","男",22,"19981207","石家庄铁道大学","信1705-1班");
//		sd.addStudent(student);
//		List<StudentBean> students =sd.queryAllStudents();
//		for(StudentBean ss:students) {
//			System.out.println(ss.getName());
//		}
		
		List<StudentBean> students =new ArrayList<StudentBean>();
		students=sd.queryStudentsByPage(1, 3);
		for(StudentBean s:students) {
			System.out.println(s.getName());
		}
		
	}

	

}
