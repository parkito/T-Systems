<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Tariffs</title>
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
        <c:forEach var="contract" items="${contractsUserList}" varStatus="loop">
            <div class="row cm-fix-height">
                <div class="col-sm-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">Number: ${contract.number}</div>
                        <div class="panel-body">

                            <h2>
                                <small>Tariff :</small>
                                    ${contract.tariff.title}
                                <br>
                                <small>Month payment :</small>
                                    ${contract.tariff.price} " RUB"
                                <small><br>Status :</small>
                                <c:if test="${contract.isBlocked() && contract.isBlockedByAdmin()}">
                                    <font color="red">Blocked by manager</font>
                                </c:if>
                                <c:if test="${contract.isBlocked() && !contract.isBlockedByAdmin()}">
                                    <font color="red">Blocked by user</font>
                                </c:if>
                                <c:if test="${!contract.isBlocked()}">
                                    <font color="green">Active</font>
                                </c:if>
                            </h2>

                        </div>
                    </div>
                </div>
                <c:if test="!${contract.getIsBlocked()}">
                    <div class="col-sm-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">Tariff list</div>
                            <div class="panel-body">
                                <c:forEach var="tariff" items="${contract.tariff}">
                                    <c:set var="tempId" value="${contract.tariff.tariffId}"/>
                                    <c:if test="${contract.getTariff().equals(tariff)}">

                                        <h3>
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="optionsRadios${loop.index}"
                                                           id="optionsRadios${loop.index}"
                                                        ${loop.index} value="option${loop.index}" checked disabled>
                                                    <b>${tariff.title}</b>
                                                </label>
                                            </div>
                                        </h3>
                                    </c:if>
                                    <c:if test="${!contract.getTariff().equals(tariff)}">
                                        <h3>
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="optionsRadios${loop.index}"
                                                           id="optionsRadios${loop.index}"
                                                        ${loop.index} value="option${loop.index}">
                                                    <b>${tariff.title}</b>
                                                </label>
                                            </div>
                                        </h3>
                                    </c:if>
                                </c:forEach>
                                <div class="modal-footer">
                                    <form name="test"
                                          onclick="change(${loop.index},${tempId},${contract.number}">
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
                </c:if>
            </div>
        </c:forEach>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
</html>