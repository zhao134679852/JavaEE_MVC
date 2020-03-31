package com.zlc.dao;

import java.util.List;

import com.zlc.entity.StudentBean;

public interface IStudentDao {

	// 查看此人是否存在***************************
	public boolean isExist(int ID);

	// 增加***************************
	public boolean addStudent(StudentBean student);

	// 删除***************************
	public boolean deleteStudentByID(int ID);

	// 更新***************************
	public boolean updateStudentByID(int ID, StudentBean student);

	// 根据学号查询***************************
	public StudentBean queryStudentByID(int ID);

	// 遍历***************************
	public List<StudentBean> queryAllStudents();

	// 查询总数***************************
	public int getTotalCount();

	// 查询某一页的学生***************************
	public List<StudentBean> queryStudentsByPage(int currentPage, int pageSize);
}
