package shop;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class LoginServlet extends HttpServlet {
    
    private static final String url = "jdbc:mysql://localhost:3306/website";
    private static final String user = "root";
    private static final String pwd = "taneesha"; // Replace with your actual password

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            handleLogin(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp"); // Redirect to error page on exception
        }
    }

    private void handleLogin(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = validateLogin(username, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("username", user.getEmail());
            session.setAttribute("userId", user.getId());
            session.setAttribute("user", user);
            response.sendRedirect("index.jsp"); // Redirect to profile servlet
        } else {
            request.setAttribute("errorMessage", "Invalid credentials");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    private User validateLogin(String username, String password) throws SQLException {
        String query = "SELECT id, first_name, last_name, shipping_address, profile_url FROM user WHERE email = ? AND password = ?";
        ResultSet rs = null;
        try (Connection conn = DriverManager.getConnection(url, user, pwd);
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String first = rs.getString("first_name");
                String last = rs.getString("last_name");
                String address = rs.getString("shipping_address");
                String image = rs.getString("profile_url");
                return new User(id, username, password, first, last, address, image); // Return User object if found
            }
        } finally {
            if (rs != null) rs.close();
        }
        return null; // Return null if user not found
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            String username = (String) session.getAttribute("username");

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection(url, user, pwd);
                String query = "SELECT id, email, password, first_name, last_name, shipping_address, profile_url FROM user WHERE email = ?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, username);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    int id = rs.getInt("id");
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    String first_name = rs.getString("first_name");
                    String last_name = rs.getString("last_name");
                    String shipping_address = rs.getString("shipping_address");
                    String image = rs.getString("profile_url");
                    User user = new User(id, email, password, first_name, last_name, shipping_address, image);
                    request.setAttribute("user", user);
                    request.getRequestDispatcher("profile.jsp").forward(request, response);
                }

                rs.close();
                stmt.close();
                conn.close();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}