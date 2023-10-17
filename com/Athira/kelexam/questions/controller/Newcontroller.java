package com.Athira.kelexam.questions.controller;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.JTable;

import com.Athira.kelexam.BeanTableModel;
import com.Athira.kelexam.generator.controller.Componentfinder;
import com.Athira.kelexam.questions.EssayDialog;
import com.Athira.kelexam.questions.FIBDialog;
import com.Athira.kelexam.questions.MCQDialog;
import com.Athira.kelexam.questions.MTFDialog;
import com.Athira.kelexam.questions.TrueFalseDialog;
import com.Athira.kelexam.questions.model.Essaymodel;
import com.Athira.kelexam.questions.model.FIBmodel;
import com.Athira.kelexam.questions.model.MCQmodel;
import com.Athira.kelexam.questions.model.MTFmodel;
import com.Athira.kelexam.questions.model.Model;
import com.Athira.kelexam.questions.model.TFmodel;

public class Newcontroller implements ActionListener {
	private Container container=null;
	private Model model=null;
	private JTable table=null;
	
	/*
	 * public Newcontroller (Container container) { super(); this.container =
	 * container;
	 * 
	 * }
	 */
	
	
	public Newcontroller(Container container,JTable table) {
		super();
		this.container = container;
		this.table=table;
		
	}

	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent e) { 
		Componentfinder finder =new Componentfinder(container);
		if (table!=null) {
			int row=table.getSelectedRow();
			if(row!=-1) {
			this.model=((BeanTableModel<Model>)table.getModel())
		                .getRow(row);
			}
		}
		
		String buttontext=finder.getSelectedButtonText(((JRadioButton) finder
				.findComponent("MCQB")).getModel().getGroup());
		if (buttontext.equals("MCQ")) {
			try {
			MCQDialog dialog = new MCQDialog((MCQmodel)model,table);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception f) {
			f.printStackTrace();
		}
			
		}
		else if(buttontext.equals("T/F")) {
			try {
				TrueFalseDialog dialog = new TrueFalseDialog((TFmodel)model,table);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			} catch (Exception f) {
				f.printStackTrace();
			}
		
		}
		else if(buttontext.equals("FIB")) {
			try {
				FIBDialog dialog = new FIBDialog((FIBmodel)model,table);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			} catch (Exception f) {
				f.printStackTrace();
			}
		}
		else if(buttontext.equals("MTF")) {
			try {
				MTFDialog dialog = new MTFDialog((MTFmodel)model,table);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			} catch (Exception f) {
				f.printStackTrace();
			}
		}
		else if(buttontext.equals("Essay")||
				buttontext.equals("Short Essay")||
				buttontext.equals("2 Mark Questions")||
			buttontext.equals("10 Mark Questions")){
			try {
				EssayDialog dialog = new EssayDialog((Essaymodel)model,table);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			} catch (Exception f) {
				f.printStackTrace();
			}
		}
		
		
	}

}
