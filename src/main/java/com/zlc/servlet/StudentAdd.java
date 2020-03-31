package com.zlc.servlet;

//添加学生的servlet
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zlc.entity.StudentBean;
import com.zlc.service.IStudentService;
import com.zlc.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class StudentAdd
 */
@WebServlet("/servlet/StudentAdd.do")
public class StudentAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentAdd() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 设定字符集编码utf-8
		request.setCharacterEncoding("UTF-8");
		// 定义输出
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		// 如果学号为空 String input='' 在转换类型时，String为空会报错
		if (request.getParameter("ID").equals("") || request.getParameter("Age") == "") {
			// 跳转到增加页面
			response.sendRedirect("../StudentAddView.jsp");
		} else {
			// 获取数据
			int id = Integer.parseInt(request.getParameter("ID"));
			String name = request.getParameter("Name");
			String sex = request.getParameter("Sex");
			int age = Integer.parseInt(request.getParameter("Age"));
			String birthday = request.getParameter("Birthday");
			String school = request.getParameter("School");
			String classes = request.getParameter("Classes");
			// 实例化bean实体类
			StudentBean student = new StudentBean(id, name, sex, age, birthday, school, classes);
			IStudentService studentService = new StudentServiceImpl();
			studentService.addStudent(student);
			// 跳转
			response.sendRedirect("StudentQueryByPage.do");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
