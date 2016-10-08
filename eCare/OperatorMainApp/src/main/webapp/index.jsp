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
    <c:url var="loginUrl" value="/login"/>
    <form method="post" action="${loginUrl}">
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
            <div class="checkbox"><label><input type="checkbox" name="remember-me-param"> Remember me</label>
            </div>
        </div>
        <div class="col-xs-6">
            <button type="submit" class="btn btn-block btn-primary">Sign in</button>
        </div>
        <input type="hidden" name="<c:out value="${_csrf.parameterName}"/>"
               value="<c:out value="${_csrf.token}"/>"/>
    </form>
    <br>

    <form method="GET" action="/rememberMe">
        <button type="submit" class="btn btn-block">Forgot password</button>
    </form>
</div>
<br>
<br>
<br>
<br>
<br>
<font color="red">
    <c:if test="${userData!=null}">
        <c:if test="${userData==false}">
            <h3 align="center">
                E-mail or password is incorrect. Try again
            </h3>
        </c:if>
    </c:if>
</font>
</body>
</html>
