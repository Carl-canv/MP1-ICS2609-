/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;

/**
 *
 * @author Granbell
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private String url;
    private String driver;
    private String username;
    private String password;
    private ArrayList<User> users;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        users = new ArrayList();
        driver = config.getInitParameter("dbdriver");
        url = config.getInitParameter("dbURL");
        username = config.getInitParameter("dbusername");
        password = config.getInitParameter("dbpassword");

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        try {
            Class.forName(driver);

            Connection con = DriverManager.getConnection(url, username, password);

            Statement stmt = con.createStatement();
            String query = "SELECT * FROM LOGIN";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                users.add(new User(rs.getString("EMAIL").trim(), rs.getString("PASSWORD").trim(), rs.getString("ROLE").trim()));
            }

            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException | ClassNotFoundException sqle) {
            sqle.printStackTrace();
        }

        for (User p : users) {
            if (p.getEmail().equals(user) && p.getPassword().equals(pass)) {
                String role = p.getRole(); 
                String name = p.getEmail();
                HttpSession session = request.getSession();

                session.setAttribute("user", name);
                session.setAttribute("role", role);
                response.sendRedirect("success.jsp");

                break;
            } else if (p.getEmail().equals(user)) {
                if (pass.equals("")) {
                    response.sendRedirect("error_2.jsp");
                }
            } else if (p.getPassword().equals(pass)) {
                if (user.equals("")) {
                   response.sendRedirect("error_1.jsp");
                }
            } else {
                response.sendRedirect("error_3.jsp");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
