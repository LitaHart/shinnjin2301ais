package com.main.pj;


import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainlistController {
	
	@Autowired
	private MainListDAO mDAO;

	
	@RequestMapping(value = "/mainlist", method = RequestMethod.GET)
	public String mainlist(HttpServletRequest request,KadaiDTO k) {
		
		try {
			postgreSQLconnect.getConnection();
			postgreSQLconnect.testConnect();;
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		mDAO.getSystemDate(request);
		mDAO.getAllKadaiList(request,k);
		
		return "todolist/02_mainlist";
		
		
		
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
	public String selectHidukeDate(HttpServletRequest request,@RequestParam("yearAndMonthData") String yearAndMonthData,
			@RequestParam("shainn_number") String shainn_number) {
		
		try {
			postgreSQLconnect.getConnection();
			postgreSQLconnect.testConnect();;
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		mDAO.selectHidukeDate(request,yearAndMonthData,shainn_number);
		return "todolist/02_mainlist";
	}
	
	
	
	
	
	
	
}
