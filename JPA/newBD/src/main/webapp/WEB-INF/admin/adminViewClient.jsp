<%@ page import="operator.entities.Contract" %>
<%@ page import="operator.entities.User" %>
<%@ page import="java.util.List" %>
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
    <title>View client</title>
</head>
<jsp:include page="header.jsp"></jsp:include>
<div id="global">
    <div class="container-fluid cm-container-white">
        <h2 style="margin-top:0;">Client searching</h2>
    </div>
    <div class="container-fluid">
        <div class="panel panel-default">
            <div class="panel-body">
                <h3 style="margin-top:0px">Enter email</h3>
                <div class="input-group input-group-lg">

                    <input type="text" class="form-control" placeholder="Searching" id="textFiled1">

                    <span class="input-group-btn">
                        <form name="newOne" onclick="finding()" class="btn btn-primary md-search-white">
                         <button style="z-index:2" class="btn btn-primary md-search-white" type="submit">&nbsp;&nbsp;&nbsp;&nbsp;</button>
                    </form>
                    </span>
                    <script>
                        function finding() {
                            var text = document.getElementById('textFiled1').value;
                            popBox();
                            function popBox() {
                                x = confirm('Are you sure?');
                                if (x == true) {
                                    var xhr = new XMLHttpRequest();
                                    xhr.open("POST", "adminViewClient?email=" + text, true);
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

        String check = (String) request.getAttribute("check");
        if (check.equals("work"))
            if (request.getAttribute("usrs") != null) {
                User user = (User) request.getAttribute("usrs");
    %>

    <div class="container-fluid">
        <div class="row cm-fix-height">
            <div class="col-sm-4">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <h3>User:</h3>
                        <p>
                        <h3><b>Name </b><%out.print(user.getName());%></h3>
                        <h3><b>Surname </b><%out.print(user.getSecondName());%></h3>
                        </p>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <h3>Numbers:</h3>
                        <p>
                                <%
                                List<Contract>contracts=user.getContracts();
                                for(Contract contract:contracts){
                               %>
                        <h3><b>Number </b><%out.print(contract.getNumber());%></h3>
                        <%}%>
                        </p>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <h3>Info:</h3>
                        <p>
                        <h3><b>Birthday </b><%out.print(user.getBirthdayData());%></h3>
                        <h3><b>Address </b><%out.print(user.getAdress());%></h3>
                        </p>
                    </div>
                </div>
            </div>
        </div>
        <%} else {%>
        <div class="container-fluid">
            <div class="panel panel-default">
                <div class="panel-body">
                    <h2><p align="center">
                        User wasn' t found</p></h2>
                </div>
            </div>
        </div>
        <%}%>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</html>