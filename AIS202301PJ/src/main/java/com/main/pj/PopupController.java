package com.main.pj;

import java.net.http.HttpRequest;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class PopupController {

    //mainlist -> 追加 시 팝업창으로 popupAdd 호출문
	@RequestMapping(value = "/popupAdd", method = RequestMethod.GET)
	public String popupAdd(Model model, HttpSession session) {
	    Shainn_info employee = (Shainn_info) session.getAttribute("employee");
	    model.addAttribute("employee", employee);
	    model.addAttribute("kadaiDTO", new KadaiDTO());
	    return "todolist/06_popupAdd";
	}


   
	@RequestMapping(value = "/popupAdd.do", method = RequestMethod.POST)
	@ResponseBody
	public String popupAdd(@RequestBody KadaiDTO kadai, HttpSession session) {
	    try {
	        Shainn_info employee = (Shainn_info) session.getAttribute("employee");
	        LocalDate localDate = LocalDate.now();
	        LocalDateTime localDateTime = LocalDateTime.now();
	        Timestamp timestamp = Timestamp.valueOf(localDateTime);

	        postgreSQLconnect.insertTask(kadai.getKadaikannri_number(), employee.getShainn_number(),
	                localDate, kadai.getKadai_naiyou(), kadai.getTassei_kahi(),
	                new java.sql.Date(System.currentTimeMillis()), localDateTime);

	        return "{\"status\": \"success\"}";
	    } catch (Exception e) {
	        // Handle the exception here
	        e.printStackTrace();
	        return "{\"status\": \"error\"}";
	    }
	}






    
    //수정 버튼 눌렀을 때 호출
    @RequestMapping(value = "/popupEdit", method = RequestMethod.GET)
    public String popupEdit(Model model) {
        return "todolist/05_popupEdit";
    }

    
    //수정 버튼 눌렀을 때 반응
    @RequestMapping(value = "/popupEdit.do", method = RequestMethod.POST)
    public String popupEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        String task = request.getParameter("task");
        postgreSQLconnect.updateTask(id, task);
        return "todolist/05_popupEdit";
    }
}
