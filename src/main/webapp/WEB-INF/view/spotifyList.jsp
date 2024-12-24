<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>


<div class="container-fluid px-4">
    <h1 class="mt-4 mb-4">Built-in DataTable</h1>

     <div class="card mb-4 mt-4">
        <div class="card-body">
            <p align="justify">The data table fetches all rows at once and paginates them client-side. This can be an issue if you have a large dataset because it can lead to performance problems and long load times. This approach is simpler to implement because the pagination logic is already handled by the DataTable plugin, and it is a good choice for smaller datasets.</p>
        </div>
     </div>

    <div class="card mb-4">
        <div class="card-header">
            <i class="fas fa-table me-1"></i>
            Spotify List
        </div>
        <div class="card-body">
            <table id="datatablesSimple">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Track Name</th>
                        <th>Artist Name</th>
                        <th>Genre</th>
                        <th>Popularity</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="entity" items="${results}" varStatus="i">
                        <tr>
                            <td>${i.index+1}</td>
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
