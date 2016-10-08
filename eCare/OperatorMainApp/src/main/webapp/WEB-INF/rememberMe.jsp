<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <form method="post" action="/rememberMe">
        <div class="col-xs-12">
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-addon"><i class="fa fa-fw fa-user"></i></div>
                    <input type="email" name="email" class="form-control" placeholder="E-mail">
                </div>
                <br>
                <button type="submit" class="btn btn-block btn-purple">Remind password</button>
            </div>
        </div>
    </form>

</div>
<br>
<br>
<br>
<br>
<br>

<c:if test="${remindCheck!=null}">
    <c:if test="${userData==false}">
        <font color="red">
            <h3 align="center">
                User doesn't exist. Try again!
            </h3>
        </font>

    </c:if>
    <c:if test="${userData==true}">
        <font color="#adff2f">
            <h3 align="center">
                Password sent on your e-mail
            </h3>
        </font>

    </c:if>
</c:if>
</body>
</html>
