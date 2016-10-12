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
    <title>K-Mobile</title>
</head>
<jsp:include page="header.jsp"></jsp:include>
<div id="global">
    <div class="container-fluid cm-container-white">
        <h2 style="margin-top:0;">Search results</h2>
        <p></p>
    </div>
    <div class="container-fluid">
        <div class="row cm-fix-height">
            <div class="panel panel-default">
                <div class="panel-body">
                    <%--<c:forEach var="val" items="${result}">--%>
                        <p><strong><h3> ${searchResult}</h3></strong></p>
                    <%--</c:forEach>--%>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</html>