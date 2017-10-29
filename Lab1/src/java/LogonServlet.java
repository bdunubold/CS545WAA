/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Khandaa
 */
@WebServlet(urlPatterns = {"/LogonServlet"})
public class LogonServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
                out.println("<head>");
                    out.println("<title>Servlet</title>");
                out.println("</head>");
                out.println("<body>");
                    out.println("<h1>Servlet context path " + request.getContextPath() + "</h1>");
                out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");


        if ("user".equals(request.getParameter("username"))
                && "pass".equals(request.getParameter("password"))) {
            out.println("Logged in successfully.");
        } else {
            if (!"".equals(request.getParameter("username")) || !"".equals(request.getParameter("password"))) {
                out.println("Given information is wrong.");
            }
            out.println("<form method=GET action=LogonServlet>");
                out.println("Username=<input type=text name=username> <br>");
                out.println("Password=<input type=text name=password>");
                    out.println("<input type=submit value='Submit'>");
            out.println("</form>");
        }
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                //have not done anything yet

    }

    @Override
    public String getServletInfo() {
        return "Login servlet.";
    }

}
