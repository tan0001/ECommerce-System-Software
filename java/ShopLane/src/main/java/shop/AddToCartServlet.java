package shop;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.http.*;
import jakarta.servlet.*;

public class AddToCartServlet extends HttpServlet {
	
	private static final String url = "jdbc:mysql://localhost:3306/website";
    private static final String user = "root";
    private static final String pwd = "taneesha";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userId = (Integer) session.getAttribute("userId");
        int productId = Integer.parseInt(request.getParameter("productId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, pwd);
            String sql = "INSERT INTO cart (user_id, product_id, quantity) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setInt(2, productId);
            ps.setInt(3, quantity);
            ps.executeUpdate();
            
            System.out.println("item added to cart");
            
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("cart");
    }
}
