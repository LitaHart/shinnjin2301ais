package com.main.pj;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainlistController {

	
	@RequestMapping(value = "/mainlist", method = RequestMethod.GET)
	public String mainlist(Locale locale, Model model) {
		
//		try {
//			postgreSQLconnect.getConnection();
//			postgreSQLconnect.testConnect();;
//		}  catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
		Date date = new Date();
        
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM月dd日"); 
        	//원하는 데이터 포맷 지정
		String strNowDate = simpleDateFormat.format(date); 
        	//지정한 포맷으로 변환 
		
		
		model.addAttribute("simpleDate", strNowDate );
		
		
		return "todolist/02_mainlist";
	}
	
	
	
	
}
