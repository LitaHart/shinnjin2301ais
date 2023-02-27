package com.main.pj;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@Autowired
	private LoginDAO ldao;
	@Autowired
	private MainListDAO mDAO;
	

	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String loginPage(Model model) {
		// DB link Check
		try {
			postgreSQLconnect.getConnection();
			postgreSQLconnect.testConnect();
			;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("innerPageData", "todolist/01_login.jsp");
		
		return "home";
	}
	
	
	@RequestMapping(value = "/mainLogin", method = RequestMethod.POST)
	public String mainLoginStart(HttpServletRequest request, Shainn_info si,HttpSession session) {
		
		ldao.loginStart(request, si);
		ldao.loginCheck(request);
		KadaiDTO k = new KadaiDTO();
		k.setShainn_number(si.getShainn_number());
		mDAO.getSystemDate(request);
		mDAO.getAllKadaiList(request, k,session);
		
		
		return "home";
	}
	
	
}
