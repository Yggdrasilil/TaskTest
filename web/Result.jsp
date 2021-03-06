<%@ page contentType="text/html;charset=GBK" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<meta name="keywords" content="Modern Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
 <!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- Graph CSS -->
<link href="css/lines.css" rel='stylesheet' type='text/css' />
<link href="css/font-awesome.css" rel="stylesheet">
<!-- jQuery -->
<script src="js/jquery.min.js"></script>
<!----webfonts--->
<!---//webfonts--->
<!-- Nav CSS -->
<link href="css/custom.css" rel="stylesheet">
<!-- Metis Menu Plugin JavaScript -->
<script src="js/metisMenu.min.js"></script>
<script src="js/custom.js"></script>
<!-- Graph JavaScript -->
<script src="js/d3.v3.js"></script>
<script src="js/rickshaw.js"></script>
<style>
	.move1{
		-webkit-animation:mv1 3s;
	}
	@keyframes mv1{
		0%{width: 0;}
		70%{width: 10%;}
		<%--100%{width: ${final_score}}--%>
	}
	.move2{
		-webkit-animation:mv2 3s;
	}
	@keyframes mv2{
		0%{opacity:0;}
		20%{opacity:1;}
		40%{opacity:0;}
		60%{opacity:1;}
		80%{opacity:0;}
		100%{opacity:1;}
	}
	.move3{
		-webkit-animation:mv3 3s;
	}
	@keyframes mv3{
		0%{opacity:0; font-size:0px;}
	
		70%{opacity:0; font-size:0px;}
		100%{opacity:1; font-size:30px;}
	}
	.change{
		-webkit-animation:cg 3s;
	}
	@keyframes cg{
		0%{ background-color:#FF5154;}
		30%{background-color:#FF5154;}
		100%{background-color:#78cd51;}
	}

</style>
</head>
<body>
<div id="wrapper">
     <!-- Navigation -->
        <nav class="top1 navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0 ; ">
            <div class="navbar-header" >
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Do your homework !</a>
            </div>
            <!-- /.navbar-header -->
            <ul class="nav navbar-nav navbar-right">
				<li class="dropdown">

	        		<ul class="dropdown-menu">
						<li class="dropdown-menu-header">
							<strong>Messages</strong>
							<div class="progress thin">
							  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
							    <span class="sr-only">40% Complete (success)</span>
							  </div>
							</div>
						</li>
						<li class="avatar">
							<a href="#">
								<img src="images/1.png" alt=""/>
								<div>New message</div>
								<small>1 minute ago</small>
								<span class="label label-info">NEW</span>
							</a>
						</li>
						<li class="avatar">
							<a href="#">
								<img src="images/2.png" alt=""/>
								<div>New message</div>
								<small>1 minute ago</small>
								<span class="label label-info">NEW</span>
							</a>
						</li>
						<li class="avatar">
							<a href="#">
								<img src="images/3.png" alt=""/>
								<div>New message</div>
								<small>1 minute ago</small>
							</a>
						</li>
						<li class="avatar">
							<a href="#">
								<img src="images/4.png" alt=""/>
								<div>New message</div>
								<small>1 minute ago</small>
							</a>
						</li>
						<li class="avatar">
							<a href="#">
								<img src="images/5.png" alt=""/>
								<div>New message</div>
								<small>1 minute ago</small>
							</a>
						</li>
						<li class="avatar">
							<a href="#">
								<img src="images/pic1.png" alt=""/>
								<div>New message</div>
								<small>1 minute ago</small>
							</a>
						</li>
						<li class="dropdown-menu-footer text-center">
							<a href="#">View all messages</a>
						</li>
	        		</ul>
	      		</li>
			    <li class="dropdown">
	        		<ul class="dropdown-menu">
						<li class="dropdown-menu-header text-center">
							<strong>Account</strong>
						</li>
						<li class="m_2"><a href="#"><i class="fa fa-bell-o"></i> Updates <span class="label label-info">42</span></a></li>
						<li class="m_2"><a href="#"><i class="fa fa-envelope-o"></i> Messages <span class="label label-success">42</span></a></li>
						<li class="m_2"><a href="#"><i class="fa fa-tasks"></i> Tasks <span class="label label-danger">42</span></a></li>
						<li><a href="#"><i class="fa fa-comments"></i> Comments <span class="label label-warning">42</span></a></li>
						<li class="dropdown-menu-header text-center">
							<strong>Settings</strong>
						</li>
						<li class="m_2"><a href="#"><i class="fa fa-user"></i> Profile</a></li>
						<li class="m_2"><a href="#"><i class="fa fa-wrench"></i> Settings</a></li>
						<li class="m_2"><a href="#"><i class="fa fa-usd"></i> Payments <span class="label label-default">42</span></a></li>
						<li class="m_2"><a href="#"><i class="fa fa-file"></i> Projects <span class="label label-primary">42</span></a></li>
						<li class="divider"></li>
						<li class="m_2"><a href="#"><i class="fa fa-shield"></i> Lock Profile</a></li>
						<li class="m_2"><a href="#"><i class="fa fa-lock"></i> Logout</a></li>
	        		</ul>
	      		</li>
			</ul>
			<form class="navbar-form navbar-right">
              <div style="color:white;padding:8px">欢迎！${userName}</div>
            </form>
            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">

                     
                        <li>
                            <a href="#"><i class="fa fa-indent nav_icon"></i>我的信息<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="graphs.html">我的成绩</a>
                                </li>
                                <li>
                                    <a href="typography.html">个人信息</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-table nav_icon"></i>查看作业<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="basic_tables.html">全部作业</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-sitemap fa-fw nav_icon"></i>Product By Yggdrasil<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="media.html">我的信息</a>
                                </li>
                                <li>
                                    <a href="Login.jsp">项目感想</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>
        <div id="page-wrapper">
<div class="col-md-12 graphs">
	   <div class="xs" style="min-height:1000px;">
  	<div class="col-md-8 inbox_right" style="width:90%;">
        	<div class="Compose-Message">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4>统计</h4>
                    </div>
                    <div class="panel-body">
                    <br>
                        <div class="alert alert-info">
                            你的成绩
                        </div>
                        <br>
                        
                        <div class="col-sm-3 widget_1_box" style=" width:100%;">
                        <div class="tile-progress bg-info change" style="min-height: 400px; ">
                            <div class="content" style="margin-top: 50px;">
                        <h4 class="move2" style="font-size: 70px;"><i class="fa fa-dashboard icon-sm move2" style="font-size: 80px;"></i>最终成绩</h4>
                        <div class="progress" style="min-height: 60px;">
                        
                        <div class="progress-bar inviewport animated visible slideInLeft move1" style="width: ${final_score*100}%;"></div>
                        
                        </div>
                        <span class="move3" style="font-size:30px;">正确率${final_score*100}%</span>
                            </div>
                        </div>
                     </div>
             
                        <br><br><br><br>
                        <div>
                        <button onclick='window.location="${user.user_last_view_page}" ' type="button" class="btn btn_5 btn-lg btn-primary">  &nbsp; 确定&nbsp;&nbsp;&nbsp;   </button>&nbsp;
                      </div>
                    </div>
                 </div>
              </div>
         </div>

        </div>
      <!-- /#page-wrapper -->
   </div>
    <!-- /#wrapper -->
    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
  </div>
 </div>
</body>

</html>
