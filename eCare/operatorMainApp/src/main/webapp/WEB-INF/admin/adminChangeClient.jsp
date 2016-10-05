<%@ page import="operator.entities.Contract" %>
<%@ page import="operator.entities.TariffOption" %>
<%@ page import="java.util.ArrayList" %>
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
    <title>Change client</title>
</head>
<jsp:include page="header.jsp"></jsp:include>
<div id="global">
    <div class="container-fluid cm-container-white">
        <h2 style="margin-top:0;">Change contract options</h2>
        <p></p>
    </div>
    <%----------------------------------------------%>
    <div class="container-fluid">
        <div class="panel panel-default">
            <div class="panel-body">
                <h3 style="margin-top:0px">Enter contract number</h3>
                <div class="input-group input-group-lg">

                    <input type="text" class="form-control" placeholder="Searching" id="textFiled">

                    <span class="input-group-btn">
                        <form name="new" onclick="find()" class="btn btn-primary md-search-white">
                         <button style="z-index:2" class="btn btn-primary md-search-white" type="submit">&nbsp;&nbsp;&nbsp;&nbsp;</button>
                    </form>
                    </span>

                    <script>
                        function find() {
                            var text = document.getElementById('textFiled').value;
                            popBox();
                            function popBox() {
                                x = confirm('Are you sure?');
                                if (x == true) {
                                    var xhr = new XMLHttpRequest();
                                    xhr.open("POST", "adminFindClient?number=" + text, true);
                                    xhr.send();
                                }
                            }
                        }
                    </script>
                </div>
            </div>
        </div>
    </div>

    <% if (request.getSession().getAttribute("check") != null) {
        if (!request.getSession().getAttribute("usr").equals("one")) {
            Contract contract = (Contract) request.getSession().getAttribute("usr");
            List<TariffOption> allTariffOptions = (List<TariffOption>) request.getSession().getAttribute("tariffOptions");
            List<Integer> tempTariff = new ArrayList<>();

    %>
    <%-----------------------------------------------%>

    <div class="container-fluid">
        <%
            List<TariffOption> contractOptions = contract.getTariffOptions();

        %>
        <div class="row cm-fix-height">
            <div class="col-sm-6">
                <div class="panel panel-default">
                    <div class="panel-heading">Number: <%out.print(contract.getNumber());%></div>
                    <div class="panel-body">

                        <h2>

                            <%
                                out.print("<small>Tariff : </small>");
                                out.print(contract.getTariff().getTitle());
                                out.print("<br>");
                                out.print("<small>Month payment : </small>");
                                out.print(contract.getTariff().getPrice() + " RUB\n");
                                out.print("<small><br>Status : </small>");
                                if (contract.isBlocked() && contract.isBlockedByAdmin())
                                    out.print("<font color =\"red\">Blocked by manager</font>");
                                if (contract.isBlocked() && !contract.isBlockedByAdmin())
                                    out.print("<font color =\"red\">Blocked by user</font>");
                                if (!contract.isBlocked())
                                    out.print("<font color =\"green\">Active</font>");
                            %>

                        </h2>

                    </div>
                </div>
            </div>
            <%if (!contract.isBlocked()) {%>
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
                            <%
                                for (int i = 0; i < allTariffOptions.size(); i++) {
                                    if (contractOptions.contains(allTariffOptions.get(i))) {
                            %>
                            <tr class="success">
                                <th scope="row"><%out.print(i + 1);%></th>
                                <td><%out.print(allTariffOptions.get(i).getTitle());%></td>
                                <td>Activated</td>
                                <td>

                                    <form name="test"
                                          onclick="disable(<%=contract.getNumber()%>,<%=allTariffOptions.get(i).getTariffOptionId()%>)">
                                        <button type="submit" class="btn btn-danger">Disable</button>
                                    </form>

                                </td>
                                <script>
                                    function disable(par1, par2) {
                                        popBox();
                                        function popBox() {

                                            var xhr = new XMLHttpRequest();
                                            xhr.open("POST", "adminChangeClient?contractNumber=" + par1
                                                    + "&tariffOptionId=" + par2 + "&method=disable", false);
                                            xhr.send();
                                            document.getElementById('textFiled').value = par1;
                                            find();
                                        }
                                    }</script>
                            </tr>
                            <%
                            } else {
                            %>

                            <tr class="active">
                                <th scope="row"><%out.print(i + 1);%></th>
                                <td><%out.print(allTariffOptions.get(i).getTitle());%></td>
                                <td>Disabled</td>
                                <td>

                                    <form name="test"
                                          onclick="unable(<%=contract.getNumber()%>,<%=allTariffOptions.get(i).getTariffOptionId()%>)">
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
                                }
                            %>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <%}%>
        </div>
        <%
                }
            }
        %>
    </div>
</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</html>