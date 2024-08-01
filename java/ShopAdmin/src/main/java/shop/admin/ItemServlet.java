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

public class ItemServlet extends HttpServlet {

	private static final String url = "jdbc:mysql://localhost:3306/website";
    private static final String user = "root";
    private static final String pwd = "taneesha";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String action = request.getParameter("action");
        
        if ("displayItem".equals(action)) {
            List<Item> items = new ArrayList<>();
            try {
            	Class.forName("com.mysql.cj.jdbc.Driver");
                String query = "SELECT id, name, description, category_id, profile_url FROM item";
                try (Connection con = DriverManager.getConnection(url, user, pwd);
                		Statement stmt = con.createStatement();
                     ResultSet rs = stmt.executeQuery(query)) {
                    while (rs.next()) {
                    	int id = rs.getInt("id");
                        String name = rs.getString("name");
                        String description = rs.getString("description");
                        int category = rs.getInt("category_id");
                        String url = rs.getString("profile_url");
                        Item item = new Item(id, name, description, category, url);
                        items.add(item);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } 
            } catch (Exception e) {
				e.printStackTrace();
			}

            request.setAttribute("items", items);
            RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp?action=displayItem");
            dispatcher.forward(request, response);
        } else if ("addItem".equals(action)) {
            RequestDispatcher dispatcher;
            switch (action) {
                case "addItem":
                    dispatcher = request.getRequestDispatcher("addItem.jsp");
                    break;
                default:
                    dispatcher = request.getRequestDispatcher("viewItem.jsp");
                    break;
            }
            dispatcher.include(request, response);
        }            
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("addItem".equals(action)) {
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            int category = Integer.parseInt(request.getParameter("category"));

            try {
                //int idParam = Integer.parseInt(id);
                Class.forName("com.mysql.cj.jdbc.Driver");
                addItem(name, description, category);
                response.getWriter().write("Item added successfully");
                System.out.println("Item added successfull");
            } catch (Exception e) {
                response.getWriter().write("Error adding item: " + e.getMessage());
            }

            response.sendRedirect("item?action=displayItem");
        }
    }

    private void addItem(String name, String description, int category) throws Exception {
        try (Connection con = DriverManager.getConnection(url, user, pwd)) {
            String query = "INSERT INTO item (name, description, category_id) VALUES (?, ?, ?)";
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setString(1, name);
                pst.setString(2, description);
                pst.setInt(3, category);
                pst.executeUpdate();
            }
        }
    }
}