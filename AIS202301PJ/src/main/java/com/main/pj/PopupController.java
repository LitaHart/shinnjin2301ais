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

    @RequestMapping(value = "/popupAdd", method = RequestMethod.GET)
    public String popupAdd(Model model) {
        return "todolist/06_popupAdd";
    }
   
    
    @RequestMapping(value = "/popupAdd.do", method = RequestMethod.GET)
    public String popupAdd(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	
    	postgreSQLconnect.insertTask(request);
    	return "todolist/06_popupAdd";
    }
    
}