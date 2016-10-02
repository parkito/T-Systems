<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <title>New option</title>
</head>
<body class="cm-no-transition cm-1-navbar">
<jsp:include page="header.jsp"></jsp:include>
<div id="global">
    <div class="container-fluid cm-container-white">
        <h2 style="margin-top:0;">Add new option</h2>
    </div>
    <div class="container-fluid">
        <div class="panel panel-default">
            <div class="panel-body">
                <div class="input-group">
                    <table class="table">
                        <thead>
                        <tr>
                            <th></th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td><input id="title" type="text" class="form-control" placeholder="Title"></td>
                            <td>
                                <font color="blue">${titleStat}</font>
                            </td>
                        </tr>
                        <tr>
                            <td><input id="price" type="text" class="form-control" placeholder="Price"></td>
                            <td><font color="blue">${priceStat}</font></td>
                        </tr>

                        <tr>
                            <td><input id="connectedPrice" type="text" class="form-control"
                                       placeholder="Connection price"></td>
                            <td><font color="blue">${connectionPriceStat}</font></td>
                        </tr>
                        </tbody>
                    </table>

                </div>
            </div>
            <div class="modal-footer">
                <form name="test" onclick="add()">
                    <button type="submit" class="btn btn-success">Add</button>
                </form>
                <script>
                    function add() {
                        var title = document.getElementById('title').value;
                        var price = document.getElementById('price').value;
                        var connectedPrice = document.getElementById('connectedPrice').value;

                        popBox();
                        function popBox() {
                            x = confirm('Are you sure? ');
                            if (x == true) {
                                var xhr = new XMLHttpRequest();
                                xhr.open("POST", "adminNewOption?title=" + title + "&price=" + price +
                                        "&connectPrice=" + connectedPrice, false);
                                xhr.send();
                                xhr.open("GET", "adminNewOption", false);
                                xhr.send();
                            }
                        }

                    }
                </script>
            </div>
        </div>
    </div>
    <c:if test="${newOption!=null}">
        <div class="container-fluid cm-container-white">
            <h2 align="center" style="margin-top:0;">Option added</h2>
        </div>
    </c:if>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</html>