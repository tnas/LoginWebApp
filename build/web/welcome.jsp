<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Welcome</title>
    </head>
    <body>
        <%
            System.out.println("Inside Welcome page...........");
            String username = (String) session.getAttribute("username");
            String rolename = (String) session.getAttribute("rolename");

            if (username == null) {
                System.out.println("Username is null from session.");
                username = (String) request.getAttribute("username");
                if (username == null) {
                    System.out.println("Username is null from request. If request comes from Servlet, then null value");
                }
            }
        %>
        <p>Welcome <%=username%>, Your RoleName is : <b><%=rolename%></b></p>
        <p><a href="logout.jsp">Logout</a>
    </body>
</html>