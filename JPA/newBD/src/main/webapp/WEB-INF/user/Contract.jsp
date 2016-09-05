<%@ page import="entities.Contract" %>
<%@ page import="entities.User" %>
<%@ page import="services.implementation.ContractServiceImpl" %>
<%@ page import="services.implementation.UserServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="services.implementation.TariffOptionServiceImpl" %>
<%@ page import="entities.TariffOption" %>
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
    String userName = (String) request.getSession(true).getAttribute("userName");
    List<Contract> contracts = (List<Contract>)request.getSession(true).getAttribute("contracts");
    TariffOptionServiceImpl tariffOptionService = (TariffOptionServiceImpl)
            request.getSession(true).getAttribute("tariffOptionService");
%>
<div id="global">
    <div class="container-fluid cm-container-white">
        <h2 style="margin-top:0;"><%out.print(userName);%>, your contracts:</h2>
        <p></p>
    </div>
    <div class="container-fluid">
            <%
          for (Contract contract : contracts) {
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
                                out.print(contract.getTariff().getPrice() + " RUB");
//                                }
                            %>

                        </h2>

                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="panel panel-default">
                    <div class="panel-heading">options</div>
                    <div class="panel-body">
                        <h2>
                            <%
                                //                                for (Contract contract : contracts) {
                                for (TariffOption tariffOption :
                                        tariffOptionService.getAllTariffOptionForContract(contract.getContractId())) {
                                    out.print("<small>Option : </small>");
                                    out.print(tariffOption.getTitle());
                                    out.print("<br>");
                                    out.print("<small>Price : </small>");
                                    out.print(tariffOption.getPrice());
                                    out.print("<br>");
                                    out.print("------------------------------------------------");
                                    out.print("<br>");
                                }
//                                }
                            %>
                        </h2>
                    </div>
                </div>
            </div>
        </div>
            <%}%>
        <jsp:include page="footer.jsp"></jsp:include>
</html>