<%@ page import="entities.Contract" %>
<%@ page import="services.implementation.UserServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String eMail = (String) request.getSession(true).getAttribute("eMail");
    UserServiceImpl userService = new UserServiceImpl();
    List<Contract> contracts = userService.getUserByEMAil(eMail).getContracts();
    double mainSum = 0;
    for (Contract contract : contracts) {
        if (!contract.isBlocked())
        mainSum += contract.getTariff().getPrice();
    }
%>
<body class="cm-no-transition cm-1-navbar">
<div id="cm-menu">
    <nav class="cm-navbar cm-navbar-primary">
        <div class="cm-flex"><a href="/" class="cm-logo"></a></div>
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
            <form id="cm-search" action="/Help" method="get">
                <input type="search" name="find" autocomplete="off" placeholder="Search...">
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
                        <a href="/user/Tariffs" class="list-group-item">
                            <h4 class="list-group-item-heading text-overflow">
                                <i class="fa fa-fw fa-envelope"></i> My scope
                            </h4>
                            <p class="list-group-item-text text-overflow">I spend <%=mainSum%> RUB per month</p>
                        </a>
                    </div>
                    <div style="padding:10px"><a class="btn btn-success btn-block" href="/user/Tariffs">Show me
                        more...</a></div>
                </div>
            </div>
        </div>
        <div class="dropdown pull-right">
            <button class="btn btn-primary md-account-circle-white" data-toggle="dropdown"></button>
            <ul class="dropdown-menu">
                <li class="disabled text-center">
                    <c:set var="userName" value="${sessionScope.userName}"/>
                    <a style="cursor:default;"><strong><c:out value='${userName}'/></strong></a>
                </li>
                <li class="divider"></li>
                <li>
                    <a href="/user/Tariffs"><i class="fa fa-fw fa-user"></i> About Me</a>
                </li>
                <li>
                    <a href="/user/Contract"><i class="fa fa-fw fa-cog"></i> Contracts</a>
                </li>
                <li>
                    <a href="/Exit"><i class="fa fa-fw fa-sign-out"></i> Sign out</a>
                </li>
            </ul>
        </div>
    </nav>
</header>