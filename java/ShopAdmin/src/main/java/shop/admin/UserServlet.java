package shop.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet {

	private static final String url = "jdbc:mysql://localhost:3306/website";
    private static final String user = "root";
    private static final String pwd = "taneesha";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String action = request.getParameter("action");
        
        if ("displayUser".equals(action)) {
            List<User> users = new ArrayList<>();
            try {
            	Class.forName("com.mysql.cj.jdbc.Driver");
                String query = "SELECT id, email, first_name, last_name, shipping_address, profile_url FROM user";
                try (Connection con = DriverManager.getConnection(url, user, pwd);
                		Statement stmt = con.createStatement();
                     ResultSet rs = stmt.executeQuery(query)) {
                    while (rs.next()) {
                    	int id = rs.getInt("id");
                        String email = rs.getString("email");
                        String first = rs.getString("first_name");
                        String last = rs.getString("last_name");
                        String address = rs.getString("shipping_address");
                        String url = rs.getString("profile_url");
                        User user = new User(id, email, first, last, address, url);
                        users.add(user);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } 
            } catch (Exception e) {
				e.printStackTrace();
			}

            request.setAttribute("users", users);
            RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp?action=displayUser");
            dispatcher.forward(request, response);
        }            
    }

}