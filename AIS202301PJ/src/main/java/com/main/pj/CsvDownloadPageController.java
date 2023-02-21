package com.main.pj;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

@Controller
public class CsvDownloadPageController {
//	https://dailylifecoding.tistory.com/entry/apache-POI-%EA%B0%84%EB%8B%A8-%EC%82%AC%EC%9A%A9%EB%B2%95-1

	private static final Logger logger = LoggerFactory.getLogger(CsvDownloadPageController.class);

	@RequestMapping(value = "/csvdownload", method = RequestMethod.GET)
	public String csvDownloadPage() {
		// DB link Check
		try {
			System.out.println("Start DownloadController");
			postgreSQLconnect.getConnection();
			postgreSQLconnect.testConnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "todolist/04_csvdownload";
	}
	
	@RequestMapping(value="/csvdownload.check", method = RequestMethod.GET)
	public void downloadDataCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("------->>>>>>>>>> Download Controller DataCheck Start");
		
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
        		
        List<CSVdownloadDTO> csvList = CSVdownloadDAO.inputcsvDownloadObject();
       
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
	public void downloadEXCEL(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		logger.debug("------->>>>>>>>>> Download Controller Start");
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet();
		wb.setSheetName(0, "課題達成データ");
		
		
		//>>>>>>>>>>>>>>>>>>>文字書き込み
		String[] header = {
        		"shainn_number","shainn_name","kadai_naiyou","tassei_yoteibi","tassei_kahi","tassei_hiduke"
        };
		
        //臨時データ(後でSQL文作成)
        // Sheet를 채우기 위한 데이터들을 Map에 저장
		Object[] c1 = new Object[] {"AIS123456", "AAA", "BEING", "2023-02-16", "1", "2023-02-16"};
		Object[] c2 = new Object[] {"AIS098765", "BBB", "NOT BEING","2023-02-17", "1", "2023-02-17"};
		Object[] c3 = new Object[] {"AIS000000", "CCC", "UN BEING","2023-02-15", "1", "2023-02-15"};
		Object[] c4 = new Object[] {"AIS234567", "DDD", "ROUFHLY BEING","2023-02-15", "1", "2023-02-15"};
		Object[] c5 = new Object[] {"AIS234567", "DDD", "ROUFHLY BEING","2023-02-14", "1", "2023-02-14"};		
		
        // >>>>>>>>>>>>>>>>>> Mapping　開始        
		Map<String, Object[]> kadaiData = new TreeMap<String, Object[]>();
		kadaiData.put("1", header);
		kadaiData.put("2", c1);
		kadaiData.put("3", c2);
		kadaiData.put("4", c3);
		kadaiData.put("5", c4);
		kadaiData.put("6", c5);
		
		// data에서 keySet를 가져온다. 이 Set 값들을 조회하면서 데이터들을 sheet에 입력한다.
		Set<String> keyset = kadaiData.keySet();
		int rownum = 0;
		
		for (String key : keyset) {
			Row row = sheet.createRow(rownum++);
			Object[] objArr = kadaiData.get(key);
			int cellNum = 0;

				for (Object obj : objArr) {
					Cell cell = row.createCell(cellNum++);
						if (obj instanceof String) {
							cell.setCellValue((String)obj);
						} else if (obj instanceof Integer) {
							cell.setCellValue((Integer)obj);
						}
				}
		}
		
//		FileOutputStream xlxsOut = new FileOutputStream(
//				new File(File("Content-Disposition", "attachment;filename=KadaiDownload.xls"))
//				);
//		wb.write(xlxsOut);
//		xlxsOut.close();
		
		//送信
		response.setHeader("Content-Disposition", "attachment;filename=download.xls");
		response.setContentType("application/vnd.ms-excel");
		wb.write(response.getOutputStream());
		
		}
	
	
	
	
	
	
	
	
	
	
	}

