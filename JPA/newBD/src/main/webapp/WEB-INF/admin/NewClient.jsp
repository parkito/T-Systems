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
                            <td>active</td>
                        </tr>
                        <tr>
                            <td><input id="surName" type="text" class="form-control" placeholder="Surname"></td>
                            <td>active</td>
                        </tr>
                        <tr>
                            <td><input id="birthday" type="text" class="form-control" placeholder="Birthday date"></td>
                            <td>active</td>
                        </tr>
                        <tr>
                            <td><input id="passport" type="text" class="form-control" placeholder="Passport"></td>
                            <td>active</td>
                        </tr>
                        <tr>
                            <td><input id="adress" type="text" class="form-control" placeholder="Adress"></td>
                            <td>active</td>
                        </tr>
                        <tr>
                            <td><input id="email" type="text" class="form-control" placeholder="Email"></td>
                            <td>active</td>
                        </tr>
                        <tr>
                            <td><input id="password" type="text" class="form-control" placeholder="Password"</td>
                            <td>active</td>
                        </tr>
                        </tbody>
                    </table>

                </div>
            </div>
            <div class="modal-footer">
                <form name="test" onclick="add('hi')">
                    <button type="submit" class="btn btn-success">Create</button>
                </form>
                <script>
                    function add(par1) {
                        var name = document.getElementById('name').value;
                        var surName = document.getElementById('surName').value;
                        popBox();
                        function popBox() {
                            x = confirm('Are you sure? ' + name);
                            if (x == true) {
                                var xhr = new XMLHttpRequest();
                                xhr.open("POST", "/admin/NewClient?name=" + name + "&surName=" + surName, true);
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