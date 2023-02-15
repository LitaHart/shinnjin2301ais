package com.main.pj;

import java.sql.Date;

public class KadaiDTO {

	private String kadaikannri_number;
	private String shainn_number;
	private Date tassei_yoteibi;
	private String kadai_naiyou;
	private int tassei_kahi;
	private Date kadai_tourokubi;
	private Date tassei_hiduke;
	
	
	public KadaiDTO() {
		// TODO Auto-generated constructor stub
	}

	
	

	public KadaiDTO(String kadaikannri_number, String shainn_number, Date tassei_yoteibi, String kadai_naiyou,
			int tassei_kahi, Date kadai_tourokubi, Date tassei_hiduke) {
		super();
		this.kadaikannri_number = kadaikannri_number;
		this.shainn_number = shainn_number;
		this.tassei_yoteibi = tassei_yoteibi;
		this.kadai_naiyou = kadai_naiyou;
		this.tassei_kahi = tassei_kahi;
		this.kadai_tourokubi = kadai_tourokubi;
		this.tassei_hiduke = tassei_hiduke;
	}




	public String getKadaikannri_number() {
		return kadaikannri_number;
	}


	public void setKadaikannri_number(String kadaikannri_number) {
		this.kadaikannri_number = kadaikannri_number;
	}


	public String getShainn_number() {
		return shainn_number;
	}


	public void setShainn_number(String shainn_number) {
		this.shainn_number = shainn_number;
	}


	public Date getTassei_yoteibi() {
		return tassei_yoteibi;
	}


	public void setTassei_yoteibi(Date tassei_yoteibi) {
		this.tassei_yoteibi = tassei_yoteibi;
	}


	public String getKadai_naiyou() {
		return kadai_naiyou;
	}


	public void setKadai_naiyou(String kadai_naiyou) {
		this.kadai_naiyou = kadai_naiyou;
	}


	public int getTassei_kahi() {
		return tassei_kahi;
	}


	public void setTassei_kahi(int tassei_kahi) {
		this.tassei_kahi = tassei_kahi;
	}


	public Date getKadai_tourokubi() {
		return kadai_tourokubi;
	}


	public void setKadai_tourokubi(Date kadai_tourokubi) {
		this.kadai_tourokubi = kadai_tourokubi;
	}


	public Date getTassei_hiduke() {
		return tassei_hiduke;
	}


	public void setTassei_hiduke(Date tassei_hiduke) {
		this.tassei_hiduke = tassei_hiduke;
	}
	
	
	
	
}
