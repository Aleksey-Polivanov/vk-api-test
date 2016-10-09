<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>

  <link rel="stylesheet" href="resources/assets/css/bootstrap.min.css">

  <title>All UsersVK</title>
</head>
<body class="no-js">
<table class="table">
  <tr>
    <th>ID</th>
    <th>VkID</th>
    <th>Name</th>
    <th>Send Email</th>
  </tr>
  <c:forEach var="friends" items="${usersVK}">
    <tr>
      <td>${friends.id}</td>
      <td>${friends.vkID}</td>
      <td>${friends.firstName} ${friends.secondName}</td>
      <td>${friends.sendMail}</td>
    </tr>
  </c:forEach>

  <form:form role="form" action="/back" method="post">

    <%--<input type="text" name="messages" placeholder="Введите messages">--%>
    <button type="submit" class="btn btn-access">Back</button>
    <%--<input type="text" name="messages" placeholder="Введите messages">--%>
  </form:form>
  <%--<tr>--%>
    <%--<td colspan="5">--%>
      <%--<form method="post" action="/depEdit">--%>
        <%--<input type="submit" value="Add new one">--%>
      <%--</form>--%>
    <%--</td>--%>
  <%--</tr>--%>
</table>
</body>
</html>