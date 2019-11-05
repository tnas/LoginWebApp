package in.edu.dmodi.loginwebapp.servlets;

import in.edu.dmodi.loginwebapp.util.CredentialStore;
import java.sql.PreparedStatement;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//This Servlet is without using Annotation
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) {
        String user = request.getParameter("userid");
        String pwd = request.getParameter("pwd");
        String rolename = request.getParameter("rolename");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        boolean isSuccess = false;
        
        try {
            //int i = this.addUserDataBase(user, pwd, rolename, fname, lname, email);
            int i = this.addUserMemory(user, pwd, rolename, fname, lname, email);
            if (i > 0) {
                System.out.println("User is successfully added to System.");
                isSuccess = true;
            } else {
                System.out.println("User Addition is Failed.");
            }
        } catch (Exception sqe) {
            out.println("Error while Inserting Record : " + sqe);
        } finally {
            try {
                rs.close();
                st.close();
            } catch (Exception e) {
            }
        }

        try {
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            if (isSuccess) {
                //response.sendRedirect("welcome.jsp");
                request.getSession().setAttribute("username", user);
                request.getSession().setAttribute("rolename", rolename);
                RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
                rd.forward(request, response);
            } else {
                out.print("Sorry Username addition failed.");
                //response.sendRedirect("error.jsp");
                RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
                rd.include(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int addUserMemory(String user, String pwd, String rolename, String fname, String lname, String email) {
        return CredentialStore.addUser(user, pwd, rolename, fname, lname, email);
    }
    
    private int addUserDataBase(String user, String pwd, String rolename, String fname, String lname, String email) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://192.168.106.69:3306/deepak_dummy", "root", "root");
        st = con.createStatement();
        int i = st.executeUpdate("INSERT INTO USER_DETAILS (USERNAME,PASSWORD,ROLE_NAME,FIRST_NAME,LAST_NAME,EMAIL) VALUES ('" + user + "','" + pwd + "','" + rolename + "','" + fname + "','" + lname + "','" + email + "')");
        return i;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
