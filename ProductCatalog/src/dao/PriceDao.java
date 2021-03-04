package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.DatabaseConnection;
import model.Price;

public class PriceDao {
	DatabaseConnection databaseConnection = new DatabaseConnection();
	Connection connection;
	Statement stmt;
	PreparedStatement pstmt;

	public PriceDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Price addPriceForProduct(Price price) {
		connection = databaseConnection.createConnection();
		try {
			pstmt = connection
					.prepareStatement("insert into prices (price,product_id,vaild_from,valid_to) values(?,?,?,?)");
			pstmt.setFloat(1, price.getPrice());
			pstmt.setInt(2, price.getProductId());
			pstmt.setString(3, price.getValidFrom());
			pstmt.setString(4, price.getValidTo());
			if (pstmt.executeUpdate() == 0)
				System.out.println("Error While Adding New Price For Product!");
			else
				System.out.println("Successfully Added New Price for Product");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return price;
	}

	public List<Price> getPrices() {
		Price price;
		List<Price> prices = new ArrayList<>();
		connection = databaseConnection.createConnection();
		try {
			stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("Select * from prices");
			if (resultSet.next() == false)
				System.out.println("Error While Fetching all Prices For Products");
			else {
				do {
					price = new Price();
					price.setPriceId(resultSet.getInt("id"));
					price.setPrice(resultSet.getFloat("price"));
					price.setProductId(resultSet.getInt("product_id"));
					price.setValidFrom(resultSet.getString("vaild_from"));
					price.setValidTo(resultSet.getString("valid_to"));
					prices.add(price);
				} while (resultSet.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prices;
	}

	public List<Price> getPricesOfProduct(int productId) {
		Price price;
		List<Price> prices = new ArrayList<>();
		connection = databaseConnection.createConnection();
		try {
			stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("Select * from prices where product_id=" + productId);
			if (resultSet.next() == false)
				System.out.println("Error While Fetching all Prices For Product");
			else {
				do {
					price = new Price();
					price.setPriceId(resultSet.getInt("id"));
					price.setPrice(resultSet.getFloat("price"));
					price.setProductId(resultSet.getInt("product_id"));
					price.setValidFrom(resultSet.getString("vaild_from"));
					price.setValidTo(resultSet.getString("valid_to"));
					prices.add(price);
				} while (resultSet.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prices;
	}

	public void deletePriceOfProduct(int priceId) {
		Price price = new Price();
		price.setPriceId(priceId);
		connection = databaseConnection.createConnection();
		try {
			pstmt = connection.prepareStatement("delete from prices WHERE id=?");
			pstmt.setInt(1, price.getPriceId());
			if (pstmt.executeUpdate() == 0)
				System.out.println("Error While Deleting!");
			else
				System.out.println("Deleted successfully!");
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
