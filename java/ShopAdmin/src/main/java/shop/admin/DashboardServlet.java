package shop.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String url = "jdbc:mysql://localhost:3306/website";
    private static final String user = "root";
    private static final String pwd = "taneesha"; // Replace with your actual password


    @Override
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

    	    boolean isValidLogin = validateLogin(username, password);

    	    if (isValidLogin) {
    	    	HttpSession session = request.getSession();
                session.setAttribute("username", username);
                response.sendRedirect("dashboard.jsp");
    	    } else {
    	      request.setAttribute("errorMessage", "Invalid credentials");
    	      request.getRequestDispatcher("index.jsp").forward(request, response);
    	    }
    	  }

    	  private boolean validateLogin(String username, String password) throws SQLException {
    	    String query = "SELECT * FROM admin WHERE username = ? AND password = ?";
    	    ResultSet rs = null;
    	    try (Connection conn = DriverManager.getConnection(url, user, pwd);
    	         PreparedStatement ps = conn.prepareStatement(query)) {
    	      ps.setString(1, username);
    	      ps.setString(2, password);
    	      rs = ps.executeQuery();
    	      return rs.next();
    	    } finally {
    	      if (rs != null) {
				rs.close();
			}
    	    }
    	  }


    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
