package com.zlc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zlc.entity.StudentBean;
import com.zlc.service.IStudentService;
import com.zlc.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class StudentUpdate
 */
@WebServlet(description = "更新学生", urlPatterns = { "/servlet/StudentUpdate.do" })
public class StudentUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentUpdate() {
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
		// 删除
		request.setCharacterEncoding("UTF-8");
		// 定义输出
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		// 接受前端的学号
		int ID = Integer.parseInt(request.getParameter("ID"));
		// 获取修改后的样子
		String name = request.getParameter("Name");
		String sex = request.getParameter("Sex");
		int age = Integer.parseInt(request.getParameter("Age"));
		String birthday = request.getParameter("Birthday");
		String school = request.getParameter("School");
		String classes = request.getParameter("Classes");
		out.print(ID + name + sex + age + birthday + school + classes);
		// 将修改的内容封装到javabean实体类中
		StudentBean student = new StudentBean(ID, name, sex, age, birthday, school, classes);
		IStudentService service = new StudentServiceImpl();
		service.updateStudentByID(ID, student);
		// 跳转
		response.sendRedirect("StudentQueryByPage.do");
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
