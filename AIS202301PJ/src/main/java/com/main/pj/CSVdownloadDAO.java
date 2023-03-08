package com.main.pj;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.SessionScope;

@Service
public class CSVdownloadDAO {

	@Autowired
	private SqlSession ss;

	public List<Object[]> checkOptionandExcute(HttpServletRequest request, String emID) {

		String shainn_number = emID;
		String timeSelect = request.getParameter("timeSelect");
		String csvInclude = request.getParameter("csvInclude");
		String selectedMonth = String.valueOf(request.getParameter("selectedMonth"));
		String[] monthData = selectedMonth.split(" ");
		String month = monthData[0];
		String year = monthData[1];
		// 영문날짜 숫자(문자열)로변환
		String numMonth = CSVdownloadDAO.changeMonth(month);
		// 검색용 마지막 날짜 설정 28 29 30 31
		String day = CSVdownloadDAO.setDateStringForSQL(numMonth, year);
		// 검색용 날짜 문자열 설정
		String betweenDate01 = year + "-" + numMonth + "-01";
		String betweenDate02 = year + "-" + numMonth + "-" + day;

		// 쿼리문 실행용 변수
		csvDownloadSelectDTO forSearch = new csvDownloadSelectDTO(shainn_number, betweenDate01, betweenDate02);

		// 쿼리문 실행 준비
		CSVDownloadMapper csvMapper = ss.getMapper(CSVDownloadMapper.class);
		CSVdownloadDTO[] csvDTO = null;

		// >>>>>>>>>> sql준비
		if (timeSelect != null && timeSelect.equals("csvMonth")) {
			// 선택 날짜와 년도 확인
			if (csvInclude != null && csvInclude.equals("csvInclude")) {
				// 미달성 과제 포함 전체 select
				csvDTO = csvMapper.getObjectMonth_all(forSearch);
			} else {
				// 선택 달의 달성 과제 select
				csvDTO = csvMapper.getObjectMonth_onlyDone(forSearch);
			}
			;
		}
		if (timeSelect != null && timeSelect.equals("csvAll")) {
			if (csvInclude != null && csvInclude.equals("csvInclude")) {
				// 미달성 과제 포함 전체 select
				csvDTO = csvMapper.getObjectAll_all(forSearch);
			} else {
				// 달성 과제 전체 select
				csvDTO = csvMapper.getObjectAll_onlyDone(forSearch);
			}
			;
		}
		;
		// csv 내용물 리스트 준비
		// DTO 만들어서 리스트에 집어넣기

		List<Object[]> csvDataFromDB_list = new ArrayList<Object[]>();
		DateFormat dateFormatwithNone = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat dateFormatwithTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String number = null;
		String shainn_name = null;
		String kadai_naiyou = null;
		String tassei_yoteibi = null;
		String tassei_kahi = null;
		String tassei_hiduke = null;

		for (CSVdownloadDTO csVdownloadDTO : csvDTO) {
			number = csVdownloadDTO.getShainn_number();
			shainn_name = csVdownloadDTO.getShainn_name();
			kadai_naiyou = csVdownloadDTO.getKadai_naiyou();
			tassei_yoteibi = dateFormatwithNone.format(csVdownloadDTO.getTassei_yoteibi());
			if (csVdownloadDTO.getTassei_kahi() == 1) {
				tassei_kahi = "達成";
			} else if (csVdownloadDTO.getTassei_kahi() == 0) {
				tassei_kahi = "未達成";
			}
			if (csVdownloadDTO.getTassei_hiduke() != null) {
				tassei_hiduke = dateFormatwithTime.format(csVdownloadDTO.getTassei_hiduke());
			} else {
				tassei_hiduke = "";
			}
			csvDataFromDB_list.add(
					new Object[] { number, shainn_name, kadai_naiyou, tassei_yoteibi, tassei_kahi, tassei_hiduke });
			// 정보 들어오는거 확인
		}

		return csvDataFromDB_list;
	}

	// ============= 날짜 검색 포맷으로 설정 yyyy-MM-dd 2월 예외설정, 30,31일 확인, 평년 윤년 계산
	public static String setDateStringForSQL(String month, String year) {
		// yyyy-MM-dd
		// 31 - 01 03 05 07 08 10 12
		// 30 - 04 06 09 11
		// 28 - 02(평년)
		// 29 - 02(윤년)- 4로 나누어 떨어지는 년도
		double yearCal = Double.parseDouble(year);
		if (yearCal % 4 == 0.0) {
			// 해당 년도는 윤년
		}
		;
		String day = null;
		if (month.equals("02")) {
			if (yearCal % 4 != 0.0) {
				day = "28";
			} else {
				day = "29";
			}
		} else if (month.equals("04") || month.equals("06") || month.equals("09") || month.equals("11")) {
			day = "30";
		} else {
			day = "31";
		}
		return day;
	}

	// ============= 영문날짜 숫자(문자열)로 변환하는 함수
	public static String changeMonth(String month) {
		String[] monthDataEN = new String[] { "January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December" };
		String[] monthDataEN_short = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep",
				"Oct", "Nov", "Dec" };
		String[] numMonth = new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
		String enTonum = null;
		for (int i = 0; i < monthDataEN.length; i++) {
			if (month.equals(monthDataEN[i]) || month.equals(monthDataEN_short[i])) {
				enTonum = numMonth[i];
			}
		}

		System.out.println("変換後値確認: " + enTonum);
		return enTonum;
	}

	public static String changeMonth2(String numMonthSub) {
		String[] numMonth = new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
		String[] monthDataEN = new String[] { "January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December" };
		String enTonum = null;
		
		for (int i = 0; i < numMonth.length; i++) {
			if (numMonthSub.equals(monthDataEN[i])) {
				enTonum = numMonth[i];
			}
		}
		System.out.println("変換後値確認: " + enTonum);
		return enTonum;
	}

}
