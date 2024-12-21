<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container-fluid px-4">
    <h1 class="mt-4">Tables</h1>
    <ol class="breadcrumb mb-4">
        <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
        <li class="breadcrumb-item active">Tables</li>
    </ol>
    <div class="card mb-4">
        <div class="card-header">
            <i class="fas fa-table me-1"></i>
            DataTable Example
        </div>
        <div class="card-body">
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
        </div>
    </div>
</div>