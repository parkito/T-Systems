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

<div id="global">
    <div class="container-fluid cm-container-white">
        <h2 style="margin-top:0;">${currentUser.name}, your contracts:</h2>
        <p></p>
    </div>

    <div class="container-fluid">
        <c:forEach var="contract" items="${contractsUserList}">
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
                <c:if test="!${contract.isBlocked()}">
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
                                    <c:forEach var="allOption" items="${allTariffOptions}" varStatus="loop">
                                        <c:forEach var="contractOption" items="${contract.tariffOptions}">
                                            <c:if test="${allOption==contractOption}">
                                                <tr class="success">
                                                    <th scope="row">${loop.index+1}</th>
                                                    <td>${allOption.title}</td>
                                                    <td>Activated</td>
                                                    <td>

                                                        <form name="test"
                                                              onclick="disable(${contract.number},${allOption.tariffOptionId})">
                                                            <button type="submit" class="btn btn-danger">Disable
                                                            </button>
                                                        </form>

                                                    </td>
                                                    <script>
                                                        function disable(par1, par2) {
                                                            popBox();
                                                            function popBox() {
                                                                x = confirm('Are you sure? ');
                                                                if (x == true) {
                                                                    var xhr = new XMLHttpRequest();
                                                                    xhr.open("DELETE", "/user/TariffOptions?contractNumber=" + par1
                                                                            + "&tariff=" + par2 + "&method=disable", true);
                                                                    xhr.send();
                                                                }
                                                            }
                                                        }</script>
                                                </tr>
                                            </c:if>
                                            <c:if test="${allOption!=contractOption}">

                                                <tr class="active">
                                                    <th scope="row">${loop.index+1}</th>
                                                    <td>${allOption.title}</td>
                                                    <td>Disabled</td>
                                                    <td>
                                                        <form name="test"
                                                              onclick="unable(${contract.number},${allOption.tariffOptionId})">
                                                            <button type="submit" class="btn btn-success">Activate
                                                            </button>
                                                        </form>

                                                    </td>

                                                    <script>
                                                        function unable(par1, par2) {
                                                            popBox();
                                                            function popBox() {
                                                                x = confirm('Are you sure? ');
                                                                if (x == true) {
                                                                    var xhr = new XMLHttpRequest();
                                                                    xhr.open("DELETE", "/user/TariffOptions?contractNumber=" + par1
                                                                            + "&tariff=" + par2 + "&method=unable", false);
                                                                    xhr.send();
                                                                    if (xhr.status == 500) {
                                                                        alert('Incompatible options')
                                                                    }
                                                                }
                                                            }
                                                        }</script>
                                                </tr>
                                            </c:if>
                                        </c:forEach>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </c:if>
            </div>
        </c:forEach>
    </div>
</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</html>