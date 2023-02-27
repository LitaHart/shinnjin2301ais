package com.main.pj;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainListDAO {

	@Autowired
	private SqlSession ss;
	
	
	public void getSystemDate(HttpServletRequest request) {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM月dd日"); 
        	//원하는 데이터 포맷 지정
		String strNowDate = simpleDateFormat.format(date); 
        	//지정한 포맷으로 변환 
		request.setAttribute("simpleDate", strNowDate );
		
	}

	public void getAllKadaiList(HttpServletRequest request, KadaiDTO k, HttpSession session) {
		// 로그인한 사람의 목표리스트 가져오기
		Shainn_info loginShainn =  (Shainn_info) session.getAttribute("loginShainn");
		String emID = loginShainn.getShainn_number();
		System.out.println(emID);
		
		k.setShainn_number(emID);
		
		List<KadaiDTO> kadais = new ArrayList<KadaiDTO>();
		
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
        	//원하는 데이터 포맷 지정
		String strNowDate = simpleDateFormat.format(date); 
		
		java.sql.Date d = java.sql.Date.valueOf(strNowDate);
		System.out.println(d);
		k.setTassei_yoteibi(d);
		kadais = ss.getMapper(MainlistMapper.class).getAllkadaiList(k);
		
		
		
		request.setAttribute("kadais",kadais);
		
	}


	public int updateTasseiKahi(HttpServletRequest request, String kahiArr, String kadaiArr, java.sql.Date yoteibiArr, String shainn_number) {
		
		KadaiDTO k = new KadaiDTO();
		k.setKadaikannri_number(kadaiArr);
		k.setShainn_number(shainn_number);
		k.setTassei_yoteibi(yoteibiArr);
		k.setTassei_kahi(Integer.parseInt(request.getParameter("kahiArr")));
		
		
		return ss.getMapper(MainlistMapper.class).updateKadai(k);
		
		
		
		
	}

	public void selectHidukeDate(HttpServletRequest request, String yearAndMonthData, String shainn_number) {
		
		KadaiDTO k = new KadaiDTO();
		
		System.out.println(yearAndMonthData);
		
		String yearAndMonthDataSplit [] = yearAndMonthData.split("\\s");
		
		String month1 = yearAndMonthDataSplit[0]; 
		String dateconma = yearAndMonthDataSplit[1]; 
		String year = yearAndMonthDataSplit[2];
		
		String date = dateconma.replaceAll("[,]", "");
		
		
		System.out.println(month1);
		System.out.println(date);
		System.out.println(year);
		
		String month = month1.substring(0, 3);
		
		System.out.println(month);
		
		if (month.equals("Jan")) {
			month = "01";
		}else if (month.equals("Feb")) {
			month = "02";
		}else if (month.equals("Mar")) {
			month = "03";
		}else if (month.equals("Apr")) {
			month = "04";
		}else if (month.equals("May")) {
			month = "05";
		}else if (month.equals("Jun")) {
			month = "06";
		}else if (month.equals("Jul")) {
			month = "07";
		}else if (month.equals("Aug")) {
			month = "08";
		}else if (month.equals("Sep")) {
			month = "09";
		}else if (month.equals("Oct")) {
			month = "10";
		}else if (month.equals("Nov")) {
			month = "11";
		}else {
			month = "12";
		}
		
		System.out.println(month + "몇월선택?");
		
		
		String hiduke = year + "-" + month + "-" + date;
		java.sql.Date d = java.sql.Date.valueOf(hiduke);
		
		System.out.println(d);
		k.setTassei_yoteibi(d);
		k.setShainn_number(shainn_number);
		
		
		String strNowDate = month + "月" + date + "日";
		
		
		
		List<KadaiDTO> kadais = new ArrayList<KadaiDTO>();
		kadais = ss.getMapper(MainlistMapper.class).selectHidukeDate(k);
		
		request.setAttribute("simpleDate", strNowDate );
		request.setAttribute("kadais",kadais);
		
		
	}

	public void getMonthList(HttpServletRequest request, KadaiDTO k, HttpSession session) {
		
		Shainn_info loginShainn =  (Shainn_info) session.getAttribute("loginShainn");
		String emID = loginShainn.getShainn_number();
		Date date = new Date();
		csvDownloadSelectDTO d = new csvDownloadSelectDTO();
		System.out.println(request.getParameter("yearAndMonthData"));
		String yearAndMonthData = request.getParameter("yearAndMonthData");
		String betweenDate01 = "";
		String betweenDate02 = "";
		String year = "";
		String numMonth = "";
		
		
		if (request.getParameter("yearAndMonthData") == null || request.getParameter("yearAndMonthData").isBlank()) {
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		        	//원하는 데이터 포맷 지정
			String strNowDate = simpleDateFormat.format(date); 
			
			year = strNowDate.substring(0, 4);
			numMonth = strNowDate.substring(5, 7);
			
			System.out.println(year);
			System.out.println(numMonth);
			String day = CSVdownloadDAO.setDateStringForSQL(numMonth, year);
			// 검색용 날짜 문자열 설정
			betweenDate01 = year + "-" + numMonth + "-01";
			betweenDate02 = year + "-" + numMonth + "-" + day;
			
			
			
			
			d.setBetweenDate01(betweenDate01);
			d.setBetweenDate02(betweenDate02);
			request.setAttribute("simpleDate", numMonth );
			
		}else {
			year = yearAndMonthData.substring(yearAndMonthData.length()-4, yearAndMonthData.length());
			String numMonthSub = yearAndMonthData.substring(0, 3);
			numMonth = CSVdownloadDAO.changeMonth(numMonthSub);
			String day = CSVdownloadDAO.setDateStringForSQL(numMonth, year);
			
			betweenDate01 = year + "-" + numMonth + "-01";
			betweenDate02 = year + "-" + numMonth + "-" + day;
			d.setBetweenDate01(betweenDate01);
			d.setBetweenDate02(betweenDate02);
			request.setAttribute("simpleDate", numMonth );
		}
		
		d.setShainn_number(emID);
		
		
		
		List<CSVdownloadDTO> kadais = new ArrayList<CSVdownloadDTO>();
		kadais = ss.getMapper(MainlistMapper.class).selectMonthDate(d);
		request.setAttribute("kadais",kadais);
		
		
		
	}

	
	
	
}
