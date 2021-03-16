package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
	
	final String connectionString; 
	
	
	
	
	public DatabaseConnection() {
		super();
		this.connectionString="jdbc:sqlserver://localhost:1433;databaseName=Product;user=sa;password=logicunit";
	}

	
	public Connection createConnection() {
		Connection connection=null;
			try {
				DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
				connection=DriverManager.getConnection(connectionString);
				if(connection!=null) {
					System.out.println("Successfully Connected to Database!!");
				}
			}
			catch(SQLException ex){
				ex.printStackTrace();
			}
//			finally {
//				try {
//					if (connection!=null && !connection.isClosed())
//					{
//						connection.close();
//					}
//				}
//				catch(SQLException ex) {
//					ex.printStackTrace();
//				}
//			}
			
			return connection;
				
	}
	
	
	public static void main (String[] args) {
		
		DatabaseConnection databaseConn=new DatabaseConnection();
		Connection connected;
		connected =databaseConn.createConnection();
		Statement st;
		try {
			st = connected.createStatement();
			String query ="Select * from products";
			ResultSet resultset=st.executeQuery(query);
			while(resultset.next()) {
				System.out.println("sas"+resultset.getInt("id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
	}
	

	
}
