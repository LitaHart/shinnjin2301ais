package com.main.pj;

import java.util.List;

public interface MainlistMapper {

	public List<KadaiDTO> getAllkadaiList(KadaiDTO k);

	public int getTasseiritu(KadaiDTO k);

	public int updateKadai(KadaiDTO k);

	public List<KadaiDTO> selectHidukeDate(KadaiDTO k);

	public List<CSVdownloadDTO> selectMonthDate_all(csvDownloadSelectDTO csvDAO);
	
	public List<CSVdownloadDTO> selectMonthDate_done(csvDownloadSelectDTO csvDAO);



}
