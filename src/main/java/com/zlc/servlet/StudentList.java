package com.zlc.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zlc.entity.StudentBean;
import com.zlc.service.IStudentService;
import com.zlc.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class StudentList
 */
@WebServlet("/servlet/StudentList.do")
public class StudentList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 定义接收编码
		request.setCharacterEncoding("UTF-8");
		// 定义输出
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		// 调用逻辑层方法
		IStudentService service = new StudentServiceImpl();
		List<StudentBean> students = service.queryAllStudents();
		//System.out.println(students);
		request.setAttribute("students", students);
		// 因为request中有数据，因此需要请求转发的方式跳转，重定向会丢失request域
		// pageContext<request<session<application
		// 跳转
		request.getRequestDispatcher("../StudentListView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
