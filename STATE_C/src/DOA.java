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
	public HashSet<state_city> getState_City() throws SQLException{
		makeConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs= stmt.executeQuery("select * from states");
		HashSet<state_city> alsc = new HashSet<state_city>();
		while(rs.next()){
			alsc.add(new state_city(rs.getString("state"),rs.getString("city")));
		}
		breakConnection();
		return alsc;
	}
	public String setState_City(state_city State_City) throws SQLException{
		makeConnection();
		String str = "insert into states value(?,?);", str2 = new String("");
		String str3 = "select * from states where state = '"+State_City.getState()+"' and city = '"+State_City.getCity()+"'";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(str3);
		if(!rs.next()){
			PreparedStatement ps = conn.prepareStatement(str);
			ps.setString(1, State_City.getState());
			ps.setString(2,State_City.getCity());
			if(ps.executeUpdate()==0)
				str2 += "City Not Added";
			else
				str2 += "City Added";
		}
		breakConnection();
		return str2;
	}
	
	public String setState_City(HashSet<state_city> listState_City) throws SQLException{
		String str2 = new String("");
		if(listState_City != null){
			makeConnection();
			PreparedStatement ps =null;
			ResultSet rs = null;
			String str = "insert into states value(?,?);";
			Statement stmt = conn.createStatement();
			for(state_city State_City:listState_City){
				String str3 = "select * from states where state = '"+State_City.getState()+"' and city = '"+State_City.getCity()+"'";
				rs = stmt.executeQuery(str3);
				if(!rs.next()){
					ps = conn.prepareStatement(str);
					ps.setString(1, State_City.getState());
					ps.setString(2,State_City.getCity());
					str2 += State_City.getCity();
					if(ps.executeUpdate()==0)
						str2 += "City Not Added <br>";
					else
						str2 += "City Added<br>";
				}
			}
		breakConnection();
		}
		return str2;
	}
}