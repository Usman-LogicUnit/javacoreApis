package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.DatabaseConnection;
import model.Location;

public class LocationDao {
	DatabaseConnection databaseConnection = new DatabaseConnection();
	Connection connection;
	Statement stmt;
	PreparedStatement pstmt;

	public LocationDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Location addLocationForProduct(Location location) {
		connection = databaseConnection.createConnection();
		try {
			pstmt = connection.prepareStatement(
					"insert into locations (name,product_id,city,state,address,phone_number) values(?,?,?,?,?,?)");
			pstmt.setString(1, location.getLocationName());
			pstmt.setInt(2, location.getProductId());
			pstmt.setString(3, location.getCity());
			pstmt.setString(4, location.getState());
			pstmt.setString(5, location.getAddress());
			pstmt.setString(6, location.getPhoneNumber());
			if (pstmt.executeUpdate() == 0)
				System.out.println("Error While Inserting!");
			else
				System.out.println("Insertion Successful in Location");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return location;
	}

	public List<Location> getLocations() {
		Location location;
		List<Location> locations = new ArrayList<>();
		connection = databaseConnection.createConnection();
		try {
			stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("Select * from locations");
			if (resultSet.next() == false)
				System.out.println("Error While Fetching all locations For Product");
			else {
				do {
					location = new Location();
					location.setLocationId(resultSet.getInt("id"));
					location.setLocationName(resultSet.getString("name"));
					location.setProductId(resultSet.getInt("product_id"));
					location.setAddress(resultSet.getString("address"));
					location.setCity(resultSet.getString("city"));
					location.setState(resultSet.getString("state"));
					location.setPhoneNumber(resultSet.getString("phone_number"));
					locations.add(location);
				} while (resultSet.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return locations;
	}

	public List<Location> getLocationsOfProducts(int product_id) {
		Location location;
		List<Location> locations = new ArrayList<>();
		connection = databaseConnection.createConnection();
		try {
			stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("Select * from locations where product_id=" + product_id);
			if (resultSet.next() == false)
				System.out.println("Error While Fetching all locations For Product");
			else {
				do {
					location = new Location();
					location.setLocationId(resultSet.getInt("id"));
					location.setLocationName(resultSet.getString("name"));
					location.setProductId(resultSet.getInt("product_id"));
					location.setAddress(resultSet.getString("address"));
					location.setCity(resultSet.getString("city"));
					location.setState(resultSet.getString("state"));
					location.setPhoneNumber(resultSet.getString("phone_number"));
					locations.add(location);
				} while (resultSet.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return locations;
	}

	public Location updateLocation(Location location) {
		connection = databaseConnection.createConnection();
		try {
			String updateQuery = "update locations SET name=?,city=?,state=?,address=? where id=?";
			pstmt = connection.prepareStatement(updateQuery);
			pstmt.setString(1, location.getLocationName());
			pstmt.setString(2, location.getCity());
			pstmt.setString(3, location.getState());
			pstmt.setString(4, location.getAddress());
			pstmt.setInt(5, location.getLocationId());
			if (pstmt.executeUpdate() == 0)
				System.out.println("Error While Updating Location name!");
			else
				System.out.println("Updated Successful in Location");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return location;
	}

	public void deleteLocationOfProduct(int location_id) {
		Location location = new Location();
		location.setLocationId(location_id);
		connection = databaseConnection.createConnection();
		try {
			pstmt = connection.prepareStatement("delete from locations where id=?");
			pstmt.setInt(1, location.getLocationId());
			if (pstmt.executeUpdate() == 0)
				System.out.println("Error While Deleting Product From Location!");
			else
				System.out.println("Deleted Successfully Product From Location");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
