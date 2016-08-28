<%--
  Created by IntelliJ IDEA.
  User: parkito
  Date: 8/25/16
  Time: 9:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
<form method="post" action="registr">
    Enter your email:<br>
    <input type="email" name="email"><br><br>
    Enter your password:<br>
    <input type="password" name="psw"><br><br>
    Enter your password again:<br>
    <input type="password" name="psw1"><br><br>
    Enter your name:<br>
    <input type="text" name="name"><br><br>
    Enter your second name:<br>
    <input type="text" name="secondName"><br><br>
    Enter your passport data<br>
    <input type="text" name="passport"><br><br>
    Enter your birthday:<br>
    <input type="text" name="birthdayDate"><br><br>
    Enter your adress:<br>
    <input type="text" name="adress"><br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>