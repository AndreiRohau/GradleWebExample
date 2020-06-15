<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 15.06.2020
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
    <h2>Result</h2>
    <h3>POST request forwarded to JSP</h3>
    ${requestScope.calculations}
    <br/>
    <%= (String) request.getAttribute ("calculations") %>

</body>
</html>
