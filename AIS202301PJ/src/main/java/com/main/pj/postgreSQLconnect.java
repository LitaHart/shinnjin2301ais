package com.main.pj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
	public static void insertTask(String kadaikannriNumber, 
            String shainn_number, 
            String tasseiYoteibi, 
            String kadaiNaiyou, 
            int tasseiKahi, 
            LocalDate kadaiTourokubi, 
            LocalDateTime tasseiHiduke)
 throws Exception {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date parsedDate = dateFormat.parse(tasseiYoteibi);
		java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
		


		
		Connection conn = null;
		PreparedStatement stmt = null;
		System.out.println(kadaikannriNumber);
		System.out.println(shainn_number + "회원번호");
		System.out.println(tasseiYoteibi);
		System.out.println(kadaiNaiyou);
		System.out.println(tasseiKahi);
		System.out.println(kadaiTourokubi);
		System.out.println(tasseiHiduke);
		
		if (kadaikannriNumber == null || kadaikannriNumber.trim().isEmpty() ||
				shainn_number == null || shainn_number.trim().isEmpty() ||
			tasseiYoteibi == null || tasseiYoteibi.trim().isEmpty() ||
			kadaiNaiyou == null || kadaiNaiyou.trim().isEmpty()) {
			throw new Exception("One or more parameters are null or empty.");
		}

		try {
			conn = getConnection();
			String sql = "INSERT INTO kadai_table (kadaikannri_number, shainn_number, tassei_yoteibi, kadai_naiyou, tassei_kahi, kadai_tourokubi, tassei_hiduke) VALUES (?, ?, ?, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, kadaikannriNumber);
			stmt.setString(2, shainn_number);
			stmt.setDate(3, sqlDate);
			stmt.setString(4, kadaiNaiyou);
			stmt.setInt(5, 0);
			stmt.setDate(6, java.sql.Date.valueOf(LocalDate.now()));
			stmt.setTimestamp(7, null);
			
			
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