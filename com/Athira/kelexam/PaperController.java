package com.Athira.kelexam;

import java.awt.Container;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import com.Athira.kelexam.generator.controller.QuestionSelector;
import com.Athira.kelexam.model.CourseModel;
import com.Athira.kelexam.model.CourseQuery;
import com.Athira.kelexam.model.PaperModel;

public class PaperController implements ItemListener {
	private JComboBox<PaperModel> listBox=null;
    private Container container=null;
	
	private QuestionSelector questionSelector=null;

	
	public PaperController(JComboBox<PaperModel> listBox,Container container) {
		super();
		this.listBox = listBox;
		this.container=container;
	}
	

	public PaperController(JComboBox<PaperModel> listBox) {
		this.listBox = listBox;
	}


	@SuppressWarnings("unchecked")
	private void setQuestionType(ItemEvent e) {
        questionSelector=new QuestionSelector(container);
        questionSelector.reset();
		CourseModel course=(CourseModel) ((JComboBox<CourseModel>)e.getSource()).getSelectedItem();
		System.out.println(course.getCourseCode());
		if(course.getCourseCode().startsWith("P")
				|| course.getCourseCode().startsWith("D")) {
			for(int i=0;i<=4;i++) {
				questionSelector.checkBoxs.get(i).setSelected(true);
				if(i==4) {
					questionSelector.countSpinners.get(i).setValue(5);
					questionSelector.markSpinners.get(i).setValue(60);
				}else {
					questionSelector.countSpinners.get(i).setValue(10);
					questionSelector.markSpinners.get(i).setValue(10);
				}
				
			}
			
		}else{
			questionSelector.checkBoxs.get(3).setSelected(true);
			questionSelector.checkBoxs.get(5).setSelected(true);
			questionSelector.checkBoxs.get(6).setSelected(true);
			questionSelector.checkBoxs.get(7).setSelected(true);
			
			questionSelector.countSpinners.get(3).setValue(10);
			questionSelector.markSpinners.get(3).setValue(10);
			questionSelector.countSpinners.get(6).setValue(7);
			questionSelector.markSpinners.get(6).setValue(20);
			questionSelector.countSpinners.get(7).setValue(3);
			questionSelector.markSpinners.get(7).setValue(20);
		}
	}
	

	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
@SuppressWarnings("unchecked")
CourseModel course=(CourseModel)((JComboBox<CourseModel>)e.getSource()).getSelectedItem();
		
		try {
			DefaultComboBoxModel<PaperModel> model=new DefaultComboBoxModel<PaperModel>();
			model.addAll(new CourseQuery().retrivePaper(course.getCourseCode()));
			listBox.setModel(model);
			listBox.setSelectedIndex(0);
			/*
			 * ((DefaultComboBoxModel<PaperModel>)listBox.getModel()) .addAll(new
			 * QuestionDB().retrivePaper(course.getCourseCode()));
			 */
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		setQuestionType(e);
		
	}

}
