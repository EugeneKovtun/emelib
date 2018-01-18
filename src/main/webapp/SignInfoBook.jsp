<!DOCTYPE html>
<%@ page contentType="text/html;charset=utf-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>eMeLib</title>
    <link rel='stylesheet prefetch' href='http://netdna.bootstrapcdn.com/font-awesome/3.2.0/css/font-awesome.min.css'>
    <%--<link rel="stylesheet" href="css/style.css" media="screen" type="text/css" / >--%>
    <link rel="icon" href="http://vladmaxi.net/favicon.ico" type="image/x-icon">
    <link rel="shortcut icon" href="http://vladmaxi.net/favicon.ico" type="image/x-icon">
    <STYLE>
        <%@ include file="/css/style.css" %>
    </STYLE>
</head>

<body>
<div class="topper">
    <a class="top1" href="personalArea.html">Личный кабинет</a>
    <a class="top" href="/exit">Выход</a>
    <img class="center" src="images/eme.png">
</div>
<div>
    <figure class="sign">
        <p><img src="images/main.jpg" width="100" height="100" alt="Main"></p>
        <a class="signaInfo" href="/">Главная</a>
    </figure>

    <figure class="sign1">
        <p><img src="images/catalog.png" width="100" height="100" alt="Catalog"></p>
        <a class="signa1Info" href="/catalog">Каталог</a>
    </figure>

</div>

<div class="var1">
    <p><img src="images/var1.jpg" width="220" height="300" alt="Var1"></p>
</div>

<div class="var2">
    <p><img src="images/var2.jpg" width="220" height="300" alt="Var2"></p>
</div>

<!--div class="var3">
<p><img src="images/var3.jpg" width="400" height="260" alt="Var3"></p>
</div-->


<!--div class = "txt">
<ul>
<li> ����� �������� � ����� �������� �� ��������� �����. </li> <br>
<li>	��� ����-�� ��� �������������� ������������ ���. </li> <br>
<li>	����� ��������� �� �������� ������ �������.</li> <br>
<li>	����� ����� ���� �������� ������� ���������� ���.</li> <br>
<li>	����� �������� ������������ ������������.</li> <br>
<li>	�������� ����� ������� ������ ������ � ����� �������.</li> <br>
<li>	����� ���� ������� ��������� ����� ��� ����� � ���� ������ � ��� �� ��������.</li>
</ul>
</div-->

<div class="name">
    Название Книги:
</div>

<div class="nameMain">
    ${name}
</div>

<div class="author">
    Автор книги:
</div>

<div class="authorMain">
    ${autor}
</div>

<div class="desc">
    Краткое описание:
</div>

<div class="descMain">
    ${description}
</div>

<div class="price">
    Цена книги:
</div>

<div class="priceMain">
    ${price}
</div>

<%--<button class="but"><a class="forBuy" href="SignText.html">Чиать книгу</a></button>--%>
<%--<button class="buy"><a class="forBuy" href="/trade">Купить книгу</a></button>--%>
${read}
${byu}

</body>
</html>