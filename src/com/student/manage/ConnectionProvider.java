package com.student.manage;
import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionProvider {
	static Connection con; 
	public static Connection createconn() {
		try {
			//load the driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//create connection
//			String user="root";
//			String password="Vaishv555";
//			String url="jdbc:mysql://localhost:3306/student_manage";
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_manage","root","Vaishv555");
		}catch(Exception e) {
			e.printStackTrace(); 
		}
		return con;
	}
}
