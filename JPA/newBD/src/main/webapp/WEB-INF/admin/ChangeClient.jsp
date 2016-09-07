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
    TariffServiceImpl tariffService = (TariffServiceImpl) request.getSession(true).getAttribute("tariffService");
    List<Integer> tempTariff = new ArrayList();
    List<TariffOption> allTariffOptions = (List<TariffOption>) request.getSession(true).getAttribute("tariffOptions");
    int i = 1, k;
%>
<div id="global">

    <div class="container-fluid cm-container-white">
        <h2 style="margin-top:0;"><%out.print(userName);%>, your tariffs:</h2>
        <p></p>
    </div>


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
                                x = confirm('Are you sure? ' + text);
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
        if (check != null)
            if (check.equals("work"))
                if (request.getSession(true).getAttribute("usr") != null) {
                    Contract contract = (Contract) request.getSession(true).getAttribute("usr");
                    contracts = contract.getUser().getContracts();

    %>

    <div class="container-fluid">
        <div class="row cm-fix-height">
            <div class="col-sm-4">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <h3>Contract:</h3>
                        <p>
                        <h3><b>Number </b><%out.print(contract.getNumber());%></h3>
                        <h3><b>Blocked </b><%out.print(contract.getIsBlocked());%></h3>
                        </p>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <h3>Client:</h3>
                        <p>
                        <h3><b>Name </b><%out.print(contract.getUser().getName());%></h3>
                        <h3><b>Surname </b><%out.print(contract.getUser().getSecondName());%></h3>
                        </p>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <h3>Contacts:</h3>
                        <p>
                        <h3><b>E-mail </b><%out.print(contract.getUser().getEmail());%></h3>
                        <h3><b>Adress </b><%out.print(contract.getUser().getAdress());%></h3>
                        </p>
                    </div>
                </div>
            </div>
        </div>

        <%
            for (Contract contr : contracts) {
                List<TariffOption> contractOptions = contr.getTariffOptions();

        %>
    </div>
    <div class="container-fluid">
        <div class="row cm-fix-height">

            <div class="col-sm-4">
                <div class="panel panel-default">
                    <div class="panel-heading">Number: <%out.print(contr.getNumber());%></div>
                    <div class="panel-body">

                        <h2>

                            <%
                                out.print("<small>Tariff : </small>");
                                out.print(contr.getTariff().getTitle());
                                out.print("<br>");
                                out.print("<small>Month payment : </small>");
                                out.print(contr.getTariff().getPrice() + " RUB");
                                out.print("<small><br>Status : </small>");
                                if (contr.isBlocked() && contr.isBlockedByAdmin())
                                    out.print("<font color =\"red\">Blocked by manager</font>");
                                if (contr.isBlocked() && !contr.isBlockedByAdmin())
                                    out.print("<font color =\"red\">Blocked by user</font>");
                                if (!contr.isBlocked())
                                    out.print("<font color =\"green\">Active</font>");

                            %>
                        </h2>
                        <%if (contr.getIsBlocked()) {%>
                        <div class="modal-footer">
                            <form name="test" onclick="unblock(<%=contr.getNumber()%>)">
                                <button type="submit" class="btn btn-success">unblock</button>
                            </form>
                            <script>
                                function unblock(number) {
                                    popBox();
                                    function popBox() {
                                        x = confirm('Are you sure?');
                                        if (x == true) {
                                            var xhr = new XMLHttpRequest();
                                            xhr.open("POST", "/admin/ChangeClient?unblockItem=" + number, true);
                                            xhr.send();
                                            window.location.reload();
                                        }
                                    }
                                }</script>
                        </div>
                        <%
                        } else {%>
                        <div class="modal-footer">
                            <form name="test" onclick="block(<%=contr.getNumber()%>)">
                                <button type="submit" class="btn btn-danger">block</button>
                            </form>
                            <script>
                                function block(number) {
                                    popBox();
                                    function popBox() {
                                        x = confirm('Are you sure? '+number);
                                        if (x == true) {
                                            var xhr = new XMLHttpRequest();
                                            xhr.open("POST", "/admin/ChangeClient?blockItem=" + number, true);
                                            xhr.send();
                                        }
                                    }
                                }
                            </script>
                        </div>
                        <%}%>
                    </div>

                </div>
            </div>
            <%if (!contr.isBlocked()) {%>
            <div class="col-sm-4">
                <div class="panel panel-default">
                    <div class="panel-heading">Tariff list</div>
                    <div class="panel-body">
                        <%
                            for (Tariff tariff : tariffService.getAll()) {
                                tempTariff.add(tariff.getTariffId());
                                if (contr.getTariff().equals(tariff)) {
                        %>
                        <h3>
                            <div class="radio">
                                <label>
                                    <%
                                        out.print("<input type=\"radio\" name=\"optionsRadios" + i + "\" id=\"optionsRadios"
                                                + i + "\" value=\"option" + i + "\" checked disabled>");
                                        out.print("<b>" + tariff.getTitle() + "</b>");
                                    %>
                                </label>
                            </div>
                        </h3>

                        <%
                        } else {
                        %>
                        <h3>
                            <div class="radio">
                                <label>
                                    <%
                                        out.print("<input type=\"radio\" name=\"optionsRadios" + i + "\" id=\"optionsRadios"
                                                + i + "\" value=\"option" + i + "\">");
                                        out.print(tariff.getTitle());
                                    %>
                                </label>
                            </div>
                        </h3>
                        <%
                                }
                            }
                        %>
                        <div class="modal-footer">
                            <form name="test"
                                  onclick="change(<%=i%>,<%=tempTariff%>,<%=contr.getNumber()%>)">
                                <button type="submit" class="btn btn-success">Change</button>
                            </form>
                            <script>
                                function change(par1, par2, par3) {
                                    var rad = document.getElementsByName('optionsRadios' + par1);
                                    for (var i = 0; i
                                    < rad.length
                                            ; i++) {
                                        if (rad[i].checked) {
                                            popBox(par2[i], par3);
                                        }
                                    }

                                    function popBox(num1, num2) {
                                        x = confirm('Are you sure? ');
                                        if (x == true) {
                                            var xhr = new XMLHttpRequest();
                                            var id = 1;
                                            xhr.open("POST", "/user/Tariffs?tariffId=" + num1 + "&contractNumber=" + num2, true);
                                            xhr.send();
                                        }
                                    }

                                }
                            </script>

                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="panel panel-default">
                    <div class="panel-heading">Tariff options</div>
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
                                for (int j = 0; j < allTariffOptions.size(); j++) {
                                    if (contractOptions.contains(allTariffOptions.get(j))) {
                            %>
                            <tr class="success">
                                <th scope="row"><%out.print(j + 1);%></th>
                                <td><%out.print(allTariffOptions.get(j).getTitle());%></td>
                                <td>Activated</td>
                                <td>

                                    <form name="test"
                                          onclick="disable(<%=contr.getNumber()%>,<%=allTariffOptions.get(j).getTariffOptionId()%>)">
                                        <button type="submit" class="btn btn-danger">Disable</button>
                                    </form>

                                </td>
                                <script>
                                    function disable(par1, par2) {
                                        popBox();
                                        function popBox() {
                                            x = confirm('Are you sure? ');
                                            if (x == true) {
                                                var xhr = new XMLHttpRequest();
                                                xhr.open("POST", "/user/TariffOptions?contractNumber=" + par1
                                                        + "&tariff=" + par2 + "&method=disable", true);
                                                xhr.send();
                                            }
                                        }
                                    }</script>
                            </tr>
                            <%
                            } else {
                            %>

                            <tr class="active">
                                <th scope="row"><%out.print(j + 1);%></th>
                                <td><%out.print(allTariffOptions.get(j).getTitle());%></td>
                                <td>Disabled</td>
                                <td>

                                    <form name="test"
                                          onclick="unable(<%=contr.getNumber()%>,<%=allTariffOptions.get(j).getTariffOptionId()%>)">
                                        <button type="submit" class="btn btn-success">Activate</button>
                                    </form>

                                </td>

                                <script>
                                    function unable(par1, par2) {
                                        popBox();
                                        function popBox() {
                                            x = confirm('Are you sure? ');
                                            if (x == true) {
                                                var xhr = new XMLHttpRequest();
                                                xhr.open("POST", "/user/TariffOptions?contractNumber=" + par1
                                                        + "&tariff=" + par2 + "&method=unable", true);
                                                xhr.send();
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
    </div>

<%
        i++;
    }
%>


<%} else {%>
<div class="container-fluid">
    <div class="panel panel-default">
        <div class="panel-body">
            <h2><p align="center">
                User wasn' t found</p></h2>
        </div>
    </div>
</div>


<%}%>
</div>
<%--</div>--%>


<%--</div>--%>
<jsp:include page="footer.jsp"></jsp:include>
</html>