<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta charset="utf-8">
    <meta name = "viewport" content="width=device-width, initial-scle=1.0">
    <title>自动化测试日志平台</title>

    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="resources/css/jquery.jgrowl.css" rel="stylesheet">
    <link href="resources/css/plugins/morris/morris-0.4.3.min.css" rel="stylesheet">
    <link href="resources/css/plugins/timeline/timeline.css" rel="stylesheet">

    <link href="resources/css/admin.css" rel="stylesheet">
</head>

<body>
    <div id="wrapper">
        <nav class="navbar navbar-default navbar-fixed-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/index.jsp">自动化测试日志平台</a>
            </div>

            <ul class="nav navbar-top-links navbar-right">
                <!-- 导航栏 用户信息 -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li>
                            <a href="#" data-toggle="modal" data-target="#editinfoModal"><i class="fa fa-user fa-fw"></i> 用户信息  </a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-gear fa-fw"></i> 用户设置</a>
                        </li>
                        <li>
                            <a href="#" data-toggle="modal" data-target="#editkeyModal"><i class="fa fa-gear fa-fw"></i> 密码修改</a>
                        </li>
                        <li class="divider">
                        </li>
                        <li>
                            <a href="/index.jsp"><i class="fa fa-sign-out fa-fw"></i> 注销</a>
                        </li>
                    </ul>
                </li>
            </ul>

            <div class="navbar-default navbar-static-side" role="navigation">
                <div class="sidebar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="#"><i class="fa fa-sitemap fa-fw"></i> 自动化测试报告<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="/report/showlogreport">测试日志信息</a>
                                </li>
                                <li>
                                    <a href="/report/showmethodreport">测试用例报告</a>
                                </li>
                                <li>
                                    <a href="/report/showsuitereport">测试用例集报告</a>
                                </li>
                                <li>
                                    <a href="/report/showtestreport">测试总体报告</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div id="page-wrapper">
        </div>
    </div>

    <!-- Core Scripts - Include with every page -->
    <script src="resources/js/jquery-1.10.2.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/plugins/metisMenu/jquery.metisMenu.js"></script>

    <!-- Page-Level Plugin Scripts - Dashboard -->
    <script src="resources/js/plugins/morris/raphael-2.1.0.min.js"></script>
    <script src="resources/js/plugins/morris/morris.js"></script>

    <!-- SB Admin Scripts - Include with every page -->
    <script src="resources/js/admin.js"></script>

</body>
</html>
