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
<jsp:include page="header.jsp"></jsp:include>
<%
    String userName = (String) request.getSession(true).getAttribute("userName");
%>
<div id="global">
    <div class="container-fluid cm-container-white">
        <h2 style="margin-top:0;">Welcome to K-Mobile</h2>
        <p></p>
    </div>
    <div class="container-fluid">
        <div class="row cm-fix-height">
            <div class="row cm-fix-height">
                <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">
                    <a href="/admin/NewClient" class="panel panel-default thumbnail cm-thumbnail">
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
                    <a href="/admin/ChangeClient" class="panel panel-default thumbnail cm-thumbnail">
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
                    <a href="/admin/EditTariff" class="panel panel-default thumbnail cm-thumbnail">
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
                    <a href="/admin/EditTariffOption" class="panel panel-default thumbnail cm-thumbnail">
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
                    <a href="/admin/ViewClient" class="panel panel-default thumbnail cm-thumbnail">
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
                    <a href="/admin/FindClient" class="panel panel-default thumbnail cm-thumbnail">
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
                            href="/Help"><h3>Help here</h3></a></p>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</html>