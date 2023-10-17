package com.Athira.kelexam.generator.controller;

import java.awt.Container;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JSpinner;


public class QuestionSelector {
public enum QuestionType {
	MCQ,TF,MTF,FIB,ESSAY,MARK2,MARK4,MARK5,MARK10
}
	public List<JCheckBox> checkBoxs=null;
	public List<JSpinner> countSpinners=null;
	public List<JSpinner> markSpinners=null;
	private List<QuestionType> selectedCheckBoxs=null;
	private List<Integer> questionCounts=null;
	private List<Integer> marks=null;
	private Componentfinder finder=null;
	
    public QuestionSelector(Container container) {
    	 finder=new Componentfinder(container);
    	 setCheckBoxs();
    	 setCountSpinners();
    	 setMarkSpinners();
    	 setQuestionCounts();
    	 
    	 setMarks();
	}
   
	
	public void setCheckBoxs() {
		
		checkBoxs = new ArrayList<JCheckBox>();
		for(int i=1;i<10;i++) {
			checkBoxs.add((JCheckBox)finder.findComponent("checkbox "+i));
		}
	}
	
	public void setCountSpinners() {
		
		countSpinners = new ArrayList<JSpinner>();
		for(int i=1;i<10;i++) {
			countSpinners.add((JSpinner)finder.findComponent("spiner"+i));
		}
	}

	
	public void setMarkSpinners() {
	
		markSpinners = new ArrayList<JSpinner>();
		for(int i=10;i<19;i++) {
			markSpinners.add((JSpinner)finder.findComponent("spiner"+i));
		}
	}
	public List<QuestionType> getSelectedCheckBoxs() {
		return selectedCheckBoxs;
	}
	public void setSelectedCheckBoxs() {
		selectedCheckBoxs=new ArrayList<QuestionSelector.QuestionType>();
			if (checkBoxs.get(0).isSelected()) {
				selectedCheckBoxs.add(QuestionType.MCQ);
			}
			if (checkBoxs.get(1).isSelected()) {
				selectedCheckBoxs.add(QuestionType.TF);
			}
			if (checkBoxs.get(2).isSelected()) {
				selectedCheckBoxs.add(QuestionType.MTF);
			}
			if (checkBoxs.get(3).isSelected()) {
				selectedCheckBoxs.add(QuestionType.FIB);
			}
			if (checkBoxs.get(4).isSelected()) {
				selectedCheckBoxs.add(QuestionType.ESSAY);
			}
			if (checkBoxs.get(5).isSelected()) {
			System.out.println(	checkBoxs.get(5).getName());
				selectedCheckBoxs.add(QuestionType.MARK2);
			}
			if (checkBoxs.get(6).isSelected()) {
				selectedCheckBoxs.add(QuestionType.MARK4);
			}
			if (checkBoxs.get(7).isSelected()) {
				selectedCheckBoxs.add(QuestionType.MARK5);
			}
			if (checkBoxs.get(8).isSelected()) {
				selectedCheckBoxs.add(QuestionType.MARK10);
			}
		}
		
	
	public List<Integer> getQuestionCounts() {
		return questionCounts;
	}
	public void setQuestionCounts() {
		questionCounts = new ArrayList<Integer>();
		int i=0;
		for (JSpinner spinner : countSpinners) {
			questionCounts.add((Integer)spinner.getModel().getValue());
		System.out.println(	questionCounts.get(i));
		i++;
		}
	}
	public List<Integer> getMarks() {
		return marks;
	}
	public void setMarks() {
		marks = new ArrayList<Integer>();
		for (JSpinner spinner : markSpinners) {
			marks.add((Integer)spinner.getModel().getValue());
		}
	}

	public void reset() {
		for(int i=0;i<9;i++) {
            checkBoxs.get(i).setSelected(false);
			countSpinners.get(i).setValue(0);
			markSpinners.get(i).setValue(0);
		}
	}
	
}
