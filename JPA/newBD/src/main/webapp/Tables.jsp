<%@ page import="services.implementation.TariffServiceImpl" %>
<%@ page import="entities.Tariff" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1">
    <link rel="stylesheet" type="text/css" href="assets/css/bootstrap-clearmin.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/roboto.css">
    <link rel="stylesheet" type="text/css" href="assets/css/material-design.css">
    <link rel="stylesheet" type="text/css" href="assets/css/small-n-flat.css">
    <link rel="stylesheet" type="text/css" href="assets/css/font-awesome.min.css">
    <title>Clearmin template</title>
</head>
<body class="cm-no-transition cm-2-navbar">
<div id="cm-menu">
    <nav class="cm-navbar cm-navbar-primary">
        <div class="cm-flex"><a href="../index.html" class="cm-logo"></a></div>
        <div class="btn btn-primary md-menu-white" data-toggle="cm-menu"></div>
    </nav>
    <div id="cm-menu-content">
        <div id="cm-menu-items-wrapper">
            <div id="cm-menu-scroller">
                <ul class="cm-menu-items">
                    <li><a href="../index.html" class="sf-house">Home</a></li>
                    <li><a href="dashboard-sales.html" class="sf-dashboard">Dashboard</a></li>
                    <li class="active"><a href="Tables.jsp" class="sf-brick">Components</a></li>
                    <li class="cm-submenu">
                        <a class="sf-window-layout">Navbar layouts <span class="caret"></span></a>
                        <ul>
                            <li><a href="layouts-breadcrumb1.html">1st nav breadcrumb</a></li>
                            <li><a href="layouts-breadcrumb2.html">2nd nav breadcrumb</a></li>
                            <li><a href="layouts-tabs.html">2nd nav tabs</a></li>
                        </ul>
                    </li>
                    <li class="cm-submenu">
                        <a class="sf-cat">Icons <span class="caret"></span></a>
                        <ul>
                            <li><a href="ico-sf.html">Small-n-flat</a></li>
                            <li><a href="ico-md.html">Material Design</a></li>
                            <li><a href="ico-fa.html">Font Awesome</a></li>
                        </ul>
                    </li>
                    <li><a href="notepad.html" class="sf-notepad">Text Editor</a></li>
                    <li><a href="../index.html" class="sf-lock-open">Login page</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>


<div id="global">
    <style>.demo hr {
        margin: 30px 0
    }</style>
    <div class="container-fluid">
        <div class="panel panel-default demo">
            <div class="panel-body">
                <div class="panel-body">
                    <h1 style="margin-top:0" align="center">
                        Tariffs
                    </h1>
                    <table class="table table-bordered table-hover">
                        <%--<caption align="center">Tariffs</caption>--%>
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Title</th>
                            <th>Price</th>
                        </tr>
                        </thead>
                        <tbody>

                        <%
                            TariffServiceImpl tariffService = new TariffServiceImpl();
                            for (Tariff tariff : tariffService.getAll()) {
                        %>
                        <tr >
                            <td><%out.print(tariff.getTariffId());%></td>
                            <td><%out.print(tariff.getTitle());%></td>
                            <td><%out.print(tariff.getPrice());%></td>
                        </tr>
                        <%}%>
                        </tbody>
                    </table>
                    <button type="button" class="btn btn-primary" style="float:right" ;>Back</button>
                    <button type="button" class="btn btn-primary" style="float:right" ;>Home</button>
                    <!--<header id=" cm-header
                ">-->
                    <!--<nav class="cm-navbar cm-navbar-primary">-->
                    <!--<div class="btn btn-primary md-menu-white hidden-md hidden-lg" data-toggle="cm-menu"></div>-->
                    <!--<div class="cm-flex">-->
                    <!--<h1>Components</h1> -->
                    <!--<form id="cm-search" action="../index.html" method="get">-->
                    <!--<input type="search" name="q" autocomplete="off" placeholder="Search...">-->
                    <!--</form>-->
                    <!--</div>-->
                    <!--<div class="pull-right">-->
                    <!--<div id="cm-search-btn" class="btn btn-primary md-search-white" data-toggle="cm-search"></div>-->
                    <!--</div>-->
                    <!--<div class="dropdown pull-right">-->
                    <!--<button class="btn btn-primary md-notifications-white" data-toggle="dropdown"> <span class="label label-danger">23</span> </button>-->
                    <!--<div class="popover cm-popover bottom">-->
                    <!--<div class="arrow"></div>-->
                    <!--<div class="popover-content">-->
                    <!--<div class="list-group">-->
                    <!--<a href="#" class="list-group-item">-->
                    <!--<h4 class="list-group-item-heading text-overflow">-->
                    <!--<i class="fa fa-fw fa-envelope"></i> Nunc volutpat aliquet magna.-->
                    <!--</h4>-->
                    <!--<p class="list-group-item-text text-overflow">Pellentesque tincidunt mollis scelerisque. Praesent vel blandit quam.</p>-->
                    <!--</a>-->
                    <!--<a href="#" class="list-group-item">-->
                    <!--<h4 class="list-group-item-heading">-->
                    <!--<i class="fa fa-fw fa-envelope"></i> Aliquam orci lectus-->
                    <!--</h4>-->
                    <!--<p class="list-group-item-text">Donec quis arcu non risus sagittis</p>-->
                    <!--</a>-->
                    <!--<a href="#" class="list-group-item">-->
                    <!--<h4 class="list-group-item-heading">-->
                    <!--<i class="fa fa-fw fa-warning"></i> Holy guacamole !-->
                    <!--</h4>-->
                    <!--<p class="list-group-item-text">Best check yo self, you're not looking too good.</p>-->
                    <!--</a>-->
                    <!--</div>-->
                    <!--<div style="padding:10px"><a class="btn btn-success btn-block" href="#">Show me more...</a></div>-->
                    <!--</div>-->
                    <!--</div>-->
                    <!--</div>-->
                    <!--<div class="dropdown pull-right">-->
                    <!--<button class="btn btn-primary md-account-circle-white" data-toggle="dropdown"></button>-->
                    <!--<ul class="dropdown-menu">-->
                    <!--<li class="disabled text-center">-->
                    <!--<a style="cursor:default;"><strong>John Smith</strong></a>-->
                    <!--</li>-->
                    <!--<li class="divider"></li>-->
                    <!--<li>-->
                    <!--<a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>-->
                    <!--</li>-->
                    <!--<li>-->
                    <!--<a href="#"><i class="fa fa-fw fa-cog"></i> Settings</a>-->
                    <!--</li>-->
                    <!--<li>-->
                    <!--<a href="../index.html"><i class="fa fa-fw fa-sign-out"></i> Sign out</a>-->
                    <!--</li>-->
                    <!--</ul>-->
                    <!--</div>-->
                    <!--</nav>-->
                    <!--<nav class="cm-navbar cm-navbar-default cm-navbar-slideup">-->
                    <!--<div class="cm-flex">-->
                    <!--<div class="nav-tabs-container">-->
                    <!--<ul class="nav nav-tabs">-->
                    <!--<li class="active"><a href="Tables.jsp">Typography &amp; Tables</a></li>-->
                    <!--<li><a href="components-buttons.html">Buttons &amp; Forms</a></li>-->
                    <!--<li><a href="components-interactive.html">Interactive Components</a></li>-->
                    <!--</ul>-->
                    <!--</div>-->
                    <!--</div>-->
                    <!--</nav>-->
                    <!--</header>-->
                    <!--<div id="global">-->
                    <!--<div class="container-fluid">-->
                    <!--<div class="row cm-fix-height">-->
                    <!--<div class="col-sm-6">-->
                    <!--<div class="panel panel-default">-->
                    <!--<div class="panel-heading">Headings</div>-->
                    <!--<div class="panel-body">-->
                    <!--<h1 style="margin-top:0">-->
                    <!--h1. Bootstrap heading <small>Secondary text</small>-->
                    <!--</h1>-->
                    <!--<h2>-->
                    <!--h2. Bootstrap heading <small>Secondary text</small>-->
                    <!--</h2>-->
                    <!--<h3>-->
                    <!--h3. Bootstrap heading <small>Secondary text</small>-->
                    <!--</h3>-->
                    <!--<h4>-->
                    <!--h4. Bootstrap heading <small>Secondary text</small>-->
                    <!--</h4>-->
                    <!--<h5>-->
                    <!--h5. Bootstrap heading <small>Secondary text</small>-->
                    <!--</h5>-->
                    <!--<h6>-->
                    <!--h6. Bootstrap heading <small>Secondary text</small>-->
                    <!--</h6>-->
                    <!--</div>-->
                    <!--</div>-->
                    <!--</div>-->
                    <!--<div class="col-sm-6">-->
                    <!--<div class="panel panel-default">-->
                    <!--<div class="panel-heading">paragraphs</div>-->
                    <!--<div class="panel-body">-->
                    <!--<p> Nullam quis risus eget urna mollis ornare vel eu leo. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nullam id dolor id nibh ultricies vehicula. </p>-->
                    <!--<p> Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec ullamcorper nulla non metus auctor fringilla. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Donec ullamcorper nulla non metus auctor fringilla. </p>-->
                    <!--<p> Maecenas sed diam eget risus varius blandit sit amet non magna. Donec id elit non mi porta gravida at eget metus. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. </p>-->
                    <!--<p> Donec ullamcorper nulla non metus auctor fringilla. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Donec ullamcorper nulla non metus auctor fringilla.</p>-->
                    <!--</div>-->
                    <!--</div>-->
                    <!--</div>-->
                    <!--</div>-->
                    <!--<div class="row cm-fix-height">-->
                    <!--<div class="col-sm-4">-->
                    <!--<div class="panel panel-default">-->
                    <!--<div class="panel-heading">Adresses</div>-->
                    <!--<div class="panel-body">-->
                    <!--<address>-->
                    <!--<strong>Twitter, Inc.</strong>-->
                    <!--<br>-->
                    <!--795 Folsom Ave, Suite 600-->
                    <!--<br>-->
                    <!--San Francisco, CA 94107-->
                    <!--<br>-->
                    <!--<abbr title="Phone">P:</abbr> (123) 456-7890 -->
                    <!--</address>-->
                    <!--<address style="margin:0">-->
                    <!--<strong>Full Name</strong>-->
                    <!--<br>-->
                    <!--<a href="mailto:#">first.last@example.com</a> -->
                    <!--</address>-->
                    <!--</div>-->
                    <!--</div>-->
                    <!--</div>-->
                    <!--<div class="col-sm-4">-->
                    <!--<div class="panel panel-default">-->
                    <!--<div class="panel-heading">Blockquotes</div>-->
                    <!--<div class="panel-body">-->
                    <!--<blockquote style="margin:0">-->
                    <!--<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>-->
                    <!--<footer>Someone famous in <cite title="Source Title">Source Title</cite></footer>-->
                    <!--</blockquote>-->
                    <!--</div>-->
                    <!--</div>-->
                    <!--</div>-->
                    <!--<div class="col-sm-4">-->
                    <!--<div class="panel panel-default">-->
                    <!--<div class="panel-heading">Lists</div>-->
                    <!--<div class="panel-body">-->
                    <!--<ul style="margin:0">-->
                    <!--<li>Facilisis in pretium</li>-->
                    <!--<li>-->
                    <!--Nulla volutpat -->
                    <!--<ul>-->
                    <!--<li>Purus sodales</li>-->
                    <!--<li>Vestibulum</li>-->
                    <!--<li>Ac tristique</li>-->
                    <!--</ul>-->
                    <!--</li>-->
                    <!--<li>Aenean sit amet</li>-->
                    <!--<li>Eget porttitor lorem</li>-->
                    <!--</ul>-->
                    <!--</div>-->
                    <!--</div>-->
                    <!--</div>-->
                    <!--</div>-->
                    <!--<div class="row">-->
                    <!--<div class="col-md-6">-->
                    <!--<div class="panel panel-default">-->
                    <!--<div class="panel-heading">Tables</div>-->
                    <!--<div class="panel-body">-->
                    <!--<table class="table table-bordered table-hover">-->
                    <!--<caption>with <code>.table-bordered</code> and <code>.table-hover</code></caption>-->
                    <!--<thead>-->
                    <!--<tr>-->
                    <!--<th>#</th>-->
                    <!--<th>First Name</th>-->
                    <!--<th>Last Name</th>-->
                    <!--<th>Username</th>-->
                    <!--</tr>-->
                    <!--</thead>-->
                    <!--<tbody>-->
                    <!--<tr>-->
                    <!--<th scope="row">1</th>-->
                    <!--<td>Mark</td>-->
                    <!--<td>Otto</td>-->
                    <!--<td>@mdo</td>-->
                    <!--</tr>-->
                    <!--<tr>-->
                    <!--<th scope="row">2</th>-->
                    <!--<td>Jacob</td>-->
                    <!--<td>Thornton</td>-->
                    <!--<td>@fat</td>-->
                    <!--</tr>-->
                    <!--<tr>-->
                    <!--<th scope="row">3</th>-->
                    <!--<td>Larry</td>-->
                    <!--<td>the Bird</td>-->
                    <!--<td>@twitter</td>-->
                    <!--</tr>-->
                    <!--</tbody>-->
                    <!--</table>-->
                    <!--<table class="table table-hover" style="margin-bottom:0">-->
                    <!--<caption>with <code>.table-hover</code> only</caption>-->
                    <!--<thead>-->
                    <!--<tr>-->
                    <!--<th>#</th>-->
                    <!--<th>First Name</th>-->
                    <!--<th>Last Name</th>-->
                    <!--<th>Username</th>-->
                    <!--</tr>-->
                    <!--</thead>-->
                    <!--<tbody>-->
                    <!--<tr>-->
                    <!--<th scope="row">1</th>-->
                    <!--<td>Mark</td>-->
                    <!--<td>Otto</td>-->
                    <!--<td>@mdo</td>-->
                    <!--</tr>-->
                    <!--<tr>-->
                    <!--<th scope="row">2</th>-->
                    <!--<td>Jacob</td>-->
                    <!--<td>Thornton</td>-->
                    <!--<td>@fat</td>-->
                    <!--</tr>-->
                    <!--<tr>-->
                    <!--<th scope="row">3</th>-->
                    <!--<td>Larry</td>-->
                    <!--<td>the Bird</td>-->
                    <!--<td>@twitter</td>-->
                    <!--</tr>-->
                    <!--</tbody>-->
                    <!--</table>-->
                    <!--</div>-->
                    <!--</div>-->
                    <!--</div>-->
                    <!--<div class="col-md-6">-->
                    <!--<div class="panel panel-default">-->
                    <!--<div class="panel-heading">Tables with contextual classes</div>-->
                    <!--<div class="panel-body">-->
                    <!--<p style="margin-bottom:0">The table is outside the <code>.panel-body</code></p>-->
                    <!--</div>-->
                    <!--<table class="table">-->
                    <!--<thead>-->
                    <!--<tr>-->
                    <!--<th>#</th>-->
                    <!--<th><code>tr</code> classes</th>-->
                    <!--<th>Column heading</th>-->
                    <!--<th>Column heading</th>-->
                    <!--</tr>-->
                    <!--</thead>-->
                    <!--<tbody>-->
                    <!--<tr class="active">-->
                    <!--<th scope="row">1</th>-->
                    <!--<td>active</td>-->
                    <!--<td>Column content</td>-->
                    <!--<td>Column content</td>-->
                    <!--</tr>-->
                    <!--<tr>-->
                    <!--<th scope="row">2</th>-->
                    <!--<td>Column content</td>-->
                    <!--<td>Column content</td>-->
                    <!--<td>Column content</td>-->
                    <!--</tr>-->
                    <!--<tr class="success">-->
                    <!--<th scope="row">3</th>-->
                    <!--<td>success</td>-->
                    <!--<td>Column content</td>-->
                    <!--<td>Column content</td>-->
                    <!--</tr>-->
                    <!--<tr>-->
                    <!--<th scope="row">4</th>-->
                    <!--<td>Column content</td>-->
                    <!--<td>Column content</td>-->
                    <!--<td>Column content</td>-->
                    <!--</tr>-->
                    <!--<tr class="info">-->
                    <!--<th scope="row">5</th>-->
                    <!--<td>info</td>-->
                    <!--<td>Column content</td>-->
                    <!--<td>Column content</td>-->
                    <!--</tr>-->
                    <!--<tr>-->
                    <!--<th scope="row">6</th>-->
                    <!--<td>Column content</td>-->
                    <!--<td>Column content</td>-->
                    <!--<td>Column content</td>-->
                    <!--</tr>-->
                    <!--<tr class="warning">-->
                    <!--<th scope="row">7</th>-->
                    <!--<td>warning</td>-->
                    <!--<td>Column content</td>-->
                    <!--<td>Column content</td>-->
                    <!--</tr>-->
                    <!--<tr>-->
                    <!--<th scope="row">8</th>-->
                    <!--<td>Column content</td>-->
                    <!--<td>Column content</td>-->
                    <!--<td>Column content</td>-->
                    <!--</tr>-->
                    <!--<tr class="danger">-->
                    <!--<th scope="row">9</th>-->
                    <!--<td>danger</td>-->
                    <!--<td>Column content</td>-->
                    <!--<td>Column content</td>-->
                    <!--</tr>-->
                    <!--</tbody>-->
                    <!--</table>-->
                    <!--</div>-->
                    <!--</div>-->
                    <!--</div>-->
                    <!--<div class="alert alert-info alert-dismissible fade in shadowed" role="alert">-->
                    <!--<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>-->
                    <!--<i class="fa fa-fw fa-info-circle"></i> Clearmin uses <a href="http://www.google.com/fonts#ChoosePlace:select/Collection:Roboto">Roboto font</a> by Google Inc. (Apache 2.0) -->
                    <!--</div>-->
                    <!--</div>-->
                    <!--<footer class="cm-footer"><span class="pull-left">Connected as John Smith</span><span class="pull-right">&copy; PAOMEDIA SARL</span></footer>-->
                    <!--</div>-->
                    <!--<script src="assets/js/lib/jquery-2.1.3.min.js"></script>-->
                    <!--<script src="assets/js/jquery.mousewheel.min.js"></script>-->
                    <!--<script src="assets/js/jquery.cookie.min.js"></script>-->
                    <!--<script src="assets/js/fastclick.min.js"></script>-->
                    <!--<script src="assets/js/bootstrap.min.js"></script>-->
                    <!--<script src="assets/js/clearmin.min.js"></script>-->
</body>
</html>