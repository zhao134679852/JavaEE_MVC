package com.zlc.service;

import java.util.List;

import com.zlc.entity.StudentBean;

public interface IStudentService {
	// 增加学生******************************
	public boolean addStudent(StudentBean student);

	// 删除学生********************************
	public boolean deleteStudentByID(int ID);

	// 更新学生*********************************
	public boolean updateStudentByID(int ID, StudentBean student);

	// 根据学号查询一个人*************************
	public StudentBean queryStudentByID(int ID);

	// 查询全部学生******************************
	public List<StudentBean> queryAllStudents();

	// 查询总数
	public int getTotalCount();

	// 查询某一页的学生
	public List<StudentBean> queryStudentsByPage(int currentPage, int pageSize);
}
