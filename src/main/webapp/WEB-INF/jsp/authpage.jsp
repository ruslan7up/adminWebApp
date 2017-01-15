<%--
  Created by IntelliJ IDEA.
  User: ruslan
  Date: 12.01.2017
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <script src="/resources/jquery/jquery-3.1.1.js"></script>
    <link rel="shortcut icon" href="/resources/favicon.ico" type="image/ico">

    <title>Авторизация</title>

    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <link href="/resources/css/signin.css" rel="stylesheet">

</head>

<body>
<!-- Начало блока авторизации -->
<div class="container">
    <div  class="form-signin">
        <h2 class="form-signin-heading">Пожалуйста авторизуйтесь</h2>
        <label for="login"  class="sr-only">Логин</label>
        <input type="text" id="login" name="login" class="form-control" placeholder="Логин" required autofocus>
        <label for="pass" class="sr-only">Пароль</label>
        <input type="password" id="pass" name="pass" class="form-control" placeholder="Пароль" required>
        <div id="errfield" style="color: red;"></div>
        <button class="btn btn-lg btn-primary btn-block" type="submit" id="trytologin">Войти</button>
    </div>
</div>
<!-- Конец блока авторизации -->

<script src="/resources/js/authPageScripts.js"></script>
</body>
</html>