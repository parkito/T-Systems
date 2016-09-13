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
                    <li><a href="/admin/NewClient" class="sf-dashboard">New client</a></li>
                    <li class="cm-submenu">
                        <a class="sf-notepad">Change contract<span class="caret"></span></a>
                        <ul>
                            <li><a href="/admin/NewContract">New contract</a></li>
                            <li><a href="/admin/ChangeClientTariff">Change tariff</a></li>
                            <li><a href="/admin/ChangeClient">Change options</a></li>
                            <li><a href="/admin/ContractControl">Contract control</a></li>
                        </ul>
                    </li>
                    <li class="cm-submenu">
                        <a class="sf-brick">Edit tariff<span class="caret"></span></a>
                        <ul>
                            <li><a href="/admin/NewTariff">New tariff</a></li>
                            <li><a href="/admin/EditTariff">Delete tariff</a></li>
                        </ul>
                    </li>
                    <li class="cm-submenu">
                        <a class="sf-brick-alt">Edit option<span class="caret"></span></a>
                        <ul>
                            <li><a href="/admin/NewOption">New option</a></li>
                            <li><a href="/admin/EditTariffOption">Delete option</a></li>
                            <li><a href="/admin/ConnectOption">Join options</a></li>
                            <li><a href="/admin/ImpossibleOption">Incompatible options</a></li>
                        </ul>
                    </li>
                    <li><a href="/admin/ViewClient" class="sf-lock-open">View clients</a></li>
                    <li><a href="/admin/FindClient" class="sf-window-layout">Find client</a></li>

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
            <button class="btn btn-primary md-account-circle-white" data-toggle="dropdown"></button>
            <ul class="dropdown-menu">
                <li class="disabled text-center">
                    <%
                        String userName = (String) request.getSession().getAttribute("userName");
                    %>
                    <a style="cursor:default;"><strong><%out.print(userName);%></strong></a>
                </li>
                <li class="divider"></li>
                <li>
                    <a href="/admin/FindClient"><i class="fa fa-fw fa-user"></i> Clients</a>
                </li>
                <li>
                    <a href="/admin/ChangeClient"><i class="fa fa-fw fa-cog"></i> Tariffs</a>
                </li>
                <li>
                    <a href="/Exit"><i class="fa fa-fw fa-sign-out"></i> Sign out</a>
                </li>
            </ul>
        </div>
    </nav>
</header>