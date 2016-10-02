<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="operator.entities.Contract" %>
<%@ page import="operator.entities.User" %>
<%@ page import="java.util.List" %>
<%@ page import="operator.entities.TariffOption" %>
<%@ page import="operator.entities.Tariff" %>
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
    <title>Change tariff</title>
</head>
<jsp:include page="header.jsp"></jsp:include>
<div id="global">
    <div class="container-fluid cm-container-white">
        <h2 style="margin-top:0;">Change tariff</h2>
        <p></p>
    </div>
    <%----------------------------------------------------------------------------------------------%>
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
        //        String check = (String) request.getSession().getAttribute("check");
        if (request.getSession().getAttribute("check") != null) {
            if (!request.getSession().getAttribute("usr").equals("one")) {
                Contract contract = (Contract) request.getSession().getAttribute("usr");
                List<Tariff> allTariffs = (List<Tariff>) request.getSession().getAttribute("allTariffs");
                List<Integer> tempTariff = new ArrayList<>();
                int i = 1;
    %>


    <%--------------------------------------------------------------------------------------------%>
    <div class="container-fluid">
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
            <div class="col-sm-6">
                <div class="panel panel-default">
                    <div class="panel-heading">Tariff list</div>
                    <div class="panel-body">
                        <%
                            for (Tariff tariff : allTariffs) {
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
                                            xhr.open("POST", "adminChangeClientTariff?tariffId=" + num1 + "&contractNumber=" + num2, false);
                                            xhr.send();
                                            xhr.open("GET", "adminChangeClientTariff", false)
                                        }
                                    }
                                }
                            </script>

                        </div>
                    </div>
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
    <%
            }
        }
    %>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</html>