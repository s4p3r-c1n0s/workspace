package employee;

import java.sql.*;
//import java.util.*;


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
	
	public boolean valid(String name, String password) throws SQLException{
		makeConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs= stmt.executeQuery("select * from logins where name = '"+name+"' and password = '"+password+"'");
		breakConnection();
		return rs.next();
		//if(name.equals(password);
	}
	public int enter(String name, String password) throws SQLException{
		makeConnection();
		int a =0 ;
		String str = "insert into logins value (?,?)";
		PreparedStatement pst= conn.prepareStatement(str);
		pst.setString(1,name);
		pst.setString(2,password);
		try{
		a = pst.executeUpdate();
		}
		catch (Exception e){a = -1;}
		breakConnection();
		return a;
	}
	public String[] fetchEmployee(String name, String search) throws SQLException{
		String result[] = new String[10];
		makeConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = null;
		if(search.equals("contain"))
		rs = stmt.executeQuery("select * from employees where name like '%"+name+"%'");
		else if(search.equals("exact"))
		rs= stmt.executeQuery("select * from employees where name = '"+name+"'");
		int i=0;
		while (rs.next()){
			result[i++] = rs.getString("name");
		}
		breakConnection();
		return result;
	}
	public String[] fetchDetails(String name) throws SQLException{
		String result[] = new String[4];
		makeConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from employees where name = '"+name+"'");
		int i=0;
		while (rs.next()){
			result[i++] = rs.getString("name");
			result[i++] = rs.getString("design");
			result[i++] = rs.getString("phone");
			result[i++] = rs.getString("address");
		}
		
		breakConnection();
		return result;
	}
}