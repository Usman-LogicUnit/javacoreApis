package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.DatabaseConnection;
import model.Attributes;

public class AttributesDao {
	DatabaseConnection databaseConnection = new DatabaseConnection();
	Connection connection;
	Statement stmt;
	PreparedStatement pstmt;

	public Attributes addAttributeOfProduct(Attributes attribute) {
		connection = databaseConnection.createConnection();
		try {
			pstmt = connection.prepareStatement("insert into attributes (attribute_name,product_id) values(?,?)");
			pstmt.setString(1, attribute.getAttributeName());
			pstmt.setInt(2, attribute.getProductId());
			if (pstmt.executeUpdate() == 0)
				System.out.println("Error While Adding  Attributes!");
			else
				System.out.println("Added Successful Attributes");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return attribute;
	}

	public List<Attributes> getAllAttributes(){
		Attributes attribute;
		List<Attributes> attributes=new ArrayList<>();
		
		connection=databaseConnection.createConnection();
		try {
			stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("Select * from attributes");
			if(resultSet.next()==false)
				System.out.println("Error While Fetching all vendors");
			else {
				do {
					attribute=new Attributes();
					attribute.setId(resultSet.getInt("id"));
					attribute.setAttributeName(resultSet.getString("attribute_name"));	
					attribute.setProductId(resultSet.getInt("product_id"));
					attributes.add(attribute);
				}while(resultSet.next());
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return attributes;
	}
	
	public List<Attributes> getAttributesOfProduct(int product_id){
		Attributes attribute;
		AttributeValueDao attributeValueDao=new AttributeValueDao();
		List<Attributes> attributes=new ArrayList<>();
		
		connection=databaseConnection.createConnection();
		try {
			stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("Select * from attributes where product_id="+product_id);
			if(resultSet.next()==false)
				System.out.println("Error While Fetching all vendors");
			else {
				do {
					attribute=new Attributes();
					attribute.setId(resultSet.getInt("id"));
					attribute.setAttributeName(resultSet.getString("attribute_name"));
					attribute.setProductId(resultSet.getInt("product_id"));
					attribute.setValues(attributeValueDao.getAllAttributeValuesByID(attribute.getId()));
					attributes.add(attribute);
				}while(resultSet.next());
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return attributes;
	}
	
	public Attributes updateAttribute(Attributes attribute) {
		connection = databaseConnection.createConnection();
		try {
			pstmt = connection.prepareStatement("update attributes set attribute_name=? where id=?");
			pstmt.setString(1, attribute.getAttributeName());
			pstmt.setInt(2, attribute.getId());
			if (pstmt.executeUpdate() == 0)
				System.out.println("Error While Updating Attribute!");
			else
				System.out.println("Updated Successful Attributes");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return attribute;
	}

	
}
