package cn.edu.njut.common.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
	private static String url;
	static {
		url = "jdbc:mysql://202.119.248.97:3306/evaluation?useUnicode=true&characterEncoding=UTF-8";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/*
	public static ResultSet query(String sql) {
		try {
			Connection conn = getConnection();
			    Statement st = (Statement) conn.createStatement();
			    ResultSet rs = st.executeQuery(sql);
			    conn.close();   //关闭数据库连接  
			    return rs;
		} catch (SQLException e) {
			return null;
		}
	}
	*/
	
	public static Connection getConnection() {
		Connection conn = null;
        try {
			conn = DriverManager.getConnection(url, "root", "mars!@com");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return conn;
	}
}
