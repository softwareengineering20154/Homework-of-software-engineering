<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
<!--
#apDiv1 {
	position:absolute;
	width:895px;
	height:115px;
	z-index:1;
	left: 20px;
	top: 22px;
}
#apDiv2 {
	position:absolute;
	width:885px;
	height:115px;
	z-index:1;
	left: 3px;
	top: 128px;
}
-->
</style>
</head>
<body>
 <div id="apDiv1">
<table width="100%" border="0" class="mytable">
  <!-- 使用JSTL中c:forEach循环便利request级别中的lstCustoemrs对象 --> 
 <c:if test="${empty requestScope.lstFoodRandow }">
	<!-- 跳转到 FindAllCustomersServlet拉去数据 -->
	<script>window.location="/cate/recommendServlet"; </script>
</c:if>
随便看看有没有你喜欢的
   <c:forEach items="${requestScope.lstFoodRandow }" var="food">
   <tr>
    <td width="6%" height="25" align="center" valign="middle" bgcolor="#FFFFCC">&nbsp;</td>
    <td width="40%" align="center" valign="middle" bgcolor="#FFFFCC">name</td>
    <td width="40%" align="center" valign="middle" bgcolor="#FFFFCC">kind</td>
  <tr>
    <td colspan="2" bgcolor="lavender" align="center" valign="middle">${goods.fname }</td>
    <td bgcolor="lavender" align="center" valign="middle">${goods.kind }</td>
    <td bgcolor="lavender" align="center" valign="middle">
    	<input type="button" name="button" id="button" value="更新" onClick="javascript:what()">           
    	 <input type="button" name="${food.foodid }" id="${food.foodid }" value="了解更多" onClick="javascript:fuck()">
   	    </td>
  </tr>
  </c:forEach> 
  </table>
  <table width="100%" border="0" class="mytable">
为您推荐最热门的事物
<tr>
    <td width="6%" height="25" align="center" valign="middle" bgcolor="#FFFFCC">&nbsp;</td>
    <td width="40%" align="center" valign="middle" bgcolor="#FFFFCC">name</td>
    <td width="40%" align="center" valign="middle" bgcolor="#FFFFCC">kind</td>
  <tr>
    <td colspan="2" bgcolor="lavender" align="center" valign="middle">${requestScope.HotNew.id }</td>
    <td bgcolor="lavender" align="center" valign="middle">${requestScope.Hot..kind }</td>
    <td bgcolor="lavender" align="center" valign="middle">
    	<input type="button" name="button" id="button" value="更新" onClick="javascript:what()">           
    	 <input type="button" name="${requestScope.lstFoodHot.foodid  }" id="${requestScope.lstFoodHot.foodid }" value="了解更多" onClick="javascript:fuck()">
   	  </td>
  </tr>
</table>
 </div>
<div id="apDiv1">
<table width="100%" border="0" class="mytable">
  <!-- 使用JSTL中c:forEach循环便利request级别中的lstCustoemrs对象 --> 
 <c:if test="${empty requestScope.lstFoodRandow }">
	<!-- 跳转到 FindAllCustomersServlet拉去数据 -->
	<script>window.location="/cate/recommendServlet"; </script>
</c:if>
随便看看有没有你喜欢的
   <c:forEach items="${requestScope.lstFoodRandow }" var="food">
   <tr>
    <td width="6%" height="25" align="center" valign="middle" bgcolor="#FFFFCC">&nbsp;</td>
    <td width="40%" align="center" valign="middle" bgcolor="#FFFFCC">name</td>
    <td width="40%" align="center" valign="middle" bgcolor="#FFFFCC">kind</td>
  <tr>
    <td colspan="2" bgcolor="lavender" align="center" valign="middle">${goods.fname }</td>
    <td bgcolor="lavender" align="center" valign="middle">${goods.kind }</td>
    <td bgcolor="lavender" align="center" valign="middle">
    	<input type="button" name="button" id="button" value="更新" onClick="javascript:what()">           
    	 <input type="button" name="${food.foodid }" id="${food.foodid }" value="了解更多" onClick="javascript:fuck()">
   	    </td>
  </tr>
  </c:forEach> 
  </table>
  <table width="100%" border="0" class="mytable">
为您推荐最热门的事物
<tr>
    <td width="6%" height="25" align="center" valign="middle" bgcolor="#FFFFCC">&nbsp;</td>
    <td width="40%" align="center" valign="middle" bgcolor="#FFFFCC">name</td>
    <td width="40%" align="center" valign="middle" bgcolor="#FFFFCC">kind</td>
  <tr>
    <td colspan="2" bgcolor="lavender" align="center" valign="middle">${requestScope.HotNew.id }</td>
    <td bgcolor="lavender" align="center" valign="middle">${requestScope.Hot.kind }</td>
    <td bgcolor="lavender" align="center" valign="middle">
    	<input type="button" name="button" id="button" value="更新" onClick="javascript:what()">           
    	 <input type="button" name="${requestScope.lstFoodHot.foodid  }" id="${requestScope.lstFoodHot.foodid }" value="了解更多" onClick="javascript:fuck()">
   	  </td>
  </tr>
</table>
  <div id="apDiv2"><table width="100%" border="0" class="mytable">
  <!-- 使用JSTL中c:forEach循环便利request级别中的lstCustoemrs对象 --> 
 <c:if test="${empty requestScope.lstFoodRandow }">
	<!-- 跳转到 FindAllCustomersServlet拉去数据 -->
	<script>window.location="/cate/recommendServlet"; </script>
</c:if>
随便看看有没有你喜欢的
   <c:forEach items="${requestScope.lstFoodRandow }" var="food">
   <tr>
    <td width="6%" height="25" align="center" valign="middle" bgcolor="#FFFFCC">&nbsp;</td>
    <td width="40%" align="center" valign="middle" bgcolor="#FFFFCC">name</td>
    <td width="40%" align="center" valign="middle" bgcolor="#FFFFCC">kind</td>
  <tr>
    <td colspan="2" bgcolor="lavender" align="center" valign="middle">${friends.fname }</td>
    <td bgcolor="lavender" align="center" valign="middle">${Post..time }</td>
    <td bgcolor="lavender" align="center" valign="middle">
    	<input type="button" name="button" id="button" value="更新" onClick="javascript:what()">           
    	 <input type="button" name="${food.foodid }" id="${food.foodid }" value="了解更多" onClick="javascript:fuck()">
   	    </td>
  </tr>
  </c:forEach> 
  </table>
  <table width="100%" border="0" class="mytable">
为您推荐最热门的事物
<tr>
    <td width="6%" height="25" align="center" valign="middle" bgcolor="#FFFFCC">&nbsp;</td>
    <td width="40%" align="center" valign="middle" bgcolor="#FFFFCC">name</td>
    <td width="40%" align="center" valign="middle" bgcolor="#FFFFCC">kind</td>
  <tr>
    <td colspan="2" bgcolor="lavender" align="center" valign="middle">${requestScope.HotPost.id }</td>
    <td bgcolor="lavender" align="center" valign="middle">${requestScope.Hot.kind }</td>
    <td bgcolor="lavender" align="center" valign="middle">
    	<input type="button" name="button" id="button" value="更新" onClick="javascript:what()">           
    	 <input type="button" name="${requestScope.lstFoodHot.foodid  }" id="${requestScope.lstFoodHot.foodid }" value="了解更多" onClick="javascript:fuck()">
   	  </td>
  </tr>
</table></div>
</div>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>好友动态</p>
</body>
</html>