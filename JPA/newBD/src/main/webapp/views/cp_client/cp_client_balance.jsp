<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=8,9,10" >
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>${language.JSP_PANEL_NAME}.</title>
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
    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/lang.js"></script>
</head>
<body class="locale-ru_RU">
<div class="lang-place" style="display:block;"><a onclick="changeRus()">ru</a><a onclick="changeEng()">en</a></div>

<div id="vds-overlay" style="display: none;"></div>
<div id="vds-wait" style="display: none;">
    <div id="loader" class="loader-32 fl"></div>
    <div class="caption-wrap border-l">
        <div id="caption">
            ${language.JSP_PLEASE_WAIT}
        </div>
    </div>
</div>
<script type="text/javascript">
    function redirect() {
    location.href = "cp_client_main";
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
                        <li><a href="cp_client_profile">${language.JSP_PROFILE_NAME}</a></li>
                        <li class="last-child"><a href="mailto:herman.urikh@aengel.ru">${language.JSP_SUPPORT_NAME}</a></li>
                    </ul>
                </div>
            </div>
            <div class="right">
                <div class="account-selector dobble">
                    <div class="main">
                        <div class="info">
                            <!--<a id="avatar_thumb" href="/info" class="avatar no-avatar thumbnail-small"></a>-->
                            <div class="username">${currentUserU.login}<span class="shad">&nbsp;</span></div>
                            <div class="user-balance">${currentUserU.balance} ${language.JSP_BALANCE_CURRENCY}</div>
                        </div>
                        <div class="slide-down" style="display:none;">
                            <div style="display:block;">
                                <ul></ul>
                                <div class="buttons-wrap">
                                    <a href="cp_client_profile" class="account-add link">
                                        <span>${language.JSP_PROFILE_NAME}</span>
                                    </a>
                                    <a href="/j_spring_security_logout" class="exit link">
                                        <span>${language.JSP_LOGOUT_NAME}</span>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div
                            ><div class="triangle"><div></div>
                </div>
                </div>


    </td></tr></table></div></div></div>
<div class="middle"><table border="0" cellspacing="0" cellpadding="0" class="wrap-table" style="width:900px;"><tr><td class="content np_menu">
    <div id="np_menu_id"  class="wrap-for-hover">

        <a href="cp_client_contracts" class="main-menu-item">
            <i class="np_icon documents"></i>
            <span class="href_line">${language.JSP_CONTRACTS_NAME}</span>
        </a>

        <a href="cp_client_balance" class="main-menu-item">
            <i class="np_icon balance"></i>
            <span class="href_line">${language.JSP_BALANCE_NAME}</span>
        </a>

        <a href="cp_client_profile" class="main-menu-item">
            <i class="np_icon crontab"></i>
            <span class="href_line">${language.JSP_INFO_NAME}</span>
        </a>

        <div class="np_menu-line"></div>
        <c:url var="logoutAction" value="/j_spring_security_logout"></c:url>
        <div><a class="js-return-to-old return-to-old ui-corner-all ui-button-text-only" href="${logoutAction}"><i class="icon-back-arrow"></i><span>${language.JSP_LOGOUT_NAME}</span></a></div>
        &nbsp;</div></td><!--np_menu-->
    <td class="np_content">
        <div class="primary_div npp_index">



            <div class="npp_balance_header element">
            			<table class="element__table element-main-table">
            				<tbody><tr>
            					<td id="npp_balance_state-actions" class="element__block">
            						<a href="cp_client_increase_balance" class="link-unstyle link-color-parent">
            							<table class="element__table">
            								<tbody><tr>
            									<td class="element__td-img"><img src="${pageContext.request.contextPath}/images/balance-pay.png"></td>
            									<td class="element__simple">
            										<div>
            											<div class="npp_balance_state-block state_default" style="display: block;">
            												<span class="link" onclick="wait()">${language.JSP_BALANCE_PAY}</span>
            												<div class="npp_balance_state-desc small-text">${language.JSP_BALANCE_INCREASE_BALANCE}</div>
            											</div>
            										</div>


            									</td>
            								</tr>
            							</tbody></table>
            						</a>
            					</td>
            					<td class="element__vline">&nbsp;</td>
            					<td class="element__vline-right"></td>
            					<td id="npp_balance_state-desc" class="element__block">

            						<div class="npp_balance_state-block state_suspended" style="display: block;">
            							<div class="npp_balance_state-title small-text important-text">${language.JSP_BALANCE_CURRENT}</div>
            							<h3 class="npp_balance_state-desc important-text">${currentUserU.balance} ${language.JSP_BALANCE_CURRENCY}</h3>
            						</div>
            					</td>
            				</tr>
            			</tbody></table>
            		</div>



            <div class="clear"></div>
            <div id="test"></div>
        </div>
    </td></tr>
</table>
</div>
</body>
</html>
