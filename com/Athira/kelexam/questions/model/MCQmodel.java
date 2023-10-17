package com.Athira.kelexam.questions.model;


public class MCQmodel  extends Model{
	private String answer=null;
	private String option1=null;
	private String option2=null;
	private String option3=null;
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String string) {
		this.option1 = string;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public boolean Empty() {
		if (answer.equals("")
				|| option1.equals("")
				||option2.equals("")
				||option3.equals("")
				|| super.isEmpty()) {
			return true;
		}
		return false;	
	}
}
