<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Logout</title>
    </head>
    <body>
        <% session.invalidate();%>
        <p>You have been successfully logout.</p>

        <br>Go to Home Page <a href="home.jsp">Home</a>
    </body>
</html>