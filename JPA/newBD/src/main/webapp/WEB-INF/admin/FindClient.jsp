<%@ page import="services.implementation.UserServiceImpl" %>
<%@ page import="entities.Contract" %>
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
        <h2 style="margin-top:0;">Client searching</h2>
        <%--<p></p>--%>
    </div>
    <div class="container-fluid">
        <div class="panel panel-default">
            <div class="panel-body">
                <h3 style="margin-top:0px">Enter contract number</h3>
                <div class="input-group input-group-lg">

                    <input type="text" class="form-control" placeholder="Searching" id="textFiled">

                    <span class="input-group-btn">
                        <form name="new" onclick="find()" class="btn btn-primary md-search-white">
                         <button style="z-index:2" class="btn btn-primary md-search-white" type="submit">&nbsp;&nbsp;&nbsp;&nbsp;</button>
                    </form>
                    </span>

                    <script>
                        function find() {
                            var text = document.getElementById('textFiled').value;
                            popBox();
                            function popBox() {
                                x = confirm('Are you sure? ' + text);
                                if (x == true) {
                                    var xhr = new XMLHttpRequest();
                                    xhr.open("POST", "/admin/FindClient?number=" + text, true);
                                    xhr.send();
                                }
                            }
                        }
                    </script>
                </div>
            </div>
        </div>
    </div>
    <%
        Contract contract;
        String check = (String) request.getSession(true).getAttribute("check");
        if (!check.equals("error")) {
            contract = (Contract) request.getSession(true).getAttribute("usr");

    %>
    <div class="container-fluid">
        <div class="panel panel-default">
            <div class="panel-body">
                <h2><%out.print(contract.getNumber());%></h2>
            </div>
        </div>
    </div>
    <%
    } else {
    %>
    <div class="container-fluid">
        <div class="panel panel-default">
            <div class="panel-body">
                <h2>User wasn't found</h2>
            </div>
        </div>
    </div>
    <%
        }
    %>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</html>