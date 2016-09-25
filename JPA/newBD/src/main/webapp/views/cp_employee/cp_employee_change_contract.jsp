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
    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/ajax.js"></script>

</head>

<body class="locale-ru_RU">
<div class="lang-place" style="display:none;">
    <a href="?change_lang=ru">ru</a>
    <a href="?change_lang=en">en</a>
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
<div id="vds-overlay" style="display: none;"></div>
<div id="vds-wait" style="display: none;">
    <div id="loader" class="loader-32 fl"></div>
    <div class="caption-wrap border-l">
        <div id="caption">
            Пожалуйста, подождите
        </div>
    </div>
</div>


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



                    <form action="cp_employee_contract_changed" id="jForm" method="POST" accept-charset="CP1252">
                        <div class="js-body info__body">
                            <h2 class="js-h">Изменение контракта с номером ${number} для пользователя ${login}</h2>
                            <div>

                                <div class="js-table form-horizontal support-issue-form">


                                    <h2 class="js-h" id="tariffOption-header">Выберите тариф для контракта </h2>
                                    <small id="tariffOption-helper">После выбора тарифа к нему можно будет подключить опции.</small>

                                    <span class="error-custom-message" id="error-custom-message-3">Пожалуйста, выберите один из тарифов.</span>
                                    <div>
                                        <div style="display:none">
                                            <input id="isContract" value=${userExists}>
                                            <input id="number" value="${number}">
                                        </div>




                                        <div id="list_database">
                                            <div style="">
                                                <table class="ui-table ui-table-hover ui-table-striped" style="width:100%"><tbody>
                                                <tr class="ui-table-header">

                                                    <th class="header_s_checkbox" width="12" align="center"><!--<input id="main_checkbox" type="radio">--></th>
                                                    <th class="header_s" style="width:150px;" id="table_header_database">Тариф</th>
                                                    <th class="header_s" style="width:100px;" id="table_header_type">Цена</th>
                                                </tr>

                                                <!--начало элемента таблицы-->
                                                <c:forEach var="tariffOption" items="${tariffsList}">
                                                    <tr name="trow" class="ui-table-data-row ui-state-even ui-selected">

                                                        <td name="tcell" class="simplecell_checkbox" align="left">
                                                            <input type="radio" id = "cb" name="cb" onchange="getOptions ('${tariffOption.id}','${tariffOption.name}');" value=${tariffOption.id}>
                                                        </td>
                                                        <td class="simplecell" name="tcell" style="vertical-align: top; width: 150px"><span>${tariffOption.name}</span><br></td>
                                                        <td class="simplecell" name="tcell" style="vertical-align: top; width: 100px;"><span>${tariffOption.price}</span></td>

                                                    </tr>
                                                </c:forEach>
                                                <!--конец элемента таблицы-->
                                                </tbody>
                                                </table></div></div>

                                        <div id="list_database2" style="display: none;">
                                            <h2 class="js-h" id="optionsForTariff"></h2>
                                            <small>Щелкните по опции для просмотра необходимых и несовместимых с ней опций.</small>
                                            <div class="js-row control-group" id="exceptions23" style="display:none">
                                                <span class="error-custom-message-incorrect">В процессе выбора опций произошли ошибки!</span><div id="exMessages">
                                                <c:forEach var="ex" items="${exceptionsList}">
                                                    <span class="error-custom-message-incorrect">${ex.message}</span>
                                                </c:forEach>
                                            </div>
                                            </div>

                                            <div style="">
                                                <table class="ui-table ui-table-hover ui-table-striped" id="optionTable" style="width:100%">
                                                    <tbody>

                                                    <tr class="ui-table-header" id="options-header">

                                                        <th class="header_s_checkbox" width="12" align="center"></th>
                                                        <th class="header_s" style="width:150px;" id="table_header_database">Опция</th>
                                                        <th class="header_s" style="width:100px;" id="table_header_type">Цена</th>
                                                        <th class="header_s" style="width:100px;" id="table_header_point_access">Цена подключения</th>
                                                    </tr>

                                                    <!--начало элемента таблицы-->


                                                    <!--конец элемента таблицы-->
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>


                                        <div class="js-row control-group">
                                            <label class="js-caption control-label"></label>

                                        </div><div class="js-row control-group">
                                        <label class="js-caption control-label"></label>
                                        <div class="js-td controls jq-validate-container">
                                            <input type="submit" id="send" value="Подтвердить" />
                                            <input type="button" style="display: none;" id="backToTariffButton" value="Назад к выбору тарифа" onclick="backToTariff()"/>

                                        </div>
                                    </div>
                                    </div>
                                </div>
                            </div>
                    </form>



                    <div class="primary_div npp_index">
                        <div class="js-table form-horizontal support-issue-form" id="bigOptionDiv" style="display: none;">
                            <h2 class="js-h">Необходимые опции</h2>
                            <div>
                                <div id="list_database3">
                                    <div style="">
                                        <table class="ui-table ui-table-hover ui-table-striped" id="optionTogetherTable" style="width:100%">
                                            <tbody>
                                            <tr class="ui-table-header">


                                                <th class="header_s" style="width:150px;" id="table_header_database">Опция</th>
                                                <th class="header_s" style="width:100px;" id="table_header_type">Цена</th>
                                                <th class="header_s" style="width:100px;" id="table_header_point_access">Цена подключения</th>
                                            </tr>

                                            <!--начало элемента таблицы-->



                                            <!--конец элемента таблицы-->
                                            </tbody>
                                        </table>
                                    </div>
                                </div>


                                <div class="js-row control-group">
                                    <label class="js-caption control-label"></label>

                                </div>
                                <div class="js-row control-group">
                                    <label class="js-caption control-label"></label>

                                </div>
                            </div>

                            <h2 class="js-h">Несовместимые опции</h2>
                            <div>

                                <div id="list_database4">
                                    <div style="">
                                        <table class="ui-table ui-table-hover ui-table-striped" id="optionIncompatibleTable" style="width:100%">
                                            <tbody>
                                            <tr class="ui-table-header">


                                                <th class="header_s" style="width:150px;" id="table_header_database">Опция</th>
                                                <th class="header_s" style="width:100px;" id="table_header_type">Цена</th>
                                                <th class="header_s" style="width:100px;" id="table_header_point_access">Цена подключения</th>
                                            </tr>

                                            <!--начало элемента таблицы-->


                                            <!--конец элемента таблицы-->
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="clear"></div>

                    <div id="test"></div>
                </div>
            </td>
        </tr>
    </table>
</div>



</body>

</html>