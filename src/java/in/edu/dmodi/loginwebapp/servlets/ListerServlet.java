/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.edu.dmodi.loginwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thiago
 */
public class ListerServlet extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) {
        
        try {
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            
            // Recuperação dos usuários
            out.print("<b>Listagem de Usuário não Implementada!</b>");
            
            RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
            rd.include(request, response);
        } 
        catch (IOException ex) {
            Logger.getLogger(ListerServlet.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (ServletException ex) {
            Logger.getLogger(ListerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
