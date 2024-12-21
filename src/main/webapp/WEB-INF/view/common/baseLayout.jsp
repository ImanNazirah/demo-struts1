<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Testing</title>
    <tiles:insert name="header" />

</head>

<body>

    <!-- Navbar -->
    <tiles:insert name="navBar" />

    <!-- Sidebar content -->
    <div id="layoutSidenav">

        <tiles:insert name="sideNav" />

        <div id="layoutSidenav_content">
            <main>
                <tiles:insert name="body" />
            </main>
            <tiles:insert name="footer" />
        </div>

    </div>

    <!-- SB Admin JavaScript (CDN) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://startbootstrap.github.io/startbootstrap-sb-admin/js/scripts.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    
</body>

</html>