<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1">
    <link rel="stylesheet" type="text/css" href="../assets/css/login.css">
    <link rel="stylesheet" type="text/css" href="../assets/css/roboto.css">
    <link rel="stylesheet" type="text/css" href="../assets/css/font-awesome.min.css">
    <title>K-Mobile</title>
    <style></style>
</head>
<body class="cm-login">

<div class="text-center" style="padding:90px 0 30px 0;background:#fff;border-bottom:1px solid #ddd">
    <img src="../assets/img/logo-big.svg" width="300" height="45">
</div>

<div class="col-sm-6 col-md-4 col-lg-3" style="margin:40px auto; float:none;">
    <form method="post" action="/login">
        <div class="col-xs-12">
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-addon"><i class="fa fa-fw fa-user"></i></div>
                    <input type="email" name="username" class="form-control" placeholder="E-mail">
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-addon"><i class="fa fa-fw fa-lock"></i></div>
                    <input type="password" name="password" class="form-control" placeholder="Password">
                </div>
            </div>
        </div>
        <div class="col-xs-6">
            <div class="checkbox"><label><input type="checkbox"> Remember me</label></div>
        </div>
        <div class="col-xs-6">
            <button type="submit" class="btn btn-block btn-primary">Sign in</button>
        </div>
    </form>
</div>
<br>
<br>
<br>
<br>
<br>
<font color="red">
    <%--<h3 align="center">--%>
        <%--<% if (!LoginServlet.isPreviousDataCorrect)--%>
            <%--out.print("E-mail or password is incorrect. Try again");--%>
        <%--%>--%>
    <%--</h3>--%>
</font>
</body>
</html>
