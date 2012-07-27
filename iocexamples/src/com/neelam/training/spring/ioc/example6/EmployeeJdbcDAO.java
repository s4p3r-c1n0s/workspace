package com.neelam.training.spring.ioc.example6;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class EmployeeJdbcDAO implements EmployeeDAO {

	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List getAllEmployees() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select * from trialemp");
			List rows = new ArrayList();
			while(rs.next()) {
				Emp emp = new Emp();
				emp.setEmpno(rs.getInt(1));
				emp.setName(rs.getString(2));
				rows.add(emp);
			}
			//code to traverse Resultset and store in List
			return rows;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return new ArrayList();
		}
		finally {
			try { rs.close(); st.close(); conn.close(); } catch(Exception e) { }
		}
	}
}