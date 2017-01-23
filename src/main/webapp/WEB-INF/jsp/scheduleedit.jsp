<%--
  Created by IntelliJ IDEA.
  User: ruslan
  Date: 15.01.2017
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="count" value="0"/>
<h3>Название группы:</h3>

<input type="text" class="form-control" id="name" value="${schedule.getName()}">
<h3>Смена:</h3>
<select class="form-control" id="shift">
    <option value="1" ${schedule.getShift() == '1' ? 'selected' : ''}>1 Смена</option>
    <option value="2" ${schedule.getShift() == '2' ? 'selected' : ''}>2 Смена</option>
</select>

<table class="table table-bordered">
    <thead>
    <tr><th>Понедельник</th></tr>
    </thead>
    <tbody id="monday">
    <c:forEach items="${schedule.getMonday()}" var="clazz" varStatus="loop">
        <c:set var="count" value="${loop.index}"/>
        <tr><td><input type="text" placeholder="Название предмета" value="${clazz.getNameofasubject()}"><input type="number" placeholder="Номер кабинета" value="${clazz.getCabinetnumber()}"></td></tr>
    </c:forEach>
    <c:if test="${count<3}">
        <c:forEach begin="${count+1}" end="3">
            <tr><td><input type="text" placeholder="Название предмета" ><input type="number" placeholder="Номер кабинета" ></td></tr>
        </c:forEach>
    </c:if>
    <c:set var="count" value="0"/>
    </tbody>
</table>

<table class="table table-bordered">
    <thead>
    <tr><th>Вторник</th></tr>
    </thead>
    <tbody id="tuesday">
    <c:forEach items="${schedule.getTuesday()}" var="clazz" varStatus="loop">
        <c:set var="count" value="${loop.index}"/>
        <tr><td><input type="text" placeholder="Название предмета" value="${clazz.getNameofasubject()}"><input type="number" placeholder="Номер кабинета" value="${clazz.getCabinetnumber()}"></td></tr>
    </c:forEach>
    <c:if test="${count<3}">
        <c:forEach begin="${count+1}" end="3">
            <tr><td><input type="text" placeholder="Название предмета" ><input type="number" placeholder="Номер кабинета" ></td></tr>
        </c:forEach>
    </c:if>
    <c:set var="count" value="0"/>
    </tbody>
</table>

<table class="table table-bordered">
    <thead>
    <tr><th>Среда</th></tr>
    </thead>
    <tbody id="wednesday">
    <c:forEach items="${schedule.getWednesday()}" var="clazz" varStatus="loop">
        <c:set var="count" value="${loop.index}"/>
        <tr><td><input type="text" placeholder="Название предмета" value="${clazz.getNameofasubject()}"><input type="number" placeholder="Номер кабинета" value="${clazz.getCabinetnumber()}"></td></tr>
    </c:forEach>
    <c:if test="${count<3}">
        <c:forEach begin="${count+1}" end="3">
            <tr><td><input type="text" placeholder="Название предмета" ><input type="number" placeholder="Номер кабинета" ></td></tr>
        </c:forEach>
    </c:if>
    <c:set var="count" value="0"/>
    </tbody>
</table>

<table class="table table-bordered">
    <thead>
    <tr><th>Четверг</th></tr>
    </thead>
    <tbody id="thursday">
    <c:forEach items="${schedule.getThursday()}" var="clazz" varStatus="loop">
        <c:set var="count" value="${loop.index}"/>
        <tr><td><input type="text" placeholder="Название предмета" value="${clazz.getNameofasubject()}"><input type="number" placeholder="Номер кабинета" value="${clazz.getCabinetnumber()}"></td></tr>
    </c:forEach>
    <c:if test="${count<3}">
        <c:forEach begin="${count+1}" end="3">
            <tr><td><input type="text" placeholder="Название предмета" ><input type="number" placeholder="Номер кабинета" ></td></tr>
        </c:forEach>
    </c:if>
    <c:set var="count" value="0"/>
    </tbody>
</table>

<table class="table table-bordered">
    <thead>
    <tr><th>Пятница</th></tr>
    </thead>
    <tbody id="friday">
    <c:forEach items="${schedule.getFriday()}" var="clazz" varStatus="loop">
        <c:set var="count" value="${loop.index}"/>
        <tr><td><input type="text" placeholder="Название предмета" value="${clazz.getNameofasubject()}"><input type="number" placeholder="Номер кабинета" value="${clazz.getCabinetnumber()}"></td></tr>
    </c:forEach>
    <c:if test="${count<3}">
        <c:forEach begin="${count+1}" end="3">
            <tr><td><input type="text" placeholder="Название предмета" ><input type="number" placeholder="Номер кабинета" ></td></tr>
        </c:forEach>
    </c:if>
    <c:set var="count" value="0"/>
    </tbody>
</table>

<button type="submit" id="tryedit" value="${schedule.getId()}">ДОБАВИТЬ</button>
