package shop;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartServlet extends HttpServlet {

    private static final String url = "jdbc:mysql://localhost:3306/website";
    private static final String user = "root";
    private static final String pwd = "taneesha"; // Replace with your actual password

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	int userId = (Integer) session.getAttribute("userId");
        List<CartItem> cartItems = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, pwd);
            String query = "SELECT c.id, p.name, p.description, p.price, p.image_url, c.quantity FROM cart c JOIN product p ON c.product_id = p.id WHERE c.user_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("c.id");
                String name = rs.getString("p.name");
                String description = rs.getString("p.description");
                int price = rs.getInt("p.price");
                String image = rs.getString("p.image_url");
                int quantity = rs.getInt("c.quantity");
                CartItem cartItem = new CartItem(id, name, description, price, image, quantity);
                cartItems.add(cartItem);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        
        request.setAttribute("cartItems", cartItems);
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }
}