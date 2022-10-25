package com.cruzeiro.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Testjdbc {
	public static void main(String[] args) {
		String jdbcurl = "jdbc:mysql://localhost:3306/dbstudent?useSSL=false&serverTimezone=UTC";
		
		String user = "root";
		String pass = "admin";
		
		
		try {
			System.out.println("Conectando...");
			Connection myConn = DriverManager.getConnection(jdbcurl, user, pass);
			System.out.println("Conectou");
		}catch(Exception ex) {
			ex.printStackTrace(); 
			
		}
	}
}
