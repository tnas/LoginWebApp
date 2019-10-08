package in.edu.dmodi.loginwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Not Used
//This Servlet is using Annotation
@WebServlet(
        description = "LoginServlet will check with DB for UserValidation",
        urlPatterns = { "/LoginServlet" },
        initParams = {
            @WebInitParam(name = "dbUser", value = "root", description = "Mysql DB User"),
            @WebInitParam(name = "dbPwd", value = "root", description = "Mysql DB Password")
        })
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("*********** LoginServlet in Servlet service method: "+username);
        
        request.setAttribute("username",username); //No use if we do sendRedirect,
        if (username.equals("kumar") && password.equals("kumar")) {
            RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
            rd.forward(request,response);
        }
        else{
            out.print("Sorry Username or Password error."); //This message will be printed in error.jsp and hence in home.jsp.
            RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
            rd.include(request,response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
