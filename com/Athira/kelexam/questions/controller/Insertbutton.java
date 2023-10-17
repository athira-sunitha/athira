package com.Athira.kelexam.questions.controller;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import com.Athira.kelexam.questions.Essay;
import com.Athira.kelexam.questions.Fillintheblanks;
import com.Athira.kelexam.questions.MCQquestions;
import com.Athira.kelexam.questions.Matchthefollowing;
import com.Athira.kelexam.questions.Trueoralse;

public class Insertbutton implements ActionListener{
	private Container container=null;
	

	public Insertbutton(Container container) {
		super();
		this.container = container;
	}
private void questionType()
{
JDialog dialogbox =(JDialog)container.getParent();
if(dialogbox instanceof MCQquestions) {
	
}
else if(dialogbox instanceof Trueoralse) {
	
}
else if (dialogbox instanceof Matchthefollowing ) {
	
}
else if(dialogbox instanceof Fillintheblanks) {
	
}
else if (dialogbox instanceof Essay) {
	
}
}
	public void actionPerformed(ActionEvent e) {
		
		questionType();
		
	}

}
