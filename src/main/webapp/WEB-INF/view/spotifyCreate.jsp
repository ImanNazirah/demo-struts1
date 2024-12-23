<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="container-fluid px-4">
     <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-7">
                <div class="card shadow-lg border-0 rounded-lg mt-5">
                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Create New Spotify Data</h3></div>
                    <div class="card-body">
                        <form action="<c:url value='/spotify-create.do' />" method="post">
                            <div class="row mb-3">
                                <div class="col-md-6">
                                    <div class="form-floating mb-3 mb-md-0">
                                        <input name="artistName" class="form-control" id="inputArtistName" type="text" placeholder="Enter input" />
                                        <label for="inputArtistName">Artist name</label>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-floating">
                                        <input name="trackName" class="form-control" id="inputTrackName" type="text" placeholder="Enter input" />
                                        <label for="inputTrackName">Track name</label>
                                    </div>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-md-6">
                                    <div class="form-floating mb-3 mb-md-0">
                                        <input name="genre" class="form-control" id="inputGenre" type="text" placeholder="Enter input" />
                                        <label for="inputGenre">Genre</label>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-floating mb-3 mb-md-0">
                                        <input name="popularity" class="form-control" id="inputPopularity" type="text" placeholder="Enter input" />
                                        <label for="inputPopularity">Popularity</label>
                                    </div>
                                </div>
                            </div>
                            <div class="mt-4 mb-2">
                                <button type="submit" class="btn btn-primary">Save</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
     </div>
</div>



