<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            
            if (rolename == null) {
                rolename = (String) request.getAttribute("rolename");
            }
        %>
        <p>Bem vindo <%=username%>, Sua Função é : <b><%=rolename%></b></p>
        <p><a href="logout.jsp">Logout</a>
        <p><a href="./listUser">Listar Usuários</a>    
    </body>
</html>