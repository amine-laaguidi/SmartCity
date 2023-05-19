<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Page d'accueil</title>
</head>
<body>
<c:choose>
    <c:when test="${user!= null}">
        <h1>Bienvenue sur la page d'accueil   ${user.username} / ${user.role}</h1>
        <form action="/logout" method="post">
            <button type="submit" >Sign Out</button>
        </form>
    </c:when>
    <c:otherwise>
        <h1>Bienvenue sur la page d'accueil  </h1>
        <a href="/login">login</a>
    </c:otherwise>
</c:choose>



</body>
</html>