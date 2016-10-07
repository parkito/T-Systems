<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="operator.entities.Contract" %>
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
    <title>Number operations</title>
</head>
<jsp:include page="header.jsp"></jsp:include>
<%
    List<Contract> contracts = (List<Contract>) request.getAttribute("contracts");
%>
<div id="global">
    <div class="container-fluid cm-container-white">
        <h2 style="margin-top:0;">${currentUser.name}, your options:</h2>
        <p></p>
    </div>
    <input type="hidden" name="<c:out value="${_csrf.parameterName}"/>"
           value="<c:out value="${_csrf.token}"/>"/>
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
                            x = confirm('Are you sure?');
                            if (x == true) {
                                var xhr = new XMLHttpRequest();
                                xhr.open("POST", "userNumberOperations?number=" + number + "&status=unblock", false);
                                xhr.send();
                                if (xhr.status == 600) {
                                    alert('Access error! Blocked by manager.')
                                }
                            }
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
                            x = confirm('Are you sure?');
                            if (x == true) {
                                var xhr = new XMLHttpRequest();
                                xhr.open("POST", "userNumberOperations?number=" + number + "&status=block", false);
                                xhr.send();
                            }
                        }
                    }
                </script>

                </tr>
                <%
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