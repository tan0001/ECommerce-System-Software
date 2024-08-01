package shop;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryServlet extends HttpServlet {
	
	private static final String url = "jdbc:mysql://localhost:3306/website";
    private static final String user = "root";
    private static final String pwd = "taneesha"; // Replace with your actual password

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Change this to your DB driver class if needed
            Connection conn = DriverManager.getConnection(url, user, pwd);
            String query = "SELECT id, name, description, profile_url FROM category";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
            	int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String image = rs.getString("profile_url");
                Category category = new Category(id, name, description, image);
                categories.add(category);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("categories", categories);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}