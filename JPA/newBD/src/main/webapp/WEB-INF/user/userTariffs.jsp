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
    <title>Tariffs</title>
</head>
<jsp:include page="header.jsp"></jsp:include>
<div id="global">
    <div class="container-fluid cm-container-white">
        <h2 style="margin-top:0;">${currentUser.name}, your tariffs:</h2>
        <p></p>
    </div>
    <input type="hidden" name="<c:out value="${_csrf.parameterName}"/>"
    value="<c:out value="${_csrf.token}"/>"/>
    <div class="container-fluid">
        <c:forEach var="contract" items="${contractsUserList}" varStatus="loopOne">
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
                                    ${contract.tariff.price} "RUB"
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
                <c:if test="${contract.getIsBlocked()!=true}">
                    <div class="col-sm-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">Tariff list</div>
                            <div class="panel-body">
                                    ${tempId.clear()}
                                <c:forEach var="tariff" items="${allTariffs}" varStatus="loop">
                                    <c:set var="t">${tempId.add(tariff.tariffId)}</c:set>
                                    <c:if test="${contract.tariff==tariff}">
                                        <h3>
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="optionsRadios${loopOne.index}"
                                                           id="optionsRadios${loopOne.index}"
                                                        ${loop.index} value="option${loop.index}" checked disabled>
                                                    <b>${tariff.title}</b>
                                                </label>
                                            </div>
                                        </h3>
                                    </c:if>
                                    <c:if test="${contract.tariff!=tariff}">
                                        <h3>
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="optionsRadios${loopOne.index}"
                                                           id="optionsRadios${loopOne.index}"
                                                        ${loop.index} value="option${loop.index}">
                                                    <b>${tariff.title}</b>
                                                </label>
                                            </div>
                                        </h3>
                                    </c:if>
                                </c:forEach>
                                <div class="modal-footer">
                                    <form name="test"
                                          onclick="change(${loopOne.index},${tempId},${contract.number})">
                                        <button type="submit" class="btn btn-success">Change</button>
                                    </form>
                                    <script>
                                        function change(par1, par2, par3) {
                                            var rad = document.getElementsByName('optionsRadios' + par1);
                                            for (var i = 0; i < rad.length; i++) {
                                                if (rad[i].checked) {
                                                    popBox(par2[i], par3);
                                                }
                                            }
                                            function popBox(num1, num2) {
                                                x = confirm('Are you sure? ');
                                                if (x == true) {
                                                    var xhr = new XMLHttpRequest();
                                                    xhr.open("POST", "userChangeTariff?tariffId=" + num1 + "&contractNumber=" + num2, false);
                                                    xhr.send();
                                                    xhr.open("GET", "userTariffs", false);
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
</div>
<jsp:include page="footer.jsp"></jsp:include>
</html>