package com.Athira.kelexam.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
	

	public Connection dbConnection()throws SQLException{
		return DriverManager
				.getConnection("jdbc:mysql://localhost:3306/keltronexam","root", "ponnus");
	}

}
