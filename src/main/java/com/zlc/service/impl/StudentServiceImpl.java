package com.zlc.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.zlc.dao.IStudentDao;
import com.zlc.dao.impl.StudentDaoImpl;
import com.zlc.entity.StudentBean;
import com.zlc.service.IStudentService;

//业务逻辑层：逻辑性的增删改查（增：查+增）删除（查+删）
public class StudentServiceImpl implements IStudentService{
	IStudentDao studentDao = new StudentDaoImpl();

	// 增加学生******************************
	public boolean addStudent(StudentBean student) {
		System.out.println(studentDao.isExist(student.getID()));
		if (!studentDao.isExist(student.getID())) {
			studentDao.addStudent(student);
			return true;
		} else {
			System.out.println("此人已存在");
			return false;
		}
	}

	// 删除学生********************************
	public boolean deleteStudentByID(int ID) {
		if (studentDao.isExist(ID)) {
			return studentDao.deleteStudentByID(ID);
		} else {
			System.out.println("此人不存在");
			return false;
		}
	}

	// 更新学生*********************************
	public boolean updateStudentByID(int ID, StudentBean student) {
		if (studentDao.isExist(ID)) {
			return studentDao.updateStudentByID(ID, student);
		} else {
			return false;
		}
	}

	// 根据学号查询一个人*************************
	public StudentBean queryStudentByID(int ID) {
		return studentDao.queryStudentByID(ID);
	}

	// 查询全部学生******************************
	public List<StudentBean> queryAllStudents() {
		return studentDao.queryAllStudents();
	}

	/**
	 * 
	 * <p>Title: getTotalCount</p>
	 * <p>Description: 查询数据总条数</p>
	 * @return
	 * @see com.zlc.service.IStudentService#getTotalCount()
	 */
	@Override
	public int getTotalCount() {
		return studentDao.getTotalCount();
	}

	/**
	 * 
	 * <p>Title: queryStudentsByPage</p>
	 * <p>Description: 查询当前页的数据集合</p>
	 * @param currentPage
	 * @param PageSize
	 * @return
	 * @see com.zlc.service.IStudentService#queryStudentsByPage(int, int)
	 */
	@Override
	public List<StudentBean> queryStudentsByPage(int currentPage, int pageSize) {
		return studentDao.queryStudentsByPage(currentPage, pageSize);
	}

	
	// 测试-主函数*******************************
	public static void main(String[] args) {
		StudentServiceImpl studentService = new StudentServiceImpl();
		/*
		 * StudentBean student = new StudentBean(1, "1", "1", 1, "1", "1", "1");
		 * studentService.addStudent(student);
		 */
		//studentService.deleteStudentByID(20173666);
		
//		StudentBean st=new StudentBean(20173628,"赵路仓","男",22,"19981207","石家庄铁道大学","信1705-1班");
//		studentService.updateStudentByID(20173628, st);
//		List<StudentBean> students = studentService.queryAllStudents();
//		for(StudentBean student:students) {
//			System.out.println(student.getName());
//			System.out.println(student.getAge());
//		}
		
		List<StudentBean> students =new ArrayList<StudentBean>();
		students=studentService.queryStudentsByPage(1, 3);
		for(StudentBean s:students) {
			System.out.println(s.getName());
		}
		
	}

}
