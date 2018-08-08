package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection{
		Connection con;
		public connection() {
			String username="root";
			String pwd="Welcome123";
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Diagnostic_DB", username, pwd);
				
			}
			catch(ClassNotFoundException e) {
				System.out.println("class not found");
			}
			catch(SQLException ex) {
				System.out.println("SQL exception");
			}
		}
		public Connection getconnection() {
			// TODO Auto-generated method stub
			return con;
		}
	}

