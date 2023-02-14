package com.main.pj;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CsvDownloadPageController {
	

	@RequestMapping(value = "/csvdownload", method = RequestMethod.GET)
	public String csvDownloadPage() {

		// DB link Check
		try {
			postgreSQLconnect.getConnection();
			postgreSQLconnect.testConnect();
			;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "todolist/04_csvdownload";
	}

}
