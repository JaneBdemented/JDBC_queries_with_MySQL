package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class jdbcQuery {
	public static final Logger logger = LoggerFactory.getLogger(jdbcQuery.class);
	private Connection myConnection;
	public jdbcQuery(){
		
	}
	public void Connect(){		
				//modify these as needed
				String rootUsername = "root";
				String rootPassword = "";
				String dbURL = "//localhost:3306/macRulesSchema";
				String connectionDatabase = "jdbc:mysql:".concat(dbURL);
				String dbTable = "macRulesTable"; //for table name in our db schema
				try {
					//attempt to connect to mysql database
					myConnection = DriverManager.getConnection(connectionDatabase, rootUsername, rootPassword);			
				}
				catch (Exception exc) {//handel error here
					exc.printStackTrace();
				}
		
	}
	public void disconnect(){
		
			try {
				myConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	public int Get_MAC_Rules(long MAC) throws SQLException {
		Statement myStatement = null;
		ResultSet myResultSet = null;
		//String dbTable = "macRulesTable"; 
		String SQL = "(SELECT * FROM macRulesTable WHERE MAC = ?),MAC;";
		try {
			myStatement = myConnection.createStatement();	//generate statement based on established connection
			myConnection.prepareStatement(SQL);
			//execute bd extract query
			myResultSet = ((Statement) myConnection).executeQuery(SQL);
			//myResultSet = myStatement.executeQuery("select * from ".concat(dbTable)."WHERE MAC =".concat(MAC));
			//process result set to obtain the list of mac addresses with their respective blocked status
			while (myResultSet.next()) {
				ResultSet Rules = myResultSet; //still needs up dating for array
			}
			//to add INSERT UPDATE  DELETE
			
		}	
		catch (Exception exc) {//handle exceptions here
			exc.printStackTrace();
		}
		finally { //cleanup
			if (myResultSet != null) {
				myResultSet.close();
			} if (myStatement != null) {
				myStatement.close();
			}
		}
		return(1);
	} 
}
