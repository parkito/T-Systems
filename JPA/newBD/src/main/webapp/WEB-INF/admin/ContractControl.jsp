<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entities.Contract" %>
<%@ page import="entities.User" %>
<%@ page import="services.implementation.ContractServiceImpl" %>
<%@ page import="services.implementation.UserServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="services.implementation.TariffOptionServiceImpl" %>
<%@ page import="entities.TariffOption" %>
<%@ page import="java.util.ArrayList" %>

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
    <title>Number operations</title>
</head>
<jsp:include page="header.jsp"></jsp:include>
<%
    User user = (User) request.getSession(true).getAttribute("userObj");
%>
<c:set var="userName" value="${sessionScope.userName}"/>

<div id="global">
    <div class="container-fluid cm-container-white">
        <h2 style="margin-top:0;">Block/unblock contracts</h2>
        <p></p>
    </div>

    <%----------------------------------------------------------------%>
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
                                x = confirm('Are you sure?');
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
        ContractServiceImpl contractService = new ContractServiceImpl();
        List<Contract> contracts = new ArrayList();// contractService.getAllContractsForUser(user.getUserId());
        String check = (String) request.getSession(true).getAttribute("check");
        if (check.equals("work"))
            if (request.getSession(true).getAttribute("usr") != null) {
                Contract contract1 = (Contract) request.getSession(true).getAttribute("usr");
                contracts.clear();
                contracts.add(contract1);
    %>
    <%-----------------------------------------------------------------%>
    <div class="container-fluid ">
        <div class="panel panel-default">
            <table class="table">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Number</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>

                <%

                    for (int i = 0; i < contracts.size(); i++) {
                        if (contracts.get(i).getIsBlocked())
                            out.print("<tr class=\"danger\">");
                        else out.print("<tr class=\"active\">");
                %>
                <th scope="row"><%out.print(i + 1);%></th>
                <td><%out.print(contracts.get(i).getNumber());%></td>
                <%
                    if (contracts.get(i).getIsBlocked())
                        out.print("<td>Blocked</td>");
                    else
                        out.print("<td>Active</td>");
                    if (contracts.get(i).getIsBlocked()) {
                %>
                <td>

                    <form name="test" onclick="unblock(<%=contracts.get(i).getNumber()%>)">
                        <button type="submit" class="btn btn-success">unblock</button>
                    </form>

                </td>
                <script>
                    function unblock(number) {
                        popBox();
                        function popBox() {
                            var xhr = new XMLHttpRequest();
                            xhr.open("DELETE", "/admin/ContractControl?unblockItem=" + number, false);
                            xhr.send();
                            document.getElementById('textFiled').value = number;
                            find();

                        }
                    }</script>

                <%
                } else {%>

                <td>
                    <form name="test" onclick="block(<%=contracts.get(i).getNumber()%>)">
                        <button type="submit" class="btn btn-danger">block</button>
                    </form>

                </td>

                <script>
                    function block(number) {
                        popBox();
                        function popBox() {
                            var xhr = new XMLHttpRequest();
                            xhr.open("DELETE", "/admin/ContractControl?blockItem=" + number, true);
                            xhr.send();
                            document.getElementById('textFiled').value = number;
                            find();
                        }
                    }
                </script>

                </tr>
                <%
                                }
                            }
                        }
                %>
                </tbody>

            </table>
        </div>
    </div>
</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</html>