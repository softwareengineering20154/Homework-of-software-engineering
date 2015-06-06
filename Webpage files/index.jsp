<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<body bgcolor="#003379">
<style type="text/css">
body,td,th {
	font-size: 12px;
}
</style>
</head>
<body>

<table width="100%" border="0">
  <tr>
    <td height="93">欢迎登录, ${sessionScope.user.nickname }&nbsp;&nbsp; &nbsp;<img id="photo" name="photo" width="39" height="50" src="/nk12-RegLogin/upload/images/photo/${sessionScope.user.context }"/>&nbsp; &nbsp;<a href="/cate/LogoutServlet">退出</a></td>
  </tr>
  <tr>
    <td height="376">&nbsp;</td>
  </tr>
  <tr>
    <td height="137">&nbsp;</td>
  </tr>
</table>
</body>
</html>