<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1">
    <link rel="stylesheet" type="text/css" href="assets/css/bootstrap-clearmin.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/roboto.css">
    <link rel="stylesheet" type="text/css" href="assets/css/material-design.css">
    <link rel="stylesheet" type="text/css" href="assets/css/small-n-flat.css">
    <link rel="stylesheet" type="text/css" href="assets/css/font-awesome.min.css">
    <title>K-Mobile</title>
</head>
<jsp:include page="header.jsp"></jsp:include>
<div id="global">
    <div class="container-fluid cm-container-white">
        <h2 style="margin-top:0;">Report generator</h2>
        <p></p>
    </div>
    <div class="container-fluid">
        <div class="panel panel-default">
            <div class="panel-body">
                <div class="input-group input-group-lg">
                    <input id="text" type="text" class="form-control" placeholder="Enter contract title">
                    <span class="input-group-btn">
                        <button style="z-index:2" onclick="find()" class="btn btn-primary"
                                type="button">Get&nbsp;&nbsp;&nbsp;&nbsp;</button>
                    </span>
                    #{beanController.get}
                </div>
            </div>
            <script>
                function find() {
                    var text = document.getElementById('text').value;
                    x = confirm('Are you sure? ');
                    if (x == true) {
                        var xhr = new XMLHttpRequest();
                        xhr.open("GET", "getTariff?contract=" + text, false);
                        xhr.send();
                    }
                }
            </script>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</html>