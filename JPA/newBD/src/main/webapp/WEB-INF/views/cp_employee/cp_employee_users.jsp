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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cp_file1.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cp_file2.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cp_file3.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cp_file4.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cp_file5.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cp_file6.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cp_file9.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/wait.js"></script>
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

    function showMenu() {
        $('#overlay_new').toggle();
        $('#new_user').toggle();
    }
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


<!-- Конец вставляемого дива -->



<fieldset class="primary_div_fieldset">

<!-- начало -->

<div class="ui-widget-overlay ui-front" id="overlay_new" style="display:none;"></div>

<!-- Начало вставляемого дива -->
<div id="new_user" class="ui-dialog ui-widget ui-widget-content ui-corner-all ui-front ui-draggable ui-resizable ui-widget-shadow" tabindex="-1" role="dialog" aria-describedby="ftp_user_dialog" aria-labelledby="ui-id-7" style="position: absolute; height: auto; width: 640px; top: 99.5px; left: 360px; display: none;">
    <div class="ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix"><span id="ui-id-7" class="ui-dialog-title">Новый пользователь</span>
        <button class="ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only ui-dialog-titlebar-close" role="button" onclick="showMenu()" aria-disabled="false" title=""><span class="ui-button-icon-primary ui-icon ui-icon-closethick"></span><span class="ui-button-text"></span>
        </button>
    </div>
    <div id="ftp_user_dialog" class="ui-dialog-content ui-widget-content" style="width: auto; min-height: 76px; max-height: none; height: auto;">
        <div class="form-horizontal npp_ftp-dialog_middle">

            <form action="cp_employee_create_user" id="jForm" method="POST" accept-charset="CP1252">
                <div class="js-body info__body">
                    <div>

                        <div style="display:none">
                            <input id="isContract" value=${userExists}>
                        </div>

                        <div class="js-row control-group" id="exceptions" style="display:none">
                            <c:forEach var="exception" items="${exList}">
                                <small>${exception.message}</small>
                            </c:forEach>

                        </div>
                    </div>



                    <div class="js-table form-horizontal support-issue-form">

                        <div class="js-row control-group">
                            <label class="js-caption control-label">Имя:</label>
                            <div class="js-td controls jq-validate-container">
                                <input type="text" id="name" class="js-input big-input" name="name">
                                <span class="error-custom-message" id="error-custom-message-4">Имя должно содержать от 1 до 30 знаков.</span>
                            </div>

                        </div>

                        <div class="js-row control-group">
                            <label class="js-caption control-label">Фамилия:</label>
                            <div class="js-td controls jq-validate-container">
                                <input type="text" id="surname" class="js-input big-input" name="surname">
                                <span class="error-custom-message" id="error-custom-message-5">Фамилия должна содержать от 1 до 30 знаков.</span>
                            </div>
                        </div>

                        <div class="js-row control-group">
                            <label class="js-caption control-label">Дата рождения (дд-мм-гггг):</label>
                            <div class="js-td controls jq-validate-container">
                                <input type="date" id="date" class="js-input big-input" name="birthday">
                                <span class="error-custom-message" id="error-custom-message-6">Пожалуйста, введите дату в указанном формате не раньше 01.01.1900 и не позднее сегодняшнего дня.</span>
                            </div>
                        </div>

                        <div class="js-row control-group">
                            <label class="js-caption control-label">Паспорт:</label>
                            <div class="js-td controls jq-validate-container">
                                <input type="text" class="js-input big-input" name="passport">
                            </div>
                        </div>

                        <div class="js-row control-group">
                            <label class="js-caption control-label">Адрес:</label>
                            <div class="js-td controls jq-validate-container">
                                <input type="text" class="js-input big-input" name="address">
                            </div>
                        </div>

                        <div class="js-row control-group">
                            <label class="js-caption control-label">E-mail:</label>
                            <div class="js-td controls jq-validate-container">
                                <input type="email" class="js-input big-input" name="email">
                            </div>
                        </div>

                        <div class="js-row control-group">
                            <label class="js-caption control-label">Начальный баланс:</label>
                            <div class="js-td controls jq-validate-container">
                                <input type="text" id="balance" class="js-input big-input" name="balance">
                                <span class="error-custom-message" id="error-custom-message-balance">Пожалуйста, введите корректное значение баланса от 0 до 999999 или оставьте поле пустым.</span>
                            </div>
                        </div>

                        <div class="js-row control-group">
                            <label class="js-caption control-label">Логин:</label>
                            <div class="js-td controls jq-validate-container">
                                <input type="text" id="userLogin" class="js-input big-input" name="login">
                                <span class="error-custom-message" id="error-custom-message-7">Логин должен содержать от 2 до 15 знаков.</span>
                                <span class="error-custom-message" id="error-user-exists">Введенный логин уже существует!</span>
                            </div>
                        </div>

                        <div class="js-row control-group">
                            <label class="js-caption control-label">Пароль:</label>
                            <div class="js-td controls jq-validate-container">
                                <input type="password" id="userPassword" class="js-input big-input" name="password">
                                <span class="error-custom-message" id="error-custom-message-8">Пароль должен содержать от 6 до 20 знаков.</span>
                            </div>
                        </div>

                        <table class="ui-table ui-table-hover ui-table-striped" style="width:100%">
                            <tbody>
                            <tr class="ui-table-header">

                                <th class="header_s_checkbox" width="12" align="center">Роль:
                                    <!--<input id="main_checkbox" type="radio">-->
                                </th>
                                <th class="header_s" style="width:150px;" id="table_header_database"></th>
                            </tr>
                            <!--начало элемента таблицы-->
                            <tr name="trow" class="ui-table-data-row ui-state-even ui-selected">
                                <td name="tcell" class="simplecell_checkbox" align="left">
                                    <input type="radio" id="cb" name="cb" value="1">
                                </td>
                                <td class="simplecell" name="tcell" style="vertical-align: top; width: 150px"><span>Клиент</span>
                                    <br>
                                </td>
                            </tr>
                            <tr name="trow" class="ui-table-data-row ui-state-even ui-selected">
                                <td name="tcell" class="simplecell_checkbox" align="left">
                                    <input type="radio" name="cb" value="2">
                                </td>
                                <td class="simplecell" name="tcell" style="vertical-align: top; width: 150px"><span>Администратор</span>
                                    <br>
                                </td>
                            </tr>
                            <!--конец элемента таблицы-->
                            </tbody>
                        </table>

                        <span class="error-custom-message" id="error-custom-message-3">Пожалуйста, выберите одну из ролей.</span>


                        <div class="js-row control-group">
                            <label class="js-caption control-label"></label>

                        </div>
                        <div class="js-row control-group">
                            <label class="js-caption control-label"></label>
                            <div class="js-td controls jq-validate-container">
                                <input type="submit" id="send" value="Создать пользователя" />
                            </div>
                        </div>
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>

<!--  конец -->

<div class="main_caption">
    Опции

</div>
<div class="element" style="display:;">
    <table class="element__table element-main-table">
        <tbody>
        <tr>
            <td class="element__block">

                <div class="info-wrap">
                    <div>
                        <a onclick="showMenu()"><span>Создать нового пользователя</span></a>
                    </div>

                </div>
            </td>

        </tr>
        </tbody>
    </table>
</div>

<h2>Список пользователей</h2>
<div id="list_database">
    <div style="">
        <table class="ui-table ui-table-hover ui-table-striped" style="width:100%">
            <tbody>
            <tr class="ui-table-header">

                <th class="header_s" style="width:100px;" id="table_header_database">Логин</th>
                <th class="header_s" style="width:100px;" id="table_header_database">Баланс</th>
                <th class="header_s" style="width:100px;" id="table_header_type">Фамилия</th>
                <th class="header_s" style="width:100px;" id="table_header_point_access">Имя</th>
                <th class="header_s" style="width:100px;" id="table_header_point">Действия</th>
            </tr>

            <!--начало элемента таблицы-->
            <c:forEach var="user" items="${usersList}">
                <tr name="trow" class="ui-table-data-row ui-state-even ui-selected">

                    <td class="simplecell" name="tcell" style="vertical-align: top; width: 100px"><span>${user.login}</span>
                        <br>
                    </td>
                    <td class="simplecell" name="tcell" style="vertical-align: top; width: 100px;"><span>${user.balance}</span>
                    </td>
                    <td class="simplecell" name="tcell" style="vertical-align: top; width: 100px;"><span>${user.surname}</span>
                    </td>
                    <td class="simplecell" name="tcell" style="vertical-align: top; width: 100px;"><span>${user.name}</span>
                    </td>
                    <td class="simplecell" name="tcell" style="vertical-align: top;">
                        <div class="href_icon">
                            <a href="cp_employee_new_contract?id=${user.id}" onclick="wait()"><span>Создать контракт</span><br> </a>
                            <a href="cp_employee_user_add_balance?id=${user.id}" onclick="wait()"><span>Пополнить баланс</span><br> </a>
                            <a href="cp_employee_user_data_change?id=${user.id}" onclick="wait()"><span>Изменить</span><br> </a>
                            <a href="cp_employee_user_delete?id=${user.id}" onclick="wait()"><span>Удалить</span> </a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            <!--конец элемента таблицы-->





            </tbody>
        </table>
    </div>
</div>

</fieldset>


<div class="clear"></div>




<div id="test"></div>
</div>
</td>
</tr>
</table>
</div>
</body>

</html>