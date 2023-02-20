package com.main.pj;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class CSVdownloadDAO  {

	public static void checkOption(HttpServletRequest request) {
		String timeSelect = request.getParameter("timeSelect");
	 	String csvInclude = request.getParameter("csvInclude");
		String selectedMonth = request.getParameter("selectedMonth");
		
		// 입력 값 확인
		System.out.println(timeSelect);
		System.out.println(csvInclude);
		System.out.println(selectedMonth);

		
	}
	
	
	
	
	
	
	//(すべて・全部)
	//(すべて・達成課題だけ)		
	//(月別・全部)
	//(月別・達成課題だけ)
	
	
	
	
	
	
	
}
