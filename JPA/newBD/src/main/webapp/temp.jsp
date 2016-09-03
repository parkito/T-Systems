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
    <title>Number operations</title>
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
                        User user = (User) request.getAttribute("userObj");
                        String userName = (String) request.getAttribute("userName");
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
        <h2 style="margin-top:0;"><%out.print(userName);%>, your numbers:</h2>
        <p></p>
    </div>
    <div class="container-fluid ">
        <%--<div class="col-md-6">--%>
        <div class="panel panel-default">
            <%--<div class="panel-heading">Tables with contextual classes</div>--%>
            <%--&lt;%&ndash;<div class="panel-body">&ndash;%&gt;--%>
            <%--<p style="margin-bottom:0">The table is outside the <code>.panel-body</code></p>--%>
            <%--</div>--%>
            <table class="table">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Number</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>

                <%
                    List<Contract> contracts = (List<Contract>) request.getAttribute("contracts");
                    for (int i = 0; i < contracts.size(); i++) {
                        if (contracts.get(i).getIsBlocked())
                            out.print("<tr class=\"danger\">");
                        else out.print("<tr class=\"active\">");
                %>
                <th scope="row"><%out.print(i + 1);%></th>
                <td><%out.print(contracts.get(i).getNumber());%></td>

                <%
                    if (contracts.get(i).getIsBlocked())
                        out.print("<td>Blocked</td>");
                    else
                        out.print("<td>Active</td>");

                    if (contracts.get(i).getIsBlocked()) {
                %>
                <form name="block" onclick="block(<%contracts.get(i).getNumber();%>)">
                    <%
                        out.print("<td><button type=\"sumbit\" name=\"id\" class=\"btn btn-success\" data-toggle=\"modal\" data-target=\"#myModalGreen\">\n" +
                                "UnBlock</button></td>");
                    %>
                </form>
                <%
                } else {
                %>
                <form name="unblock" onclick="unblock(<%contracts.get(i).getNumber();%>)">
                    <%
                        out.print("<td><button type=\"sumbit\" class=\"btn btn-danger\" data-toggle=\"modal\" data-target=\"#myModal\">\n" +
                                "Block</button></td>");
                    %>
                </form>
                }%>

                <td>
                </td>
                </tr>
                <%}%>
                </tbody>

            </table>
        </div>
    </div>
</div>

<div id="myModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">X</span></button>
                <h3 class="modal-title" id="myModalLabel">
                    Do you want to block number ?
                    <a class="anchorjs-link" href="#myModalLabel"><span
                            class="anchorjs-icon"></span></a>
                </h3>
            </div>
            <div class="modal-footer">
                <form action="/login" method="post">
                    <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-default">Yes</button>

                </form>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<div id="myModalGreen" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">X</span></button>
                <h3 class="modal-title" id="myModalLabel1">
                    Do you want to unblock number ?
                    <a class="anchorjs-link" href="#myModalLabel"><span
                            class="anchorjs-icon"></span></a>
                </h3>
            </div>
            <div class="modal-footer">
                <form action="/login" method="post">
                    <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-default">Yes</button>

                </form>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>


</div>
<script>
    function block(id) {
        popBox();
        function popBox() {
            x = confirm('Are you sure?');
            if (x == true) {
                var xhr = new XMLHttpRequest();
                xhr.open("POST", "/user/NumberOperations?blockItem=" + id, true);
                xhr.send();
            }
        }
    }
</script>

<script>
    function unblock(id) {
        popBox();
        function popBox() {
            x = confirm('Are you sure?');
            if (x == true) {
                var xhr = new XMLHttpRequest();
                xhr.open("POST", "/user/NumberOperations?unblockItem=" + id, true);
                xhr.send();
            }
        }
    }
</script>
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