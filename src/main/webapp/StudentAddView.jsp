<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>StudentAddl.html</title>
</head>
<link href="assets/css/lib/bootstrap.min.css" rel="stylesheet">

<body align="center">
	添加学生信息
	<br>
	<form class="form-horizontal" action="servlet/StudentAdd.do"
		method="post" align="center">
		<fieldset>

			<!-- Form Name -->
			<legend>Add Student Page</legend>
			<!-- Text input-->
			<div class="control-group">
				<div class="controls">
					学号<input id="ID" name="ID" type="text" placeholder="请输入您的学号"
						class="input-xlarge">
				</div>
			</div>

			<!-- Text input-->
			<div class="control-group">
				<div class="controls">
					姓名 <input id="Name" name="Name" type="text" placeholder="请输入您的姓名"
						class="input-xlarge">

				</div>
			</div>

			<!-- Multiple Radios -->
			<div class="control-group">
				<div class="controls">
					性别&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" name="Sex"
						value="男" checked="checked"> 男 <input type="radio"
						name="Sex" id="Sex-1" value="女"> 女
				</div>
			</div>

			<!-- Text input-->
			<div class="control-group">
				<div class="controls">
					年龄 <input id="Age" name="Age" type="text" placeholder="请输入您的年龄"
						class="input-xlarge">
				</div>
			</div>

			<!-- Text input-->
			<div class="control-group">
				<div class="controls">
					生日 <input id="Birthday" name="Birthday" type="text"
						placeholder="请输入您的生日" class="input-xlarge">
					<p class="help-block">格式：19950513</p>
				</div>
			</div>

			<!-- Text input-->
			<div class="control-group">
				<div class="controls">
					学校 <input id="School" name="School" type="text"
						placeholder="请输入您的学校" class="input-xlarge">
				</div>
			</div>

			<!-- Text input-->
			<div class="control-group">
				<div class="controls">
					班级 <input id="Classes" name="Classes" type="text"
						placeholder="请输入您的班级" class="input-xlarge">
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

	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="servlet/StudentQueryByPage.do">返回</a>
</body>
</html>
