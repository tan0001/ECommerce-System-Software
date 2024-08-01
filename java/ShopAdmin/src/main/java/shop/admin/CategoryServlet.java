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

public class CategoryServlet extends HttpServlet {

	private static final String url = "jdbc:mysql://localhost:3306/website";
    private static final String user = "root";
    private static final String pwd = "taneesha";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String action = request.getParameter("action");
        
        if ("displayCategory".equals(action)) {
            List<Category> categories = new ArrayList<>();
            try {
            	Class.forName("com.mysql.cj.jdbc.Driver");
                String query = "SELECT id, name, description, profile_url FROM category";
                try (Connection con = DriverManager.getConnection(url, user, pwd);
                		Statement stmt = con.createStatement();
                     ResultSet rs = stmt.executeQuery(query)) {
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String name = rs.getString("name");
                        String description = rs.getString("description");
                        String url = rs.getString("profile_url");
                        Category category = new Category(id, name, description, url);
                        categories.add(category);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } 
            } catch (Exception e) {
				e.printStackTrace();
			}

            request.setAttribute("categories", categories);
            RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp?action=displayCategory");
            dispatcher.forward(request, response);
        } /*else if ("removeCategory".equals(action)) {
            List<Category> categories = new ArrayList<>();
            try {
            	Class.forName("com.mysql.cj.jdbc.Driver");
            	String query = "DELETE FROM category WHERE id=?";
                try (Connection con = DriverManager.getConnection(url, user, pwd);
                		PreparedStatement pst = con.prepareStatement(query);) {
                	pst.setInt(1, id);
                    pst.executeUpdate();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            request.setAttribute("categories", categories);
            RequestDispatcher dispatcher = request.getRequestDispatcher("removeCategory.jsp");
            dispatcher.forward(request, response);
        }*/ else if ("addCategory".equals(action)) {
            RequestDispatcher dispatcher;
            switch (action) {
                case "addCategory":
                    dispatcher = request.getRequestDispatcher("addCategory.jsp");
                    break;
                default:
                    dispatcher = request.getRequestDispatcher("viewCategory.jsp");
                    break;
            }
            dispatcher.include(request, response);
        }            
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("addCategory".equals(action)) {
            String name = request.getParameter("name");
            String description = request.getParameter("description");

            try {
                //int idParam = Integer.parseInt(id);
                Class.forName("com.mysql.cj.jdbc.Driver");
                addCategory(name, description);
                response.getWriter().write("Category added successfully");
                System.out.println("Category added successfull");
            } catch (NumberFormatException e) {
                response.getWriter().write("Invalid ID format");
            } catch (Exception e) {
                response.getWriter().write("Error adding category: " + e.getMessage());
            }

            response.sendRedirect("category?action=displayCategory");
        } /*else if ("removeCategory".equals(action)) {
            try {
                int idParam = Integer.parseInt(id);
                Class.forName("com.mysql.cj.jdbc.Driver");
                removeCategory(idParam);
                response.getWriter().write("Category removed successfully");
            } catch (NumberFormatException e) {
                response.getWriter().write("Invalid ID format");
            } catch (Exception e) {
                response.getWriter().write("Error removing category: " + e.getMessage());
            }

            response.sendRedirect("category?action=displayCategory");
        }*/
    }

    private void addCategory(String name, String description) throws Exception {
        try (Connection con = DriverManager.getConnection(url, user, pwd)) {
            String query = "INSERT INTO category (name, description) VALUES (?, ?)";
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setString(1, name);
                pst.setString(2, description);
                pst.executeUpdate();
            }
        }
    }
}