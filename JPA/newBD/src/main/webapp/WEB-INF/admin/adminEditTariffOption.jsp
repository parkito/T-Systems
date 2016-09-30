<%@ page import="operator.entities.Contract" %>
<%@ page import="operator.entities.User" %>
<%@ page import="java.util.List" %>
<%@ page import="operator.entities.TariffOption" %>
<%@ page import="operator.entities.Tariff" %>

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
    <title>Edit tariff options</title>
</head>
<jsp:include page="header.jsp"></jsp:include>
<%
    List<TariffOption> tariffs = (List<TariffOption>) request.getAttribute("options");
%>
<div id="global">
    <div class="container-fluid cm-container-white">
        <h2 style="margin-top:0;">Delete options</h2>
        <p></p>
    </div>
    <div class="container-fluid ">
        <div class="panel panel-default">
            <table class="table">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Option</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>

                <%
                    for (int i = 0; i < tariffs.size(); i++) {
                        out.print("<tr class=\"active\">");
                %>
                <th scope="row"><%out.print(i + 1);%></th>
                <td><%out.print(tariffs.get(i).getTitle());%></td>

                <td>

                    <form name="test" onclick="del(<%=tariffs.get(i).getTariffOptionId()%>)">
                        <button type="submit" class="btn btn-danger">delete</button>
                    </form>

                </td>
                <script>
                    function del(number) {
                        popBox();
                        function popBox() {
                            x = confirm('Are you sure?');
                            if (x == true) {
                                var xhr = new XMLHttpRequest();
                                xhr.open("POST", "adminEditTariffOption?tariffOptionId=" + number, false);
                                xhr.send();
                            }
                        }
                    }</script>
                </tr>
                <%}%>
                </tbody>
            </table>
        </div>
    </div>
</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</html>