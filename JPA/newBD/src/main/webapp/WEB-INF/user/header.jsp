<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                        String userName = (String) request.getSession(true).getAttribute("userName");
                    %>
                    <a style="cursor:default;"><strong><c:out value='${userName}'/></strong></a>
                    <%--<a style="cursor:default;"><strong><%out.print(userName);%></strong></a>--%>
                </li>
                <li class="divider"></li>
                <li>
                    <a href="/user/AboutMe"><i class="fa fa-fw fa-user"></i> Profile</a>
                </li>
                <li>
                    <a href="/user/ChangeData"><i class="fa fa-fw fa-cog"></i> Settings</a>
                </li>
                <li>
                    <a href="/Exit"><i class="fa fa-fw fa-sign-out"></i> Sign out</a>
                </li>
            </ul>
        </div>
    </nav>
</header>