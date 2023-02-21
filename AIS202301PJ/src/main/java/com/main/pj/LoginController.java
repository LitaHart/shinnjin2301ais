package com.main.pj;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@Autowired
	private LoginDAO ldao;
	
	

	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String loginPage() {
		// DB link Check
		try {
			postgreSQLconnect.getConnection();
			postgreSQLconnect.testConnect();
			;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "todolist/01_login";
	}
	
	
	@RequestMapping(value = "/mainLogin", method = RequestMethod.POST)
	public String mainLoginStart(HttpServletRequest Req, Shainn_info si) {
		
		ldao.loginStart(Req, si);
		ldao.loginCheck(Req);
		
		
		
		return "home";
	}
	
	
}
