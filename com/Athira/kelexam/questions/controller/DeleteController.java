package com.Athira.kelexam.questions.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import com.Athira.kelexam.BeanTableModel;
import com.Athira.kelexam.model.EssayQuery;
import com.Athira.kelexam.model.FIBQuery;
import com.Athira.kelexam.model.MCQQuery;
import com.Athira.kelexam.model.MTFQuery;
import com.Athira.kelexam.model.TFQuery;
import com.Athira.kelexam.questions.model.Essaymodel;
import com.Athira.kelexam.questions.model.FIBmodel;
import com.Athira.kelexam.questions.model.MCQmodel;
import com.Athira.kelexam.questions.model.MTFmodel;
import com.Athira.kelexam.questions.model.Model;
import com.Athira.kelexam.questions.model.TFmodel;

public class DeleteController implements ActionListener {
	private JTable table=null;
	

	public DeleteController(JTable table) {
		this.table = table;
	}


	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int selectedRow=table.getSelectedRow();
		Model model=((BeanTableModel<Model>)table.getModel())
				.getRow(selectedRow);
			try {
				if (model instanceof MCQmodel) {
					new MCQQuery().deleteQuestion((MCQmodel) model);
				}
				else if(model instanceof FIBmodel) {
					new FIBQuery().deleteQuestion((FIBmodel) model);
				}
				else if (model instanceof TFmodel) {
					new TFQuery().deleteQuestion((TFmodel) model);
				}
				else if(model instanceof MTFmodel) {
					new MTFQuery().deleteQuestion((MTFmodel) model);
				}
				else if (model instanceof Essaymodel) {
					new EssayQuery().deleteQuestion((Essaymodel) model);
				}
			    ((BeanTableModel<Model>)table.getModel()).removeRows(selectedRow);
				JOptionPane.showMessageDialog(null, "Question deleted successfully", "DELETED", 
						JOptionPane.PLAIN_MESSAGE);
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
				JOptionPane.showMessageDialog(null, "couldn't delete", "WARNING", 
						JOptionPane.WARNING_MESSAGE);
			}
			
	}

}
