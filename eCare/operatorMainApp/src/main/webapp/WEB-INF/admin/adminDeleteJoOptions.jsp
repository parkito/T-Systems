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
        for (int j = 0; j < 3; j++) {

    %>
    <div class="container-fluid">
        <div class="row cm-fix-height">
            <div class="col-sm-6">
                <div class="panel panel-default">
                    <div class="panel-heading">Number:</div>
                    <div class="panel-body">

                        <h2>


                        </h2>

                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="panel panel-default">
                    <div class="panel-heading">Tariff option list</div>
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
                                for (int i = 0; i < allTariffOptions.size(); i++) {
                            %>

                            <tr class="active">
                                <th scope="row"><%out.print(i + 1);%></th>
                                <td><%out.print(allTariffOptions.get(i).getTitle());%></td>
                                <td>Disabled</td>
                                <td>

                                    <form name="test"
                                          onclick="unable(<%=allTariffOptions.get(i)%>,<%=allTariffOptions.get(i).getTariffOptionId()%>)">
                                        <button type="submit" class="btn btn-success">Activate</button>
                                    </form>

                                </td>

                                <script>
                                    function unable(par1, par2) {
                                        popBox();
                                        function popBox() {
                                            var xhr = new XMLHttpRequest();
                                            xhr.open("POST", "adminChangeClient?contractNumber=" + par1
                                                    + "&tariffOptionId=" + par2 + "&method=unable", false);
                                            xhr.send();
                                            if (xhr.status == 405) {
                                                alert('Incompatible options')
                                            }
                                            else {
                                                document.getElementById('textFiled').value = par1;
                                                find();
                                            }

                                        }
                                    }</script>
                            </tr>

                            <%
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