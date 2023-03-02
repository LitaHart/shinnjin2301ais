package com.main.pj;

import java.util.Date;

public class CSVdownloadDTO {

	private String shainn_number;
	private String shainn_name;
	private String kadai_naiyou;
	private Date tassei_yoteibi;
	private int tassei_kahi;
	private Date tassei_hiduke;

	public CSVdownloadDTO() {
		// TODO Auto-generated constructor stub
	}

	public CSVdownloadDTO(String shainn_number, String shainn_name, String kadai_naiyou, Date tassei_yoteibi,
			int tassei_kahi, Date tassei_hiduke) {
		super();
		this.shainn_number = shainn_number;
		this.shainn_name = shainn_name;
		this.kadai_naiyou = kadai_naiyou;
		this.tassei_yoteibi = tassei_yoteibi;
		this.tassei_kahi = tassei_kahi;
		this.tassei_hiduke = tassei_hiduke;
	}

	public String getShainn_number() {
		return shainn_number;
	}

	public void setShainn_number(String shainn_number) {
		this.shainn_number = shainn_number;
	}

	public String getShainn_name() {
		return shainn_name;
	}

	public void setShainn_name(String shainn_name) {
		this.shainn_name = shainn_name;
	}

	public String getKadai_naiyou() {
		return kadai_naiyou;
	}

	public void setKadai_naiyou(String kadai_naiyou) {
		this.kadai_naiyou = kadai_naiyou;
	}

	public Date getTassei_yoteibi() {
		return tassei_yoteibi;
	}

	public void setTassei_yoteibi(Date tassei_yoteibi) {
		this.tassei_yoteibi = tassei_yoteibi;
	}

	public int getTassei_kahi() {
		return tassei_kahi;
	}

	public void setTassei_kahi(int tassei_kahi) {
		this.tassei_kahi = tassei_kahi;
	}

	public Date getTassei_hiduke() {
		return tassei_hiduke;
	}

	public void setTassei_hiduke(Date tassei_hiduke) {
		this.tassei_hiduke = tassei_hiduke;
	}

}
