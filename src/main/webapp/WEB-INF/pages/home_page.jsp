<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

    <link rel="stylesheet" href="resources/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/assets/css/style.css">

    <title>Title</title>
</head>
<body>


    <form:form role="form" action="/sendEmail" method="post">

        <input  type="text" name="day" placeholder="Введите день"/>
        <button type="submit" class="btn btn-primary logIn">Send Email</button>

    </form:form>

    <form:form role="form" action="/sendEmailWithAttachment" method="post">

        <input  type="text" name="day" placeholder="Введите день"/>
        <button type="submit" class="btn btn-primary logIn">SEWA</button>

    </form:form>

    <form:form role="form" action="/readFile" method="post">

        <input  type="text" name="sheet" placeholder="Введите название страницы"/>
        <button type="submit" class="btn btn-primary logIn">Read File</button>

    </form:form>









<div class="RegForm">
<form:form role="form" action="/authorization" method="post">
<div class="form">
    <h3>Authorization</h3>
    <div class="token">
        <label>Token-VK</label>
        <input class="tokenf" type="text" name="accessToken" placeholder="Введите Access Token"/>
    </div>
   <div>
        <%--<label>AppID</label>--%>
        <input type="hidden" name="AppID" value="5599674"/>
   </div>

    <button type="submit" class="btn btn-primary logIn">Log in</button>
</form:form>

<p>Для получения токена: <br>
    1. Список <a href="https://docs.google.com/spreadsheets/d/1Lr2dyW6ZHMO-ejaLrfBvV-7u0WCtbAoV0oYanqIaXPc/edit?usp=sharing">Аккаунтов</a><br>
    2. авторизируйтесь на сайте <a href="http://vk.com">vk.com</a><br>
    3. нажмите на <a href="https://oauth.vk.com/authorize?client_id=5599674&scope=offline,messages&redirect_uri=https://oauth.vk.com/blank.html&display=page&v=5.21&response_type=token">Get Token</a><br>
    <%--2. нажмите на <a href="https://oauth.vk.com/authorize?client_id=5599674&scope=offline,messages&redirect_uri=localhost:8080/home&display=page&v=5.21&response_type=token">Get Token</a><br>--%>
    4. в открытом окне скопируйте ваш access_token из url</p>
    <%--<c:if test="${token != null}">--%>
    <%--3. Ваш access token = ${token}--%>
    <%--</c:if>--%>

</div>
</div>

</body>
</html>
