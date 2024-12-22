<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Testing</title>
    <tiles:insert name="header" />

</head>

<body class="sb-nav-fixed">

    <tiles:insert name="navBar" />

    <div id="layoutSidenav">

        <tiles:insert name="sideNav" />

        <div id="layoutSidenav_content">
            <main>
                <tiles:insert name="body" />
            </main>
            <tiles:insert name="footer" />
        </div>

    </div>

    <tiles:insert name="script" />
    
</body>

</html>