<!DOCTYPE html>
<%@ page contentType="text/html;charset=utf-8" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
	<title>eMeLib</title>
	<link rel='stylesheet prefetch' href='http://netdna.bootstrapcdn.com/font-awesome/3.2.0/css/font-awesome.min.css'>
	<%--<link rel="stylesheet" href="css/style.css" media="screen" type="text/css" / >--%>
	<link rel="icon" href="http://vladmaxi.net/favicon.ico" type="image/x-icon" >
	<link rel="shortcut icon" href="http://vladmaxi.net/favicon.ico" type="image/x-icon">
    <STYLE>
        <%@ include file="/css/style.css" %>
    </STYLE>
</head>

<body>
  <div class = "topper">
  <a class="top1" href="/">Главная</a>
  <a class="top" href="/exit">Выход</a>
  <img class ="center" src="images/eme.png">
  </div>
  
  <div class ="us">
  <img src="images/user.png" width="220" height="200">
   </div>
  <div class = "user"> ${login} </div>
  
  
  
  <div class = "vv1">
      Список доступных книг:
  </div>
  
  <ol class ="lk">
      ${books}
  </ol>

  <div class="kl">
  <p><img src="images/var1.jpg" width="260" height="350" alt="Var1"></p>
  </div>
</body>
</html>