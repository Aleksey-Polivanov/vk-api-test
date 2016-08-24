<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<jsp:useBean id="_csrf"  class="org.springframework.security.web.csrf.CsrfToken" />--%>
<%--<%@ varible name="error" type="java.util.Optional<String>" %>--%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Log in</title>
</head>
<body>

<form:form role="form" action="/login" method="post">

    <c:if test="${param.error != null}">

        <p> Invalid Username and password </p>

    </c:if>


    <c:if test="${param.logout != null}">

        <p> You have been logged out. </p>

    </c:if>

<div>
<label for="username">username</label>
<input type="text" name="username" id="username"/>
</div>
<div>
<label for="password">Password</label>
<input type="password" name="password" id="password"/>
</div>
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>

<button type="submit" class="btn">Log in</button>

</form:form>
</body>
</html>

    <%--<body>--%>
    <%--<nav role="navigation">--%>
        <%--<ul>--%>
            <%--<li><a href="/">Home</a></li>--%>
        <%--</ul>--%>
    <%--</nav>--%>

    <%--<h1>Log in</h1>--%>

    <%--<p>You can use: demo@localhost / demo</p>--%>

    <%--<form role="form" action="/login" method="post">--%>
        <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>

        <%--<div>--%>
            <%--<label for="email">Email address</label>--%>
            <%--<input type="email" name="email" id="email" required autofocus/>--%>
        <%--</div>--%>
        <%--<div>--%>
            <%--<label for="password">Password</label>--%>
            <%--<input type="password" name="password" id="password" required/>--%>
        <%--</div>--%>
        <%--<div>--%>
            <%--<label for="remember-me">Remember me</label>--%>
            <%--<input type="checkbox" name="remember-me" id="remember-me"/>--%>
        <%--</div>--%>
        <%--<button type="submit">Sign in</button>--%>
    <%--</form>--%>

    <%--<#if error.isPresent()>--%>
        <%--<p>The email or password you have entered is invalid, try again.</p>--%>
    <%--</#if>--%>
    <%--</body>--%>
    <%--</html>--%>