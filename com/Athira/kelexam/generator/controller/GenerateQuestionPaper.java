package com.Athira.kelexam.generator.controller;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;

import javax.swing.JComboBox;

import com.Athira.kelexam.generator.Generated_Request;
import com.Athira.kelexam.generator.model.CreateQuestionPaper;
import com.Athira.kelexam.model.CourseModel;
import com.Athira.kelexam.model.PaperModel;

public class GenerateQuestionPaper implements ActionListener {
	private Container container=null;
	private  QuestionSelector questionSelector=null;
	public GenerateQuestionPaper(Container container) throws IOException {
		super();
		this.container=container;
		
	}


	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		questionSelector=new QuestionSelector(container);
		Componentfinder finder=new Componentfinder(container);
		CourseModel course=(CourseModel)((JComboBox<CourseModel>)finder.findComponent("course"))
				.getSelectedItem();
		PaperModel papermodel=(PaperModel)((JComboBox<PaperModel>)finder.findComponent("subject"))
				.getSelectedItem();
		String date=(String)((JComboBox<String>)finder.findComponent("month"))
				.getSelectedItem()+" "+(String)((JComboBox<String>)finder.findComponent("year"))
				.getSelectedItem();
		questionSelector.setSelectedCheckBoxs();
		CreateQuestionPaper paper=new CreateQuestionPaper();
		try {
			paper.writePaper(questionSelector.getSelectedCheckBoxs(),course.getCourseCode()+papermodel.getPaperCode(),
					questionSelector.getQuestionCounts(),questionSelector.getMarks(),date);
			Generated_Request frame=new Generated_Request(paper.getWordFile());
			frame.setVisible(true);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
