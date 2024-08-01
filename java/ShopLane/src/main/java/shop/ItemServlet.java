package shop;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class ItemServlet extends HttpServlet {
	
	private static final String url = "jdbc:mysql://localhost:3306/website";
    private static final String user = "root";
    private static final String pwd = "taneesha"; // Replace with your actual password

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoryId = request.getParameter("categoryId");
        System.out.println(categoryId);

        List<Item> items = new ArrayList<>();
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, pwd);
            String sql = "SELECT id, name, description, profile_url FROM item WHERE category_id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, categoryId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
            	int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                String image = resultSet.getString("profile_url");
                Item item = new Item(id, name, description, image, Integer.parseInt(categoryId));
                items.add(item);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Items: " + items);
        request.setAttribute("items", items);
        request.getRequestDispatcher("categories").forward(request, response);
    }
}