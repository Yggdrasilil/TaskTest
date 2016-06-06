<%@ page contentType="text/html;charset=GBK" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Welcome</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<meta name="keywords" content="Modern Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
 <!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/font-awesome.css" rel="stylesheet">
<!-- jQuery -->
<script src="js/jquery.min.js"></script>
<!----webfonts--->
<!---//webfonts--->
<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>
<style type="text/css">

.moveH{
  -webkit-animation:headmove 2s; /* Safari and Chrome */
}
@keyframes headmove
{
  0% {font-size:0px;}
30% {font-size:0px;}
100% {font-size: 119px;}
}


.bigInput{
  -webkit-animation:big 2.5s;
}
@keyframes big{
    0% {opacity:0;}
  50%   {opacity:0.1;}
  100% {opacity:1;}
}

.InputMiss{
  -webkit-animation:miss 2.5s;
}
@keyframes miss{
    0% {opacity:1;}
  100% {opacity:0;}
}


.headMiss{
  -webkit-animation:hdmiss 2.5s;
}@keyframes hdmiss{
  0% {font-size:119px;}
  100% {font-size: 0px;}
}

</style>



</head>
<body id="login">
  <div class="login-logo">
  </div>
  <h2 id="head2"class="form-heading moveH">
      <c:if test="${empty errorInfo}">
          Yggdrasil
      </c:if>
      <c:if test="${!empty errorInfo}">
          ${errorInfo}
      </c:if>
  </h2>
  <div class="app-cam">

	  <form id="form1" class="bigInput" action="/Login" method="post">
		<input name="user_id" type="text" class="text" value="帐号" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '帐号';}">
		<input name="user_password" type="password" value="密码密码你的密码" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '密码密码你的密码';}">
		<input class="submit" type="submit" value="登陆"></input>
		<div class="login-social-link">
          <a href="/Register.jsp" class="twitter" style=" margin-bottom:600px;">
              注册
          </a>
        </div>
	</form>
  
  </div>
</body>
</html>
