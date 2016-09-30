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
    <title>Incompatible options</title>
</head>
<body class="cm-no-transition cm-1-navbar">
<jsp:include page="header.jsp"></jsp:include>
<div id="global">
    <div class="container-fluid cm-container-white">
        <h2 style="margin-top:0;">Add incompatible options</h2>
    </div>
    <div class="container-fluid">
        <div class="panel panel-default">
            <div class="panel-body">
                <div class="input-group">
                    <%
                        String tariffOne;
                        String tariffTwo;

                        if (request.getAttribute("oneStat") == null)
                            tariffOne = "";
                        else
                            tariffOne = (String) request.getAttribute("oneStat");

                        if (request.getAttribute("twoStat") == null)
                            tariffTwo = "";
                        else
                            tariffTwo = (String) request.getAttribute("twoStat");

                    %>
                    <h4>Add options</h4>
                    <table class="table">
                        <thead>
                        <tr>
                            <th></th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td><input id="tariffOne" type="text" class="form-control" placeholder="First tariff"></td>
                            <td>
                                <font color="blue"><%out.print(tariffOne);%></font>
                            </td>
                        </tr>
                        <tr>
                            <td><input id="tariffTwo" type="text" class="form-control" placeholder="Second tariff"></td>
                            <td><font color="blue"><%out.print(tariffTwo);%></font></td>
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
                        var tariffOne = document.getElementById('tariffOne').value;
                        var tariffTwo = document.getElementById('tariffTwo').value;

                        popBox();
                        function popBox() {
                            x = confirm('Are you sure? ');
                            if (x == true) {
                                var xhr = new XMLHttpRequest();
                                xhr.open("POST", "adminImpossibleOption?tariffOne=" + tariffOne + "&tariffTwo=" + tariffTwo, true);
                                xhr.send();
                            }
                        }

                    }
                </script>
            </div>
        </div>
    </div>
    <%if (tariffOne.equals("OK") && tariffTwo.equals("OK")) {%>
    <div class="container-fluid cm-container-white">
        <h2 align="center" style="margin-top:0;">Connection added</h2>

    </div>
    <%}%>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</html>