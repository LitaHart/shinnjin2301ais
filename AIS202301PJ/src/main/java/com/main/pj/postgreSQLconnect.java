package com.main.pj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

	// 등록 버튼 SQL
	public static void insertTask(String kadaikannriNumber, String shainnNumber, LocalDate tasseiYoteibi, String kadaiNaiyou, int tasseiKahi, Date kadaiTourokubi, LocalDateTime tasseiHiduke) throws Exception {
	    Connection conn = null;
	    PreparedStatement stmt = null;

	    if (kadaikannriNumber == null || kadaikannriNumber.trim().isEmpty() ||
	            shainnNumber == null || shainnNumber.trim().isEmpty() ||
	            tasseiYoteibi == null ||
	            kadaiNaiyou == null || kadaiNaiyou.trim().isEmpty() ||
	            kadaiTourokubi == null || tasseiHiduke == null) {
	        throw new Exception("One or more parameters are null or empty.");
	    }

	    try {
	        conn = getConnection();
	        String sql = "INSERT INTO kadai_table (kadaikannri_number, shainn_number, tassei_yoteibi, kadai_naiyou, tassei_kahi, kadai_tourokubi, tassei_hiduke) VALUES (?, ?, ?, ?, ?, ?, ?)";
	        stmt = conn.prepareStatement(sql);
	        stmt.setString(1, kadaikannriNumber);
	        stmt.setString(2, shainnNumber);
	        stmt.setObject(3, tasseiYoteibi);
	        stmt.setString(4, kadaiNaiyou);
	        stmt.setInt(5, tasseiKahi);
	        stmt.setDate(6, kadaiTourokubi);
	        stmt.setObject(7, tasseiHiduke);

	        if (stmt.executeUpdate() == 1) {
	            conn.close();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}









	

	//수정 버튼 SQL 입니다.
	public static void updateTask(int id, String task) throws SQLException, Exception {
	    Connection conn = null;
	    PreparedStatement stmt = null;

	    try {
	        conn = getConnection();
	        String sql = "UPDATE tasks SET task = ? WHERE id = ?";
	        stmt = conn.prepareStatement(sql);

	        stmt.setString(1, task);
	        stmt.setInt(2, id);

	        if (stmt.executeUpdate() == 1) {
	            System.out.println("Task updated successfully");
	            conn.close();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    
	}


}