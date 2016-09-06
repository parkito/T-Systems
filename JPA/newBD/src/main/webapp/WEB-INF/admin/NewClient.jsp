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
        <h2 style="margin-top:0;">Add new client</h2>
        <%--<p></p>--%>
    </div>
    <div class="container-fluid">
        <div class="panel panel-default">
            <div class="panel-body">
                <div class="input-group">
                    <%
                        String nameStat = (String) request.getSession().getAttribute("nameStat");
                        String surNameStat = (String) request.getSession(true).getAttribute("surNameStat");
                        String birthday = (String) request.getSession(true).getAttribute("birthday");
                        String passport = (String) request.getSession(true).getAttribute("passport");
                        String adress = (String) request.getSession(true).getAttribute("adress");
                        String email = (String) request.getSession(true).getAttribute("email");
                        String password = (String) request.getSession(true).getAttribute("password");
                    %>
                    <table class="table">
                        <thead>
                        <tr>
                            <th></th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td><input id="name" type="text" class="form-control" placeholder="Enter name"></td>
                            <td>
                                <font color="blue"><%out.print(nameStat);%></font>
                            </td>
                        </tr>
                        <tr>
                            <td><input id="surName" type="text" class="form-control" placeholder="Surname"></td>
                            <td><font color="blue"><%out.print(surNameStat);%></font></td>
                        </tr>
                        <tr>
                            <td><input id="birthday" type="date" class="form-control" placeholder="Birthday date"></td>
                            <td><font color="blue"><%out.print(birthday);%></font></td>
                        </tr>
                        <tr>
                            <td><input id="passport" type="text" class="form-control" placeholder="Passport"></td>
                            <td><font color="blue"><%out.print(passport);%></font></td>
                        </tr>
                        <tr>
                            <td><input id="adress" type="text" class="form-control" placeholder="Adress"></td>
                            <td><font color="blue"><%out.print(adress);%></font></td>
                        </tr>
                        <tr>
                            <td><input id="email" type="email" class="form-control" placeholder="Email"></td>
                            <td><font color="blue"><%out.print(email);%></font></td>
                        </tr>
                        <tr>
                            <td><input id="password" type="password" class="form-control" placeholder="Password"></td>
                            <td><font color="blue"><%out.print(password);%></font></td>
                        </tr>
                        </tbody>
                    </table>

                </div>
            </div>
            <div class="modal-footer">
                <form name="test" onclick="add()">
                    <button type="submit" class="btn btn-success">Create</button>
                </form>
                <script>
                    function add() {
                        var name = document.getElementById('name').value;
                        var surName = document.getElementById('surName').value;
                        var birthday = document.getElementById('birthday').value;
                        var passport = document.getElementById('passport').value;
                        var adress = document.getElementById('adress').value;
                        var email = document.getElementById('email').value;
                        var password = document.getElementById('password').value;
                        popBox();
                        function popBox() {
                            x = confirm('Are you sure? ');
                            if (x == true) {
                                var xhr = new XMLHttpRequest();
                                xhr.open("POST", "/admin/NewClient?name=" + name + "&surName=" + surName
                                        + "&birthday=" + birthday + "&passport=" + passport
                                        + "&adress=" + adress + "&email=" + email + "&password=" + password, true);
                                xhr.send();
                            }
                        }

                    }
                </script>
            </div>
        </div>
    </div>

</div>
<jsp:include page="footer.jsp"></jsp:include>
</html>