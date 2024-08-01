package shop.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProductServlet extends HttpServlet {

	private static final String url = "jdbc:mysql://localhost:3306/website";
    private static final String user = "root";
    private static final String pwd = "taneesha";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String action = request.getParameter("action");
        
        if ("displayProduct".equals(action)) {
            List<Product> products = new ArrayList<>();
            try {
            	Class.forName("com.mysql.cj.jdbc.Driver");
                String query = "SELECT id, name, description, price, item_id, image_url FROM product";
                try (Connection con = DriverManager.getConnection(url, user, pwd);
                		Statement stmt = con.createStatement();
                     ResultSet rs = stmt.executeQuery(query)) {
                    while (rs.next()) {
                    	int id = rs.getInt("id");
                        String name = rs.getString("name");
                        String description = rs.getString("description");
                        int price = rs.getInt("price");
                        int item = rs.getInt("item_id");
                        String url = rs.getString("image_url");
                        Product product = new Product(id, name, description, price, item, url);
                        products.add(product);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } 
            } catch (Exception e) {
				e.printStackTrace();
			}

            request.setAttribute("products", products);
            RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp?action=displayProduct");
            dispatcher.forward(request, response);
        } else if ("addProduct".equals(action)) {
            RequestDispatcher dispatcher;
            switch (action) {
                case "addProduct":
                    dispatcher = request.getRequestDispatcher("addProduct.jsp");
                    break;
                default:
                    dispatcher = request.getRequestDispatcher("viewProduct.jsp");
                    break;
            }
            dispatcher.include(request, response);
        }            
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("addProduct".equals(action)) {
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            int price = Integer.parseInt(request.getParameter("price"));
            int item = Integer.parseInt(request.getParameter("item"));

            try {
                //int idParam = Integer.parseInt(id);
                Class.forName("com.mysql.cj.jdbc.Driver");
                addProduct(name, description, price, item);
                response.getWriter().write("Product added successfully");
                System.out.println("Product added successfull");
            } catch (Exception e) {
                response.getWriter().write("Error adding product: " + e.getMessage());
            }

            response.sendRedirect("product?action=displayProduct");
        }
    }

    private void addProduct(String name, String description, int price, int item) throws Exception {
        try (Connection con = DriverManager.getConnection(url, user, pwd)) {
            String query = "INSERT INTO product (name, description, price, item_id) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setString(1, name);
                pst.setString(2, description);
                pst.setInt(3, price);
                pst.setInt(4, item);
                pst.executeUpdate();
            }
        }
    }
}