package AlbumCart;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;



public class DOA {
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
	static public DOA getObject(){
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
	
	public ArrayList<String> fetchCategoryList() throws SQLException{
		makeConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select distinct category from albums");
		ArrayList<String> categoryList = new ArrayList<String>();
		while(rs.next()){
			categoryList.add(rs.getString("category"));
		}
		breakConnection();
		return categoryList;
	}
	
	public ArrayList<album> fetchAlbumList(String category) throws SQLException{
		makeConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from albums where category = '"+category+"'");
		ArrayList<album> albumList = new ArrayList<album>();
		while(rs.next()){
			albumList.add(new album(rs.getString("name"),rs.getInt("qty"),rs.getDouble("price"),rs.getString("category")));
		}
		breakConnection();
		return albumList;
	}
	public album getAlbum(String albumName) throws SQLException{
		makeConnection();
		album Album = null;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from albums where name = '"+albumName+"'");
		if(rs.next()){
			Album = new album(rs.getString("name"),rs.getInt("qty"),rs.getDouble("price"),rs.getString("category"));
		}
		breakConnection();
		return Album;
	}
	public int buyAlbum(String albumName, int albumQty) throws SQLException{
		makeConnection();
		int newQty=0;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select qty from albums where name = '"+albumName+"';");
		if(rs.next()){
			newQty = rs.getInt("qty") - albumQty;
		}
		String str = "update albums set qty=? where name = ?;";
		PreparedStatement pst= conn.prepareStatement(str);
		pst.setInt(1,newQty);
		pst.setString(2,albumName);
		int a =  pst.executeUpdate();
		breakConnection();
		return a;
		
	}
	public HashSet<album> getAllAlbums() throws SQLException{
		makeConnection();
		HashSet<album> Albums = new HashSet<album>();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from albums");
		while(rs.next()){
			Albums.add(new album(rs.getString("name"),rs.getInt("qty"),rs.getDouble("price"),rs.getString("category")));
		}
		breakConnection();
		return Albums;
	}
}