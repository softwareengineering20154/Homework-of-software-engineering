<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
        .all{ margin:20px auto; width:1010px; height:70px;}
        .all .bll{width:70px; height:70px; float:left; margin-left:10px;}
        .all .bll .list{ width:50px; height:50px; -moz-border-radius:10px;border-radius:10px;cursor:pointer;margin:0px auto; margin-top:10px;line-height:50px; text-align:center;color:White; font-weight:500; font-size:18px; font-family:@新宋体;}
        .divradius{ -moz-border-radius:50px;border-radius:50px;line-height:60px;}
		
		.all .bll .backc1:hover{ -moz-border-radius:50px;border-radius:50px;}
		
		.all .bll .backc6:hover{ -moz-border-radius:50px;border-radius:50px;}
		
		.all .bll .backc7:hover{-moz-box-shadow: 5px 5px 5px #888888;box-shadow: 5px 5px 5px #888888;}
		
		.all .bll .backc8
		{
            transition:width 1s, height 1s;
            -moz-transition:width 1s, height 1s, -moz-transform 1s; /* Firefox 4 */
            -webkit-transition:width 1s, height 1s, -webkit-transform 1s; /* Safari and Chrome */
            -o-transition:width 1s, height 1s, -o-transform 1s; /* Opera */
		}
		.all .bll .backc8:hover
		{
            transform:rotateY(360deg);
            -moz-transform:rotateY(360deg); /* Firefox 4 */
            -webkit-transform:rotateY(360deg); /* Safari and Chrome */
            -o-transform:rotateY(360deg); /* Opera */
		}
		
		.all .bll .backc9
		{
            transition:width 1s, height 1s;
            -moz-transition:width 1s, height 1s, -moz-transform 1s; /* Firefox 4 */
            -webkit-transition:width 1s, height 1s, -webkit-transform 1s; /* Safari and Chrome */
            -o-transition:width 1s, height 1s, -o-transform 1s; /* Opera */
		}
		.all .bll .backc9:hover
		{
            transform:rotateX(360deg);
            -moz-transform:rotateX(360deg); /* Firefox 4 */
            -webkit-transform:rotateX(360deg); /* Safari and Chrome */
            -o-transform:rotateX(360deg); /* Opera */
		}
		
		.all .bll .backc10
		{
            transition:width 0.5s, height 0.5s;
            -moz-transition:width 0.5s, height 0.5s, -moz-transform 0.5s; /* Firefox 4 */
            -webkit-transition:width 0.5s, height 0.5s, -webkit-transform 0.5s; /* Safari and Chrome */
            -o-transition:width 0.5s, height 0.5s, -o-transform 0.5s; /* Opera */
		}
		.all .bll .backc10:hover
		{
            transform:rotate(45deg);
            -moz-transform:rotate(45deg); /* Firefox 4 */
            -webkit-transform:rotate(45deg); /* Safari and Chrome */
            -o-transform:rotate(45deg); /* Opera */
		}
		
		.all .bll .backc11
		{
            transition:width 0.5s, height 0.5s;
            -moz-transition:width 0.5s, height 0.5s, -moz-transform 0.5s; /* Firefox 4 */
            -webkit-transition:width 0.5s, height 0.5s, -webkit-transform 0.5s; /* Safari and Chrome */
            -o-transition:width 0.5s, height 0.5s, -o-transform 0.5s; /* Opera */
		}
		.all .bll .backc11:hover
		{
		    width:60px;
            height:60px;
            line-height:60px;
            margin-top:5px;
            transform:rotate(360deg);
            -moz-transform:rotate(360deg); /* Firefox 4 */
            -webkit-transform:rotate(360deg); /* Safari and Chrome */
            -o-transform:rotate(360deg); /* Opera */
		}
		
		.all .bll a{text-decoration:none;}
        .backc1{ background-color:#66cccc;}
		.backc2{ background-color:#cc6633;}
		.backc3{ background-color:#999933;}
		.backc4{ background-color:#669933;}
		.backc5{ background-color:#cc9933;}
		.backc6{ background-color:#cc6666;}
		.backc7{ background-color:#336666;}
		.backc8{ background-color:#cc6633;}
		.backc9{ background-color:#5B5B00;}
		.backc10{ background-color:#ff9966;}
		.backc11{ background-color:#669999;}
    #apDiv1 {
	position:absolute;
	width:200px;
	height:115px;
	z-index:1;
	left: 401px;
	top: 19px;
}
#apDiv2 {
	position:absolute;
	width:119px;
	height:99px;
	z-index:2;
	left: 738px;
	top: 21px;
}
#apDiv3 {
	position:absolute;
	width:200px;
	height:115px;
	z-index:1;
	left: 136px;
	top: -9px;
}
</style>
<script type="text/javascript" src="js/jquery-1.5.2.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $(".backc2").mouseover(function () {
                $(this).animate({ marginTop: "5px" }, 200);
            });
            $(".backc2").mouseleave(function () {
                $(this).animate({ marginTop: "10px" }, 200);
            });

            $(".backc3").mouseover(function () {
                $(this).animate({ marginTop: "5px" }, 200);
                $(this).animate({ marginTop: "10px" }, 200);
            });

            $(".backc4").mouseover(function () {
                $(this).fadeTo(300, 0.3);
            });
            $(".backc4").mouseleave(function () {
                $(this).fadeTo(300, 1);
            });

            $(".backc5").mouseover(function () {
                $(this).fadeTo(400, 0.3);
                $(this).fadeTo(400, 1);
            });

            $(".backc6").mouseover(function () {
                $(this).addClass("divradius").fadeTo(300, 0.3);
            });
            $(".backc6").mouseleave(function () {
                $(this).removeClass("divradius").fadeTo(300, 1);
            });
        });
    </script>
    <script language="javascript">
		function gotoExit(){
	this.parent.location = 'clock.html';
	}
</script>
</head>
<body>
<c:if test="${empty sessionScope.user }">
	<script>
		alert("你怎么不登陆，快去登录！！！！");
		this.parent.location="/cate/jsp/clock.html";
	</script>
</c:if>
<div id="apDiv1">
 <div class="all">
        <div class="bll"><a href="select.jsp" target="show">
          <div class="list backc1">好友</div></a></div>  
        <div class="bll"><a href="register.jsp" target="show">
          <div class="list backc6">资讯</div></a></div>
        <div class="bll"><a href="#" target="show">
          <div class="list backc7">帖子</div></a></div>
        <div class="bll"><a href="#" target="show"><div class="list backc11">空间</div></a></div>
  </div>
</div>
<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
  <div id="apDiv2">
    <div id="apDiv3">
      <table width="100%" border="0">
  <tr>
    <td height="93">欢迎登录, ${sessionScope.user.nickname }&nbsp;&nbsp; &nbsp;<img id="photo" name="photo" width="39" height="50" src="/nk12-RegLogin/upload/images/photo/${sessionScope.user.context }"/>&nbsp; &nbsp;<a href="javascript:gotoExit();">退出</a></td>
  </tr>
  <tr>
    <td height="376">&nbsp;</td>
  </tr>
  <tr>
    <td height="137">&nbsp;</td>
  </tr>
</table>
  </div>
  <a href="javascript:gotoExit();"><img src="images/4.jpg" width="103" height="96" alt="tx"></a> </div>
</div>
</body>
</html>