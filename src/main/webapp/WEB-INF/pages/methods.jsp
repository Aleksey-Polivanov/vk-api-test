<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" href="resources/assets/css/bootstrap.min.css">

    <title>Methods</title>
</head>
<body>

<form:form role="form" action="/getMyFriends" method="post">

    <%--<input type="hidden" name="vkApi" value="${vkApi}">--%>
    <button type="submit" class="btn btn-warning">Get My Friends</button>

</form:form>


</body>
</html>
