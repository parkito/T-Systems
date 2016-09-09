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
    <title>K-Mobile/Contracts</title>
</head>
<jsp:include page="header.jsp"></jsp:include>

<c:set var="userName" value="${sessionScope.userName}"/>
<c:set var="contracts" value="${sessionScope.contracts}"/>
<c:set var="tariffOptionService" value="${sessionScope.tariffOptionService}"/>

<div id="global">
    <div class="container-fluid cm-container-white">
        <h2 style="margin-top:0;"><c:out value="${userName}"/>, your contracts:</h2>
        <p></p>
    </div>
    <div class="container-fluid">
        <c:forEach var="contract" items="${contracts}">
            <div class="row cm-fix-height">
                <div class="col-sm-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">Number: <c:out value="${contract.getNumber()}"/></div>
                        <div class="panel-body">
                            <h2>
                                <small>Tariff :</small>
                                <c:out value="${contract.getTariff().getTitle()}"/>
                                <br>
                                <small>Month payment :</small>
                                <c:out value="${contract.getTariff().getPrice()}"/> RUB
                                <small><br>Status :</small>
                                <c:if test="${contract.isBlocked() && contr.isBlockedByAdmin()}">
                                    <font color="red">Blocked by manager</font>
                                </c:if>
                                <c:if test="${contract.isBlocked() && !contr.isBlockedByAdmin()}">
                                    <font color="red">Blocked by user</font>
                                </c:if>
                                <c:if test="${!contract.isBlocked()}">
                                    <font color="green">Active</font>
                                </c:if>
                            </h2>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">options</div>
                        <div class="panel-body">
                            <h2>
                                <c:forEach var="tariffOption" items="${tariffOptionService
                                .getAllTariffOptionForContract(contract.getContractId())}">
                                    <small>Option :</small>
                                    <c:out value="${tariffOption.getTitle()}"/>
                                    <br>
                                    <small>Price :</small>
                                    <c:out value="${tariffOption.getPrice()}"/>
                                    <br>
                                    <p>------------------------------------------------</p>
                                    <br>

                                </c:forEach>
                            </h2>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</html>