package com.main.pj;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		
		
		
		}
	
	
	
	
	
	
	
	
	
}
