<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entities.Contract" %>
<%@ page import="entities.User" %>
<%@ page import="services.implementation.ContractServiceImpl" %>
<%@ page import="services.implementation.UserServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="services.implementation.TariffOptionServiceImpl" %>
<%@ page import="entities.TariffOption" %>
<%@ page import="services.implementation.TariffServiceImpl" %>
<%@ page import="entities.Tariff" %>
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
    <title>K-Mobile/Contracts</title>
</head>
<jsp:include page="header.jsp"></jsp:include>
<%

    User user = (User) request.getSession(true).getAttribute("user");
    String userName = (String) request.getSession(true).getAttribute("userName");

    List<Contract> contracts = (List<Contract>) request.getSession(true).getAttribute("contracts");
    TariffServiceImpl tariffService = (TariffServiceImpl) request.getSession(true).getAttribute("tariffService");
    List<Integer> tempTariff = new ArrayList();
    int i = 1, k;
%>
<div id="global">
    <div class="container-fluid cm-container-white">
        <h2 style="margin-top:0;"><c:out value='${userName}'/>, your tariffs:</h2>
        <%--<h2 style="margin-top:0;"><%out.print(userName);%>, your tariffs:</h2>--%>
        <p></p>
    </div>

    <div class="container-fluid">
        <%
            for (Contract contract : contracts) {

        %>
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
                                out.print(contract.getTariff().getPrice() + " RUB");
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
            <%if (!contract.getIsBlocked()) {%>
            <div class="col-sm-6">
                <div class="panel panel-default">
                    <div class="panel-heading">Tariff list</div>
                    <div class="panel-body">
                        <%
                            for (Tariff tariff : tariffService.getAll()) {
                                tempTariff.add(tariff.getTariffId());
                                if (contract.getTariff().equals(tariff)) {%>

                        <h3>
                            <div class="radio">
                                <label>
                                    <%
                                        out.print("<input type=\"radio\" name=\"optionsRadios" + i + "\" id=\"optionsRadios"
                                                + i + "\" value=\"option" + i + "\" checked disabled>");
                                        out.print("<b>" + tariff.getTitle() + "</b>");
                                    %>
                                </label>
                            </div>
                        </h3>

                        <%
                        } else {
                        %>
                        <h3>
                            <div class="radio">
                                <label>
                                    <%
                                        out.print("<input type=\"radio\" name=\"optionsRadios" + i + "\" id=\"optionsRadios"
                                                + i + "\" value=\"option" + i + "\">");
                                        out.print(tariff.getTitle());
                                    %>
                                </label>
                            </div>
                        </h3>
                        <%
                                }
                            }
                        %>
                        <div class="modal-footer">
                            <form name="test" onclick="change(<%=i%>,<%=tempTariff%>,<%=contract.getNumber()%>)">
                                <button type="submit" class="btn btn-success">Change</button>
                            </form>
                            <script>
                                function change(par1, par2, par3) {
                                    var rad = document.getElementsByName('optionsRadios' + par1);
                                    for (var i = 0; i
                                    < rad.length
                                            ; i++) {
                                        if (rad[i].checked) {
                                            popBox(par2[i], par3);
                                        }
                                    }

                                    function popBox(num1, num2) {
                                        x = confirm('Are you sure? ');
                                        if (x == true) {
                                            var xhr = new XMLHttpRequest();
                                            var id = 1;
                                            xhr.open("POST", "/user/Tariffs?tariffId=" + num1 + "&contractNumber=" + num2, true);
                                            xhr.send();
                                        }
                                    }

                                }
                            </script>

                        </div>
                    </div>
                </div>
            </div>
            <%}%>

        </div>
        <%
                i++;
            }
        %>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
</html>