<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1">
    <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap-clearmin.min.css">
    <link rel="stylesheet" type="text/css" href="../assets/css/roboto.css">
    <link rel="stylesheet" type="text/css" href="../assets/css/material-design.css">
    <link rel="stylesheet" type="text/css" href="../assets/css/small-n-flat.css">
    <link rel="stylesheet" type="text/css" href="../assets/css/font-awesome.min.css">
    <title>New client</title>
</head>
<jsp:include page="header.jsp"></jsp:include>

<div id="global">
    <div class="container-fluid cm-container-white">
        <h2 style="margin-top:0;">Add new client</h2>
    </div>
    <div class="container-fluid">
        <div class="panel panel-default">
            <div class="panel-body">
                <div class="input-group">
                    <table class="table">
                        <thead>
                        <tr>
                            <th></th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td><input id="name" type="text" class="form-control" placeholder="Enter name"></td>
                            <td>
                                <font color="blue">
                                    <c:if test="${nameStat!=null}">
                                        ${nameStat}
                                    </c:if>
                                </font>
                            </td>
                        </tr>
                        <tr>
                            <td><input id="surName" type="text" class="form-control" placeholder="Surname"></td>
                            <td>
                                <font color="blue">
                                    <c:if test="${surName!=null}">
                                        ${surName}
                                    </c:if>
                                </font>
                            </td>
                        </tr>
                        <tr>
                            <td><input id="birthday" type="date" class="form-control" placeholder="Birthday date"></td>
                            <font color="blue">
                                <c:if test="${birthday!=null}">
                                    ${birthday}
                                </c:if>
                            </font>
                        </tr>
                        <tr>
                            <td><input id="passport" type="text" class="form-control" placeholder="Passport"></td>
                            <font color="blue">
                                <c:if test="${passport!=null}">
                                    ${passport}
                                </c:if>
                            </font>
                        </tr>
                        <tr>
                            <td><input id="adress" type="text" class="form-control" placeholder="Adress"></td>
                            <font color="blue">
                                <c:if test="${adress!=null}">
                                    ${adress}
                                </c:if>
                            </font>
                        </tr>
                        <tr>
                            <td><input id="email" type="email" class="form-control" placeholder="Email"></td>
                            <font color="blue">
                                <c:if test="${email!=null}">
                                    ${email}
                                </c:if>
                            </font>
                        </tr>
                        <tr>
                            <td><input id="number" type="email" class="form-control" placeholder="Number"></td>
                            <font color="blue">
                                <c:if test="${number!=null}">
                                    ${number}
                                </c:if>
                            </font>
                        </tr>
                        </tbody>
                    </table>

                </div>
            </div>
            <div class="modal-footer">
                <form name="test" onclick="add()">
                    <button type="submit" class="btn btn-success">Create</button>
                </form>
                <script>
                    function add() {
                        var name = document.getElementById('name').value;
                        var surName = document.getElementById('surName').value;
                        var birthday = document.getElementById('birthday').value;
                        var passport = document.getElementById('passport').value;
                        var adress = document.getElementById('adress').value;
                        var email = document.getElementById('email').value;
                        var number = document.getElementById('number').value;
                        popBox();
                        function popBox() {
                            x = confirm('Are you sure? ');
                            if (x == true) {
                                var xhr = new XMLHttpRequest();
                                xhr.open("DELETE", "adminNewClient?name=" + name + "&surName=" + surName
                                        + "&birthday=" + birthday + "&passport=" + passport
                                        + "&adress=" + adress + "&email=" + email + "&number=" + number, false);
                                xhr.send();

                            }
                        }

                    }
                </script>
            </div>
        </div>
    </div>
    <%--<%--%>
    <%--if (nameStat.equals("OK") && surName.equals("OK") && birthday.equals("OK") && passport.equals("OK")--%>
    <%--&& adress.equals("OK") && email.equals("OK")) {--%>
    <%--%>--%>
    <div class="container-fluid cm-container-white">
        <h2 align="center" style="margin-top:0;">Client added, password generated</h2>
    </div>
    <%--<%}%>--%>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</html>