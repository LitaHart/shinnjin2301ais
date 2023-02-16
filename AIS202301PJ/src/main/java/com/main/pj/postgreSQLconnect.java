package com.main.pj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

@Service
public class postgreSQLconnect {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
        // データベースのURL
        final String URL = "jdbc:postgresql://localhost:5432/postgres";
        // データベースにアクセスするユーザー
        final String USER = "postgres";
        // パスワード
        final String PASSWORD = "123456";
    
        Class.forName("org.postgresql.Driver");
        // データベースへ接続する
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        
        return con;
    }
	
	public static void testConnect(){
		java.sql.Statement stmt;
		try {
			stmt = getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT VERSION() AS version");
			while (rs.next()) {
				String testVersion = rs.getString("version");
				System.out.println(testVersion);             
				}
            rs.close();
			stmt.close();
			getConnection().close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
}
