package shop.admin;

import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

public class DBSetupServlet extends HttpServlet {

	private static final String url = "jdbc:mysql://localhost:3306/website";
	private static final String username = "root";
	private static final String pwd = "taneesha";
	
	/*
	private static void createDB() throws Exception {
	  try (Connection conn = DriverManager.getConnection(url, username, pwd);
	       Statement stmt = conn.createStatement()) {
		// query to create a database, only if it does not already exist
		String query = "CREATE DATABASE IF NOT EXISTS website";
		stmt.executeUpdate(query);
	  }
	}
	*/
	
	private static void createAdmin(Statement stmt) throws Exception {
		String query = "CREATE TABLE IF NOT EXISTS admin (\r\n"
				+ "  id INT AUTO_INCREMENT PRIMARY KEY,\r\n"
				+ "  username VARCHAR(255) UNIQUE NOT NULL,\r\n"
				+ "  password VARCHAR(255) NOT NULL,\r\n"
				+ "  profile_url VARCHAR(255)\r\n"
				+ ");";
		stmt.executeUpdate(query);
	}
	
	private static void createUser(Statement stmt) throws Exception {
		String query = "CREATE TABLE IF NOT EXISTS user (\r\n"
				+ "  id INT AUTO_INCREMENT PRIMARY KEY,\r\n"
				+ "  email VARCHAR(255) UNIQUE NOT NULL,\r\n"
				+ "  password VARCHAR(255) NOT NULL,\r\n"
				+ "  first_name VARCHAR(255),\r\n"
				+ "  last_name VARCHAR(255),\r\n"
				+ "  shipping_address TEXT,\r\n"
				+ "  profile_url VARCHAR(255)\r\n"
				+ ");";
		stmt.executeUpdate(query);
	}
	
	private static void createCategory(Statement stmt) throws Exception {
		String query = "CREATE TABLE IF NOT EXISTS category (\r\n"
				+ "  id INT AUTO_INCREMENT PRIMARY KEY,\r\n"
				+ "  name VARCHAR(255) NOT NULL,\r\n"
				+ "  description TEXT,\r\n"
				+ "  profile_url VARCHAR(255)\r\n"
				+ ");";
		stmt.executeUpdate(query);
	}
	
	private static void createItem(Statement stmt) throws Exception {
		String query ="CREATE TABLE IF NOT EXISTS item (\r\n"
				+ "  id INT AUTO_INCREMENT PRIMARY KEY,\r\n"
				+ "  name VARCHAR(255) NOT NULL,\r\n"
				+ "  description TEXT,\r\n"
				+ "  category_id INT NOT NULL,\r\n"
				+ "  profile_url VARCHAR(255),\r\n"
				+ "  FOREIGN KEY (category_id) REFERENCES category(id)\r\n"
				+ ");";
		stmt.executeUpdate(query);
	}
	
	private static void createProduct(Statement stmt) throws Exception {
		String query = "CREATE TABLE IF NOT EXISTS product (\r\n"
				+ "  id INT AUTO_INCREMENT PRIMARY KEY,\r\n"
				+ "  name VARCHAR(255) NOT NULL,\r\n"
				+ "  description TEXT,\r\n"
				+ "  price DECIMAL(10, 2) NOT NULL,\r\n"
				+ "  item_id INT NOT NULL,\r\n"
				+ "  image_url VARCHAR(255),\r\n"
				+ "  FOREIGN KEY (item_id) REFERENCES item(id)\r\n"
				+ ");";
		stmt.executeUpdate(query);
	}
	
	private static void createInvoice(Statement stmt) throws Exception {
		String query = "CREATE TABLE IF NOT EXISTS invoice (\r\n"
				+ "  id INT AUTO_INCREMENT PRIMARY KEY,\r\n"
				+ "  user_id INT NOT NULL,\r\n"
				+ "  order_date DATETIME NOT NULL,\r\n"
				+ "  status VARCHAR(255) NOT NULL CHECK (status IN ('Pending', 'Paid', 'Cancelled')),  -- Modified line\r\n"
				+ "  total DECIMAL(10, 2) NOT NULL,\r\n"
				+ "  billing_address TEXT,\r\n"
				+ "  shipping_address TEXT,\r\n"
				+ "  payment_method VARCHAR(255),\r\n"
				+ "  profile_url VARCHAR(255),\r\n"
				+ "  FOREIGN KEY (user_id) REFERENCES user(id)\r\n"
				+ ");";
		stmt.executeUpdate(query);
	}
	
	private static void createCart(Statement stmt) throws Exception {
		String query = "CREATE TABLE IF NOT EXISTS cart (\r\n"
				+ "  id INT AUTO_INCREMENT PRIMARY KEY,\r\n"
				+ "  user_id INT NOT NULL,\r\n"
				+ "  product_id INT NOT NULL,\r\n"
				+ "  quantity INT NOT NULL,\r\n"
				+ "  profile_url VARCHAR(255),\r\n"
				+ "  FOREIGN KEY (user_id) REFERENCES user(id),\r\n"
				+ "  FOREIGN KEY (product_id) REFERENCES product(id)\r\n"
				+ ");";
		stmt.executeUpdate(query);
	}

	private static void createTables() throws Exception {
		try (Connection conn = DriverManager.getConnection(url, username, pwd);
				Statement stmt = conn.createStatement()) {
			// query to create a database, only if it does not already exist
			createAdmin(stmt);
			createUser(stmt);
			createCategory(stmt);
			createItem(stmt);
			createProduct(stmt);
			createInvoice(stmt);
			createCart(stmt);
			System.out.println("created db and tables");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			System.out.println(request.getContextPath());
			Class.forName("com.mysql.cj.jdbc.Driver");
			//createDB();
			createTables();
			response.getWriter().println("Database and tables created successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println(e);
			//response.getWriter().println("Error creating database: " + e.getMessage());
		}
	}
}