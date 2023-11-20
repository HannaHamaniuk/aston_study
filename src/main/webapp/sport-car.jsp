<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Sport Cars</title>

</head>
<body>
<h2> Sport Cars</h2>
<table border="1">
    <tr>
        <th>engine power</th>
        <th>brand</th>
        <th>color</th>
        <th> max speed</th>


    </tr>
    <c:forEach var="sport" items="${sportCars}">
        <tr>
            <td>${sport.enginePower}</td>
            <td>${sport.brand}</td>
            <td>${sport.color}</td>
            <td>${sport.maxSpeed}</td>
        </tr>
    </c:forEach>
    </table>
<br>

<a href ="/cars">all cars</a>


</body>
</html>
