<%--
  Created by IntelliJ IDEA.
  User: Asia
  Date: 2015-12-29
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>homee!</title>
    <spring:url value="/resources/img/dark-side.jpg" var="darkSide" />
    <spring:url value="/resources/img/go-fack-yourself.jpg" var="fuckYourself" />
    <spring:url value="/resources/img/gardze-wami.jpg" var="gardzeWami" />
</head>
<body>
<div class="spittleView">
    <div>
        <spring:message code="form.home.register"/>:<br/>
        <a href="/spitter/register"><img src="${gardzeWami}"/></a>
    </div>
    <div>
        spittles:<br/>
        <a href="/spittles"><img src="${darkSide}"/></a>
    </div>
    <div>
        spittle:<br/>
        <a href="/spittles/1234"><img src="${fuckYourself}"/></a>
    </div>
</div>
</body>
</html>
