<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.active.cate.vo.Showposts"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function SendPageNumber(id){
	 // 跳转到指定的servlet并携带参数id
	 window.location="/cate/LimitedShowServlet?pageNumber="+id;
}
</script>
<style type="text/css">
<!--
#apDiv1 {
	position:absolute;
	width:1049px;
	height:115px;
	z-index:1;
	left: 6px;
	top: 85px;
}
#apDiv2 {
	position:absolute;
	width:200px;
	height:63px;
	z-index:2;
	left: 1px;
	top: -76px;
	color: #0CF;
}
-->
</style>
</head>
<body>
<c:if test="${empty requestScope.lstPosts }">
	<!-- 跳转到 FindAllCustomersServlet拉去数据 -->
	<script>window.location="/cate/LimitedShowServlet"; </script>
</c:if>
<div id="apDiv1">
<table width="100%" border="0" class="mytable">
  <!-- 使用JSTL中c:forEach循环便利request级别中的lstCustoemrs对象 --> 
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
  <tr>
  <!-- 首页 上一页 当前页码 下一页 末页 -->
  <a href="javascript:SendPageNumber(${ 1});">首页</a>
   <a href="javascript:SendPageNumber(${ requestScope.pageNumber-1});">上一页</a></tr>
</table>
<div id="apDiv2">您的搜索结果：</div>
<table width="100%" border="0" class="mytable">
  <tr>
    <a >当前为第${requestScope.pageNumber}页</a>
    <a href="javascript:SendPageNumber(${ requestScope.pageNumber+1});">下一页</a>
    <a href="javascript:SendPageNumber(${ requestScope.totalPage});">末页</a>
  </tr>
</table>
</div>
</body>
</html>