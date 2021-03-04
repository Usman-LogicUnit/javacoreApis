package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.DatabaseConnection;

import model.Values;

public class AttributeValueDao {
	DatabaseConnection databaseConnection=new DatabaseConnection();
	Connection connection;
	Statement stmt;
	PreparedStatement pstmt;
	
	public Values addAttributeValue(Values value) {
		connection = databaseConnection.createConnection();
		try {
			pstmt = connection.prepareStatement("insert into attribute_values(attribute_id,value) values(?,?)");
			pstmt.setInt(1,value.getAttributeId() );
			pstmt.setString(2, value.getValue());
			if (pstmt.executeUpdate() == 0)
				System.out.println("Error While Adding Attribute value!");
			else
				System.out.println("Added Successful Attributes Value");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return value;
	}
	
	
	public List<Values> getAllAttributeValues(){
		Values value;
		List<Values> values=new ArrayList<>();
		
		connection=databaseConnection.createConnection();
		try {
			stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("Select * from attribute_values");
			if(resultSet.next()==false)
				System.out.println("Error While Fetching all attributes values");
			else {
				do {
					value=new Values();
					value.setId(resultSet.getInt("id"));
					value.setValue(resultSet.getString("value"));
					value.setAttributeId(resultSet.getInt("attribute_id"));
					values.add(value);
				}while(resultSet.next());
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return values;
	}
	
	public List<Values> getAllAttributeValuesByID(int attribute_id){
		Values value;
		List<Values> values=new ArrayList<>();
		
		connection=databaseConnection.createConnection();
		try {
			stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("Select * from attribute_values where attribute_id="+attribute_id);
			if(resultSet.next()==false)
				System.out.println("Error While Fetching all attributes values");
			else {
				do {
					value=new Values();
					value.setId(resultSet.getInt("id"));
					value.setValue(resultSet.getString("value"));
					value.setAttributeId(resultSet.getInt("attribute_id"));
					values.add(value);
				}while(resultSet.next());
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return values;
	}
	
}
