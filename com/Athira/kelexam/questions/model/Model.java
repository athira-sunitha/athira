package com.Athira.kelexam.questions.model;

public  class Model {

	private String questionId=null;
	private String question=null;
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	protected boolean isEmpty() {
		if (question.equals("")) {
			return true;
		}
		return false;
		
	}
}
