package com.Athira.kelexam.model;

public class PaperModel {
	private String paperName=null;
	private String paperCode=null;
	public PaperModel(String paperName, String paperCode) {
		super();
		this.paperName = paperName;
		this.paperCode = paperCode;
	}
	
	public PaperModel() {
		super();
	}

	public String getPaperName() {
		return paperName;
	}
	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}
	public String getPaperCode() {
		return paperCode;
	}
	public void setPaperCode(String paperCode) {
		this.paperCode = paperCode;
	}

	@Override
	public String toString() {
		return  paperCode + " - "+ paperName;
	}
	

}
