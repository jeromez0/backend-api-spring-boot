package com.flexon.BackendAPI.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnSingleton {

	private static ConnSingleton singleton = new ConnSingleton();

	private Connection conn;

	private ConnSingleton() {
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://flexon-training-db.cbgbvojyukko.us-west-1.rds.amazonaws.com:3306/bankDB";
		final String USER = "admin";
		final String PASS = "admin123";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			this.conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Succsessfully connected!");

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static ConnSingleton getConnSingleton() {
		return singleton;
	}

	public Connection getConnection() {
		return conn;
	}

}