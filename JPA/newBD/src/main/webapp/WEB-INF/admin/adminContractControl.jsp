<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="operator.entities.Contract" %>
<%@ page import="operator.entities.User" %>
<%@ page import="java.util.List" %>
<%@ page import="operator.entities.TariffOption" %>
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
    <title>Contract control</title>
</head>
<jsp:include page="header.jsp"></jsp:include>
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
                                    xhr.open("POST", "adminFindClient?number=" + text, false);
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

        if (request.getSession().getAttribute("check") != null) {
            if (!request.getSession().getAttribute("usr").equals("one")) {
                List<Contract> contracts = new ArrayList();
                Contract contract1 = (Contract) request.getSession().getAttribute("usr");
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
                            xhr.open("POST", "adminContractControl?status=unblock&number=" + number, false);
                            xhr.send();
                            xhr.open("POST", "adminFindClient?number=" + number, false);
                            xhr.send();
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
                            xhr.open("POST", "adminContractControl?status=block&number=" + number, false);
                            xhr.send();
                            xhr.open("POST", "adminFindClient?number=" + number, false);
                            xhr.send();
                        }
                    }
                </script>

                </tr>
                <%
                                }
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