<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 15.06.2020
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Index</title>
  </head>
  <body>

  <h2>Index</h2>
  <form action="pathToThisServlet" >
    <input type="number" name="valueToMultiply" value="10"/>
    <button type="submit" >Run calculations</button>
  </form>
  <hr/>

  <form method="post" action="pathToThisServlet" >
    <input type="number" name="valueToMultiply" value="10"/>
    <button type="submit" >Go to result jsp page</button>
  </form>


  </body>
</html>
