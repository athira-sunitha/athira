package com.Athira.kelexam;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import com.Athira.kelexam.generator.QuestionPaperGeneration;
import com.Athira.kelexam.model.CourseModel;
import com.Athira.kelexam.model.CourseQuery;
import com.Athira.kelexam.questions.Question;

public class WindowLoading extends WindowAdapter {
	private QuestionPaperGeneration generator=null;
	private Question question=null;
	private JComboBox<CourseModel> list=null;
	
	
	public WindowLoading(QuestionPaperGeneration generator, JComboBox<CourseModel> list) {
		super();
		this.generator = generator;
		this.list=list;
	}


	public WindowLoading(Question question, JComboBox<CourseModel> list) {
		super();
		this.question = question;
		this.list=list;
	}
	public void addList() throws SQLException {
		((DefaultComboBoxModel<CourseModel>)list.getModel())
		.addAll(new CourseQuery().retriveCourse());
		list.setSelectedIndex(0);
	}

@Override
	public void windowOpened(WindowEvent e) {
		if(generator!=null) {
			
			try {
				addList();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (question!=null) {
			try {
				addList();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
}
