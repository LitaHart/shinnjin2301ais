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

	public String monthlyListPage_basic(Model model, HttpServletRequest request, KadaiDTO k, HttpSession session) {

		if (ldao.loginCheck(request)) {
			mDAO.getSystemDate(request);
			mDAO.getMonthList(request, k, session);
//			mDAO.getMonthList3page(request, k, session);
			
			model.addAttribute("innerPageData", "todolist/03_monthlylist.jsp");
		} else {
			request.setAttribute("innerPageData", "todolist/01_login.jsp");
		}
		return "home";
	}
	

	@RequestMapping(value = "/monthlylistCallAll", method = RequestMethod.GET)
	public String monthlyListPage_CallAll(Model model, HttpServletRequest request, KadaiDTO k, HttpSession session) {

		if (ldao.loginCheck(request)) {
			mDAO.getSystemDate(request);
//			mDAO.getMonthList(request, k, session);
			mDAO.getMonthList3page(request, k, session);
			
			model.addAttribute("innerPageData", "todolist/03_monthlylist.jsp");
		} else {
			request.setAttribute("innerPageData", "todolist/01_login.jsp");
		}
		return "home";
	}


}
