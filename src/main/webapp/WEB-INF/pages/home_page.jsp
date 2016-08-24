<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

    <link rel="stylesheet" href="resources/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/assets/css/style.css">

    <title>Title</title>
</head>
<body>
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
    1. авторизируйтесь на сайте <a href="http://vk.com">vk.com</a><br>
    2. нажмите на <a href="https://oauth.vk.com/authorize?client_id=5599674&scope=messages&redirect_uri=https://oauth.vk.com/blank.html&display=page&v=5.21&response_type=token">Get Token</a><br>
    3. в открытом окне скопируйте ваш access_token из url</p>
</div>
</div>

</body>
</html>
