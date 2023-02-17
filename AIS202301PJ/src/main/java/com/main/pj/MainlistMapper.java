package com.main.pj;

import java.util.List;

public interface MainlistMapper {

	public List<KadaiDTO> getAllkadaiList(KadaiDTO k);

	public int getTasseiritu(KadaiDTO k);
}
