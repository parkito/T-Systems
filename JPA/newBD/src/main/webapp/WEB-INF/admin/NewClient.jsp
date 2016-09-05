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
<jsp:include page="header.jsp"></jsp:include>
    <%
    String userName = (String) request.getSession(true).getAttribute("userName");
%>

<
<div id="global">
    <div class="container-fluid cm-container-white">
        <h2 style="margin-top:0;">Client searching</h2>
        <%--<p></p>--%>
    </div>
    <div class="container-fluid">
        <div class="panel panel-default">
            <div class="panel-body">
            </div>
        </div>
    </div>

    <jsp:include page="footer.jsp"></jsp:include>
</html>