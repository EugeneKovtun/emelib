<!DOCTYPE html>
<%@ page contentType="text/html;charset=utf-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>eMeLib</title>
    <link rel='stylesheet prefetch' href='http://netdna.bootstrapcdn.com/font-awesome/3.2.0/css/font-awesome.min.css'>
    <%--<link rel="stylesheet" href="css/style.css" media="screen" type="text/css"/>--%>
    <link rel="icon" href="http://vladmaxi.net/favicon.ico" type="image/x-icon">
    <link rel="shortcut icon" href="http://vladmaxi.net/favicon.ico" type="image/x-icon">
    <STYLE>
        <%@ include file="/css/style.css" %>
    </STYLE>
</head>

<body>

<div class="topper">
    <a class="top" href="/">Главная</a>
</div>

<div class="bk">
    ${name}
</div>
<textarea class="TEXT" rows=150 cols=130>
    ${text}
</textarea>
</body>
</html>