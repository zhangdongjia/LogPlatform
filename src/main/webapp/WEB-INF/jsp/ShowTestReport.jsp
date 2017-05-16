<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2016/11/7
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>测试总体报告</title>
    <!-- Core CSS - Include with every page -->
    <link href="../resources/css/bootstrap.css" rel="stylesheet">
    <link href="../resources/font-awesome/css/font-awesome.css" rel="stylesheet">
    <!-- Page-Level Plugin CSS - Tables -->
    <link href="../resources/css/plugins/dataTables/bootstrap-table.css" rel="stylesheet">
    <!-- SB Admin CSS - Include with every page -->
    <link href="../resources/css/admin.css" rel="stylesheet">
    <link href="../resources/css/jquery.jgrowl.css" rel="stylesheet">
    <link href="../resources/css/bootstrap-select.css" rel="stylesheet">

    <script>
        function download() {
            location.href = "downloadExcel4"
        }
    </script>
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
                    <li class="divider"></li>
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
        <div class="row">
            <div class="col-lg-12">
                <h3 class="page-header">测试总体报告</h3>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-12">
                <div class="table-responsive">
                    <div id="toolbar" class="btn-group">
                        <button id="download" type="button" class="btn btn-default" onclick="download()">
                            <i class="glyphicon glyphicon-download-alt"></i> 生成Excel
                        </button>
                    </div>
                    <table id="table_test"
                           data-url="/report/getAllTest"
                           data-toggle="table"
                           data-search="true"
                           data-show-toggle="true"
                           data-show-refresh="true"
                           data-show-columns="true"
                           data-sort-name="reportId"
                           data-sort-order="desc"
                           data-toolbar="#toolbar"
                           data-pagination="true"
                           data-page-size="25"
                           data-pagination-loop="false"
                           data-row-style="rowStyle">
                        <thead>
                        <tr>
                            <th data-field="state" data-checkbox="true"></th>
                            <th data-field="reportId" data-sortable="true">测试ID</th>
                            <th data-field="suitesPass" data-sortable="true">本次测试通过用例集数</th>
                            <th data-field="suitesFail" data-sortable="true">本次测试未通过用例集数</th>
                            <th data-field="testResult" data-sortable="true">本次测试通过情况</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<!--更改按钮高度-->
<script>
    $(function(){
        $('.btn-default').height('20');
    });
</script>

<!-- Core Scripts - Include with every page -->
<script src="../resources/js/jquery-1.10.2.js"></script>
<script src="../resources/js/bootstrap.min.js"></script>
<script src="../resources/js/plugins/metisMenu/jquery.metisMenu.js"></script>

<!-- Page-Level Plugin Scripts - Tables -->
<script src="../resources/js/plugins/dataTables/bootstrap-table.js"></script>
<script src="../resources/js/plugins/dataTables/bootstrap-table-zh-CN.js"></script>

<!-- SB Admin Scripts - Include with every page -->
<script src="../resources/js/admin.js"></script>
<!-- select -->
<script src="../resources/js/bootstrap-select.js"></script>
<!-- 动态select -->
<script src="../resources/js/bootstrap-suggest.js"></script>
<script src="../resources/js/bootstrap-suggest.min.js"></script>
<!-- notification  -->
<script src="../resources/js/jquery.jgrowl.js"></script>
<script src="../resources/jsFile/get-log-report.js"></script>

</body>
</html>
