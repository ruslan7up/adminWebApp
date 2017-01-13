<%--
  Created by IntelliJ IDEA.
  User: ruslan
  Date: 12.01.2017
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html class="error-page">
<head>
    <title>Ошибка 404</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" media="screen" href="/resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" media="screen" href="/resources/bootstrap/css/bootstrap-theme.min.css">

    <link rel="stylesheet" media="screen" href="/resources/css/bootstrap-admin-theme.css">
    <link rel="stylesheet" media="screen" href="/resources/css/bootstrap-admin-theme-change-size.css">

    <link rel="stylesheet" media="screen" href="/resources/css/bootstrap-error-page.css">
</head>
<body>

<div class="container-fluid">
    <div class="row-fluid">
        <div class="col-lg-12">
            <div class="centering text-center error-container">
                <div class="text-center">
                    <h2 class="without-margin">Ошибка <span class="text-warning"><big>404</big></span></h2>
                    <h4 class="text-warning">Страница не найдена</h4>
                </div>
                <div class="text-center">
                    <h3><small>Основные страницы ниже</small></h3>
                </div>
                <hr>
                <ul class="pager">
                    <li><a href="/goods/goodsPanel">Склад</a></li>
                    <li><a href="/orders/info">Заказы</a></li>
                    <li><a href="/shop/info">Магаизны</a></li>
                    <li><a href="/admin/allPanels">Сотрудники</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>

<div class="navbar navbar-footer navbar-fixed-bottom">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <footer role="contentinfo">
                    <p class="left">Курсовая работа</p>
                    <p class="right">&copy; 2016 <a href="https://vk.com/ruslanw" target="_blank">VK</a></p>
                </footer>
            </div>
        </div>
    </div>
</div>

</body>
</html>
