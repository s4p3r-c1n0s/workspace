import java.sql.*;
import java.util.*;


class DOA {
	private Connection conn ;
	private String url ;
	private String dbName ;
	private String driver ;
	private String userName ;
	private String passwd ;
	
	static DOA doa = new DOA(); 
	static boolean connected = false;
	private DOA(){
		conn = null;
		url = "jdbc:mysql://localhost:3306/";
		dbName = "LL_JAVA";
		driver = "com.mysql.jdbc.Driver";
		userName = "root";
		passwd = "umangjeet";
	}
	static DOA getObject(){
		return doa;
	}
	private void makeConnection() throws SQLException{
		if(!connected){
			try {
				Class.forName(driver).newInstance();
				conn = DriverManager.getConnection(url+dbName,userName,passwd);	  
				System.out.println("Connected to the database");
			} catch (Exception e) {
				e.printStackTrace();
				}
			connected = true;
		}
	}
	private void breakConnection() throws SQLException{
		if(connected){
			conn.close();
			System.out.println("Disconnected from database");
			connected = false;
		}
	}
	
}