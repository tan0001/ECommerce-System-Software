package shop.admin;

import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

public class RegisterServlet extends HttpServlet {

	private static final String url = "jdbc:mysql://localhost:3306/website";
	private static final String username = "root";
	private static final String pwd = "taneesha";	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String name = request.getParameter("username");
			String password = request.getParameter("password");
			createAdmin(name,password);
			response.getWriter().write("Record added successfully");
            System.out.println("Record added successfull");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println(e);
		}
		response.sendRedirect("index.jsp");
	}
	
	private void createAdmin(String name, String password) throws Exception {
		try (Connection con = DriverManager.getConnection(url, username, pwd)) {
	        String query = "INSERT INTO admin (username, password) VALUES (?, ?)";
	        try (PreparedStatement pst = con.prepareStatement(query)) {
	            pst.setString(1, name);
	            pst.setString(2, password);
	            pst.executeUpdate();
	        }
	    }
	}
}