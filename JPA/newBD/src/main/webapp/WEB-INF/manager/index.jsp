<%@ page import="services.implementation.UserServiceImpl" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1">
    <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap-clearmin.min.css">
    <link rel="stylesheet" type="text/css" href="../assets/css/roboto.css">
    <link rel="stylesheet" type="text/css" href="../assets/css/material-design.css">
    <link rel="stylesheet" type="text/css" href="../assets/css/small-n-flat.css">
    <link rel="stylesheet" type="text/css" href="../assets/css/font-awesome.min.css">
    <title>K-Mobile</title>
</head>
<body class="cm-no-transition cm-1-navbar">
<div id="cm-menu">
    <nav class="cm-navbar cm-navbar-primary">
        <div class="cm-flex"><a href="index.jsp" class="cm-logo"></a></div>
        <div class="btn btn-primary md-menu-white" data-toggle="cm-menu"></div>
    </nav>
    <div id="cm-menu-content">
        <div id="cm-menu-items-wrapper">
            <div id="cm-menu-scroller">
                <ul class="cm-menu-items">
                    <li class="active"><a href="/login" class="sf-house">Home</a></li>
                    <li><a href="/manager/NewClient" class="sf-dashboard">New client</a></li>
                    <li><a href="/manager/ChangeClient" class="sf-notepad">Change client</a></li>
                    <li><a href="/manager/EditTariff" class="sf-brick">Edit tariff</a></li>
                    <li><a href="/manager/EditTariffOption" class="sf-brick-alt">Edit options</a></li>
                    <li><a href="/manager/ViewClient" class="sf-lock-open">View clients</a></li>
                    <li><a href="/manager/FindClient" class="sf-window-layout">Find client</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
<header id="cm-header">
    <nav class="cm-navbar cm-navbar-primary">
        <div class="btn btn-primary md-menu-white hidden-md hidden-lg" data-toggle="cm-menu"></div>
        <div class="cm-flex">
            <h1>Home</h1>
            <form id="cm-search" action="index.jsp" method="get">
                <input type="search" name="q" autocomplete="off" placeholder="Search...">
            </form>
        </div>
        <div class="pull-right">
            <div id="cm-search-btn" class="btn btn-primary md-search-white" data-toggle="cm-search"></div>
        </div>
        <div class="dropdown pull-right">
            <button class="btn btn-primary md-notifications-white" data-toggle="dropdown"><span
                    class="label label-danger">1</span></button>
            <div class="popover cm-popover bottom">
                <div class="arrow"></div>
                <div class="popover-content">
                    <div class="list-group">
                        <a href="/user/Offer" class="list-group-item">
                            <h4 class="list-group-item-heading text-overflow">
                                <i class="fa fa-fw fa-envelope"></i> New offer special for you !
                            </h4>
                            <p class="list-group-item-text text-overflow">Less money - better quality</p>
                        </a>
                    </div>
                    <div style="padding:10px"><a class="btn btn-success btn-block" href="/user/Tarrifs">Show me
                        more...</a></div>
                </div>
            </div>
        </div>
        <div class="dropdown pull-right">
            <button class="btn btn-primary md-account-circle-white" data-toggle="dropdown"></button>
            <ul class="dropdown-menu">
                <li class="disabled text-center">
                    <%
                        String userName = (String) request.getAttribute("userName");
                    %>
                    <a style="cursor:default;"><strong><%out.print(userName);%></strong></a>
                </li>
                <li class="divider"></li>
                <li>
                    <a href="/user/AboutMe"><i class="fa fa-fw fa-user"></i> Profile</a>
                </li>
                <li>
                    <a href="/user/ChangeData"><i class="fa fa-fw fa-cog"></i> Settings</a>
                </li>
                <li>
                    <a href="/user/Exit"><i class="fa fa-fw fa-sign-out"></i> Sign out</a>
                </li>
            </ul>
        </div>
    </nav>
</header>
<div id="global">
    <div class="container-fluid cm-container-white">
        <h2 style="margin-top:0;">Welcome to K-Mobile</h2>
        <p></p>
    </div>
    <div class="container-fluid">
        <div class="row cm-fix-height">
            <div class="row cm-fix-height">
                <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">
                    <a href="/manager/NewClient" class="panel panel-default thumbnail cm-thumbnail">
                        <div class="panel-body text-center">
                                <span class="svg-48">
                                    <img src="../assets/img/sf/dashboard.svg" alt="dashboard">
                                </span>
                            <h4>New client</h4>
                            <small>Add new contract</small>

                        </div>
                    </a>
                </div>
                <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">
                    <a href="/manager/ChangeClient" class="panel panel-default thumbnail cm-thumbnail">
                        <div class="panel-body text-center">
                                <span class="svg-48">
                                    <img src="../assets/img/sf/notepad.svg" alt="notepad">
                                </span>
                            <h4>Change client</h4>
                            <small>Edit exist data</small>

                        </div>
                    </a>
                </div>
                <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">
                    <a href="/user/TariffOptions" class="panel panel-default thumbnail cm-thumbnail">
                        <div class="panel-body text-center">
                                <span class="svg-48">
                                    <img src="../assets/img/sf/brick.svg" alt="brick">
                                </span>
                            <h4>Edit tariff</h4>
                            <small>Edit tariff data</small>

                        </div>
                    </a>
                </div>
                <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">
                    <a href="/user/NumberOperations" class="panel panel-default thumbnail cm-thumbnail">
                        <div class="panel-body text-center">
                                <span class="svg-48">
                                    <img src="../assets/img/sf/brick-alt.svg" alt="lock-open">
                                </span>
                            <h4>Edit options</h4>
                            <small>Edit tariff options</small>

                        </div>
                    </a>
                </div>

                <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">
                    <a href="/user/ChangeData" class="panel panel-default thumbnail cm-thumbnail">
                        <div class="panel-body text-center">
                    <span class="svg-48">
                    <img src="../assets/img/sf/lock.svg" alt="window-layout">
                    </span>
                            <h4>View clients</h4>
                            <small>Block/Unblock</small>

                        </div>
                    </a>
                </div>
                <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">
                    <a href="/manager/FindClient" class="panel panel-default thumbnail cm-thumbnail">
                        <div class="panel-body text-center">
                    <span class="svg-48">
                    <img src="../assets/img/sf/window-layout.svg" alt="cat">
                    </span>
                            <h4>Find client</h4>
                            <small>Searching by number</small>

                        </div>
                    </a>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-body"><h1 style="margin:0px;" align="center">Hello, <%out.print(userName);%>!</h1>
                    <p><strong><h3>Remember corporate agreements about client data! </h3></strong>
                    <h3>Clients are our past, reality, and future! </h3><a
                            href="/user/Contract.jsp"><h3>Help here</h3></a></p>
                </div>

            </div>


            <footer class="cm-footer"><span class="pull-left">Created by Artyom Karnov</span><span
                    class="pull-right">&copy;T-Systems JavaSchool</span></footer>
        </div>
    </div>
</div>
<script src="../assets/js/lib/jquery-2.1.3.min.js"></script>
<script src="../assets/js/jquery.mousewheel.min.js"></script>
<script src="../assets/js/jquery.cookie.min.js"></script>
<script src="../assets/js/fastclick.min.js"></script>
<script src="../assets/js/bootstrap.min.js"></script>
<script src="../assets/js/clearmin.min.js"></script>
<script src="../assets/js/demo/home.js"></script>
</body>
</html>