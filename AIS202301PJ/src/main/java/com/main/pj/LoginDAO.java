package com.main.pj;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginDAO {

	@Autowired
	private SqlSession ss;
	
	public void loginStart(HttpServletRequest Req, Shainn_info si) {
		System.out.println(si.getShainn_number());
		LoginMapper lm = ss.getMapper(LoginMapper.class);
		Shainn_info shainn = lm.getShainnByID(si);
		System.out.println(shainn);
		if (shainn != null) {
			if (si.getShainn_number().equals(shainn.getShainn_number())) {
				Req.getSession().setAttribute("loginShainn", shainn);
				Req.getSession().setMaxInactiveInterval(60*10);
				System.out.println("LoginSuccess_main");
			}
		} else {
				Req.setAttribute("result", "社員情報がありません。");
				System.out.println("LoginFailed_main");
		}
	}

	public boolean loginCheck(HttpServletRequest Req) {
		Shainn_info shainn = (Shainn_info)Req.getSession().getAttribute("loginShainn");
		if (shainn != null) {
			
			Req.setAttribute("innerPageData", "todolist/02_mainlist.jsp" );
			System.out.println("LoginSuccess_check");
			return true;
		} 
		Req.setAttribute("innerPageData", "todolist/01_login.jsp");
		System.out.println("LoginFailed_check");
		return false;
	}
	
	
	

}
