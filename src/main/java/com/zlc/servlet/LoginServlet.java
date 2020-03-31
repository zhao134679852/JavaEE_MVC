package com.zlc.servlet;

//登录的servlet
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zlc.service.ILoginService;
import com.zlc.service.impl.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "用户登录", urlPatterns = { "/servlet/LoginServlet.do" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
		
		// 设定字符集编码 utf-8
		request.setCharacterEncoding("UTF-8");
		// 定义页面输出
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter writer=response.getWriter();
		//传送错误信息/密码/用户名
		String message="";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//判断用户名密码为空的情况
		if(username==""||password=="") {
			// 登录失败，跳转登录界面
			response.sendRedirect("../Login.html");
			
		}
		ILoginService loginService=new LoginService();
		//权限赋值
		String authority=loginService.queryLogin(username, password);
		if(authority==null) {
			// 登录失败，跳转登录界面
			message="登录失败！您的用户名或密码未填写！";
			writer.write(message);
			response.sendRedirect("../Login.html");
		}else if(authority.equals("admin")) {
			// 登录成功，跳转管理员界面
			message="登录成功！欢迎您，您的权限为【管理员】";
			writer.write(message);
			response.sendRedirect("../index.html");
		}else if(authority.equals("customer")) {
			// 登陆成功，跳转普通用户界面
			message="登录成功！欢迎您，您的权限为【普通用户】";
			writer.write(message);
			response.sendRedirect("../index.html");
		}else {
			// 登录失败，跳转登录界面
			message="登录失败！您的用户名或密码有误！";
			writer.write(message);
			response.sendRedirect("../Login.html");
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
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
