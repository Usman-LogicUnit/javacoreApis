package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.DatabaseConnection;
import model.Product;

public class ProductDao {
	DatabaseConnection databaseConnection ;
	Connection connection;
	Statement stmt;
	PreparedStatement pstmt;

	
	
	public ProductDao() {
		super();
		// TODO Auto-generated constructor stub
		databaseConnection = new DatabaseConnection();
		connection = databaseConnection.createConnection();
	}

	public Product addNewProduct(Product product) {
		connection = databaseConnection.createConnection();
		try {
			pstmt = connection.prepareStatement("insert into products (name,availability,manf_date,exp_date) values(?,?,?,?)");
			pstmt.setString(1, product.getProductName());
			pstmt.setString(2, product.getAvailability());
			pstmt.setString(3,product.getManufactureDate());
			pstmt.setString(4,product.getExpireDate());
			if (pstmt.executeUpdate() == 0)
				System.out.println("Error While Adding New Product!");
			else
				System.out.println("Successfully Added New Product");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	public List<Product> getallProducts() {
		Product product;
		List<Product> products=new ArrayList<>();
		connection = databaseConnection.createConnection();
		try {
			stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("Select * from products");
			if (resultSet.next() == false)
				System.out.println("Error While Fetching all products");
			else {
				System.out.println(resultSet);
				do {
					product=new Product();
					product.setProductId(resultSet.getInt("id"));
					product.setProductName(resultSet.getString("name"));
					product.setAvailability(resultSet.getString("availability"));
					product.setManufactureDate(resultSet.getString("manf_date"));
					product.setExpireDate(resultSet.getString("exp_date"));	
					products.add(product);
				} while (resultSet.next());}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	
	public List<Product> getProductById(int id) {
		Product product;
		List<Product> products=new ArrayList<>();
		connection = databaseConnection.createConnection();
		try {
			stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("Select * from products where id="+id);
			if (resultSet.next() == false)
				System.out.println("Error While Fetching product");
			else {
				System.out.println(resultSet);
				do {
					product=new Product();
					product.setProductId(resultSet.getInt("id"));
					product.setProductName(resultSet.getString("name"));
					product.setAvailability(resultSet.getString("availability"));
					product.setManufactureDate(resultSet.getString("manf_date"));
					product.setExpireDate(resultSet.getString("exp_date"));	
					products.add(product);
				} while (resultSet.next());}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	public Product updateProduct(Product product) {
		connection = databaseConnection.createConnection();
		try {
			String updateQuery="update products SET name=?,availability=?,manf_date=?,exp_date=? where id=?";
			pstmt = connection.prepareStatement(updateQuery);
			pstmt.setString(1,product.getProductName());
			pstmt.setString(2, product.getAvailability());
			pstmt.setString(3,product.getManufactureDate());
			pstmt.setString(4,product.getExpireDate());
			pstmt.setInt(5, product.getProductId());
			if (pstmt.executeUpdate() == 0)
				System.out.println("Error While Updating!");
			else
				System.out.println("Product Updated successfully!");
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}
	

	public void deleteProduct(int id) {
		Product product = new Product();
		product.setProductId(id);
		connection = databaseConnection.createConnection();
		try {
			pstmt = connection.prepareStatement("delete from products WHERE id=?");
			pstmt.setInt(1, product.getProductId());
			if (pstmt.executeUpdate() == 0)
				System.out.println("Error While Deleting!");
			else
				System.out.println("Deleted successfully!");
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		
	}
}
