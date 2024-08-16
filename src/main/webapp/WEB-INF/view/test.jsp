<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<html>
<head>
    <title></title>
</head>
<body>
<h1><bean:write name="testForm" property="greeting" /></h1>
</body>
</html>
