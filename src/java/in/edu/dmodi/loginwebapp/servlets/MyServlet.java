package in.edu.dmodi.loginwebapp.servlets;

import in.edu.dmodi.loginwebapp.util.CredentialStore;
import java.sql.PreparedStatement;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    
    protected void service(HttpServletRequest request, HttpServletResponse response) {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rolename = request.getParameter("rolename");
        
        System.out.println("MyServlet service method: " + username + ", RoleName: " + rolename);
        
        // No use if we do sendRedirect, with RequestDispatcher this will be retrieved.
        request.setAttribute("username", username); 
        request.setAttribute("rolename", rolename);
        
        boolean isValidUser = validateUserOnDatabase(username, password, rolename);
        //boolean isValidUser = validateUserOnMemory(username, password, rolename);
        
        try {
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            
            if (isValidUser) {
                RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
                rd.forward(request, response);
            }
            else{
                out.print("Sorry Username or Password error.");
                //response.sendRedirect("error.jsp");
                RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
                rd.include(request, response);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("................Done in servlet................");
    }
    
        public boolean validateUserOnDatabase(String user, String pwd, String role){
        
        String driverName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://192.168.106.69:3306/deepak_dummy";
        String dbuser = "root";
        String dbpassword = "root";
        String sql = "select USERNAME,ROLE_NAME from USER_DETAILS where USERNAME=? and PASSWORD=? and ROLE_NAME=?";
        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(url, dbuser, dbpassword);
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pwd);
            ps.setString(3, role);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch(Exception sqe) {
            out.println("Error while fetching Record : " + sqe);
        }
        finally {
            try {
                rs.close();
                ps.close();
            }catch(Exception e){}
        }
        return false;
    }
    
    public boolean validateUserOnMemory(String user, String pwd, String role) {
        return CredentialStore.containsUser(user, pwd, role);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
}
