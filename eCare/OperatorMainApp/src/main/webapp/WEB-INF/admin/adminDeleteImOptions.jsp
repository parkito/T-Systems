<%@ page import="operator.entities.TariffOption" %>
<%@ page import="java.util.List" %>

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
    List<TariffOption> allTariffOptions = (List<TariffOption>) request.getAttribute("options");
%>
<div id="global">
    <div class="container-fluid cm-container-white">
        <h2 style="margin-top:0;">Delete options</h2>
        <p></p>
    </div>
    <%
        for (TariffOption option : allTariffOptions) {
            if (option.getimpossibleTogether().size() > 0) {

    %>
    <div class="container-fluid">
        <div class="row cm-fix-height">
            <div class="col-sm-6">
                <div class="panel panel-default">
                    <div class="panel-heading">Option: <%out.print(option.getTitle());%></div>
                    <div class="panel-body">

                        <h2>
                            <%out.print(option.getTitle());%>
                        </h2>

                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="panel panel-default">
                    <div class="panel-heading">Joint options</div>
                    <div class="panel-body">
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
                            <%
                                for (int i = 0; i < option.getjointTogether().size(); i++) {
                            %>

                            <tr class="active">
                                <th scope="row"><%out.print(i + 1);%></th>
                                <td><%out.print(option.getimpossibleTogether().get(i).getTitle());%></td>
                                <td>Joint</td>
                                <td>

                                    <form name="test"
                                          onclick="unable(<%=option.getTariffOptionId()%>,<%=option.getimpossibleTogether().get(i).getTariffOptionId()%>)">
                                        <button type="submit" class="btn btn-danger">Delete</button>
                                    </form>

                                </td>

                                <script>
                                    function unable(par1, par2) {
                                        popBox();
                                        function popBox() {
                                            var xhr = new XMLHttpRequest();
                                            xhr.open("POST", "adminDeleteImOptions?modified=" + par1
                                                    + "&removed=" + par2, false);
                                            xhr.send();

                                        }
                                    }</script>
                            </tr>

                            <%
                                    }
                                }

                            %>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%}%>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</html>