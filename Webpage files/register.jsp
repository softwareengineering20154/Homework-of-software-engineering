<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="javascript">
//表单提交验证方法
function checkForm(){
	//非空验证
	//step 1: 获取注册账号的值
	var account = document.getElementById('textfield').value;
	var password = document.getElementById('textfield2').value;
	var repassword = document.getElementById('textfield3').value;
	var nickname = document.getElementById('textfield4').value;
	var flaga=true;
	var flagb=true;
	var flagc=true;
	var flagd=true;
	//step 2: 判断变量是否为空
	if(account == null || account.length < 6){
		//alert('用户名不能为空！');
		txtNameMsg1.innerHTML="<font style='font-size:12px; color:red'>用户名过短 </font>";
		flaga=false;
    }
	if(password == null || password.length < 6){
		//alert('用户名不能为空！');
		txtNameMsg2.innerHTML="<font style='font-size:12px; color:red'>密码过短  </font>";
		flagb=false;
    }
	if(repassword != password){
		//alert('用户名不能为空！');
		txtNameMsg3.innerHTML="<font style='font-size:12px; color:red'>密码不一致 </font>";
		flagc=false;
    }
	if(nickname == null || nickname.length < 6){
		//alert('用户名不能为空！');
		txtNameMsg4.innerHTML="<font style='font-size:12px; color:red'>昵称过短  </font>";
		flagd=false;
    }
	if(flaga==false||flagb==false||flagc==false||flagd==false){
		return false;
	}
}

</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
body {
	background-repeat: no-repeat;
}
#apDiv1 {
	position:absolute;
	width:679px;
	height:105px;
	z-index:1;
	top: 13px;
	left: 172px;
}
#apDiv2 {
	position:absolute;
	width:200px;
	height:22px;
	z-index:2;
	top: 322px;
	left: 153px;
}
#apDiv3 {
	position:absolute;
	width:118px;
	height:115px;
	z-index:3;
	left: 34px;
	top: 101px;
}
#apDiv4 {
	position:absolute;
	width:612px;
	height:350px;
	z-index:1;
	left: 332px;
	top: 92px;
}
-->
</style></head>
<body background="images/background.jpg">
<div id="apDiv4">
  <form name="form1" method="post" action="/cate/RegisterServlet" onSubmit="return checkForm();">
    <table width="67%" height="348" border="0" align="center">
      <tr>
        <td height="109" colspan="2" align="center" valign="middle">&nbsp;</td>
      </tr>
      <tr>
        <td width="23%" height="30" align="right">登陆账号：</td>
        <td width="75%"><label>
          <input type="text" name="account" id="textfield">
          <span id="txtNameMsg1"><font style="font-size:12px; color:#069"></font></span>
        </label></td>
      </tr>
      <tr>
        <td height="31" align="right">登录密码：</td>
        <td width="75%"><label>
          <input type="text" name="password" id="textfield2">
          <span id="txtNameMsg2"><font style="font-size:12px; color:#069"></font></span>
        </label></td>
      </tr>
      <tr>
        <td height="29" align="right">确认密码：</td>
        <td><label>
          <input type="text" name="repassword" id="textfield3">
          <span id="txtNameMsg3"><font style="font-size:12px; color:#069"></font></span>
        </label></td>
      </tr>
      <tr>
        <td height="31" align="right">用户昵称：</td>
        <td><label>
          <input type="text" name="nickname" id="textfield4">
          <span id="txtNameMsg4"><font style="font-size:12px; color:#069"></font></span>
        </label></td>
      </tr>
      <tr>
        <td height="32" align="right">学院：</td>
        <td><label>
          <input type="text" name="college" id="textfield5">
        </label></td>
      </tr>
      <tr>
        <td height="33" align="right">性别：</td>
        <td><label>
          <input type="radio" name="radio" id="radio1" value="男">
          男
          <input type="radio" name="radio" id="radio2" value="女">
          女</label></td>
      </tr>
      <tr>
        <td height="33" colspan="2" align="center" valign="middle"><div id="apDiv2">
          <input type="submit" name="button" id="button" value="立即注册">
        </div>
          <label> </label></td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>