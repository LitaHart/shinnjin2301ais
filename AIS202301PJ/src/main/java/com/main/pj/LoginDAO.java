package com.main.pj;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginDAO {

	@Autowired
	private SqlSession ss;

	public void loginStart(HttpServletRequest request, Shainn_info si) {
		System.out.println(si.getShainn_number());
		LoginMapper lm = ss.getMapper(LoginMapper.class);
		Shainn_info shainn = lm.getShainnByID(si);
		System.out.println(shainn);
		if (shainn != null) {
			if (si.getShainn_number().equals(shainn.getShainn_number())) {
				request.getSession().setAttribute("loginShainn", shainn);
				request.getSession().setMaxInactiveInterval(60 * 10);
				System.out.println("LoginSuccess_main");
			}
		} else {
			request.setAttribute("result", "社員情報がありません。");
			System.out.println("LoginFailed_main");
		}
	}

	public boolean loginCheck(HttpServletRequest request) {
		Shainn_info shainn = (Shainn_info) request.getSession().getAttribute("loginShainn");
		if (shainn != null) {
			System.out.println("LoginSuccess_check");
			return true;
		}
		System.out.println("LoginFailed_check");
		return false;
	}

}
