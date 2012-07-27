package com.neelam.training.spring.ioc.example1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.neelam.training.spring.ioc.common.Flight;

public class FlightServiceDao implements FlightService {

	private String tableName;
	private DataSource dataSource;
	
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public String getTableName() {
		return tableName;
	}
	public DataSource getDataSource() {
		return dataSource;
	}
	
	public List getAvailableFlights() {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List rows = new ArrayList();
		try {
			conn = dataSource.getConnection();
			String sql = "select * from "+tableName;
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			System.out.println(rs);
			
			while(rs.next()) {
				Flight f = new Flight();
				f.setFlightNo(rs.getString(1));
				f.setCarrier(rs.getString(2));
				f.setFrom(rs.getString(3));
				f.setTo(rs.getString(4));
				rows.add(f);
			}
			
		}
		catch(SQLException e) {
			//throw new RuntimeException(e);
			e.printStackTrace();
		}
		finally {
			try { 
				rs.close(); 
				pst.close(); 
				conn.close(); 
				} catch(SQLException e) { 
					e.printStackTrace();
				}
		}
		return rows;
	}
}
