<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>All Countries</title>

</head>
<body>
<h2> All Countries</h2>
<table border="1">
    <tr>
        <th>name</th>
        <th>president</th>
        <th>capital</th>
        <th>action</th>

    </tr>
    <c:forEach var="country" items="${countries}">
        <tr>
            <td>${country.name}</td>
            <td>${country.president}</td>
            <td>${country.capital}</td>
            <td>
                <a href="/unions?id=${country.id}">view unions</a>
            </td>
        </tr>
    </c:forEach>
    </table>
<br>



</body>
</html>