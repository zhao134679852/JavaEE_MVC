<%@ page language="java"
	import="java.util.*,java.sql.*,com.zlc.entity.StudentBean,com.zlc.entity.PageBean"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'StudentList.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script src="./jquery/jquery.min.js"></script>
<script src="./bootstrap/js/bootstrap.js"></script>
<script src="./bootstrap-table/bootstrap-table.js"></script>
<script src="./bootstrap-table/bootstrap-table-export.js"></script>
<script src="./extends/tableExport/jquery.base64.js"></script>
<script src="./extends/tableExport/tableExport.js"></script>
</head>
<body align="center">
	<a>显示学生信息</a>
	<br>
	<a href="StudentAddView.jsp">添加</a>
	<br>
	<table border="1px" align="center">
		<tr>
			<th>学号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>年龄</th>
			<th>生日</th>
			<th>学校</th>
			<th>班级</th>
			<th>操作</th>
		</tr>
		<%
			/* //获取request域的数据
			List<StudentBean> students = (List<StudentBean>) request.getAttribute("students");
			for (StudentBean student : students) { */
			PageBean pages = (PageBean) request.getAttribute("page");
			for (StudentBean student : pages.getStudents()) {
		%>
		<tr>
			<td><%=student.getID()%></td>
			<td><%=student.getName()%></td>
			<td><%=student.getSex()%></td>
			<td><%=student.getAge()%></td>
			<td><%=student.getBirthday()%></td>
			<td><%=student.getSchool()%></td>
			<td><%=student.getClasses()%></td>
			<td><a href="servlet/StudentEdit.do?ID=<%=student.getID()%>">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;<a
				href="servlet/StudentDelete.do?ID=<%=student.getID()%>">删除</a></td>
		</tr>
		<%
			}
		%>
	</table>
	<br>
	<%
		if (pages.getCurrentPage() == pages.getTotalPage()) {
	%>
	<a href="servlet/StudentQueryByPage.do?currentPage=1">首页</a>
	<a
		href="servlet/StudentQueryByPage.do?currentPage=<%=pages.getCurrentPage() - 1%>">上一页</a>
	<%
		} else if (pages.getCurrentPage() == 1) {
	%>
	<a
		href="servlet/StudentQueryByPage.do?currentPage=<%=pages.getCurrentPage() + 1%>">下一页</a>
	<a
		href="servlet/StudentQueryByPage.do?currentPage=<%=pages.getTotalPage()%>">尾页</a>
	<%
		} else {
	%>
	<a href="servlet/StudentQueryByPage.do?currentPage=1">首页</a>
	<a
		href="servlet/StudentQueryByPage.do?currentPage=<%=pages.getCurrentPage() - 1%>">上一页</a>
	<a
		href="servlet/StudentQueryByPage.do?currentPage=<%=pages.getCurrentPage() + 1%>">下一页</a>
	<a
		href="servlet/StudentQueryByPage.do?currentPage=<%=pages.getTotalPage()%>">尾页</a>
	<%
		}
	%>

</body>
</html>

