<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container-fluid px-4">
     <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-7">
                <div class="card shadow-lg border-0 rounded-lg mt-5">
                    <div class="card-header">
                        <h3 class="text-center font-weight-light my-4">
                            <c:choose>
                                <c:when test="${spotifyForm.actionType == 'create'}">Create Data</c:when>
                                <c:when test="${spotifyForm.actionType == 'edit'}">Edit Data</c:when>
                                <c:when test="${spotifyForm.actionType == 'delete'}">Delete Data</c:when>
                                <c:otherwise>Create Data</c:otherwise>
                            </c:choose>
                        </h3>
                    </div>
                    <div class="card-body">
                        <c:set var="actionUrl" value="/spotify-create.do" />
                        <c:choose>
                            <c:when test="${spotifyForm.actionType == 'create'}">
                                <c:set var="actionUrl" value="/spotify-create.do" />
                            </c:when>
                            <c:when test="${spotifyForm.actionType == 'edit'}">
                                <c:set var="actionUrl" value="/spotify-update.do" />
                            </c:when>
                            <c:when test="${spotifyForm.actionType == 'delete'}">
                                <c:set var="actionUrl" value="/spotify-delete.do" />
                            </c:when>
                            <c:otherwise>
                                <c:set var="actionUrl" value="/spotify-create.do" />
                            </c:otherwise>
                        </c:choose>
                        <form action="<c:url value='${actionUrl}' />" method="post">
                            <c:if test="${not empty param.id}">
                                <input name="id" class="form-control" id="inputUserId" type="text" value="${param.id}" style="display:none;" />
                            </c:if>
                            <div class="row mb-3">
                                <div class="col-md-6">
                                    <div class="form-floating mb-3 mb-md-0">
                                        <input name="artistName" class="form-control" id="inputArtistName" type="text" placeholder="Enter input" value="${spotifyForm.actionType == 'create' ? '' : spotifyForm.artistName}"  />
                                        <label for="inputArtistName">Artist name</label>
                                        <span class="text-danger">
                                              <html:errors property="artistName"/>
                                        </span>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-floating">
                                        <input name="trackName" class="form-control" id="inputTrackName" type="text" placeholder="Enter input" value="${spotifyForm.actionType == 'create' ? '' : spotifyForm.trackName}" />
                                        <label for="inputTrackName">Track name</label>
                                        <span class="text-danger">
                                              <html:errors property="trackName"/>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-md-6">
                                    <div class="form-floating mb-3 mb-md-0">
                                        <input name="genre" class="form-control" id="inputGenre" type="text" placeholder="Enter input" value="${spotifyForm.actionType == 'create' ? ''  : spotifyForm.genre}"  />
                                        <label for="inputGenre">Genre</label>
                                        <span class="text-danger">
                                              <html:errors property="genre"/>
                                        </span>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-floating mb-3 mb-md-0">
                                        <input name="popularity" class="form-control" id="inputPopularity" type="text" placeholder="Enter input" value="${spotifyForm.actionType == 'create' ? '' : spotifyForm.popularity}"  />
                                        <label for="inputPopularity">Popularity</label>
                                        <span class="text-danger">
                                              <html:errors property="popularity"/>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="row mb-3 mt-3 justify-content-between">
                                <div class="col-md-6 text-start">
                                    <button type="submit" class="btn btn-dark">
                                      <c:choose>
                                        <c:when test="${spotifyForm.actionType == 'create'}">Save</c:when>
                                        <c:when test="${spotifyForm.actionType == 'edit'}">Update</c:when>
                                        <c:when test="${spotifyForm.actionType == 'delete'}">Delete</c:when>
                                        <c:otherwise>Save</c:otherwise>
                                      </c:choose>
                                    </button>
                                </div>
                                <div class="col-md-6 text-end">
                                    <a href="<c:url value='/spotify-pagination.do' />" class="btn btn-dark">Cancel</a>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
     </div>
</div>



