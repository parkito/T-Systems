<%@ page import="services.implementation.UserServiceImpl" %>
<%@ page import="entities.User" %><%--<%@ page import="manipulating.TariffDAO" %>--%>
<%--<%@ page import="base.Tariff" %>--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>

<h1>Hello JSP</h1>
<%!
    //    TariffDAO tariffDAO = new TariffDAO();
//    Tariff tariff = tariffDAO.getTariff("Base1");
    UserServiceImpl userService = new UserServiceImpl();
%>
<%
    //    TariffDAO tariffDAO = new TariffDAO();
    //Tariff tariff = tariffDAO.getTariff("Base1");
    java.util.Date date = new java.util.Date();
%>

<h2>
    Now is
    <%=date.toString() + " "%>
</h2>
</body>
</html>