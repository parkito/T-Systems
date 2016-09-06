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

    <%
        for (Contract contract : contracts) {
            List<TariffOption> contractOptions = contract.getTariffOptions();

    %>
    <div class="container-fluid">
        <div class="row cm-fix-height">

            <div class="col-sm-4">
                <div class="panel panel-default">
                    <div class="panel-heading">Number: <%out.print(contract.getNumber());%></div>
                    <div class="panel-body">

                        <h2>

                            <%
                                out.print("<small>Tariff : </small>");
                                out.print(contract.getTariff().getTitle());
                                out.print("<br>");
                                out.print("<small>Month payment : </small>");
                                out.print(contract.getTariff().getPrice() + " RUB");
                            %>
                        </h2>
                    </div>
                </div>
            </div>

            <div class="col-sm-4">
                <div class="panel panel-default">
                    <div class="panel-heading">Tariff list</div>
                    <div class="panel-body">

                        <%
                            for (Tariff tariff : tariffService.getAll()) {
                                tempTariff.add(tariff.getTariffId());
                                if (contract.getTariff().equals(tariff)) {%>

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
                                  onclick="change(<%//=i%>,<%//=tempTariff%>,<%//=contract.getNumber()%>)">
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
                                          onclick="disable(<%=contract.getNumber()%>,<%=allTariffOptions.get(j).getTariffOptionId()%>)">
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
                                          onclick="unable(<%=contract.getNumber()%>,<%=allTariffOptions.get(j).getTariffOptionId()%>)">
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
        </div>
    </div>
</div>
<%
        i++;
    }
%>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</html>