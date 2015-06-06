<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>你好，请登录</title>
<style type="text/css">
<!--
#apDiv1 {
	position:absolute;
	width:200px;
	height:247px;
	z-index:1;
	left: 929px;
	top: 154px;
}
-->
</style>
</head>
<style type="text/css">
body,td,th {
	color: #FFFFCC;
	font-size: 14px;
}
</style>

<body>

<div style="width:500px;margin:0 auto;">

	<canvas id="clock" width="500" height="500" onClick=resetcolor()>
		您的浏览器不支持canvas标签!
	</canvas>

</div>

<script>
	var clock=document.getElementById("clock");
	var cxt=clock.getContext("2d");
	var colr=(200+Math.floor(Math.random()*55.99));
	var colg=(200+Math.floor(Math.random()*55.99));
	var colb=(200+Math.floor(Math.random()*55.99));
	
	function resetcolor(){
		colr=(200+Math.floor(Math.random()*55.99));
		colg=(200+Math.floor(Math.random()*55.99));
		colb=(200+Math.floor(Math.random()*55.99));
	}
	
	function drawClock(){
	//获取时间
	var now=new Date();
	var hou=now.getHours();
	var min=now.getMinutes();
	var sec=now.getSeconds();
	var mec=now.getMilliseconds();
	
	//转换12小时进制
	hou=hou>12?hou-12:hou;
	//清空画布
	cxt.clearRect(0,0,500,500);
	//阴影
	cxt.fill();
	cxt.fillStyle="gray";
	cxt.beginPath();
	cxt.arc(270,260,205,0,Math.PI*2,true);
	cxt.closePath();
	cxt.fill();
	//表盘
	cxt.fill();
	cxt.fillStyle="white";
	cxt.beginPath();
	cxt.arc(250,250,205,0,Math.PI*2,true);
	cxt.closePath();
	cxt.fill();
	//蓝色表盘（边框）
	cxt.strokeStyle="#dddddd"
	cxt.lineWidth=10;
	cxt.beginPath();
	cxt.arc(250,250,185,0,Math.PI*2,true);
	cxt.closePath();
	cxt.stroke();
	cxt.strokeStyle="#"+colr.toString(16)+colg.toString(16)+colb.toString(16);
	cxt.lineWidth=10;
	cxt.beginPath();
	cxt.arc(250,250,200,0,Math.PI*2,true);
	cxt.closePath();
	cxt.stroke();
	cxt.strokeStyle="#"+colr.toString(16)+colg.toString(16)+colb.toString(16);
	cxt.lineWidth=3;
	cxt.beginPath();
	cxt.arc(250,250,192,0,Math.PI*2,true);
	cxt.closePath();
	cxt.stroke();
	cxt.strokeStyle="#"+(colr-100).toString(16)+(colg-100).toString(16)+(colb-100).toString(16);
	cxt.lineWidth=5;
	cxt.beginPath();
	cxt.arc(250,250,205,0,Math.PI*2,true);
	cxt.closePath();
	cxt.stroke();
	//刻度（时分）
		//时刻度
		for(var i=0;i<12;i++){
			cxt.save();
			cxt.lineWidth=5;
			cxt.strokeStyle="black";
			//设置原点
			cxt.translate(250,250);
			//设置旋转角度;
			cxt.rotate(30*i/180*Math.PI);
			cxt.beginPath();
			cxt.moveTo(0,180);
			cxt.lineTo(0,160);
			cxt.closePath();
			cxt.stroke();
			cxt.restore();
		}
		//分刻度
		for(var i=0;i<60;i++){
			if(i%5!=0){
				cxt.save();
				cxt.lineWidth=2;
				cxt.strokeStyle="black";
				//设置原点
				cxt.translate(250,250);
				//设置旋转角度;
				cxt.rotate(6*i/180*Math.PI);
				cxt.beginPath();
				cxt.moveTo(0,175);
				cxt.lineTo(0,165);
				cxt.closePath();
				cxt.stroke();
				cxt.restore();
			}
		}
	//指针（时分秒）
	//时针
	cxt.save();
	cxt.lineWidth=12;
	cxt.strokeStyle="black";
	cxt.beginPath();
	cxt.translate(250,250);
	cxt.rotate((hou*30+min*0.5+180)/180*Math.PI);
	cxt.moveTo(0,0);
	cxt.lineTo(0,90);
	cxt.closePath();
	cxt.stroke()
	cxt.restore();
	//分针
	cxt.save();
	cxt.lineWidth=5;
	cxt.strokeStyle="black";
	cxt.beginPath();
	cxt.translate(250,250);
	cxt.rotate((min*6+sec*0.1+180)/180*Math.PI);
	cxt.moveTo(0,0);
	cxt.lineTo(0,130);
	cxt.closePath();
	cxt.stroke()
	cxt.restore();
	//秒针
	cxt.save();
	cxt.lineWidth=2;
	cxt.strokeStyle="red";
	cxt.beginPath();
	cxt.translate(250,250);
	cxt.rotate((sec*6+mec*0.006+180)/180*Math.PI);
	cxt.moveTo(0,0);
	cxt.lineTo(0,150);
	cxt.closePath();
	cxt.stroke();
	cxt.fillStyle="red";
	cxt.beginPath();
	cxt.arc(0,148,4,0,Math.PI*2,true);
	cxt.closePath();
	cxt.fill();
	cxt.fillStyle="white";
	cxt.beginPath();
	cxt.arc(0,148,2,0,Math.PI*2,true);
	cxt.closePath();
	cxt.fill();
	cxt.restore();
	//秒针装饰
	cxt.fillStyle="red";
	cxt.beginPath();
	cxt.arc(250,250,15,0,Math.PI*2,true);
	cxt.closePath();
	cxt.fill();
	cxt.fillStyle="black";
	cxt.beginPath();
	cxt.arc(250,250,13,0,Math.PI*2,true);
	cxt.closePath();
	cxt.fill();
	cxt.fillStyle="white";
	cxt.beginPath();
	cxt.arc(250,250,10,0,Math.PI*2,true);
	cxt.closePath();
	cxt.fill();
	
}
drawClock();
//使用setInterval(代码,周期(毫秒制))让时钟动起来
setInterval(drawClock,10);
</script>
<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
</div>
<div id="apDiv1">
<form name="form1" method="post" action="/cate/LoginServlet">
  <table width="200" height="189" border="1">
    <tr>
      <td width="64" height="49" bgcolor="#00CCFF">账号</td>
      <td width="120"><label>
        <input type="text" name="account" id="account" />
      </label></td>
    </tr>
    <tr>
      <td height="50" bgcolor="#00FFFF">密码</td>
      <td><label>
        <input type="text" name="password" id="password" />
      </label></td>
    </tr>
    <tr>
      <td height="45" colspan="2"align="center" valign="middle" bgcolor="#CC9900"><input type="submit" name="submit" id="submit" value="立刻登陆浏览更多信息"></td>
    </tr>
    <tr>
      <td colspan="2" bgcolor="#33CC33">还没账号？赶紧&nbsp;&nbsp;&nbsp;
	
	<a href="/cate/JSP/frame.jsp">注册</a>
    	</td>
    </tr>
  </table>
  </form>
</div>
</body>
</html><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>时间到了！</title>
</head>



 <body background="a/1.jpg" no-repeat><div class="all">
<div style="width:500px;margin:0 auto;">

	<canvas id="clock" width="500" height="500" onClick=resetcolor()>
		您的浏览器不支持canvas标签!
	</canvas>

</div>

<script>
	var clock=document.getElementById("clock");
	var cxt=clock.getContext("2d");
	var colr=(200+Math.floor(Math.random()*55.99));
	var colg=(200+Math.floor(Math.random()*55.99));
	var colb=(200+Math.floor(Math.random()*55.99));
	
	function resetcolor(){
		colr=(200+Math.floor(Math.random()*55.99));
		colg=(200+Math.floor(Math.random()*55.99));
		colb=(200+Math.floor(Math.random()*55.99));
	}
	
	function drawClock(){
	//获取时间
	var now=new Date();
	var hou=now.getHours();
	var min=now.getMinutes();
	var sec=now.getSeconds();
	var mec=now.getMilliseconds();
	
	//转换12小时进制
	hou=hou>12?hou-12:hou;
	//清空画布
	cxt.clearRect(0,0,500,500);
	//阴影
	cxt.fill();
	cxt.fillStyle="gray";
	cxt.beginPath();
	cxt.arc(270,260,205,0,Math.PI*2,true);
	cxt.closePath();
	cxt.fill();
	//表盘
	cxt.fill();
	cxt.fillStyle="white";
	cxt.beginPath();
	cxt.arc(250,250,205,0,Math.PI*2,true);
	cxt.closePath();
	cxt.fill();
	//蓝色表盘（边框）
	cxt.strokeStyle="#dddddd"
	cxt.lineWidth=10;
	cxt.beginPath();
	cxt.arc(250,250,185,0,Math.PI*2,true);
	cxt.closePath();
	cxt.stroke();
	cxt.strokeStyle="#"+colr.toString(16)+colg.toString(16)+colb.toString(16);
	cxt.lineWidth=10;
	cxt.beginPath();
	cxt.arc(250,250,200,0,Math.PI*2,true);
	cxt.closePath();
	cxt.stroke();
	cxt.strokeStyle="#"+colr.toString(16)+colg.toString(16)+colb.toString(16);
	cxt.lineWidth=3;
	cxt.beginPath();
	cxt.arc(250,250,192,0,Math.PI*2,true);
	cxt.closePath();
	cxt.stroke();
	cxt.strokeStyle="#"+(colr-100).toString(16)+(colg-100).toString(16)+(colb-100).toString(16);
	cxt.lineWidth=5;
	cxt.beginPath();
	cxt.arc(250,250,205,0,Math.PI*2,true);
	cxt.closePath();
	cxt.stroke();
	//刻度（时分）
		//时刻度
		for(var i=0;i<12;i++){
			cxt.save();
			cxt.lineWidth=5;
			cxt.strokeStyle="black";
			//设置原点
			cxt.translate(250,250);
			//设置旋转角度;
			cxt.rotate(30*i/180*Math.PI);
			cxt.beginPath();
			cxt.moveTo(0,180);
			cxt.lineTo(0,160);
			cxt.closePath();
			cxt.stroke();
			cxt.restore();
		}
		//分刻度
		for(var i=0;i<60;i++){
			if(i%5!=0){
				cxt.save();
				cxt.lineWidth=2;
				cxt.strokeStyle="black";
				//设置原点
				cxt.translate(250,250);
				//设置旋转角度;
				cxt.rotate(6*i/180*Math.PI);
				cxt.beginPath();
				cxt.moveTo(0,175);
				cxt.lineTo(0,165);
				cxt.closePath();
				cxt.stroke();
				cxt.restore();
			}
		}
	//指针（时分秒）
	//时针
	cxt.save();
	cxt.lineWidth=12;
	cxt.strokeStyle="black";
	cxt.beginPath();
	cxt.translate(250,250);
	cxt.rotate((hou*30+min*0.5+180)/180*Math.PI);
	cxt.moveTo(0,0);
	cxt.lineTo(0,90);
	cxt.closePath();
	cxt.stroke()
	cxt.restore();
	//分针
	cxt.save();
	cxt.lineWidth=5;
	cxt.strokeStyle="black";
	cxt.beginPath();
	cxt.translate(250,250);
	cxt.rotate((min*6+sec*0.1+180)/180*Math.PI);
	cxt.moveTo(0,0);
	cxt.lineTo(0,130);
	cxt.closePath();
	cxt.stroke()
	cxt.restore();
	//秒针
	cxt.save();
	cxt.lineWidth=2;
	cxt.strokeStyle="red";
	cxt.beginPath();
	cxt.translate(250,250);
	cxt.rotate((sec*6+mec*0.006+180)/180*Math.PI);
	cxt.moveTo(0,0);
	cxt.lineTo(0,150);
	cxt.closePath();
	cxt.stroke();
	cxt.fillStyle="red";
	cxt.beginPath();
	cxt.arc(0,148,4,0,Math.PI*2,true);
	cxt.closePath();
	cxt.fill();
	cxt.fillStyle="white";
	cxt.beginPath();
	cxt.arc(0,148,2,0,Math.PI*2,true);
	cxt.closePath();
	cxt.fill();
	cxt.restore();
	//秒针装饰
	cxt.fillStyle="red";
	cxt.beginPath();
	cxt.arc(250,250,15,0,Math.PI*2,true);
	cxt.closePath();
	cxt.fill();
	cxt.fillStyle="black";
	cxt.beginPath();
	cxt.arc(250,250,13,0,Math.PI*2,true);
	cxt.closePath();
	cxt.fill();
	cxt.fillStyle="white";
	cxt.beginPath();
	cxt.arc(250,250,10,0,Math.PI*2,true);
	cxt.closePath();
	cxt.fill();
	
}
drawClock();
//使用setInterval(代码,周期(毫秒制))让时钟动起来
setInterval(drawClock,10);
</script>
<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
</div>
</body>
</html>