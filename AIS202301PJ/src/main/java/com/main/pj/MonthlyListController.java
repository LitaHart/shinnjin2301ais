package com.main.pj;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MonthlyListController {
	
	@Autowired
	private MainListDAO mDAO;
	@Autowired
	private LoginDAO ldao;
	
	
	@RequestMapping(value = "/monthlylist", method = RequestMethod.GET)
	public String monthlyListPage(Model model,HttpServletRequest request,KadaiDTO k,HttpSession session) {

		// DB link Check
		try {
			postgreSQLconnect.getConnection();
			postgreSQLconnect.testConnect();
			;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		mDAO.getSystemDate(request);
		ldao.loginCheck(request);
		mDAO.getMonthList(request,k,session);
		model.addAttribute("innerPageData", "todolist/03_monthlylist.jsp");
		return "home";
	}

}
