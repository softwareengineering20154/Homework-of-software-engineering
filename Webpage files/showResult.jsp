<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.active.cate.vo.Showposts"%>
<%@page import="com.active.cate.po.Users"%>
<%@page import="com.active.cate.po.Food"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body,td,th {
	font-size: 16px;
}
#apDiv1 {
	position:absolute;
	width:946px;
	height:115px;
	z-index:1;
	left: 9px;
	top: 48px;
}
</style>
<script type="text/javascript">
function what(){
	alert('?');
}

function fuck(){
	var price = tsetform.text.value;
	var place = food.exeplace;
	var info="price"+"，exeplace"+place;
	alert(info);
}
function findById(id){
	 // 跳转到指定的servlet并携带参数id
	 window.location="/cate/FindUsersByIdServlet?userid="+id;
}
</script>
</head>
<body>

<div id="apDiv1">
<table width="100%" border="0" class="mytable">
  </tr>
  <!-- 使用JSTL中c:forEach循环便利request级别中的lstCustoemrs对象 --> 
  <c:forEach items="${requestScope.lstUsers }" var="user">
  <tr>
    <td width="6%" height="25" align="center" valign="middle" bgcolor="#FFFFCC">&nbsp;</td>
    <td width="40%" align="center" valign="middle" bgcolor="#FFFFCC">name</td>
    <td width="40%" align="center" valign="middle" bgcolor="#FFFFCC">account</td>
  <tr>
   	<td bgcolor="lavender" height="25" align="center" valign="middle"><input type="checkbox" name="checkbox" id="checkbox"></td>
    <td bgcolor="lavender" align="center" valign="middle">${user.nickname }</td>
    <td bgcolor="lavender" align="center" valign="middle">${user.account }</td>
    <td bgcolor="lavender" align="center" valign="middle">
    	<input type="button" name="button" id="button" value="更新" onClick="javascript:select();">           
    	 <input type="button" name="button2" id="button2" value="了解更多" onClick="javascript:findById(${user.userid });">
    </td>
  </tr>
  </c:forEach> 
   <c:forEach items="${requestScope.lstFood }" var="food">
   <tr>
    <td width="6%" height="25" align="center" valign="middle" bgcolor="#FFFFCC">&nbsp;</td>
    <td width="40%" align="center" valign="middle" bgcolor="#FFFFCC">name</td>
    <td width="40%" align="center" valign="middle" bgcolor="#FFFFCC">kind</td>
  <tr>
    <td colspan="2" bgcolor="lavender" align="center" valign="middle">${food.fname }</td>
    <td bgcolor="lavender" align="center" valign="middle">${food.kind }</td>
    <td bgcolor="lavender" align="center" valign="middle">
    	<input type="button" name="button" id="button" value="更新" onClick="javascript:what()">           
    	 <input type="button" name="${food.foodid }" id="${food.foodid }" value="了解更多" onClick="javascript:fuck()">
    	 </td>
  </tr>
  </c:forEach> 
  <c:forEach items="${requestScope.lstPosts }" var="showpost">
   <tr>
    <td width="6%" height="25" align="center" valign="middle" bgcolor="#FFFFCC">&nbsp;</td>
    <td width="40%" align="center" valign="middle" bgcolor="#FFFFCC">nickname</td>
    <td width="40%" align="center" valign="middle" bgcolor="#FFFFCC">context</td>
  <tr>
    <td colspan="2" bgcolor="lavender" align="center" valign="middle">${showpost.nickname }</td>
    <td bgcolor="lavender" align="center" valign="middle">${showpost.pcontext }</td>
    <td bgcolor="lavender" align="center" valign="middle">
    	<input type="button" name="button" id="button" value="更新" onClick="javascript:what()">           
    	 <input type="button" name="${showfood.pid }" id="${showfood.pid }" value="去看看" onClick="javascript:fuck()">
    	 </td>
  </tr>
  </c:forEach> 
</table>
</div>
您的搜索结果
</body>
</html>