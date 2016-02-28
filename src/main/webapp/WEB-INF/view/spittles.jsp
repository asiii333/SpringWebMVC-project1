<%--
  Created by IntelliJ IDEA.
  User: Asia
  Date: 2015-12-23
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>current spittle</title>
</head>
<body>
<h1>current spittle</h1>
<div>
    <c:forEach items="${spittleList}" var="spittle" >
      <li id="spittle_<c:out value="${spittle.id}"/>">
        <div class="spittleMessage">
          <c:out value="${spittle.message}" />
        </div>
        <div>
          <span class="spittleTime"><c:out value="${spittle.time}" /></span>
          <span class="spittleLocation">
            (<c:out value="${spittle.latitude}" />,
            <c:out value="${spittle.longitude}" />)
          </span>
        </div>
      </li>
    </c:forEach>
  </div>
</body>
</html>
