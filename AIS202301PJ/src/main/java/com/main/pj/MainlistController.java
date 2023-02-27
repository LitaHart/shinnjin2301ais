package com.main.pj;


import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainlistController {
	
	@Autowired
	private MainListDAO mDAO;
	@Autowired
	private LoginDAO ldao;
	
	@RequestMapping(value = "/mainlist", method = RequestMethod.GET)
	public String mainlist(Model model,HttpServletRequest request,KadaiDTO k,HttpSession session) {
		
		try {
			postgreSQLconnect.getConnection();
			postgreSQLconnect.testConnect();;
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		ldao.loginCheck(request);
		mDAO.getSystemDate(request);
		mDAO.getAllKadaiList(request,k,session);
		
		model.addAttribute("innerPageData", "todolist/02_mainlist.jsp");
		return "home";
		};
	
	
	@ResponseBody
	@RequestMapping(value = "/update.tassei.kahi", method = RequestMethod.GET)
	public int updateTasseiKahi(HttpServletRequest request,@RequestParam("kahiArr") String kahiArr,
			@RequestParam("kadaiArr") String kadaiArr,
			@RequestParam("yoteibiArr") Date yoteibiArr,
		@RequestParam("shainn_number") String shainn_number) {
		
		try {
			postgreSQLconnect.getConnection();
			postgreSQLconnect.testConnect();;
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mDAO.updateTasseiKahi(request,kahiArr,kadaiArr,yoteibiArr,shainn_number);
	}
	
	
	
	
	
	@RequestMapping(value = "/selectHidukeDate", method = RequestMethod.GET)
	public String selectHidukeDate(Model model,HttpServletRequest request,@RequestParam("yearAndMonthData") String yearAndMonthData,
			@RequestParam("shainn_number") String shainn_number) {
		
		try {
			postgreSQLconnect.getConnection();
			postgreSQLconnect.testConnect();;
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ldao.loginCheck(request);
		mDAO.selectHidukeDate(request,yearAndMonthData,shainn_number);
		model.addAttribute("innerPageData", "todolist/02_mainlist.jsp");
		return "home";
	}
	
	
	
	
	
	
	
}
