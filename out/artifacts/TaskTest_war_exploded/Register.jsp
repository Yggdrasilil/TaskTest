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


@keyframes miss{
    0% {opacity:1;}
  100% {opacity:0;}
}


</style>
<script>
function  myFunction(){
    var form1=document.getElementById("form1");
    var head2=document.getElementById("head2");
    form1.className+=" InputMiss";
    head2.className+=" headMiss";
    var i=0;
    setTimeout(test(), 10000);

}
function test(){
  var form1=document.getElementById("form1");
  alert("欢迎！");
  form1.submit();
}

function check(form) {
    var p1 = form.user_password;
    var p2 = form.passwd2;
    if (p1.value != p2.value) {
        p2.oninvalid();
        return false;
    }
    return true;
}
onload = function() {
    var p2 = document.forms["my_f1"].passwd2;
    p2.oninvalid = function() {
        this.setCustomValidity("密码不一致，请重新输入");
    }
    p2.oninput = function() {
        this.setCustomValidity("");
    }

}
</script>


</head>
<body id="login">
  <div class="login-logo">
  </div>
  <h2 id="head2"class="form-heading moveH">
      <c:if test="${empty errorInfo}">
          Welcome
      </c:if>
      <c:if test="${!empty errorInfo}">
          ${errorInfo}
      </c:if>
  </h2>


    <form class="form-signin app-cam bigInput" action="/Register" method="post" name="my_f1" onsubmit="return check(this);">
      <p></p>
        <p>
            在下面输入你的个人信息
        </p>
      <input name="user_name" type="text" class="form-control1" placeholder="全名" autofocus>
      <input name="user_dept" type="text" class="form-control1" placeholder="系别" autofocus>
      <input name="user_class" type="text" class="form-control1" placeholder="专业" autofocus>
      <div class="radios">
        <label class="label_radio">
            <input name="user_sex" type="radio" value="男"> 男孩儿
        </label>
        <label class="label_radio">
            <input name="user_sex" type="radio" value="女"> 女孩儿
        </label>
	  </div>
	  <p> 填写你的帐号信息</p>
      <input name="user_id" type="text" class="form-control1" placeholder="用户名" autofocus>

      <input name="user_password" type="password" required="true"  class="form-control1" placeholder="密码"/>
      <input name="passwd2" type="password" required="true"  class="form-control1" placeholder="重新输入密码"/>

      <label class="checkbox-custom check-success">
          <input type="checkbox" value="agree this condition" id="checkbox1"> <label for="checkbox1">我同意锦城123校规！</label>
      </label>

      <input class="btn btn-lg btn-success1 btn-block" type="submit" value="提交" />

      <div class="registration" style=" margin-bottom:100px;">
          已经注册？那你跑这来干嘛
          <a class="" href="Login.jsp">
              点这登陆
          </a>
      </div>
  </form>

</body>
</html>
