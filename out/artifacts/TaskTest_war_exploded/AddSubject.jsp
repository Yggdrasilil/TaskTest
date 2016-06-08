<%--
  Created by IntelliJ IDEA.
  User: Yggdrasil
  Date: 16/6/7
  Time: 下午7:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
</head>
<body>
<div id="wrapper">
    <!-- Navigation -->
    <nav class="top1 navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.html">Content Manage System</a>
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
            <div style="color:white;padding:8px">欢迎${user.user_name}</div>
        </form>
        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">
                <ul class="nav" id="side-menu">

                    <li>
                        <a href="#"><i class="fa fa-laptop nav_icon"></i>学生管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="grids.html">所有学生</a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-indent nav_icon"></i>作业管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="graphs.html">添加作业</a>
                            </li>
                            <li>
                                <a href="typography.html">管理作业</a>
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
                            <li>
                                <a href="basic_tables.html">选择类</a>
                            </li>
                            <li>
                                <a href="basic_tables.html">判断类</a>
                            </li>
                            <li>
                                <a href="basic_tables.html">多选类</a>
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
                                <a href="login.html">项目感想</a>
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
        <div class="graphs">
            <div class="xs">


                <div class="col-md-8 inbox_right">
                    <div class="Compose-Message">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4>添加新的题目 </h4>
                            </div>
                            <form class="panel-body" method="post" action="/AddSubject">
                                    <div class="alert alert-warning" role="alert" style="margin-bottom:-1%">
                                        <strong>提示：</strong> 请选择要添加的题目的类型
                                    </div><br>
                                    <table class="table">
                                        <tbody>
                                        <tr class="unread checked">
                                            <td class="hidden-xs">
                                                <input name="subject_type" value="3" type="radio">
                                            <td class="hidden-xs">

                                            </td>
                                            <td class="hidden-xs">
                                                多选题：
                                            </td>
                                            <td>
                                                可以选择多个下选项
                                            </td>
                                            <td>
                                            </td>
                                            <td>
                                                难度系数&nbsp;&nbsp;
                                                <i class="fa fa-star icon-state-warning"></i>
                                                <i class="fa fa-star icon-state-warning"></i>
                                                <i class="fa fa-star icon-state-warning"></i>
                                            </td>
                                        </tr>
                                        <tr class="unread checked">
                                            <td class="hidden-xs">
                                                <input name="subject_type" value="1" type="radio" checked>
                                            </td>
                                            <td class="hidden-xs">

                                            </td>
                                            <td class="hidden-xs">
                                                单选题：
                                            </td>
                                            <td>
                                                一次只能选择一个选项
                                            </td>
                                            <td>
                                            </td>
                                            <td>
                                                难度系数&nbsp;&nbsp;
                                                <i class="fa fa-star icon-state-warning"></i>
                                                <i class="fa fa-star icon-state-warning"></i>
                                            </td>
                                        </tr>
                                        <tr class="unread checked">
                                            <td class="hidden-xs">
                                                <input name="subject_type" value="2" type="radio">
                                            </td>
                                            <td class="hidden-xs">

                                            </td>
                                            <td class="hidden-xs">
                                                判断题：
                                            </td>
                                            <td>
                                                每道题只有两个答案，判断正误
                                            </td>
                                            <td>
                                            </td>
                                            <td>
                                                难度系数&nbsp;
                                                <i class="fa fa-star icon-state-warning"></i>
                                            </td>
                                        </tr>

                                        </tbody>
                                    </table>
                                    <input value="确定"  type="submit" class="btn btn-success warning_2" style="background-color:#ffc107 ; border-color:#ffc107 ; font-size: 23px;"></input>&nbsp;&nbsp;
                                <button onclick='window.location=${user.user_last_view_page}' type="button" class="btn btn_5 btn-lg btn-default">取消</button>
                            </form>

                                <br>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="clearfix"> </div>
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
