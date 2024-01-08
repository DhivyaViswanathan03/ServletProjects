package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



public class jdbcutil {
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static Connection getJdbcConnection() throws SQLException, IOException {
			
		return PhysicalConnection();
		
	}

	
	private static Connection PhysicalConnection() throws FileNotFoundException, IOException, SQLException {
		File f=new File("C:\\Users\\Navis\\ServletApplication\\CrudAppServletJsp\\src\\main\\java\\properties\\application.properties");
		FileInputStream fio=new FileInputStream(f);
		Properties p=new Properties();
		p.load(fio);
		String url=p.getProperty("jdbcUrl");
		String userName=p.getProperty("user");
		String password=p.getProperty("password");
        Connection con=DriverManager.getConnection(url,userName,password);
		return con;
	}
	
	public static void CleanUp(Connection con,Statement stmt,ResultSet rs) throws SQLException {
		if(con !=null) {
			con.close();
		}
		if(stmt!=null) {
			stmt.close();
		}
		if(rs!=null) {
			rs.close();
		}
	}
}


