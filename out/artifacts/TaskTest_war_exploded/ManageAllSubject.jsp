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
		-webkit-animation:mv1 1s;
	}
	@keyframes mv1{
		0%{opacity: 0}
        100%{opacity: 1}
	}
.move2{
		-webkit-animation:mv2 1s;
	}
	@keyframes mv2{
		0%{background-color: whitesmoke}
        30%{background-color: whitesmoke}
		100%{}
	}
	.move3{
		-webkit-animation:mv3 2s;
	}
	@keyframes mv3{
		0%{ opacity: 0;}
		100%{opacity: 1;}
	}
    .move4{
        -webkit-animation:mv4 1s;
    }
    @keyframes mv4{
        0%{right: -300px;}
        100%{right: 0px;}
    }
    .move5{
        -webkit-animation:mv5 2s;
    }
    @keyframes mv5{
        0%{ font-size:0px;}
        50%{ font-size:0px;}
        100%{font-size: 40px;}
    }
    .move6{
        -webkit-animation:mv6 2s;
    }
    @keyframes mv6{
        0%{ opacity: 0;}
        100%{opacity: 1;}
    }
</style>
</head>
<body>
<div id="wrapper">
     <!-- Navigation -->
        <nav class="top1 navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0; background-color:#FFDB63;">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/ManageAllTasks">Content Manage System</a>
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
                <div style="color:white;padding:8px">欢迎!${user.user_name}</div>
            </form>
            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">

                        <li>
                            <a href="#"><i class="fa fa-laptop nav_icon"></i>学生管理<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="/ManageAllUsers">所有学生</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-indent nav_icon"></i>作业管理<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="/AddTask">添加作业</a>
                                </li>
                                <li>
                                    <a href="/ManageAllTasks">管理作业</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-table nav_icon"></i>查看作业<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="/ManageAllSubject">全部题目</a>
                                </li>
                                <li>
                                    <a href="/ManageAllSubjectOfA_Type?check_subject_type=1">选择类</a>
                                </li>
                                <li>
                                    <a href="/ManageAllSubjectOfA_Type?check_subject_type=2">判断类</a>
                                </li>
                                <li>
                                    <a href="/ManageAllSubjectOfA_Type?check_subject_type=3">多选类</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-sitemap fa-fw nav_icon"></i>Product By Yggdrasil<span
                                    class="fa arrow"></span></a>
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

        <div id="page-wrapper" >
            <div class="col-md-12 graphs" >
                   <div class="xs" style="min-height: 900px">
                   <div>
                        <span style="float:left;">选择题：</span>
                        <div style=" float:left;width:10px; height:10px; background-color: #F27A7C; margin-top:6px;margin-right:20px;"></div>
                        <span style="float:left;">判断题：</span>
                        <div style=" float:left;width:10px; height:10px; background-color:#ffc107;  border:1px; ; margin-top:6px;margin-top:6px;margin-right:20px"></div>
                        <span style="float:left;">多选题：</span>
                        <div style=" float:left;width:10px; height:10px; background-color: #6DD3F3; margin-top:6px;margin-right:20px"></div>
                    </div><br>


                <c:forEach items="${task}" var="a">

                    <br><h3>${a.task_name}</h3>

                    <c:if test="${empty a.subject}">
                        <div class="panel panel-warning move1" style="border-color:red">
                            <div class="panel-heading move2" style="background-color:red">
                                <h2>空的题目</h2>

                                <div class="panel-ctrls" data-actions-container="" data-action-collapse="{&quot;target&quot;: &quot;.panel-body&quot;}"><span class="button-icon has-bg"><i class="ti ti-angle-down"></i></span></div>
                            </div>
                            <div class="panel-body no-padding" style="display: block; text-align: center">
                                <h1 style="margin-top: 60px; margin-bottom: 60px;">该作业还没有题目</h1>
                                <button onclick=window.location="/AddSubject?task_id=${a.task_id}&&subject_id=0" type="button" class="btn btn_5 btn-lg btn-primary" > 添加题目  </button>
                                <button onclick=window.location="/DeleteTask?delete_task_id=${a.task_id}" type="button" class="btn btn_5 btn-lg btn-primary" > 删除该作业  </button>
                            </div>
                        </div>
                    </c:if>

                    <c:forEach items="${a.subject}" var="c">
                        <div class="panel panel-warning move1" style="border-color:

                                /*实现颜色*/
                        <c:if test="${c.subject_type%3 == 0 }">#6DD3F3</c:if>
                        <c:if test="${c.subject_type%3 == 1 }">#F27A7C</c:if>
                        <c:if test="${c.subject_type%3 == 2 }"></c:if>
                                ">
                            <div class="panel-heading move2" style="background-color:
                            <c:if test="${c.subject_type%3 == 0 }">#6DD3F3</c:if>
                                <c:if test="${c.subject_type%3 == 1 }">#F27A7C</c:if>
                            <c:if test="${c.subject_type%3 == 2 }"></c:if>
                            ">
                                <h2>${c.subject_title}</h2>
                                <h5 style="float:right; margin-top:-14px; margin-right:13px">
                                    <a href="/UpdateSubject?update_subject_id=${c.subject_id}&&update_task_id=${c.task_id}&&update_subject_type=${c.subject_type}" class="secondary-content" style="color: #6D6D6D"> 修改题目 </a></h5>
                                <h5 style="float:right; margin-top:-14px; margin-right:13px">
                                    <a href="/DeleteSubject?delete_subject_id=${c.subject_id}&&delete_task_id=${c.task_id}" class="secondary-content" style="color:#6D6D6D"> 删除题目 </a>
                                </h5>
                                <div class="panel-ctrls" data-actions-container="" data-action-collapse="{&quot;target&quot;: &quot;.panel-body&quot;}"><span class="button-icon has-bg"><i class="ti ti-angle-down"></i></span></div>
                            </div>
                            <div class="panel-body no-padding" style="display: block;">
                                <table class="table table-striped">
                                    <thead>
                                        <tr class="warning">
                                            <th>答案编号</th>
                                            <th>答案内容</th>
                                            <th style="width:20%">答案正误</th>
                                        </tr>
                                    </thead>
                                    <tbody>

                                    <c:forEach items="${c.choice}" var="b">
                                        <tr>
                                            <td>${b.choice_id}</td>
                                            <td>${b.choice_content}</td>
                                            <td>
                                                <c:if test="${b.choice_isTrue == 1}">
                                                    正确
                                                </c:if>
                                                <c:if test="${b.choice_isTrue == 0}">
                                                    错误
                                                </c:if>
                                            </td>
                                        </tr>
                                    </c:forEach>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </c:forEach>
                </c:forEach>

                       <c:if test="${empty task[0]}">
                           <br>
                           <div class="col-md-8 inbox_right move4">
                               <div class="Compose-Message">
                                   <div class="panel panel-default">
                                       <div class="panel-heading">
                                           <h4>Danger</h4>
                                       </div>
                                       <div class="panel-body">
                                           <br><br><br>
                                           <div class="alert alert-danger move6" style=" font-size:40px; text-align:center; height:220px">
                                               <div class="move5" style=" margin-top:66px;"><b>提示:</b>还没有作业</div>
                                           </div><br>

                                           <div style=" text-align:center;"><br>
                                               <h3 class="h3">你可以:</h3><br>
                                               <button onclick='window.location="${user.user_lase_view_page}"' type="button" class="btn btn_5 btn-lg btn-danger">  &nbsp; 返回&nbsp;&nbsp;&nbsp;   </button>&nbsp;
                                               <button onclick='window.location="/AddTask"' type="button" class="btn btn_5 btn-lg btn-primary">  &nbsp; 添加作业&nbsp;&nbsp;&nbsp;   </button>&nbsp;
                                           </div>
                                       </div>
                                   </div>
                               </div>
                           </div>
                       </c:if>

                    </div>
            </div>
   </div>
  </div>
      <!-- /#page-wrapper -->
   </div>
    <!-- /#wrapper -->
    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>
