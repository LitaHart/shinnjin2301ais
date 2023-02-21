package com.main.pj;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.ibatis.session.SqlSession;
import org.apache.poi.ss.util.SSCellRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CSVdownloadDAO  {

	@Autowired
	SqlSession ss;
	
	public static void checkOption(HttpServletRequest request) {
		String shainn_number = (String) request.getSession().getAttribute("loginShainn");
		String timeSelect = request.getParameter("timeSelect");
	 	String csvInclude = request.getParameter("csvInclude");
		String selectedMonth = String.valueOf(request.getParameter("selectedMonth"));
		String[] monthData = selectedMonth.split(" ");
		String month = monthData[0];
		String year = monthData[1];
		// 영문날짜 숫자(문자열)로변환		
		String numMonth = CSVdownloadDAO.changeMonth(month);
		//검색용 마지막 날짜 설정 28 29 30 31
		String day = CSVdownloadDAO.setDateStringForSQL(numMonth, year);
	
		//검색용 날짜 문자열 설정
		String betweenDate01 = year+"-"+numMonth+"-01";
		String betweenDate02 = year+"-"+numMonth+"-"+day;
		
		System.out.println(betweenDate01);
		System.out.println(betweenDate02);
		
		csvDownloadSelectDTO forSearch = new csvDownloadSelectDTO(shainn_number, betweenDate01, betweenDate02);
	
		
		// >>>>>>>>>> sql준비
		//CSVDownloadMapper cdm = ss.getMapper(CSVDownloadMapper.class);
		
		CSVdownloadDTO cdto = null;
		
		//(すべて・全部)
		//(すべて・達成課題だけ)		
		//(月別・全部)
		//(月別・達成課題だけ)
		//=======================================
		if (timeSelect.equals("csvMonth")) {
			// 선택 날짜와 년도 확인
			// 선택 달의 달성 과제 select
				if (csvInclude.equals("csvInclude")) {
				//미달성 과제 포함 전체 select
				};
		} else if (timeSelect.equals("csvAll")) {
				// 달성 과제 전체 select
				if (csvInclude.equals("csvInclude")) {
				//미달성 과제 포함 전체 select
				};
		};	
		//=======================================
	
	
	}
	
	// 내용물받아오기
	public static List<CSVdownloadDTO> inputcsvDownloadObject() {
		
		
		
		
		
		// Date 포맷팅 준비
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		
		// csv 내용물 리스트 준비 
		List<CSVdownloadDTO> csvDownloadList = Arrays.asList();
		//csvDownloadList.add();

		//DTO 만들어서 리스트에 집어넣기
		
		return csvDownloadList;
	}
	
	//============= 날짜 검색 포맷으로 설정 yyyy-MM-dd 2월 예외설정, 30,31일 확인, 평년 윤년 계산
	public static String setDateStringForSQL(String month, String year){		
			//	yyyy-MM-dd
			// 31 - 01 03 05 07 08 10 12
			// 30 - 04 06 09 11
			// 28 - 02(평년)
			// 29 - 02(윤년)- 4로 나누어 떨어지는 년도 
		double yearCal = Double.parseDouble(year);
			if (yearCal%4 == 0.0) {
				// 해당 년도는 윤년
			};
		String day = null;
			if (month.equals("02")) {
				if (yearCal%4 != 0.0) {
					day = "28";
				} else {
					day = "29";
				}
			} else if (month.equals("04")||month.equals("06")||month.equals("09")||month.equals("11")) {
				day = "30";
			} else {
				day = "31";
			}
		return day;
	}
	// ============= 영문날짜 숫자(문자열)로 변환하는 함수		
	public static String changeMonth(String month) {
		String[] monthDataEN = new String[]{
				"January",
				"February",
				"March",
				"April",
				"May",
				"June",
				"July",
				"August",
				"September",
				"October",
				"November",
				"December"
		};
		String[] monthDataEN_short = new String[]{
				"Jan",
				"Feb",
				"Mar",
				"Apr",
				"May",
				"Jun",
				"Jul",
				"Aug",
				"Sep",
				"Oct",
				"Nov",
				"Dec"
		};
		String[] numMonth = new String[]{
				"01",
				"02",
				"03",
				"04",
				"05",
				"06",
				"07",
				"08",
				"09",
				"10",
				"11",
				"12"
		};
		String enTonum =  null;
		for (int i = 0; i < monthDataEN.length; i++) {
			if ( month.equals(monthDataEN[i])||month.equals(monthDataEN_short[i])){
				enTonum = numMonth[i];
			}
		}
		
		System.out.println("変換後値確認: " + enTonum );
		return enTonum;
	}

}
