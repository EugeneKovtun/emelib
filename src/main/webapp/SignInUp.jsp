<!DOCTYPE html>
<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sign in page</title>
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
    <a class="top" href="notSignMain.html">Глaвная!</a>
    <img class="center" src="images/eme.png">
</div>


<div class="box">
    <nav id="tabs" class="tabs">
        <a id="tabLogin" class="iconLogin active blueBox" title="Sign in"></a>
        <a id="tabRegister" class="iconRegister greenBox" title="Sign up"></a>
    </nav>

    <div class="containerWrapper">

        <!-- login container -->
        <div id="containerLogin" class="tabContainer active">
            <form action="/login" method="post">
                <h2 class="loginTitle">Sign in</h2>
                <div class="loginContent">
                    <div class="inputWrapper">
                        <input name="login" type="text" placeholder="Login"/>
                    </div>
                    <div class="inputWrapper">
                        <input name="password" type="password" placeholder="Password"/>
                    </div>
                </div>
                <button class="blueBox"><span class="iconLogin"></span> Sign in!</button>
                <div class="clear"></div>
            </form>
        </div>

        <!-- register container -->
        <div id="containerRegister" class="tabContainer">
            <form action="/registration" method="post">
                <h2 class="loginTitle">Sign up</h2>
                <div class="registerContent">
                    <div class="inputWrapper">
                        <input name="login" type="text" placeholder="Your login"/>
                    </div>
                    <div class="inputWrapper">
                        <input name="password" type="password" placeholder="Your password"/>
                    </div>
                </div>
                <div class="sog">
                    Регистрируясь, вы подтверждаете <br> условия <a href="/contract"> договора </a>.
                </div>
                <button class="greenBox"><span class="iconRegister"></span> Sign up!</button>
                <div class="clear"></div>
            </form>
        </div>
        <div class="clear"></div>
        <div class="clear"></div>
    </div>
</div>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
<script>
    <%@ include file="/js/index.js" %>
</script>
</body>
</html>