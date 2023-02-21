package com.main.pj;

public class csvDownloadSelectDTO {

	private String shainn_number;
	private String betweenDate01;
	private String betweenDate02;
	
	public csvDownloadSelectDTO() {
		// TODO Auto-generated constructor stub
	}

	public csvDownloadSelectDTO(String shainn_number, String betweenDate01, String betweenDate02) {
		super();
		this.shainn_number = shainn_number;
		this.betweenDate01 = betweenDate01;
		this.betweenDate02 = betweenDate02;
	}

	public String getShainn_number() {
		return shainn_number;
	}

	public void setShainn_number(String shainn_number) {
		this.shainn_number = shainn_number;
	}

	public String getBetweenDate01() {
		return betweenDate01;
	}

	public void setBetweenDate01(String betweenDate01) {
		this.betweenDate01 = betweenDate01;
	}

	public String getBetweenDate02() {
		return betweenDate02;
	}

	public void setBetweenDate02(String betweenDate02) {
		this.betweenDate02 = betweenDate02;
	}
	
	
}
