<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@page import="javax.servlet.http.Cookie"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script language="javascript">
	window.onload = function() {
		initSelectCountry();
		inserthis();
		//将city下拉菜单隐藏
		var lblCity = document.getElementById('lblCity');
		lblCity.style.display = 'none';
		//获取下拉菜单控件
		var country = document.getElementById('country');
		//编辑其.onChange方法
		country.onchange = function() {
			var res = country.value
			//获取城市下拉菜单对象
			var city = document.getElementById('city');
			//判断选择的是哪个国家
			if (res == '11') {
				lblCity.style.display = 'block';
				city.options.length = 0;
				city.options.add(new Option('名称', '21'));
				city.options.add(new Option('种类', '22'));
			}
			if (res == '12') {
				lblCity.style.display = 'block';
				city.options.length = 0;
				city.options.add(new Option('主题', '21'));
				city.options.add(new Option('楼主', '22'));
			}
			if (res == '13') {
				lblCity.style.display = 'block';
				city.options.length = 0;
				city.options.add(new Option('昵称', '21'));
				city.options.add(new Option('学院', '22'));
			}
		};
	};

	function initSelectCountry() {
		var country = document.getElementById('country');
		var opt_cs = new Option('null', 'null');
		var opt_us = new Option('商品', '11');
		var opt_cn = new Option('帖子', '12');
		var opt_un = new Option('用户', '13');
		country.options.add(opt_cs);
		country.options.add(opt_us);
		country.options.add(opt_cn);
		country.options.add(opt_un);
	}
	function inserthis() {
		var list = ${requestScope.lstCookies }
		for(i=0,i<list.length,i++){
			i=1;
			
		}
		var cookie = document.getElementById('cookie');
		var opt = new Option("sssss","sssss" );
		cookie.options.add(opt);
	}
	function checkForm() {
		//非空验证
		//step 1: 获取注册账号的值
		var account = document.getElementById('select').value;
		//step 2: 判断变量是否为空
		if (account == null || account.length == 0) {
			alert("不能為空");
			return false;
		}
	}
</script>
<style type="text/css">
body,td,th {
	font-size: 20px;
	color: #963;
	font-weight: bold;
}

<!--
#select {
	font-size: 45px;
	font-weight: 200;
}

#apDiv1 {
	position: absolute;
	width: 592px;
	height: 138px;
	z-index: 1;
	left: 220px;
	top: 34px;
	font-size: larger;
	color: #309;
}

.txt {
	background-color: #09C;
	height: 80px;
	width: 120px;
	border-top-style: dashed;
	border-right-style: dashed;
	border-bottom-style: dashed;
	border-left-style: dashed;
	text-indent: 100px;
	color: #0FC;
	font-size: 36px;
}

#apDiv2 {
	position: absolute;
	width: 149px;
	height: 98px;
	z-index: 1;
	left: 822px;
	top: 72px;
}

#apDiv3 {
	position: absolute;
	width: 113px;
	height: 122px;
	z-index: 2;
	left: 68px;
	top: 31px;
}

#apDiv4 {
	position: absolute;
	width: 442px;
	height: 97px;
	z-index: 3;
	left: 258px;
	top: 58px;
}

#submit {
	font-size: 36px;
	border-top-style: none;
	border-right-style: none;
	border-bottom-style: none;
	border-left-style: none;
	border-top-width: thin;
	border-right-width: thin;
	border-bottom-width: thin;
	border-left-width: thin;
	background-color: #CCC;
	color: #666;
}

#submit {
	position: fixed;
}

#submit {
	background-color: #999;
}

#submit {
	font-size: 16px;
	background-color: #999;
	word-spacing: normal;
}

#apDiv5 {
	position: absolute;
	width: 200px;
	height: 157px;
	z-index: 4;
	left: 350px;
	top: 173px;
}

#whatf {
	font-size: 24px;
}

#whats {
	font-size: 24px;
}

.24 {
	font-size: 24px;
}
-->
</style>
</head>
<body background="images/background.jpg">
<c:if test="${empty requestScope.ifc }">
	<!-- 跳转到 FindAllCustomersServlet拉去数据 -->
	<script>window.location="/cate/SelectCookie"; </script>

</c:if>
搜索历史：
<c:forEach items="${requestScope.lstCookies }" var="value">
<td bgcolor="lavender" align="center" valign="middle">${value }</td> 
</c:forEach> 

	<form name="form1" method="post" action="/cate/SelectFindServlet"
		onsubmit="return checkForm();">
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<div id="apDiv4">
			<label> <input type="text" name="select" id="select">
			  <br>
			  <select name="cookie" class="24" id="cookie">
		      </select>
            </label>
		</div>
	  <p>&nbsp;</p>
		<div id="apDiv5">
			<label>您想搜什么<br>
			</label> <select class="24" id="country" name="country">
			</select> <label id="lblCity"><br> 在具体一点吧<br> <select name="city"
				class="24" id="city">
			</select> </label> <input type="button" id="btn" value="选择" />
		</div>

		<p>&nbsp;</p>
		<div id="apDiv2">
			<label> <input type="submit" name="button" id="button"
				value="立即搜索">
			</label>
		</div>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
	</form>
</body>
</html>