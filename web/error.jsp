<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Login Error</title>
    </head>
    <body>
        <center><p style="color:red">Sorry, your record is not available.</p></center>
            <%
                getServletContext().getRequestDispatcher("/home.jsp").include(request, response);
            %>
    </body>
</html>