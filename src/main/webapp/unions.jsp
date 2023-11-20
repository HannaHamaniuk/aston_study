<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Unions</title>

</head>
<body>
<h2> Union list</h2>
<table border="1">
    <tr>
        <th>title</th>


    </tr>
    <c:forEach var="union" items="${unions}">
        <tr>
            <td>${union.title}</td>


        </tr>
    </c:forEach>
    </table>
<br>



</body>
</html>