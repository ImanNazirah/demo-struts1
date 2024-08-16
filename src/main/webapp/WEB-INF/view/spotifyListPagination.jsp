<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table border="1">
    <tr>
            <th>ID</th>
            <th>trackName</th>
            <th>artistName</th>
            <th>genre</th>
            <th>popularity</th>
    </tr>
     <c:forEach var="entity" items="${data}">
            <tr>
                <td>${entity.id}</td>
                <td>${entity.trackName}</td>
                <td>${entity.artistName}</td>
                <td>${entity.genre}</td>
                 <td>${entity.popularity}</td>
            </tr>
      </c:forEach>
</table>

<div>
    <c:if test="${currentPage > 1}">
        <a href="spotifyPagination.do?page=${currentPage - 1}">Previous</a>
    </c:if>

    <c:if test="${currentPage < totalPages}">
        <a href="spotifyPagination.do?page=${currentPage + 1}">Next</a>
    </c:if>
</div>