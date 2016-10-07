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
                    <li class="active"><a href="main" class="sf-house">Home</a></li>
                    <li><a href="adminNewClient" class="sf-dashboard">New client</a></li>
                    <li class="cm-submenu">
                        <a class="sf-notepad">Change contract<span class="caret"></span></a>
                        <ul>
                            <li><a href="adminNewContract">New contract</a></li>
                            <li><a href="adminChangeClientTariff">Change tariff</a></li>
                            <li><a href="adminChangeClient">Change options</a></li>
                            <li><a href="adminContractControl">Contract control</a></li>
                        </ul>
                    </li>
                    <li class="cm-submenu">
                        <a class="sf-brick">Edit tariff<span class="caret"></span></a>
                        <ul>
                            <li><a href="adminNewTariff">New tariff</a></li>
                            <li><a href="adminEditTariff">Delete tariff</a></li>
                        </ul>
                    </li>
                    <li class="cm-submenu">
                        <a class="sf-brick-alt">Edit option<span class="caret"></span></a>
                        <ul>
                            <li><a href="adminNewOption">New option</a></li>
                            <li><a href="adminEditTariffOption">Delete option</a></li>
                            <li><a href="adminConnectOption">Join options</a></li>
                            <li><a href="adminImpossibleOption">Incompatible options</a></li>
                            <li><a href="adminDeleteImOptions">Delete incompatibles</a></li>
                            <li><a href="adminDeleteJoOptions">Delete join</a></li>
                        </ul>
                    </li>
                    <li><a href="adminViewClient" class="sf-lock-open">View clients</a></li>
                    <li><a href="adminFindClient" class="sf-window-layout">Find client</a></li>
                    <li><a href="adminRest" class="sf-file-pdf">Report</a></li>
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
            <form id="cm-search" action="Help" method="get">
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
                    <a style="cursor:default;"><strong>${currentUser.name}</strong></a>
                </li>
                <li class="divider"></li>
                <li>
                    <a href="adminFindClient"><i class="fa fa-fw fa-user"></i> Clients</a>
                </li>
                <li>
                    <a href="adminChangeClient"><i class="fa fa-fw fa-cog"></i> Tariffs</a>
                </li>
                <li>
                    <a href="logout"><i class="fa fa-fw fa-sign-out"></i> Sign out</a>
                </li>
            </ul>
        </div>
    </nav>
</header>