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
<div id="global">
    <div class="container-fluid cm-container-white">
        <h2 style="margin-top:0;">Add new tariff</h2>
    </div>
    <div class="container-fluid">
        <div class="panel panel-default">
            <div class="panel-body">
                <div class="input-group">
                    <%
                        String title;
                        String price;

                        if (request.getSession().getAttribute("titleStat") == null)
                            title = "";
                        else
                            title = (String) request.getSession().getAttribute("titleStat");

                        if (request.getSession(true).getAttribute("priceStat") == null)
                            price = "";
                        else
                            price = (String) request.getSession(true).getAttribute("priceStat");

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
                            <td><input id="title" type="text" class="form-control" placeholder="Title"></td>
                            <td>
                                <font color="blue"><%out.print(title);%></font>
                            </td>
                        </tr>
                        <tr>
                            <td><input id="price" type="text" class="form-control" placeholder="Price"></td>
                            <td><font color="blue"><%out.print(price);%></font></td>
                        </tr>
                        </tbody>
                    </table>

                </div>
            </div>
            <div class="modal-footer">
                <form name="test" onclick="add()">
                    <button type="submit" class="btn btn-success">Add</button>
                </form>
                <script>
                    function add() {
                        var title = document.getElementById('title').value;
                        var price = document.getElementById('price').value;

                        popBox();
                        function popBox() {
                            x = confirm('Are you sure? ');
                            if (x == true) {
                                var xhr = new XMLHttpRequest();
                                xhr.open("POST", "/admin/NewTariff?title=" + title + "&price=" + price, true);
                                xhr.send();
                            }
                        }

                    }
                </script>
            </div>
        </div>
    </div>
    <%if (title.equals("OK") && price.equals("OK")) {%>
    <div class="container-fluid cm-container-white">
        <h2 align="center" style="margin-top:0;">Tariff added</h2>

    </div>
    <%}%>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</html>