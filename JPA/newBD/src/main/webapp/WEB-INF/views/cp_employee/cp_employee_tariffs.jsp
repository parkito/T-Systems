
<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=8,9,10" >
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Панель управления аккаунтом.</title>
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon"/>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cp_file1.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cp_file2.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cp_file3.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cp_file4.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cp_file5.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cp_file6.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cp_file9.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/validate.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/wait.js"></script>
</head>
<body class="locale-ru_RU">
<div class="lang-place" style="display:none;"><a href="?change_lang=ru">ru</a><a href="?change_lang=en">en</a><a href="?change_lang=de">de</a></div>
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

<div class="header"><div style="width:902px;"><div><table border="0" cellspacing="0" cellpadding="0" class="wrap-table" style="width:900px;">
    <tr><td>


        <div class="main-header">
            <div class="inner-wrap">
                <div class="logotype"  onclick="redirect()">
                </div>
                <div class="nav-wrap">
                    <ul class="nav">
                        <li><a href="cp_employee_profile">Профиль</a></li>
                        <!--<li class="last-child"><a href="mailto:herman.urikh@aengel.ru">Служба поддержки</a></li>-->
                    </ul>
                </div>
            </div>
            <div class="right">
                <div class="account-selector dobble">
                    <div class="main">
                        <div class="info">
                            <!--<a id="avatar_thumb" href="/info" class="avatar no-avatar thumbnail-small"></a>-->
                            <div class="username">${currentUserU.login}<span class="shad">&nbsp;</span></div>

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
                    </div
                            ><div class="triangle"><div></div>
                </div>
                </div>
            </div>
        </div>


    </td></tr></table></div></div></div>
<div class="middle"><table border="0" cellspacing="0" cellpadding="0" class="wrap-table" style="width:900px;"><tr><td class="content np_menu">
    <div id="np_menu_id"  class="wrap-for-hover">

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
        <div><a class="js-return-to-old return-to-old ui-corner-all ui-button-text-only" href="${logoutAction}"><i class="icon-back-arrow"></i><span>Выход из аккаунта</span></a></div>
        &nbsp;</div></td><!--np_menu-->
    <td class="np_content">



        <div class="primary_div npp_index">





            <fieldset class="primary_div_fieldset">

                <div class="ui-widget-overlay ui-front" id="overlay_new" style="display:none;"></div>

                <!-- Начало вставляемого дива -->
                <div id="new_user" class="ui-dialog ui-widget ui-widget-content ui-corner-all ui-front ui-draggable ui-resizable ui-widget-shadow" tabindex="-1" role="dialog" aria-describedby="ftp_user_dialog" aria-labelledby="ui-id-7" style="position: absolute; height: auto; width: 640px; top: 99.5px; left: 360px; display: none;">
                    <div class="ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix"><span id="ui-id-7" class="ui-dialog-title">Новый тариф</span>
                        <button class="ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only ui-dialog-titlebar-close" role="button" onclick="showMenu()" aria-disabled="false" title=""><span class="ui-button-icon-primary ui-icon ui-icon-closethick"></span><span class="ui-button-text"></span>
                        </button>
                    </div>
                    <div id="ftp_user_dialog" class="ui-dialog-content ui-widget-content" style="width: auto; min-height: 76px; max-height: none; height: auto;">
                        <div class="form-horizontal npp_ftp-dialog_middle">

                            <form name="myForm" action="cp_employee_create_tariff" id="jForm" method="POST" accept-charset="CP1252">
                                <div class="js-body info__body">
                                    <div class="js-table form-horizontal support-issue-form">

                                        <div class="js-row control-group">
                                            <label class="js-caption control-label">Название тарифа:</label>
                                            <div class="js-td controls jq-validate-container">
                                                <input type="text" id="name" class="js-input big-input" name="name">
                                                <span class="error-custom-message" id="error-custom-message-4">Название тарифа должно содержать от 1 до 30 символов.</span>


                                            </div>
                                        </div>
                                        <div class="js-row control-group">
                                            <label class="js-caption control-label">Ежемесячная цена (в рублях):</label>
                                            <div class="js-td controls jq-validate-container">
                                                <input type="text" id="price" class="js-input big-input" name = "price">
                                                <span class="error-custom-message" id="error-custom-message-5">Пожалуйста, введите корректное значение цены от 0 до 999999.</span>
                                            </div>
                                        </div>

                                        <h2 class="js-h">Выберите опции, которые будут совместимы с тарифом</h2><div>



                                        <div id="list_database">
                                            <div style="">
                                                <table class="ui-table ui-table-hover ui-table-striped" style="width:100%"><tbody>
                                                <tr class="ui-table-header">

                                                    <th class="header_s_checkbox" width="12" align="center"><!--<input id="main_checkbox" type="checkbox" checked="checked">--></th>
                                                    <th class="header_s" style="width:150px;" id="table_header_database">Опция</th>
                                                    <th class="header_s" style="width:100px;" id="table_header_type">Цена</th>
                                                    <th class="header_s" style="width:100px;" id="table_header_point_access">Цена подключения</th>
                                                </tr>

                                                <!--начало элемента таблицы-->
                                                <c:forEach var="option" items="${optionsList}">
                                                    <tr name="trow" class="ui-table-data-row ui-state-even ui-selected">

                                                        <td name="tcell" class="simplecell_checkbox" align="left"><input type="checkbox" checked="checked" name="cb" value=${option.id}></td>
                                                        <td class="simplecell" name="tcell" style="vertical-align: top; width: 150px"><span>${option.name}</span><br></td>
                                                        <td class="simplecell" name="tcell" style="vertical-align: top; width: 100px;"><span>${option.price}</span></td>
                                                        <td class="simplecell" name="tcell" style="vertical-align: top; width: 100px;"><span>${option.initialPrice}</span></td>

                                                    </tr>
                                                </c:forEach>
                                                <!--конец элемента таблицы-->
                                                </tbody>
                                                </table></div></div>


                                        <div class="js-row control-group">
                                            <label class="js-caption control-label"></label>

                                        </div><div class="js-row control-group">
                                        <label class="js-caption control-label"></label>
                                        <div class="js-td controls jq-validate-container">
                                            <input type="submit" id="send" value="Создать тариф" />
                                        </div>
                                    </div></div>
                                    </div></div>
                            </form>
                        </div>
                    </div>
                </div>






                <div class="main_caption">
                    Тарифы

                </div>
                <div class="element" style="display:block;">
                    <table class="element__table element-main-table">
                        <tbody>
                        <tr>
                            <td class="element__block">

                                <div class="info-wrap">
                                    <div>
                                        <a onclick="showMenu()"><span>Создание нового тарифа</span></a>
                                    </div>

                                </div>
                            </td>

                        </tr>
                        </tbody>
                    </table>
                </div>

                <h2>Список существующих тарифов</h2>
                <div id="list_database">
                    <div style="">
                        <table class="ui-table ui-table-hover ui-table-striped" style="width:100%"><tbody>
                        <tr class="ui-table-header">

                            <th class="header_s" style="width:150px;" id="table_header_database">Тариф</th>
                            <th class="header_s" style="width:100px;" id="table_header_type">Цена</th>
                            <th class="header_s" style="width:100px;" id="table_header_point">Действия</th>
                        </tr>

                        <!--начало элемента таблицы-->
                        <c:forEach var="tariffOption" items="${tariffsList}">
                            <tr name="trow" class="ui-table-data-row ui-state-even ui-selected">

                                <td class="simplecell" name="tcell" style="vertical-align: top; width: 150px"><span>${tariffOption.name}</span><br></td>
                                <td class="simplecell" name="tcell" style="vertical-align: top; width: 100px;"><span>${tariffOption.price}</span></td>
                                <td class="simplecell" name="tcell" style="vertical-align: top;">
                                    <div class="href_icon">
                                        <a href="cp_employee_change_tariff?id=${tariffOption.id}" onclick="wait()"><span>Изменить</span><br> </a>
                                        <a href="cp_employee_delete_tariff?id=${tariffOption.id}" onclick="wait()"><span>Удалить</span> </a>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                        <!--конец элемента таблицы-->






                        </tbody>
                        </table></div></div>

            </fieldset>

            <div class="clear"></div>




            <div id="test"></div>
        </div>
    </td></tr>
</table>
</div>
</body>
</html>
