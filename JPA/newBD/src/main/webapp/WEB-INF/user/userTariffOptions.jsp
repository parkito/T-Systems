<%@ page import="operator.entities.Contract" %>
<%@ page import="operator.entities.TariffOption" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Tariff options</title>
</head>
<jsp:include page="header.jsp"></jsp:include>
<%
    List<TariffOption> allOptions = (List<TariffOption>) request.getAttribute("allTariffOptions");
    List<Contract> contracts = (List<Contract>)request.getAttribute("contractsUserList");

%>

<div id="global">
    <div class="container-fluid cm-container-white">
        <h2 style="margin-top:0;">${currentUser.name}, your options:</h2>
        <p></p>
    </div>
    <input type="hidden" name="<c:out value="${_csrf.parameterName}"/>"
           value="<c:out value="${_csrf.token}"/>"/>
    <div class="container-fluid">
        <%for (Contract contract : contracts) {%>
        <div class="row cm-fix-height">
            <div class="col-sm-6">
                <div class="panel panel-default">
                    <div class="panel-heading">Number: <%out.print(contract.getNumber());%></div>
                    <div class="panel-body">
                        <h2>
                            <%
                                out.print("<small>Tariff : </small>");
                                out.print(contract.getTariff().getTitle());
                                out.print("<br>");
                                out.print("<small>Month payment : </small>");
                                out.print(contract.getTariff().getPrice() + " RUB\n");
                                out.print("<small><br>Status : </small>");
                                if (contract.isBlocked() && contract.isBlockedByAdmin())
                                    out.print("<font color =\"red\">Blocked by manager</font>");
                                if (contract.isBlocked() && !contract.isBlockedByAdmin())
                                    out.print("<font color =\"red\">Blocked by user</font>");
                                if (!contract.isBlocked())
                                    out.print("<font color =\"green\">Active</font>");
                            %>
                        </h2>
                    </div>
                </div>
            </div>
            <%if (!contract.isBlocked()) {%>
            <div class="col-sm-6">
                <div class="panel panel-default">
                    <div class="panel-heading">Tariff option list</div>
                    <div class="panel-body">
                        <%%>
                        <table class="table">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Option</th>
                                <th>Status</th>
                                <th>Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            <% for (TariffOption option : allOptions) {
                                int i=1;
                                if (contract.getTariffOptions().contains(option)) {
                            %>
                            <tr class="success">
                                <th scope="row"><%out.print(i);%></th>
                                <td><%out.print(option.getTitle());%></td>
                                <td>Activated</td>
                                <td>

                                    <form name="test"
                                          onclick="disable(<%=contract.getNumber()%>,<%=option.getTariffOptionId()%>)">
                                        <button type="submit" class="btn btn-danger">Disable</button>
                                    </form>

                                </td>
                                <script>
                                    function disable(par1, par2) {
                                        popBox();
                                        function popBox() {
                                            x = confirm('Are you sure? ');
                                            if (x == true) {
                                                var xhr = new XMLHttpRequest();
                                                xhr.open("GET", "userChangeTariffOptions?contractNumber=" + par1
                                                        + "&tariffOptionId=" + par2 +  "&method=disable", false);
                                                xhr.send();
                                            }
                                        }
                                    }</script>
                            </tr>
                            <%
                            } else {
                            %>

                            <tr class="active">
                                <th scope="row"><%out.print(i);%></th>
                                <td><%out.print(option.getTitle());%></td>
                                <td>Disabled</td>
                                <td>

                                    <form name="test"
                                          onclick="unable(<%=contract.getNumber()%>,<%=option.getTariffOptionId()%>)">
                                        <button type="submit" class="btn btn-success">Activate</button>
                                    </form>

                                </td>

                                <script>
                                    function unable(par1, par2) {
                                        popBox();
                                        function popBox() {
                                            x = confirm('Are you sure? ');
                                            if (x == true) {
                                                var xhr = new XMLHttpRequest();
                                                xhr.open("GET", "userChangeTariffOptions?contractNumber=" + par1
                                                        + "&tariffOptionId=" + par2 + "&method=unable", false);
                                                xhr.send();
                                                if (xhr.status == 430) {
                                                    alert('Incompatible options')
                                                }
                                            }
                                        }
                                    }</script>
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
            <%}%>
        </div>
        <%}%>
    </div>
</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</html>