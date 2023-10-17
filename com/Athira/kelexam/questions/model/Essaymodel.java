package com.Athira.kelexam.questions.model;


public class Essaymodel  extends Model {
private int mark=0;

public int getMark() {
	return mark;
}

public void setMark(int mark) {
	if (mark>0 && mark<=15) {
		this.mark = mark;
	}	
}
public boolean Empty() {
	if (mark==0|| super.isEmpty()) {
		return true;
	}
	return false;	
}
}
