<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,java.sql.*,com.zlc.entity.StudentBean"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link href="assets/css/lib/bootstrap.min.css" rel="stylesheet">
<body align="center">
	添加学生信息
	<br>
	<form class="form-horizontal" name="f1" id="f1"
		action="StudentUpdate.do" method="post">

		<%
			//获取request域的数据
			StudentBean student = (StudentBean) request.getAttribute("students");
		%>
		<fieldset>

			<!-- Form Name -->
			<legend>Edit Page</legend>

			<!-- Text input-->
			<div class="control-group">
				<div class="controls">
					学号 <input id="ID" name="ID" type="text"
						value="<%=student.getID()%>" class="input-xlarge">
				</div>
			</div>

			<!-- Text input-->
			<div class="control-group">
				<div class="controls">
					姓名 <input id="Name" name="Name" type="text"
						value="<%=student.getName()%>" class="input-xlarge">
				</div>
			</div>

			<!-- Multiple Radios -->
			<div class="control-group">
				<div class="controls">
					性别<input id="Sex" name="Sex" type="text"
						value="<%=student.getSex()%>" class="input-xlarge">
				</div>
			</div>

			<!-- Text input-->
			<div class="control-group">
				<div class="controls">
					年龄 <input id="Age" name="Age" type="text"
						value="<%=student.getAge()%>" class="input-xlarge">
				</div>
			</div>

			<!-- Text input-->
			<div class="control-group">
				<div class="controls">
					生日 <input id="Birthday" name="Birthday" type="text"
						value="<%=student.getBirthday()%>" class="input-xlarge">
					<p class="help-block">格式：19950513</p>
				</div>
			</div>

			<!-- Text input-->
			<div class="control-group">
				<div class="controls">
					学校 <input id="School" name="School" type="text"
						value="<%=student.getSchool()%>" class="input-xlarge">
				</div>
			</div>

			<!-- Text input-->
			<div class="control-group">
				<div class="controls">
					班级 <input id="Classes" name="Classes" type="text"
						value="<%=student.getClasses()%>" class="input-xlarge">
				</div>
			</div>

			<!-- Button (Double) -->
			<div class="control-group">
				<label class="control-label" for="submit"></label>
				<div class="controls">
					<input type="submit" id="submit" name="submit"
						class="btn btn-success" /> <input type="reset" name="reset"
						class="btn btn-danger" />
				</div>
			</div>
		</fieldset>
	</form>
	<a href="StudentQueryByPage.do">返回</a>
</body>
</html>