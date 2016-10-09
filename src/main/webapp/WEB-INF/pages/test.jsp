<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: agios
  Date: 06.09.16
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="https://docs.google.com/spreadsheets/d/1Lr2dyW6ZHMO-ejaLrfBvV-7u0WCtbAoV0oYanqIaXPc/edit" >Аккаунты</a>
<c:forEach var="i" begin="1" end="${imageCount}" >

    ${i}

</c:forEach>


</body>
</html>
