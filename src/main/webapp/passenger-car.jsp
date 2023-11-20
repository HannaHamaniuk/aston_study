<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Passenger Cars</title>

</head>
<body>
<h2> Passenger Cars</h2>
<table border="1">
    <tr>
        <th>engine power</th>
        <th>brand</th>
        <th>color</th>
        <th> seat amount</th>


    </tr>
    <c:forEach var="passenger" items="${passengers}">
        <tr>
            <td>${passenger.enginePower}</td>
            <td>${passenger.brand}</td>
            <td>${passenger.color}</td>
            <td>${passenger.passengerAmount}</td>
        </tr>
    </c:forEach>
    </table>
<br>

<a href ="/cars">all cars</a>


</body>
</html>
