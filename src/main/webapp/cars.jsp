<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>All Cars</title>

</head>
<body>
<h2> All Cars</h2>
<table border="1">
    <tr>
        <th>engine power</th>
        <th>brand</th>
        <th>color</th>
        <th>action</th>

    </tr>
    <c:forEach var="car" items="${cars}">
        <tr>
            <td>${car.enginePower}</td>
            <td>${car.brand}</td>
            <td>${car.color}</td>
            <td>
                <a href="/delete?id=${car.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
    </table>
<br>

<a href ="/add-car">add new car</a>
<a href ="/pass">all passenger cars</a>
<a href ="/sport">all sport cars</a>


</body>
</html>
