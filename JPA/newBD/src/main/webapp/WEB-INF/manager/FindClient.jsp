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
<body class="cm-no-transition cm-1-navbar">
<div id="cm-menu">
    <nav class="cm-navbar cm-navbar-primary">
        <div class="cm-flex"><a href="index.jsp" class="cm-logo"></a></div>
        <div class="btn btn-primary md-menu-white" data-toggle="cm-menu"></div>
    </nav>
    <div id="cm-menu-content">
        <div id="cm-menu-items-wrapper">
            <div id="cm-menu-scroller">
                <ul class="cm-menu-items">
                    <li class="active"><a href="/login" class="sf-house">Home</a></li>
                    <li><a href="/user/Contract" class="sf-dashboard">Contracts</a></li>
                    <li><a href="/user/Tariffs" class="sf-notepad">Tariffs</a></li>
                    <li><a href="/user/TariffOptions" class="sf-brick">Tariff options</a></li>
                    <li><a href="/user/NumberOperations" class="sf-lock-open">Unlock number</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
<header id="cm-header">
    <nav class="cm-navbar cm-navbar-primary">
        <div class="btn btn-primary md-menu-white hidden-md hidden-lg" data-toggle="cm-menu"></div>
        <div class="cm-flex">
            <h1>Home</h1>
            <form id="cm-search" action="index.jsp" method="get">
                <input type="search" name="q" autocomplete="off" placeholder="Search...">
            </form>
        </div>
        <div class="pull-right">
            <div id="cm-search-btn" class="btn btn-primary md-search-white" data-toggle="cm-search"></div>
        </div>
        <div class="dropdown pull-right">
            <button class="btn btn-primary md-notifications-white" data-toggle="dropdown"><span
                    class="label label-danger">1</span></button>
            <div class="popover cm-popover bottom">
                <div class="arrow"></div>
                <div class="popover-content">
                    <div class="list-group">
                        <a href="/user/Offer" class="list-group-item">
                            <h4 class="list-group-item-heading text-overflow">
                                <i class="fa fa-fw fa-envelope"></i> New offer special for you !
                            </h4>
                            <p class="list-group-item-text text-overflow">Less money - better quality</p>
                        </a>
                    </div>
                    <div style="padding:10px"><a class="btn btn-success btn-block" href="/user/Tarrifs">Show me
                        more...</a></div>
                </div>
            </div>
        </div>
        <div class="dropdown pull-right">
            <button class="btn btn-primary md-account-circle-white" data-toggle="dropdown"></button>
            <ul class="dropdown-menu">
                <li class="disabled text-center">
                    <%

                        User user = (User) request.getAttribute("user");
                        String userName = (String) request.getAttribute("userName");

                        List<Contract> contracts = (List<Contract>) request.getAttribute("contracts");
                        TariffServiceImpl tariffService = (TariffServiceImpl) request.getAttribute("tariffService");
                        List<Integer> tempTariff = new ArrayList();
                        int i = 1, k;
                    %>
                    <a style="cursor:default;"><strong><%out.print(userName);%></strong></a>
                </li>
                <li class="divider"></li>
                <li>
                    <a href="/user/AboutMe"><i class="fa fa-fw fa-user"></i> Profile</a>
                </li>
                <li>
                    <a href="/user/ChangeData"><i class="fa fa-fw fa-cog"></i> Settings</a>
                </li>
                <li>
                    <a href="/user/Exit"><i class="fa fa-fw fa-sign-out"></i> Sign out</a>
                </li>
            </ul>
        </div>
    </nav>
</header>
<div id="global">
    <div class="container-fluid cm-container-white">
        <h2 style="margin-top:0;"><%out.print(userName);%>, your tariffs:</h2>
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
                            %>

                        </h2>

                    </div>
                </div>
            </div>
            <div class="col-sm-6">
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
                            <form name="test" onclick="change(<%=i%>,<%=tempTariff%>,<%=contract.getNumber()%>)">
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

        </div>
        <%
                i++;
            }
        %>
    </div>



    <script src="../assets/js/lib/jquery-2.1.3.min.js"></script>
    <script src="../assets/js/jquery.mousewheel.min.js"></script>
    <script src="../assets/js/jquery.cookie.min.js"></script>
    <script src="../assets/js/fastclick.min.js"></script>
    <script src="../assets/js/bootstrap.min.js"></script>
    <script src="../assets/js/clearmin.min.js"></script>
    <script src="../assets/js/demo/popovers-tooltips.js"></script>
    <footer class="cm-footer"><span class="pull-left">Created by Artyom Karnov</span><span
            class="pull-right">&copy;T-Systems JavaSchool</span></footer>
</body>
</html>