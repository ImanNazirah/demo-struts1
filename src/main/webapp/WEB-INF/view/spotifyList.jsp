<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Query Results</title>
</head>
<body>
    <h2>Query Results</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>trackName</th>
            <th>artistName</th>
            <th>genre</th>
            <th>popularity</th>
        </tr>
        <c:forEach var="entity" items="${results}">
            <tr>
                <td>${entity.id}</td>
                <td>${entity.trackName}</td>
                <td>${entity.artistName}</td>
                <td>${entity.genre}</td>
                 <td>${entity.popularity}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
