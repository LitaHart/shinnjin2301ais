package com.main.pj;

import java.io.PrintWriter;
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
import javax.servlet.http.HttpServletResponse;

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
	public static void insertTask(String shainn_number, String tasseiYoteibi, String kadaiNaiyou, int tasseiKahi, LocalDate kadaiTourokubi, LocalDateTime tasseiHiduke) throws Exception {


		Connection conn = null;
		PreparedStatement stmt = null;
	
		System.out.println(shainn_number + "회원번호");
		System.out.println(tasseiYoteibi);
		System.out.println(kadaiNaiyou);
		System.out.println(tasseiKahi);
		System.out.println(kadaiTourokubi);
		System.out.println(tasseiHiduke);
		
		if (
				shainn_number == null || shainn_number.trim().isEmpty() ||
			tasseiYoteibi == null || tasseiYoteibi.trim().isEmpty() ||
			kadaiNaiyou == null || kadaiNaiyou.trim().isEmpty()) {
			throw new Exception("One or more parameters are null or empty.");
		}

		try {
			conn = getConnection();
	        // 최대 10개까지만 작동할 수 있게 하자.
	        String countSql = "SELECT COUNT(*) FROM kadai_table WHERE shainn_number = ? AND tassei_yoteibi = ?::DATE";
	        stmt = conn.prepareStatement(countSql);
	        stmt.setString(1, shainn_number);
	        stmt.setString(2, tasseiYoteibi);
	        ResultSet rs = stmt.executeQuery();
	        rs.next();
	        int count = rs.getInt(1);
	        rs.close();
	        stmt.close();
	        
	        

	        if (count >= 10) {
	        	throw new Error("The maximum number of tasks for the given date has been exceeded.");
	        	
	        	}

			//추가 데이터
			String sql = "INSERT INTO kadai_table (shainn_number, tassei_yoteibi, kadai_naiyou, tassei_kahi, kadai_tourokubi, tassei_hiduke) VALUES (?, ?::DATE, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, shainn_number);
			stmt.setString(2, tasseiYoteibi);
			stmt.setString(3, kadaiNaiyou);
			stmt.setInt(4, 0);
			stmt.setDate(5, java.sql.Date.valueOf(LocalDate.now()));
			stmt.setTimestamp(6, null);
			
			
			if (stmt.executeUpdate() == 1) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	//수정 버튼 SQL 입니다.
	public static void updateTask(int kadaikannri_number, String kadaiNaiyou) throws SQLException, Exception {
	    Connection conn = null;
	    PreparedStatement stmt = null;

	    try {
	        conn = getConnection();
	        String sql = "UPDATE kadai_table SET kadai_naiyou = ? WHERE kadaikannri_number = ?";
	        stmt = conn.prepareStatement(sql);
	        stmt.setString(1, kadaiNaiyou);
	        stmt.setInt(2, kadaikannri_number);

	        if (stmt.executeUpdate() == 1) {
	            System.out.println("Task updated successfully");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (stmt != null) {
	            stmt.close();
	        }
	        if (conn != null) {
	            conn.close();
	        }
	    }
	}
}