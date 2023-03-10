package com.main.pj;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CsvDownloadPageController {
//	https://dailylifecoding.tistory.com/entry/apache-POI-%EA%B0%84%EB%8B%A8-%EC%82%AC%EC%9A%A9%EB%B2%95-1
	@Autowired
	private CSVdownloadDAO csvDAO;
	private static final Logger logger = LoggerFactory.getLogger(CsvDownloadPageController.class);
	@Autowired
	private LoginDAO ldao;

	@RequestMapping(value = "/csvdownload", method = RequestMethod.GET)
	public String csvDownloadPage(Model model,HttpServletRequest request) {
		// DB link Check
		try {
			System.out.println("Start DownloadController");
			postgreSQLconnect.getConnection();
			postgreSQLconnect.testConnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (ldao.loginCheck(request)) {
			model.addAttribute("innerPageData", "todolist/04_csvdownload.jsp");
		} else {
			request.setAttribute("innerPageData", "todolist/01_login.jsp");
		}
		return "home";
	}

	@RequestMapping(value = "/csvdownload.check", method = RequestMethod.GET)
	public void downloadDataCheck(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		logger.info("------->>>>>>>>>> Download Controller DataCheck Start");
		
		Shainn_info loginShainn =  (Shainn_info) session.getAttribute("loginShainn");
		String emID = loginShainn.getShainn_number();
		System.out.println(emID);
		
		List<Object[]> csvDataFromDB = csvDAO.checkOptionandExcute(request, emID);

		logger.info("------->>>>>>>>>> Download Controller writeCSV Start");

		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet();
		wb.setSheetName(0, "???????????????");

		logger.info("------->>>>>>>>>> Download Controller ?????????????????? Start");
		String[] header = { "shainn_number", "shainn_name", "kadai_naiyou", "tassei_yoteibi", "tassei_kahi",
				"tassei_hiduke" };
		Map<String, Object[]> kadaiData = new HashMap<String, Object[]>();
		kadaiData.put(null, header);
		for (int j = 0; j < csvDataFromDB.size(); j++) {
			kadaiData.put(Integer.toString(j + 1), csvDataFromDB.get(j));
		}

		// data?????? keySet??? ????????????. ??? Set ????????? ??????????????? ??????????????? sheet??? ????????????.
		Set<String> keyset = kadaiData.keySet();
		int rownum = 0;

		for (String key : keyset) {
			Row row = sheet.createRow(rownum++);
			Object[] objArr = kadaiData.get(key);
			int cellNum = 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellNum++);
				if (obj instanceof String) {
					cell.setCellValue((String) obj);
				} else if (obj instanceof Integer) {
					cell.setCellValue((Integer) obj);
				}
			}
		}
		// ??????
		response.setHeader("Content-Disposition", "attachment;filename=download.xls");
		response.setContentType("application/vnd.ms-excel");
		wb.write(response.getOutputStream());
	}
}
