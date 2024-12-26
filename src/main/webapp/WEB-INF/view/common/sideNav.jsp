<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="layoutSidenav_nav">
    <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
        <div class="sb-sidenav-menu">
            <div class="nav">
                <div class="sb-sidenav-menu-heading">Core</div>

                <a href="<c:url value='/dashboard.do' />" class="nav-link">
                    <div class="sb-nav-link-icon">
                        <i class="fas fa-tachometer-alt"></i>
                    </div>
                    Dashboard
                </a>

                <a href="<c:url value='/spotify-list.do' />" class="nav-link">
                    <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                    Spotify List
                </a>

                <a href="<c:url value='/spotify-pagination.do' />" class="nav-link">
                    <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                    Spotify List V2
                </a>

            </div>
        </div>
        <div class="sb-sidenav-footer">
            <div class="small">Logged in as:</div>
            <%
                String username = (String) session.getAttribute("loggedInUser");
            %>
             <span>
                 <%= username != null ? username : "Guest" %>
             </span>
        </div>
    </nav>
</div>