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
  <br/>

  <form method="post" action="pathToThisServlet" >
    <input hidden type="text" name="strategy" value="postMultiply"/>
    <input type="number" name="valueToMultiply" value="10"/>
    <button type="submit" >Go to result jsp page</button>
  </form>

  <hr/>
  <br/>
  <br/>
  <h3>SMS form</h3>
  <form method="post" action="pathToThisServlet" >
    <input hidden type="text" name="strategy" value="sendSMS"/>
    <label>
      Send to: <input type="tel" pattern="[0-9]{12}" title="12 digits"name="toPhoneNumber" value="" required style="margin: 5px"/> <br/>
    </label>
    <label>
      Text: <br/> <textarea name="text" style="height: 100px; width: 220px; margin: 5px" required></textarea><br/>
    </label>

    <p><%=(request.getAttribute("isSent") == null) ? "" :
            ((Boolean) request.getAttribute("isSent")) ? "SMS was sent" : "SMS was not sent"%></p>

    <button type="submit" >Send Email</button>
  </form>



  </body>
</html>
