package com.zlc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zlc.entity.PageBean;
import com.zlc.entity.StudentBean;
import com.zlc.service.IStudentService;
import com.zlc.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class StudentQueryByPage
 */
@WebServlet(description = "按页查询学生", urlPatterns = { "/servlet/StudentQueryByPage.do" })
public class StudentQueryByPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentQueryByPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设定字符集编码utf-8
		request.setCharacterEncoding("UTF-8");
		// 定义输出
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		// 调用接口
		IStudentService studentService = new StudentServiceImpl();
		List<StudentBean> students = new ArrayList<StudentBean>();
		// 第一次访问,设置第一页
		String cPage = request.getParameter("currentPage");
		if (cPage == null) {
			cPage = "1";
		}
		// 数据
		int currentPage = Integer.parseInt(cPage);
		int totalCount = studentService.getTotalCount();
		int pageSize = 3;
		PageBean page = new PageBean();
		page.setTotalCount(totalCount);
		page.setCurrentPage(currentPage);
		page.setPageSize(pageSize);

		students = studentService.queryStudentsByPage(currentPage, pageSize);
		page.setStudents(students);
		request.setAttribute("page", page);
		request.getRequestDispatcher("../StudentListView.jsp").forward(request, response);
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
