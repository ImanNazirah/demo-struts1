<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container-fluid px-4">
    <h1 class="mt-4 mb-4">Custom Pagination DataTable</h1>
     <div class="card mb-4 mt-4">
        <div class="card-body">
            <p align="justify">With custom pagination, you fetch only a subset of rows (one page at a time) from the server. This is more efficient for large datasets since only the required data is fetched and rendered on the page. This requires more server-side logic and custom code, but it is scalable and performs better with large amounts of data.</p>
        </div>
     </div>
    <div class="card mb-4">
        <div class="card-header">
            <i class="fas fa-table me-1"></i>
            Spotify List V2
        </div>
        <div class="mt-4 mb-2">
             <div>
                 <a class="modal-effect btn btn-dark mx-2" href="<c:url value='/spotify-init.do?action=create' />">
                     <i class="fas fa-plus"></i>
                 </a>
             </div>
        </div>
        <div class="card-body">
           <table id="datatablesSimpleCustom">
             <thead>
                   <tr>
                       <th>No.</th>
                       <th>Track Name</th>
                       <th>Artist Name</th>
                       <th>Genre</th>
                       <th>Popularity</th>
                       <th>Action</th>
                   </tr>
               </thead>
               <tbody>
                   <c:forEach var="entity" items="${data}" varStatus="i">
                       <tr>
                           <td>${i.index+1}</td>
                           <td>${entity.trackName}</td>
                           <td>${entity.artistName}</td>
                           <td>${entity.genre}</td>
                           <td>${entity.popularity}</td>
                              <td>
                                   <div class="d-flex align-items-center justify-content-center">
                                       <a class="modal-effect btn btn-dark mx-2" href="<c:url value='/spotify-init.do?action=edit&id=${entity.id.toString()}' />">
                                            <i class="fas fa-pencil-alt"></i>
                                       </a>
                                       <a class="modal-effect btn btn-danger" href="<c:url value='/spotify-init.do?action=delete&id=${entity.id.toString()}' />">
                                            <i class="fas fa-trash-alt"></i>
                                       </a>
                                   </div>
                              </td>
                       </tr>
                   </c:forEach>
               </tbody>
           </table>

           <!-- Previous or Next link  -->
           <!--
           <div>
               <c:if test="${currentPage > 1}">
                   <a href="spotify-pagination.do?page=${currentPage - 1}">Previous</a>
               </c:if>
               <c:if test="${currentPage < totalPages}">
                   <a href="spotify-pagination.do?page=${currentPage + 1}">Next</a>
               </c:if>
           </div>
           -->

           <!-- Page number links -->
           <div class="datatable-bottom">
               <nav class="datatable-pagination">
                    <ul class="datatable-pagination-list">
                        <c:forEach var="page" begin="1" end="${totalPages}" step="1">
                             <c:choose>
                               <c:when test="${page == currentPage}">
                                   <li class="datatable-pagination-list-item datatable-active">
                                       <a data-page="${page}" class="datatable-pagination-list-item-link">${page}</a>
                                   </li>
                               </c:when>
                               <c:otherwise>
                                   <li class="datatable-pagination-list-item">
                                        <a href="spotify-pagination.do?page=${page}" data-page="${page}" class="datatable-pagination-list-item-link">${page}</a>
                                   </li>
                               </c:otherwise>
                              </c:choose>
                        </c:forEach>
                    </ul>
               </nav>
           </div>
        </div>
    </div>
</div>

