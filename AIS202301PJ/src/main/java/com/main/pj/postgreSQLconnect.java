package com.main.pj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class postgreSQLconnect {
	
	@Autowired
	SqlSession ss;

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
  
  public static void testConnect() {
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
      e.printStackTrace();
    } 
  }

  public static void insertTask(HttpServletRequest request) throws Exception{
//	    java.sql.Statement stmt;
//	    stmt = getConnection().createStatement();
//	    String insertSQL = "INSERT INTO task (task) VALUES ('" + task + "')";
//	    stmt.executeUpdate(insertSQL);
//	    stmt.close();
//	    getConnection().close();
	  
	  
	  Connection conn = null;
      PreparedStatement stmt = null;
      
  	 String task = request.getParameter("task");
     System.out.println(task); 
      
          try {
			conn = getConnection();		
			String sql = "INSERT INTO tasks VALUES(1234,?)";
			stmt = conn.prepareStatement(sql);
			System.out.println("Task added successfully");

	        stmt.setString(1, task);
	        
	        if ( stmt.executeUpdate() == 1) {
				conn.close();
			}
	        
	        
	       
	        
	        
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  		
  
  }
	  
	  
	  
	}

