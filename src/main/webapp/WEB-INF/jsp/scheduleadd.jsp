<%--
  Created by IntelliJ IDEA.
  User: ruslan
  Date: 15.01.2017
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h3>Название группы:</h3>

<input type="text" class="form-control" id="name">
<h3>Смена:</h3>
<select class="form-control" id="shift">
    <option value="1" selected>1 Смена</option>
    <option value="2">2 Смена</option>
</select>

<table class="table table-bordered">
    <thead>
     <tr><th>Понедельник</th></tr>
    </thead>
    <tbody id="monday">
    <c:forEach var="i" begin="1" end="4">
    <tr><td><input type="text" placeholder="Название предмета"><input type="number" placeholder="Номер кабинета"></td></tr>
    </c:forEach>
    </tbody>
</table>

<table class="table table-bordered">
    <thead>
    <tr><th>Вторник</th></tr>
    </thead>
    <tbody id="tuesday">
    <c:forEach var="i" begin="1" end="4">
        <tr><td><input type="text" placeholder="Название предмета"><input type="number" placeholder="Номер кабинета"></td></tr>
    </c:forEach>
    </tbody>
</table>

<table class="table table-bordered">
    <thead>
    <tr><th>Среда</th></tr>
    </thead>
    <tbody id="wednesday">
    <c:forEach var="i" begin="1" end="4">
        <tr><td><input type="text" placeholder="Название предмета"><input type="number" placeholder="Номер кабинета"></td></tr>
    </c:forEach>
    </tbody>
</table>

<table class="table table-bordered">
    <thead>
    <tr><th>Четверг</th></tr>
    </thead>
    <tbody id="thursday">
    <c:forEach var="i" begin="1" end="4">
        <tr><td><input type="text" placeholder="Название предмета"><input type="number" placeholder="Номер кабинета"></td></tr>
    </c:forEach>
    </tbody>
</table>

<table class="table table-bordered">
    <thead>
    <tr><th>Пятница</th></tr>
    </thead>
    <tbody id="friday">
    <c:forEach var="i" begin="1" end="4">
        <tr><td><input type="text" placeholder="Название предмета"><input type="number" placeholder="Номер кабинета"></td></tr>
    </c:forEach>
    </tbody>
</table>

<button type="submit" id="tryadd">ДОБАВИТЬ</button>
