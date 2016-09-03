<html>
<head>
    <title>Page</title>
</head>
<body>
<input type="radio" name="r1" value="5">one<br>
<input type="radio" name="r1" value="13">two<br>
<input type="radio" name="r1" value="53">free<br>
<br>
<input type="radio" name="r2" value="1">one<br>
<input type="radio" name="r2" value="2">two<br>
<input type="radio" name="r2" value="3">free<br>
<br>
<form onclick="fun1()">
    <button type="submit">Button</button>
</form>
<script>function fun1() {
    var rad = document.getElementsByName('r1');
    for (var i = 0; i
    < rad.length
            ; i++) {
        if (rad[i].checked) {
            alert('Active ' + i + ' radiobutton');
        }
    }
}</script>
</body>
</html>