package com.Athira.kelexam.questions.controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;

import com.Athira.kelexam.BeanTableModel;
import com.Athira.kelexam.WrapCellRenderer;
import com.Athira.kelexam.model.CourseModel;
import com.Athira.kelexam.model.EssayQuery;
import com.Athira.kelexam.model.FIBQuery;
import com.Athira.kelexam.model.MCQQuery;
import com.Athira.kelexam.model.MTFQuery;
import com.Athira.kelexam.model.PaperModel;
import com.Athira.kelexam.model.TFQuery;
import com.Athira.kelexam.questions.model.Essaymodel;
import com.Athira.kelexam.questions.model.FIBmodel;
import com.Athira.kelexam.questions.model.MCQmodel;
import com.Athira.kelexam.questions.model.MTFmodel;
import com.Athira.kelexam.questions.model.Model;
import com.Athira.kelexam.questions.model.TFmodel;

public class SelectionController implements ItemListener {

	private JTable table=null;
	private JComboBox<CourseModel> course=null;
	private JComboBox<PaperModel> paper=null;
	public  static String PAPER="";
	
	public SelectionController(JTable table, JComboBox<CourseModel> course, JComboBox<PaperModel> paper) {
		this.table = table;
		this.paper=paper;
		this.course=course;
		
	}
	public SelectionController(JTable table) {
		super();
		this.table=table;
	}
	public void setPaper() {
		if (course.getSelectedItem()!=null &&paper.getSelectedItem()!=null) {
			PAPER=((CourseModel)course.getSelectedItem()).getCourseCode()+
					((PaperModel)paper.getSelectedItem()).getPaperCode()+"1";
		}
	}
	  @SuppressWarnings({ "rawtypes", "unchecked" })
	public void setTable(String type) throws SQLException {
		  
		
		BeanTableModel model=null;
		if (type.equalsIgnoreCase("mcq")) {
			  List<MCQmodel> list=new ArrayList<MCQmodel>();
			  list.addAll(new MCQQuery().retriveQuestion(PAPER,0));
			  model=new BeanTableModel(MCQmodel.class,Model.class,list);	 
		}
		else if (type.equalsIgnoreCase("t/f")) {
			  List<TFmodel>list=new ArrayList<TFmodel>();
			  list.addAll(new TFQuery().retriveQuestion(PAPER,0));
			  model=new BeanTableModel(TFmodel.class,Model.class,list);	 
		}
		else if (type.equalsIgnoreCase("mtf")) {
			  List<MTFmodel>list=new ArrayList<MTFmodel>();
			  list.addAll(new MTFQuery().retriveQuestion(PAPER,0));
			  model=new BeanTableModel(MTFmodel.class,Model.class,list);	 
		}
		else if (type.equalsIgnoreCase("fib")) {
			  List<FIBmodel>list=new ArrayList<FIBmodel>();
			  list.addAll(new FIBQuery().retriveQuestion(PAPER,0));
			  model=new BeanTableModel(FIBmodel.class,Model.class,list);	 
		}
		else if (type.equalsIgnoreCase("essay")) {
			  List<Essaymodel>list=new ArrayList<Essaymodel>();
			  list.addAll(new EssayQuery().retriveQuestion(PAPER,0));
			  model=new BeanTableModel(Essaymodel.class,Model.class,list);	 
		}
		
		if (model!=null) {
			 table.setModel(model); 
		
		for (int column=0;column<model.getColumnCount();column++) {
				table.getColumnModel().getColumn(column).setCellRenderer(new WrapCellRenderer());
				model.setColumnEditable(column, false);
		 }
		}
		table.setRowSelectionAllowed(true);
	  }
	public void itemStateChanged(ItemEvent e) {
		
		if(((JRadioButton)e.getSource()).isSelected()) {
			try {
				setPaper();
				setTable(((JRadioButton)e.getSource()).getActionCommand());
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
				JOptionPane.showMessageDialog(null, "Request failed", "WARNING", 
						JOptionPane.WARNING_MESSAGE);
			} 
			catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
				JOptionPane.showMessageDialog(null, "Something went wrong try again",
						"WARNING", JOptionPane.WARNING_MESSAGE);
			}		
		}

	}

}
