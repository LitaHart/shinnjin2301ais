package com.main.pj;

public interface CSVDownloadMapper {

	CSVdownloadDTO[] getObjectMonth_onlyDone(csvDownloadSelectDTO forSearch);

	CSVdownloadDTO[] getObjectMonth_all(csvDownloadSelectDTO forSearch);

	CSVdownloadDTO[] getObjectAll_onlyDone(csvDownloadSelectDTO forSearch);

	CSVdownloadDTO[] getObjectAll_all(csvDownloadSelectDTO forSearch);
	
}
