package com.main.pj;

import java.net.http.HttpRequest;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PopupController {

    //mainlist -> 追加 시 팝업창으로 popupAdd 호출문
    @RequestMapping(value = "/popupAdd", method = RequestMethod.GET)
    public String popupAdd(Model model) {
        return "todolist/06_popupAdd";
    }
   


 // 등록 버튼 눌렀을 때 반응
    @RequestMapping(value = "/popupAdd.do", method = RequestMethod.GET)
    public String popupAdd(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String shainn_number = request.getParameter("shainn_number");

        String kadaiNaiyou = request.getParameter("kadai_naiyou");
        if (kadaiNaiyou == null || kadaiNaiyou.trim().isEmpty()) {
            throw new Exception("kadai_naiyou parameter is null or empty");
        }

        String tasseiYoteibi = request.getParameter("tassei_yoteibi");
        if (tasseiYoteibi == null || tasseiYoteibi.trim().isEmpty()) {
            throw new Exception("tassei_yoteibi parameter is null or empty");
        }
        LocalDate kadaiTourokubi = LocalDate.now();
        LocalDateTime tasseiHiduke = null;
        
        postgreSQLconnect.insertTask( 
        		shainn_number, 
                tasseiYoteibi, 
                kadaiNaiyou, 
                0, 
                kadaiTourokubi, 
                tasseiHiduke);

        return "todolist/06_popupAdd";
    }

    
    
   
//	@RequestParam("kadaiNum") String kadaiNum,
//	@RequestParam("kadai_naiyou") String kadai_naiyou
 
    //수정 버튼 눌렀을 때 호출
    @RequestMapping(value = "/popupEdit", method = RequestMethod.GET)
    public String popupEdit(Model model,HttpServletRequest request, HttpServletResponse response,    		
    		@RequestParam("kadaiNum") String kadaiNum, @RequestParam("kadai_naiyou") String kadai_naiyou) {
    	
//    	String kadaiNum = request.getParameter("kadaiNum");
//    	String kadai_naiyou = request.getParameter("kadai_naiyou");
    	System.out.println(kadaiNum);
    	System.out.println(kadai_naiyou);
    	
    	
    	
    	request.setAttribute("kadaiNum", kadaiNum);
    	request.setAttribute("kadai_naiyou", kadai_naiyou);
        return "todolist/05_popupEdit";
    }

    //수정 버튼 눌렀을 때 반응
    @RequestMapping(value = "/popupEdit.do", method = RequestMethod.GET)
    public String popupEdit(HttpServletRequest request, HttpServletResponse response,
            @RequestParam("kadaikannri_number") int kadaikannri_number,
            @RequestParam("kadai_naiyou") String kadaiNaiyou) throws Exception {
        postgreSQLconnect.updateTask(kadaikannri_number, kadaiNaiyou);
        return "todolist/05_popupEdit";
    }

}