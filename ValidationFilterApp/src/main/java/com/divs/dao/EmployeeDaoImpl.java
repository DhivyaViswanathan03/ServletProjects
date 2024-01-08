package com.divs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.divs.Dto.Employee;

public class EmployeeDaoImpl implements EmployeDao {

	@Override
	public String insert(Employee e) {
		try {
			String insertQuery="insert into employee(`id`,`name`,`age`,`mail`,`mobile`) values(?,?,?,?,?)";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///divs","root","Welcome@123");
			if(con!=null) {
				PreparedStatement stmt=con.prepareStatement(insertQuery);
				if(stmt!=null) {
					stmt.setString(1, e.getEid());
					stmt.setString(2, e.getEname());
					stmt.setInt(3, e.getEage());
					stmt.setString(4, e.getEmail());
					stmt.setString(5, e.getEmobile());
					int rowCount=stmt.executeUpdate();
					if(rowCount==1)
						return "success";
					else
						return "failure";
				}
				
			}
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return "failure";
	}

}
