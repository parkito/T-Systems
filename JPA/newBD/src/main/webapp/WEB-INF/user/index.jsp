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
        <h2 style="margin-top:0;">Welcome to K-Mobile site!</h2>
        <p></p>
    </div>
    <div class="container-fluid">
        <div class="row cm-fix-height">
            <div class="row cm-fix-height">
                <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">
                    <a href="/user/Contract" class="panel panel-default thumbnail cm-thumbnail">
                        <div class="panel-body text-center">
                                <span class="svg-48">
                                    <img src="../assets/img/sf/dashboard.svg" alt="dashboard">
                                </span>
                            <h4>Contracts</h4>
                            <small>How much money do I have?</small>

                        </div>
                    </a>
                </div>
                <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">
                    <a href="/user/Tariffs" class="panel panel-default thumbnail cm-thumbnail">
                        <div class="panel-body text-center">
                                <span class="svg-48">
                                    <img src="../assets/img/sf/notepad.svg" alt="notepad">
                                </span>
                            <h4>Tariffs</h4>
                            <small>Much more freedom!</small>

                        </div>
                    </a>
                </div>
                <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">
                    <a href="/user/TariffOptions" class="panel panel-default thumbnail cm-thumbnail">
                        <div class="panel-body text-center">
                                <span class="svg-48">
                                    <img src="../assets/img/sf/brick.svg" alt="brick">
                                </span>
                            <h4>Tariff options</h4>
                            <small>You can change world!</small>

                        </div>
                    </a>
                </div>
                <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">
                    <a href="/user/NumberOperations" class="panel panel-default thumbnail cm-thumbnail">
                        <div class="panel-body text-center">
                                <span class="svg-48">
                                    <img src="../assets/img/sf/lock-open.svg" alt="lock-open">
                                </span>
                            <h4>Unlock number</h4>
                            <small>Available for connection!</small>

                        </div>
                    </a>
                </div>

                <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">
                    <a href="/user/ChangeData" class="panel panel-default thumbnail cm-thumbnail">
                        <div class="panel-body text-center">
                    <span class="svg-48">
                    <img src="../assets/img/sf/window-layout.svg" alt="window-layout">
                    </span>
                            <h4>Change personal data</h4>
                            <small>Give more details for better service!</small>

                        </div>
                    </a>
                </div>
                <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">
                    <a href="/Exit" class="panel panel-default thumbnail cm-thumbnail">
                        <div class="panel-body text-center">
                    <span class="svg-48">
                    <img src="../assets/img/sf/cat.svg" alt="cat">
                    </span>
                            <h4>Exit</h4>
                            <small>Bye!</small>

                        </div>
                    </a>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-body"><h1 style="margin:0px;" align="center">Hello, <%out.print(userName);%>!</h1>
                    <p><strong><h3>We are glad to see you here ! </h3></strong>
                    <h3>Let's discover all opportunities and explore new horizonts! If you need a help, please</h3><a
                            href="/user/Contract.jsp"><h3>Contact us</h3></a></p>
                </div>

            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</html>