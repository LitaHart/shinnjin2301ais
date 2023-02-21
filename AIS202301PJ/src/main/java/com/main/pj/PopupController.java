package com.main.pj;
import java.net.http.HttpRequest;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class PopupController {
	
	
	//mainlist -> 追加 시 팝업창으로 popupAdd 호출문
    @RequestMapping(value = "/popupAdd", method = RequestMethod.GET)
    public String popupAdd(Model model) {
        return "todolist/06_popupAdd";
    }
   
    //등록 버튼 눌렀을 때 반응
    @RequestMapping(value = "/popupAdd.do", method = RequestMethod.GET)
    public String popupAdd(HttpServletRequest request, HttpServletResponse response) throws Exception {   	
    	postgreSQLconnect.insertTask(request);
    	return "todolist/06_popupAdd";
    }
    
    
    @RequestMapping(value = "/popupEdit", method = RequestMethod.GET)
    public String popupEdit(Model model) {
      return "todolist/05_popupEdit";
    }
    
    @RequestMapping(value = "/popupEdit.do", method = RequestMethod.GET)
    public String popupEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        postgreSQLconnect.updateTask(request);
        return "todolist/05_popupEdit";
    }
}