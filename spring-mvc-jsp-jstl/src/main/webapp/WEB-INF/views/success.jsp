<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Article adder</title>
</head>
<body>
    <c:if test="${not empty article}">
        <h1><c:out value="${article.title}"/></h1>
        <p>
            <c:out value="${article.content}" />
        </p>
        <c:if test="${not empty article.tags}">
            <c:forEach var="tag" items="${article.tags}">
                <li><c:out value="${tag}" /></li>
            </c:forEach>
        </c:if>
    </c:if>
</body>
</html>
