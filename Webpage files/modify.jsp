<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改个人信息</title>
<style type="text/css">
<!--
one {
	width: 200px;
	height: 15px;
	line-height: 15px;
	border: none;
	background-color: #08C;
	background-image: url(images/01.jpg);
	background-repeat: no-repeat;
}

#submit {
	background-color: #01C;
	height: 80px;
	width: 100px;
	text-decoration: underline;
}

#statement {
	background-color: #6DF;
	width: 300px;
	height: 80px;
	font-size: 10px;
	line-height: 10px;
}

body,td,th {
	font-size: 16px;
	font-weight: bold;
}

body {
	background-image: url(images/u=1517650168,1468429118&fm=56.jpg);
	background-repeat: repeat;
}

#apDiv1 {
	position: absolute;
	width: 426px;
	height: 188px;
	z-index: 1;
	left: 322px;
	top: 52px;
}

#apDiv2 {
	position: absolute;
	width: 200px;
	height: 115px;
	z-index: 2;
	left: 43px;
	top: 47px;
}

#apDiv3 {
	position: absolute;
	width: 200px;
	height: 115px;
	z-index: 3;
	left: 41px;
	top: 178px;
}

#apDiv4 {
	position: absolute;
	width: 200px;
	height: 115px;
	z-index: 4;
	left: 780px;
	top: 57px;
}

#apDiv5 {
	position: absolute;
	width: 421px;
	height: 196px;
	z-index: 5;
	left: 323px;
	top: 250px;
}

#apDiv6 {
	position: absolute;
	width: 200px;
	height: 115px;
	z-index: 6;
	left: 787px;
	top: 234px;
}
-->
</style>
</head>
<body>
<c:if test="${empty sessionScope.user }">
	<script>
		alert("你怎么不登陆，快去登录！！！！");
		location="/cate/jsp/clock.jsp";
	</script>
</c:if>
	<form action="/cate/ModifyServlet" method="post"
		enctype="multipart/form-data" name="form1">
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
<p>&nbsp;</p>
		<p>&nbsp;</p>
		<div id="apDiv6">
			<input type="submit" name="submit" id="submit" value="点我提交">
		</div>
    <p>&nbsp;</p>
		<p>&nbsp;</p>
		<div id="apDiv2">
			<label> 您的账号<br> <br> <input name="account" value=" ${sessionScope.user.nickname }"
				type="text" id="account" readonly="readonly" class="one" size="20">
				<br> 确认昵称<br> <br> <input type="text" name="nickname"
				id="nickname">
			</label>
		</div>
		<div id="apDiv3">
      <p>输入密码</p>
			<p>
				<label> <input type="password" name="password" id="password">
				</label>
			</p>
			<p>确认密码</p>
			<p>
				<label> <input type="password" name="repassword"
					id="repassword">
				</label>
			</p>
		</div>
		<div id="apDiv4">
			您的性别
	  <table width="200">
				<tr>
					<td><label> <input type="radio" name="gender"
							value="男" id="gender_0"> 男
					</label></td>
				</tr>
				<tr>
					<td><label> <input type="radio" name="gender"
							value="男" id="gender_1"> 女
					</label></td>
				</tr>
			</table>
			<p>您的大学</p>

			<label> <input type="text" name="college" id="college">
			</label>

		</div>
		<p>&nbsp;</p>
		<div id="apDiv5">
			<label> 您的个人简介<br> <textarea name="statement"
					id="statement"></textarea>
			</label>
		</div>
<p>&nbsp;</p>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<div id="apDiv1">
			<img src="images/002.jpg" width="161" height="155" alt="j"> <input
				type="file" name="photo" id="photo"> 
		</div>
		<p>&nbsp;</p>
	</form>
</body>
</html>