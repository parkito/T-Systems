<%--
    Document   : index
    Created on : 06.08.2012, 23:36:00
    Author     : Egorov A.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Главная страница блога</title>
</head>
<body>
<header>
    <a href="/"><img alt="Логотип" id="top-image" src="http://cdn.korsit.com/png/trunk/t-mobile.png"/></a>
    <div id="user-panel">
        <a href="#"><img alt="Иконка юзера" scr="http://animal-store.ru/img/2015/050401/4834712"/></a>
        <a href="javascript:void(0);">[Панель для юзера]</a>
    </div>
</header>
<div id="main">
    <aside class="leftAside">
        <h2>Tariffs</h2>
        <ul>
            <li><a href="#">Basic</a></li>
            <li><a href="#">Gb 1</a></li>
            <li><a href="#">Gb 2</a></li>
            <li><a href="#">Call 1</a></li>
            <li><a href="#">Call 2</a></li>
            <li><a href="#">Ultimate</a></li>

        </ul>
    </aside>
    <section>
        <article>
            <h1>Статья</h1>
            <div class="text-article">
                Текст статьи
            </div>
            <div class="fotter-article">
                <span class="autor">Автор статьи: <a href="#">автор</a></span>
                <span class="read"><a href="javascript:void(0);">Читать...</a></span>
                <span class="date-article">Дата статьи: 20.12.2012</span>
            </div>
        </article>
        <article>
            <h1>Статья</h1>
            <div class="text-article">
                Текст статьи
            </div>
            <div class="fotter-article">
                <span class="autor">Автор статьи: <a href="#">автор</a></span>
                <span class="read"><a href="javascript:void(0);">Читать...</a></span>
                <span class="date-article">Дата статьи: 20.12.2012</span>

            </div>
        </article>
    </section>
</div>

</body>
</html>