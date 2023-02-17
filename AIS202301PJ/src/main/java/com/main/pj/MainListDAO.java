package com.main.pj;

import javax.servlet.http.HttpServletRequest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainListDAO {

	@Autowired
	private SqlSession ss;
	
	
	public void getSystemDate(HttpServletRequest request) {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM月dd日"); 
        	//원하는 데이터 포맷 지정
		String strNowDate = simpleDateFormat.format(date); 
        	//지정한 포맷으로 변환 
		request.setAttribute("simpleDate", strNowDate );
		
	}

	public void getAllKadaiList(HttpServletRequest request, KadaiDTO k) {
		// 로그인한 사람의 목표리스트 가져오기
		k.setShainn_number("ais230102");
		List<KadaiDTO> kadais = new ArrayList<KadaiDTO>();
		kadais = ss.getMapper(MainlistMapper.class).getAllkadaiList(k);
		
		
		
		request.setAttribute("kadais",kadais);
		
	}
	
	
}
