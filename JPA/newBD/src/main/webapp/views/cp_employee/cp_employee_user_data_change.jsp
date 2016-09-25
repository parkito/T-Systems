<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<head>
    <meta http-equiv="X-UA-Compatible" content="IE=8,9,10">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Панель управления аккаунтом.</title>
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cp_file1.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cp_file2.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cp_file3.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cp_file4.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cp_file5.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cp_file6.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cp_file9.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/validate.js"></script>
</head>

<body class="locale-ru_RU">
<div class="lang-place" style="display:none;"><a href="?change_lang=ru">ru</a><a href="?change_lang=en">en</a><a href="?change_lang=de">de</a>
</div>
<div id="vds-overlay" style="display: none;"></div>
<div id="vds-wait" style="display: none;">
    <div id="loader" class="loader-32 fl"></div>
    <div class="caption-wrap border-l">
        <div id="caption">
            Пожалуйста, подождите
        </div>
    </div>
</div>

<script type="text/javascript">
    function redirect() {
        location.href = "cp_employee_main";
    }
</script>

<script>
    $(document).ready(function() {
        if (document.getElementById('isContract').value == "true") {
            var o = document.getElementById('exceptions');
            o.style.display = 'block';
        }
    });
</script>

<div class="header">
    <div style="width:902px;">
        <div>
            <table border="0" cellspacing="0" cellpadding="0" class="wrap-table" style="width:900px;">
                <tr>
                    <td>

                        <img src='/images/ajax-loader.gif' style='display:none'>

                        <div class="main-header">
                            <div class="inner-wrap">
                                <div class="logotype" onclick="redirect()">
                                </div>
                                <div class="nav-wrap">
                                    <ul class="nav">
                                        <li><a href="cp_employee_profile">Профиль</a>
                                        </li>
                                        <!--<li class="last-child"><a href="mailto:herman.urikh@aengel.ru">Служба поддержки</a></li>-->
                                    </ul>
                                </div>
                            </div>
                            <div class="right">
                                <div style="display:none">
                                    <input id="isContract" value=${userExists}>
                                </div>
                                <div class="account-selector dobble">
                                    <div class="main">
                                        <div class="info">
                                            <!--<a id="avatar_thumb" href="/info" class="avatar no-avatar thumbnail-small"></a>-->
                                            <div class="username">${currentUserU.login}<span class="shad">&nbsp;</span>
                                            </div>

                                        </div>
                                        <div class="slide-down" style="display:none;">
                                            <div style="display:block;">
                                                <ul></ul>
                                                <div class="buttons-wrap">
                                                    <a href="/info/" class="account-add link">
                                                        <span>Профиль аккаунта</span>
                                                    </a>
                                                    <a href="/logout/" class="exit link">
                                                        <span>Выход</span>
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="triangle">
                                        <div></div>
                                    </div>
                                </div>


                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
<div class="middle">
    <table border="0" cellspacing="0" cellpadding="0" class="wrap-table" style="width:900px;">
        <tr>
            <td class="content np_menu">
                <div id="np_menu_id" class="wrap-for-hover">

                    <a href="cp_employee_contracts" class="main-menu-item">
                        <i class="np_icon logmanager"></i>
                        <span class="href_line">Контракты</span>
                    </a>

                    <a href="cp_employee_users" class="main-menu-item">
                        <i class="np_icon managers"></i>
                        <span class="href_line">Пользователи</span>
                    </a>
                    <a href="cp_employee_user_search" class="main-menu-item">
                        <i class="np_icon domains"></i>
                        <span class="href_line">Поиск пользователя</span>
                    </a>

                    <a href="cp_employee_tariffs" class="main-menu-item">
                        <i class="np_icon tariffOption"></i>
                        <span class="href_line">Тарифы</span>
                    </a>

                    <a href="cp_employee_options" class="main-menu-item">
                        <i class="np_icon mysql"></i>
                        <span class="href_line">Опции</span>
                    </a>

                    <div class="np_menu-line"></div>
                    <c:url var="logoutAction" value="/j_spring_security_logout"></c:url>
                    <div><a class="js-return-to-old return-to-old ui-corner-all ui-button-text-only" href="${logoutAction}"><i class="icon-back-arrow"></i><span>Выход из аккаунта</span></a>
                    </div>
                    &nbsp;</div>
            </td>
            <!--np_menu-->
            <td class="np_content">



                <div class="primary_div npp_index">

                    <div style="display:none;">
                        <div id="template_HotActionsDialog">
                            <div class="form-horizontal npp_index-hot_actions_dialog">
                                <div class="control-group">
                                    <table class="ui-table ui-table-striped ui-table-expanded dialog" id="tabl">
                                    </table>
                                </div>

                                <div class="form-actions">
                                    <button class="btn" id="save_button">Сохранить настройки</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <form name="MyForm" action="cp_employee_change_user" id="jForm" method="POST" accept-charset="CP1252">
                        <div class="js-body info__body">
                            <h2 class="js-h">Изменение пользователя</h2>
                            <div>
                                <div class="js-row control-group" id="exceptions" style="display:none">
                                    <c:forEach var="exception" items="${exList}">
                                    <small>${exception.message}<small><div>
                                        </c:forEach>

                                    </div>
                                </div>
                                <div class="js-table form-horizontal support-issue-form">

                                    <div class="js-row control-group">
                                        <label class="js-caption control-label">Имя:</label>
                                        <div class="js-td controls jq-validate-container">
                                            <input type="text" id="name" class="js-input big-input" name="name" value="${name}">
                                            <span class="error-custom-message" id="error-custom-message-4">Имя должно содержать от 1 до 30 знаков.</span>

                                        </div>
                                    </div>

                                    <div class="js-row control-group">
                                        <label class="js-caption control-label">Фамилия:</label>
                                        <div class="js-td controls jq-validate-container">
                                            <input type="text" id="surname" class="js-input big-input" name = "surname" value="${surname}">
                                            <span class="error-custom-message" id="error-custom-message-5">Фамилия должна содержать от 1 до 30 знаков.</span>

                                        </div>
                                    </div>

                                    <div class="js-row control-group">
                                        <label class="js-caption control-label">Дата рождения (дд.мм.гггг):</label>
                                        <div class="js-td controls jq-validate-container">
                                            <input type="date" id="date" class="js-input big-input" name="birthday" value=${birthday}>
                                            <span class="error-custom-message" id="error-custom-message-6">Пожалуйста, введите дату в указанном формате не раньше 01.01.1900 и не позднее сегодняшнего дня.</span>

                                        </div>
                                    </div>

                                    <div class="js-row control-group">
                                        <label class="js-caption control-label">Паспорт:</label>
                                        <div class="js-td controls jq-validate-container">
                                            <input type="text" class="js-input big-input" name="passport" value="${passport}">
                                        </div>
                                    </div>

                                    <div class="js-row control-group">
                                        <label class="js-caption control-label">Адрес:</label>
                                        <div class="js-td controls jq-validate-container">
                                            <input type="text" class="js-input big-input" name="address" value="${address}">
                                        </div>
                                    </div>
                                    <div class="js-row control-group" style="display:none;">
                                        <label class="js-caption control-label">Логин:</label>
                                        <div class="js-td controls jq-validate-container">
                                            <input type="text" class="js-input big-input" name="login" value="${login}">
                                        </div>
                                    </div>

                                    <div class="js-row control-group" style="display:none;">
                                        <label class="js-caption control-label">Id:</label>
                                        <div class="js-td controls jq-validate-container">
                                            <input type="text" class="js-input big-input" name="id" value=${id}>
                                        </div>
                                    </div>

                                    <div class="js-row control-group">
                                        <label class="js-caption control-label">E-mail:</label>
                                        <div class="js-td controls jq-validate-container">
                                            <input type="email" class="js-input big-input" name="email" value="${email}">
                                        </div>
                                    </div>

                                    <div class="js-row control-group">
                                        <label class="js-caption control-label">Баланс:</label>
                                        <div class="js-td controls jq-validate-container">
                                            <input type="number" id="balance" class="js-input big-input" name="balance" value="${balance}">
                                            <span class="error-custom-message" id="error-custom-message-balance">Пожалуйста, введите корректное значение баланса от 0 до 999999 или оставьте поле пустым.</span>

                                        </div>
                                    </div>

                                    <div class="js-row control-group">
                                        <label class="js-caption control-label">Пароль:</label>
                                        <div class="js-td controls jq-validate-container">
                                            <input type="password" id="userPassword" class="js-input big-input" name="password">
                                            <span class="error-custom-message" id="error-custom-message-8">Пароль должен содержать от 6 до 20 знаков.</span>

                                        </div>
                                    </div>


                                    <div class="js-row control-group">
                                        <label class="js-caption control-label"></label>

                                    </div><div class="js-row control-group">
                                    <label class="js-caption control-label"></label>
                                    <div class="js-td controls jq-validate-container">
                                        <input type="submit" id="send" value="Изменить пользователя" />
                                    </div>
                                </div></div>
                            </div></div>
                    </form>

                    <div class="clear"></div>




                    <div id="test"></div>
                </div>
            </td></tr>
    </table>
</div>



</body>
</html>