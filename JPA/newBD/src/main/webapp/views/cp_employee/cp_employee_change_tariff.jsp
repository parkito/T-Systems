
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
</script>


<div class="header"><div style="width:902px;"><div><table border="0" cellspacing="0" cellpadding="0" class="wrap-table" style="width:900px;">
    <tr><td>

        <img src='/images/ajax-loader.gif' style='display:none'>

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

            <form action="cp_employee_tariff_final_change" id="jForm" method="POST" accept-charset="CP1252">
                <div class="js-body info__body">
                    <h2 class="js-h">Изменение тарифа</h2><div>
                    <div class="js-table form-horizontal support-issue-form">

                        <div class="js-row control-group">
                            <label class="js-caption control-label">Название тарифа:</label>
                            <div class="js-td controls jq-validate-container">
                                <input type="text" id="name" name= "name" class="js-input big-input" value="${tariffOption.name}">
                                <span class="error-custom-message" id="error-custom-message-4">Название тарифа должно содержать от 1 до 30 символов.</span>

                            </div>
                        </div>
                        <div class="js-row control-group">
                            <label class="js-caption control-label">Ежемесячная цена (в рублях):</label>
                            <div class="js-td controls jq-validate-container" >

                                <input type="text" id="price" name="price" class="js-input big-input" value="${tariffOption.price}">
                                <span class="error-custom-message" id="error-custom-message-5">Пожалуйста, введите корректное значение цены от 0 до 999999.</span>

                            </div>
                        </div>

                        <div class="js-row control-group" style="display:none;">
                             <label class="js-caption control-label">Id тарифа:</label>
                              <div class="js-td controls jq-validate-container">

                               <input type="text" name="id" value=${id}>
                                </div>
                        </div>

                        <h2 class="js-h">Выберите опции, которые будут совместимы с тарифом</h2><div>



                        <div id="list_database">
                            <div style="">
                                <table class="ui-table ui-table-hover ui-table-striped" style="width:100%"><tbody>
                                <tr class="ui-table-header">

                                    <th class="header_s_checkbox" width="12" align="center"><!--<input id="main_checkbox"></th> -- type="checkbox" checked="checked" -->
                                    <th class="header_s" style="width:150px;" id="table_header_database">Опция</th>
                                    <th class="header_s" style="width:100px;" id="table_header_type">Цена</th>
                                    <th class="header_s" style="width:100px;" id="table_header_point_access">Цена подключения</th>
                                </tr>

                                <!--начало элемента таблицы-->
                                <!--текущие опции-->

                                <c:forEach var="option" items="${currentOptionsList}">
                                  <tr name="trow" class="ui-table-data-row ui-state-even ui-selected">
                                        <td name="tcell" class="simplecell_checkbox" align="left"><input type="checkbox" checked="checked" name="cb" value=${option.id}></td>
                                        <td class="simplecell" name="tcell" style="vertical-align: top; width: 150px"><span>${option.name}</span><br></td>
                                        <td class="simplecell" name="tcell" style="vertical-align: top; width: 100px;"><span>${option.price}</span></td>
                                         <td class="simplecell" name="tcell" style="vertical-align: top; width: 100px;"><span>${option.initialPrice}</span></td>

                                   </tr>
                                </c:forEach>

                                 <!--остальные опции-->
                                <c:forEach var="option" items="${allOptionsList}">
                                     <tr name="trow" class="ui-table-data-row ui-state-even ui-selected">
                                     <td name="tcell" class="simplecell_checkbox" align="left"><input type="checkbox" name="cb" value=${option.id}></td>
                                     <td class="simplecell" name="tcell" style="vertical-align: top; width: 150px"><span>${option.name}</span><br></td>
                                     <td class="simplecell" name="tcell" style="vertical-align: top; width: 100px;"><span>${option.price}</span></td>
                                     <td class="simplecell" name="tcell" style="vertical-align: top; width: 100px;"><span>${option.initialPrice}</span></td>

                                      </tr>
                                 </c:forEach>
                                <!--конец элемента таблицы-->


                                </tbody>
                                </table></div></div><div class="js-row control-group">
                            <label class="js-caption control-label"></label>

                        </div><div class="js-row control-group">
                        <label class="js-caption control-label"></label>
                        <div class="js-td controls jq-validate-container">
                            <input type="submit" id="send" value="Изменить тариф" />
                        </div>
                    </div></div>
                </div></div>
                    </div>
            </form>

            <div class="clear"></div>



            <div id="test"></div>
        </div>
    </td></tr>
</table>
</div>



</body>
</html>
