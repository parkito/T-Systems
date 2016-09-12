<%@ page import="entities.Contract" %>
<%@ page import="entities.User" %>
<%@ page import="services.implementation.ContractServiceImpl" %>
<%@ page import="services.implementation.UserServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="services.implementation.TariffOptionServiceImpl" %>
<%@ page import="entities.TariffOption" %>
<%@ page import="services.implementation.TariffServiceImpl" %>
<%@ page import="entities.Tariff" %>
<%@ page import="java.util.ArrayList" %>
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
<%
    User user = (User) request.getSession(true).getAttribute("user");
    String userName = (String) request.getSession(true).getAttribute("userName");

    List<Contract> contracts = (List<Contract>) request.getSession(true).getAttribute("contracts");
    List<TariffOption> allTariffOptions = (List<TariffOption>) request.getSession(true).getAttribute("tariffOptions");
    List<Integer> tempTariff = new ArrayList();


%>
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
                                    xhr.open("POST", "/admin/FindClient?number=" + text, true);
                                    xhr.send();
                                }
                            }
                        }
                    </script>
                </div>
            </div>
        </div>
    </div>

    <% String check = (String) request.getSession(true).getAttribute("check");
        if (check.equals("work"))
            if (request.getSession(true).getAttribute("usr") != null) {
                Contract contract1 = (Contract) request.getSession(true).getAttribute("usr");
                contracts.clear();
                contracts.add(contract1);
    %>
    <%-----------------------------------------------%>

    <div class="container-fluid">
        <%
            for (Contract contract : contracts) {
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
                                            xhr.open("DELETE", "/user/TariffOptions?contractNumber=" + par1
                                                    + "&tariff=" + par2 + "&method=disable", true);
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
                                            xhr.open("DELETE", "/user/TariffOptions?contractNumber=" + par1
                                                    + "&tariff=" + par2 + "&method=unable", false);
                                            xhr.send();
                                            if (xhr.status == 500) {
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