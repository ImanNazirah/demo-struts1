<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Testing</title>
    <tiles:insert name="header" />

</head>

<body class="bg-dark">
    <div id="layoutAuthentication">
        <div id="layoutAuthentication_content">
            <main>
                <tiles:insert name="body" />
            </main>
        </div>
        <div id="layoutAuthentication_footer">
            <tiles:insert name="footer" />
        </div>
    </div>
    <tiles:insert name="script" />

</body>


</html>