package shop;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class RegisterServlet extends HttpServlet {
    
    private static final String url = "jdbc:mysql://localhost:3306/website";
    private static final String user = "root";
    private static final String pwd = "taneesha"; // Replace with your actual password

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String email = request.getParameter("email");
    	String password = request.getParameter("password");
    	String first_name = request.getParameter("first");
    	String last_name = request.getParameter("last");
    	String address = request.getParameter("address");
    	String image = request.getParameter("image");
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
            registerUser(email, password, first_name, last_name, address, image);
            response.getWriter().write("User registered successfully");
            System.out.println("User registered successfull");
            response.sendRedirect("login.jsp");
          } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Error adding product: " + e.getMessage());
          }
    }
    
    private void registerUser(String email, String password, String first, String last, String address, String image) throws Exception {
        try (Connection con = DriverManager.getConnection(url, user, pwd)) {
            String query = "INSERT INTO user (email, password, first_name, last_name, shipping_address, profile_url) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setString(1, email);
                pst.setString(2, password);
                pst.setString(3, first);
                pst.setString(4, last);
                pst.setString(5, address);
                pst.setString(6, image);
                pst.executeUpdate();
            }
        }
    }
}