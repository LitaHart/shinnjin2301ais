package com.main.pj;

import java.net.http.HttpHeaders;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

@Controller
public class CsvDownloadPageController {
	

	private static final Logger logger = LoggerFactory.getLogger(CsvDownloadPageController.class);

	@RequestMapping(value = "/csvdownload", method = RequestMethod.GET)
	public String csvDownloadPage() {
		// DB link Check
		try {
			postgreSQLconnect.getConnection();
			postgreSQLconnect.testConnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "todolist/04_csvdownload";
	}

	// ＞＞＞＞＞＞＞＞＞＞＞＞＞＞＞＞＞＞＞　一般DOCUMENTファイル
	@RequestMapping(value = "/csvdownload.test.csv", method = RequestMethod.GET)
	public void downloadCSV(HttpServletResponse response) throws Exception{
		logger.debug("------->>>>>>>>>> Download Controller Start");
		String csvFileName = "KADAILISTcsv";	
		response.setContentType("text/csv");

		 // creates mock data
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",csvFileName);
        response.setHeader(headerKey, headerValue);
        
        logger.debug("------->>>>>>>>>> Download Controller Start 臨時データ入力");
        // 臨時月日
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2023-02-16");
        //臨時データ(後でSQL文作成)
        CSVdownloadDTO c1 = new CSVdownloadDTO("AIS123456", "AAA", "BEING", date, 1, date);
        CSVdownloadDTO c2 = new CSVdownloadDTO("AIS098765", "BBB", "NOT BEING", date, 2, date);
        CSVdownloadDTO c3 = new CSVdownloadDTO("AIS000000", "CCC", "UN BEING", date, 1, date);
        CSVdownloadDTO c4 = new CSVdownloadDTO("AIS234567", "DDD", "ROUFHLY BEING", date, 2, date);
        CSVdownloadDTO c5 = new CSVdownloadDTO("AIS987654", "EEE", "SURELY BEING", date, 1, date);
        		
        List<CSVdownloadDTO> csvList = Arrays.asList(c1,c2,c3,c4,c5);
       
        logger.debug("------->>>>>>>>>> Download Controller Start csvファイル作成開始");
        // uses the Super CSV API to generate CSV data from the model data
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),CsvPreference.STANDARD_PREFERENCE);
        String[] header = {
        		"shainn_number","shainn_name","kadai_naiyou","tassei_yoteibi","tassei_kahi","tassei_hiduke"
        };
        csvWriter.writeHeader(header);
        for (CSVdownloadDTO data : csvList) {
        	csvWriter.write(data, header);
		}
        csvWriter.close();
	}
	
	// ＞＞＞＞＞＞＞＞＞＞＞＞＞＞＞＞＞＞＞　工事中　： XLXS ファイル
	@RequestMapping(value = "/csvdownload.test.excel", method = RequestMethod.GET)
	public ModelAndView downloadEXCEL(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// ------------------------------------------------------		
		// 臨時月日
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2023-02-16");
        //臨時データ(後でSQL文作成)
        CSVdownloadDTO c1 = new CSVdownloadDTO("AIS123456", "AAA", "BEING", date, 1, date);
        CSVdownloadDTO c2 = new CSVdownloadDTO("AIS098765", "BBB", "NOT BEING", date, 2, date);
        CSVdownloadDTO c3 = new CSVdownloadDTO("AIS000000", "CCC", "UN BEING", date, 1, date);
        CSVdownloadDTO c4 = new CSVdownloadDTO("AIS234567", "DDD", "ROUFHLY BEING", date, 2, date);
        CSVdownloadDTO c5 = new CSVdownloadDTO("AIS987654", "EEE", "SURELY BEING", date, 1, date);
        // ------------------------------------------------------			
		
		ModelAndView mav = new ModelAndView();
		
		List<Map<String,CSVdownloadDTO>> dataList = new ArrayList<Map<String,CSVdownloadDTO>>();
		Map<String,CSVdownloadDTO> testData = new HashMap<String, CSVdownloadDTO>();
		
		testData.put("1", c1);
		testData.put("2", c2);
		testData.put("3", c3);
		testData.put("4", c4);
		testData.put("5", c5);
		
		dataList.add(testData);
		
		mav.addObject("columnIds", "shainn_number,shainn_name,kadai_naiyou,tassei_yoteibi,tassei_kahi,tassei_hiduke");
		mav.addObject("columnNames", "社員番号,氏名,課題内容,達成予定日,達成可否,達成日");
		mav.addObject("ExcelDataList",dataList);
		
		mav.setViewName("excelCsvWriteView");
		
		return mav;
	}
		
	
}
