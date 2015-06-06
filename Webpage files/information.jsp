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
	background-color: #09C;
	background-image: url(images/01.jpg);
	background-repeat: no-repeat;
}

#submit {
	background-color: #09C;
	height: 80px;
	width: 100px;
	text-decoration: underline;
}

#statement {
	background-color: #6CF;
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
	left: 301px;
	top: 39px;
}

#apDiv2 {
	position: absolute;
	width: 200px;
	height: 115px;
	z-index: 2;
	left: 481px;
	top: 57px;
}

#apDiv3 {
	position: absolute;
	width: 200px;
	height: 115px;
	z-index: 3;
	left: 518px;
	top: 162px;
}

#apDiv4 {
	position: absolute;
	width: 200px;
	height: 115px;
	z-index: 4;
	left: 42px;
	top: 50px;
}

#apDiv5 {
	position: absolute;
	width: 421px;
	height: 196px;
	z-index: 5;
	left: 302px;
	top: 241px;
}

#apDiv6 {
	position: absolute;
	width: 200px;
	height: 115px;
	z-index: 6;
	left: 797px;
	top: 112px;
}
#apDiv7 {
	position:absolute;
	width:200px;
	height:115px;
	z-index:6;
	left: 37px;
	top: 293px;
}
#apDiv8 {
	position:absolute;
	width:200px;
	height:115px;
	z-index:7;
	left: 759px;
	top: 59px;
	font-size: 16px;
}
-->
</style>
</head>
<body>
<c:if test="${empty requestScope.user }">
	<!-- 跳转到 FindAllCustomersServlet拉去数据 -->
	<script>alert("出错了");</script>
</c:if>
	<form action="/cate/ModifyServlet" method="post"
		enctype="multipart/form-data" name="form1">
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
	  <p>&nbsp;</p>
		<div id="apDiv8">
		  <p>这个人最近浏览的帖子</p>
          <p>
			  <label>
			    <input name="gender" type="text" id="gender" value=" ${requestScope.user.gender }" readonly="readonly">
			  </label>
			</p>
		  <p>&nbsp;</p>
		  <p>这个人最近关注的信息</p>
          <p>
			  <label>
			    <input name="gender" type="text" id="gender" value=" ${requestScope.user.gender }" readonly="readonly">
			  </label>
			</p>
		  <p>&nbsp;</p>
		  <p>这个人最近查看的商品</p>
          <p>
			  <label>
			    <input name="gender" type="text" id="gender" value=" ${requestScope.user.gender }" readonly="readonly">
			  </label>
			</p>
</div>
		<p>&nbsp;</p>
  <p>&nbsp;</p>
		<p>&nbsp;</p>
		<div id="apDiv2">
	    <label><br>
<br> 
				他的昵称<br> <br> <input name="nickname" type="text"
				id="nickname" value=" ${requestScope.user.nickname }" readonly="readonly">
		  </label>
		</div>
		<div id="apDiv4">
			<p>他的性别 </p>
			<p>
			  <label>
			    <input name="gender" type="text" id="gender" value=" ${requestScope.user.gender }" readonly="readonly">
			  </label>
			</p>
			<p>他的大学</p>

			<p>
			  <label> <input name="college" type="text" id="college" value=" ${requestScope.user.college }" readonly="readonly">
		      </label>
			  
		  </p>
			<p>&nbsp;</p>
		</div>
      <div id="apDiv7">
        <p>
          <input name="add" type="submit" value="加为好友">
          
        </p>
        <p>
          <input type="hidden" name="hiddenField" id="hiddenField" value="${requestScope.user.userid }">
        </p>
      </div>
      <p>&nbsp;</p>
		<div id="apDiv5">
			<label> 他的个人简介<br> <textarea name="statement" readonly="readonly"
					id="statement"> ${requestScope.user.statement }</textarea>
			</label>
		</div>
<p>&nbsp;</p>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<div id="apDiv1">
	  <img src="images/002.jpg" width="161" height="155" alt="j"></div>
		<p>&nbsp;</p>
	</form>
</body>
</html>