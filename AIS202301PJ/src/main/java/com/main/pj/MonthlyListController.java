package com.main.pj;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MonthlyListController {
	
	
	
	@RequestMapping(value = "/monthlylist", method = RequestMethod.GET)
	public String monthlyListPage() {

		// DB link Check
		try {
			postgreSQLconnect.getConnection();
			postgreSQLconnect.testConnect();
			;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "todolist/03_monthlylist";
	}

}
