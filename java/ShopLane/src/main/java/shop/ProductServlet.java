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

public class ProductServlet extends HttpServlet {
	
	private static final String url = "jdbc:mysql://localhost:3306/website";
    private static final String user = "root";
    private static final String pwd = "taneesha"; // Replace with your actual password

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String itemId = request.getParameter("itemId");
        System.out.println(itemId);

        List<Product> products = new ArrayList<>();
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, pwd);
            String sql = "SELECT id, name, description, price, image_url FROM product WHERE item_id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, itemId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
            	int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                int price = resultSet.getInt("price");
                String image = resultSet.getString("image_url");
                Product product = new Product(id, name, description, price, image, Integer.parseInt(itemId));
                products.add(product);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Products: " + products);
        request.setAttribute("products", products);
        request.getRequestDispatcher("items").forward(request, response);
    }
}