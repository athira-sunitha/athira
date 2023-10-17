package com.Athira.kelexam.questions.model;

public class FIBmodel extends Model{
	private String answer=null;
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public boolean Empty() {
		if (answer.equals("")|| super.isEmpty()) {
			return true;
		}
		return false;	
	}

}
