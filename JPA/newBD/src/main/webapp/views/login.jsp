<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login_file1.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login_file2.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/form_script_1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/form_script_2.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery.js"></script>
    <title>Личный кабинет - авторизация</title>
    <meta charset="utf-8" />
</head>

<body class="locale-ru_RU">
<script>
    $(document).ready(function()
    {
    if (document.getElementById('isInputValid').value == "false") {
    var o = document.getElementById('alert-error');
    o.style.display = 'block';
    }
    });
    </script>

<div class="l_login_container">
    <div class="l_login_wrap">
        <div class="l_login">
            <div class="error-alert" id="alert-error" style="display:none">
                <div><span class="error-alert-message">Логин или пароль указаны неверно. Попробуйте еще раз.</span>
                </div>
            </div>
            <div id="isValid" style="display:none">
                <input id="isInputValid" value=${isInputValid}>

            </div>
            <div class="b_secondary-menu js-forms-cont">
                <c:url var="loginUrl" value="/j_spring_security_check"></c:url>
                <!--<form class="cp_loginscreen-form" action="login-check-data" method="post">-->
                <form class="cp_loginscreen-form" action="${loginUrl}" method="post">
                    <div class="b_input_wrap">
                        <label for="panel-login" class="b_input_text_placeholder" style="display:none">Имя пользователя</label>
                        <input id="panel-login" class="b_input_text" name="username" size="30" value="" type="text" />
                    </div>
                    <div class="b_input_wrap">
                        <label for="panel-password" class="b_input_text_placeholder" style="display:none">Пароль</label>
                        <input id="panel-password" class="b_input_text" name="password" size="30" type="password" />
                    </div>
                    <div class="js-restore-block" style="display:block">
                        <!--<a class="b_link b_link-restore" href="#">Восстановить пароль</a>-->
                        <label class="b_checkbox_wrap">
                            <input class="b_checkbox" name="remember-me" type="checkbox" />
                            <i class="b_checkbox_icon"></i> Запомнить меня
                        </label>
                    </div>
                    <button type="submit" class="b_submit_button_1">Войти</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>

</html>