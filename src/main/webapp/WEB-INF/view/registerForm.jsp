<%--
  Created by IntelliJ IDEA.
  User: Asia
  Date: 2015-12-30
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<html>
<head>
    <title>Zarejstruj sie!</title>
</head>
<body>
<h1>formularz młodzierzy</h1>
<sf:form method="POST" commandName="spitter">
  imie: <sf:input type="text" path="firstName"/> <br/>
        <sf:errors path="firstName" />
  nazwisko: <sf:input type="text" path="lastName"/> <br/>
  nazwa: <sf:input type="text" path="userName"/><br/>
  hasło: <sf:password path="password"/><br/>
    <input type="submit" value="zarejstreuj"><br/>

</sf:form>

</body>
</html>
