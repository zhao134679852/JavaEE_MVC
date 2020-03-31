package com.zlc.test;

import com.zlc.dao.IStudentDao;
import com.zlc.dao.impl.StudentDaoImpl;
import com.zlc.entity.StudentBean;
import com.zlc.service.IStudentService;
import com.zlc.service.impl.StudentServiceImpl;

//测试类
public class Test {
	public static void main(String[] args) {

		IStudentService service = new StudentServiceImpl();
		StudentBean student = new StudentBean(5, "按时吃", "男", 22, "19990516", "石家庄铁道大学", "信1705-1班");
		service.addStudent(student);
		IStudentDao dao=new StudentDaoImpl();
		//dao.addStudent(student);
	
	}
}
