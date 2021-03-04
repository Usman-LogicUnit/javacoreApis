package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.DatabaseConnection;
import model.Vendor;

public class VendorDao {
	DatabaseConnection databaseConnection = new DatabaseConnection();
	Connection connection;
	Statement stmt;
	PreparedStatement pstmt;

	public List<Vendor> getVendors() {
		Vendor vendor;
		List<Vendor> vendors = new ArrayList<>();
		connection = databaseConnection.createConnection();
		try {
			stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("Select * from vendors");
			if (resultSet.next() == false)
				System.out.println("Error While Fetching all Vendors For Products");
			else {
				do {
					vendor = new Vendor();
					vendor.setVendorId(resultSet.getInt("id"));
					vendor.setVendorName(resultSet.getString("name"));
					vendor.setPhoneNumber(resultSet.getString("phone_number"));
					vendor.setProductId(resultSet.getInt("product_id"));
					vendors.add(vendor);

				} while (resultSet.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vendors;
	}

	public List<Vendor> getVendorsOfProduct(int product_id) {
		Vendor vendor;
		List<Vendor> vendors = new ArrayList<>();
		connection = databaseConnection.createConnection();
		try {
			stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("Select * from vendors where id=" + product_id);
			if (resultSet.next() == false)
				System.out.println("Error While Fetching all Vendors For Products");
			else {
				do {
					vendor = new Vendor();
					vendor.setVendorId(resultSet.getInt("id"));
					vendor.setVendorName(resultSet.getString("name"));
					vendor.setPhoneNumber(resultSet.getString("phone_number"));
					vendor.setProductId(resultSet.getInt("product_id"));
					vendors.add(vendor);

				} while (resultSet.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vendors;
	}

	public Vendor addVendorForProduct(Vendor vendor) {
		connection = databaseConnection.createConnection();
		try {
			pstmt = connection.prepareStatement("insert into vendors (name,product_id,phone_number) values(?,?,?)");
			pstmt.setString(1, vendor.getVendorName());
			pstmt.setInt(2, vendor.getProductId());
			pstmt.setString(3, vendor.getPhoneNumber());
			if (pstmt.executeUpdate() == 0)
				System.out.println("Error While Inserting in Vendor!");
			else
				System.out.println("Insertion Successful in vendor");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vendor;
	}

	public Vendor updateVendorById(Vendor vendor) {
		connection = databaseConnection.createConnection();
		try {
			String updateQuery = "update vendors SET name=?,phone_number=? where id=?";
			pstmt = connection.prepareStatement(updateQuery);
			pstmt.setString(1, vendor.getVendorName());
			pstmt.setString(2, vendor.getPhoneNumber());
			pstmt.setInt(3, vendor.getVendorId());
			if (pstmt.executeUpdate() == 0)
				System.out.println("Error While Updating in Vendor!");
			else
				System.out.println("Updated Successful in vendor");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vendor;
	}

}
