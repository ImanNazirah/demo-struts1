<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<div class="container-fluid px-4">
    <h1 class="mt-4">
        <bean:write name="testForm" property="greeting" />
    </h1>
</div>