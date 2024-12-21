<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>


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
            <table id="datatablesSimple">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>trackName</th>
                        <th>artistName</th>
                        <th>genre</th>
                        <th>popularity</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="entity" items="${results}">
                        <tr>
                            <td>${entity.id}</td>
                            <td>${entity.trackName}</td>
                            <td>${entity.artistName}</td>
                            <td>${entity.genre}</td>
                            <td>${entity.popularity}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
