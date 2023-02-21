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

	//등록 버튼 SQL 입니다.
	public static void insertTask(HttpServletRequest request) throws Exception {
		  Connection conn = null;
		  PreparedStatement stmt = null;

		  String task = request.getParameter("task");
		  System.out.println(task);

		  try {
		    conn = getConnection();
		    String sql = "INSERT INTO tasks (task) VALUES(?)";	//등록 버튼 후 tasks 라는 테이블의 task열,에 테스트 하기 위한 SQL
		    stmt = conn.prepareStatement(sql);
		    System.out.println("Task added successfully");

		    stmt.setString(1, task);

		    if (stmt.executeUpdate() == 1) {
		      conn.close();
		    }
		  } catch (Exception e) {
		    e.printStackTrace();
		  }
		}
	
	
	//수정 버튼 SQL 입니다.
	public static void updateTask(HttpServletRequest request) throws Exception {
	    Connection conn = null;
	    PreparedStatement stmt = null;

	    int id = Integer.parseInt(request.getParameter("id"));
	    String task = request.getParameter("task");
	    System.out.println(task);

	    try {
	        conn = getConnection();
	        String sql = "UPDATE tasks SET task = ? WHERE id = ?";	//로컬로는 테스트 불가. 이후 테이블 생성 후 체크
	        stmt = conn.prepareStatement(sql);
	        System.out.println("Task updated successfully");

	        stmt.setString(1, task);
	        stmt.setInt(2, id);

	        if (stmt.executeUpdate() == 1) {
	            conn.close();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
