package com.student.manage;
import java.util.*;

import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.PreparedStatement;
import java.sql.Connection;
public class StudentDao {
	public static boolean insertStudentToDB(Student st) {
		boolean flag=false;
		try {
			Connection con=ConnectionProvider.createconn();
			String str="insert into students(sname,sphone,scity) values(?,?,?)";
			
			//prepared statement
			PreparedStatement pstmt =con.prepareStatement(str);
			
			//set value of parameter
			pstmt.setString(1, st.getStudentName());
			pstmt.setLong(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			
			//execute
			pstmt.executeUpdate();
			flag=true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
		
		
	}

	public static boolean deleteStudent(int id) {
		// TODO Auto-generated method stub
		boolean flag=false;
		try {
			Connection con=ConnectionProvider.createconn();
			String str="delete from students where sid=?";
			
			//prepared statement
			PreparedStatement pstmt =con.prepareStatement(str);
			
			//set value of parameter
			pstmt.setInt(1,id);
			
			//execute
			pstmt.executeUpdate();
			flag=true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static void showData() {
		// TODO Auto-generated method stub
		try {
			Connection con=ConnectionProvider.createconn();
			String str="select * from students";
			
			//prepared statement
			Statement stmt =con.createStatement();
			//execute
			ResultSet set=stmt.executeQuery(str);
			while(set.next()) {
				int id=set.getInt(1);
				String name=set.getString(2);
				long phone=set.getLong(3);
				String city=set.getString(4);
				System.out.println("ID:"+id);
				System.out.println("Name:"+name);
				System.out.println("Phone:"+phone);
				System.out.println("City:"+city);
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
