package com.Athira.kelexam.questions.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.Athira.kelexam.BeanTableModel;
import com.Athira.kelexam.generator.controller.Componentfinder;
import com.Athira.kelexam.model.EssayQuery;
import com.Athira.kelexam.model.FIBQuery;
import com.Athira.kelexam.model.MCQQuery;
import com.Athira.kelexam.model.MTFQuery;
import com.Athira.kelexam.model.TFQuery;
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

public class InsertController implements ActionListener{
	private JDialog dialog=null;
	private Componentfinder finder=null;
	private JTable table=null;

	public InsertController(JDialog dialog,JTable table) {
		this.dialog=dialog;
		finder=new Componentfinder(dialog.getContentPane());
		this.table=table;
	}
	@SuppressWarnings("unchecked")
	private String getQuestionId() {
		int rowCount=table.getRowCount();
		if (rowCount==0) {
			return SelectionController.PAPER.substring(0,SelectionController.PAPER.length()-1)+1001;
		}
		Model model=((BeanTableModel<Model>)table.getModel())
        .getRow(table.getRowCount()-1);
		String id=model.getQuestionId();
		String newId=id.substring(0, id.length()-4)+ 
				(Integer.parseInt(id.substring(id.length()-4, id.length()))+1);
		
		return newId;
		
	}
private void questionType() throws SQLException
{
if(dialog instanceof MCQDialog) {
	MCQmodel mcq=new MCQmodel();
	mcq.setQuestion(((JTextArea)finder.findComponent("question")).getText());
	mcq.setAnswer(((JTextField)finder.findComponent("Ca")).getText());
	mcq.setOption1(((JTextField) finder.findComponent("oop1")).getText());
	mcq.setOption2(((JTextField) finder.findComponent("oop2")).getText());
	mcq.setOption3(((JTextField) finder.findComponent("oop3")).getText());
	mcq.setQuestionId(getQuestionId());
	if (mcq.Empty()) {
		throw new NullPointerException();
	}
	new MCQQuery().insertQuestion(mcq);
	new SelectionController(table).setTable("mcq");
}
else if(dialog instanceof TrueFalseDialog) {
	TFmodel tf=new TFmodel();
	tf.setQuestion(((JTextArea)finder.findComponent("TF TA")).getText());
	if(((JRadioButton) finder.findComponent("true rb")).isSelected()) {
		tf.setAnswer(true);
	}
	else {
		tf.setAnswer(false);
	}
	tf.setQuestionId(getQuestionId());
	new TFQuery().insertQuestion(tf);
	new SelectionController(table).setTable("t/f");
}
else if (dialog instanceof MTFDialog ) {
	MTFmodel mtf=new MTFmodel();
	mtf.setQuestion(((JTextArea)finder.findComponent("mtf question")).getText());
	mtf.setAnswer(((JTextField)finder.findComponent("ans tf 1")).getText());
	mtf.setQuestionId(getQuestionId());
	if (mtf.Empty()) {
		throw new NullPointerException();
	}	
	new MTFQuery().insertQuestion(mtf);
	new SelectionController(table).setTable("mtf");
}
else if(dialog instanceof FIBDialog) {
	FIBmodel fib=new FIBmodel();
	fib.setQuestion(((JTextArea)finder.findComponent("ta_fib")).getText());
	fib.setAnswer(((JTextField)finder.findComponent("fib_tf")).getText());
	fib.setQuestionId(getQuestionId());
	if (fib.Empty()) {
		throw new NullPointerException();
	}
	new FIBQuery().insertQuestion(fib);
	new SelectionController(table).setTable("fib");
}
else if (dialog instanceof EssayDialog) {
	Essaymodel essay =new Essaymodel();
	essay.setQuestion(((JTextArea)finder.findComponent("question")).getText());
	try {
		essay.setMark(Integer.parseInt(((JTextField)finder.findComponent("mark")).getText()));
	} catch (Exception e) {
		// TODO: handle exception
		JOptionPane.showMessageDialog(null, "Enter number", "WARNING", 
				JOptionPane.WARNING_MESSAGE);
	}
	essay.setQuestionId(getQuestionId());
	if (essay.Empty()) {
		throw new NullPointerException();
	}
	new EssayQuery().insertQuestion(essay);
	new SelectionController(table).setTable("essay");
}
}
	public void actionPerformed(ActionEvent e) {
	try {
		questionType();
		JOptionPane.showMessageDialog(null, "Question inserted successfully", "INSERTED", 
				JOptionPane.PLAIN_MESSAGE);
	} catch (SQLException e2) {
		// TODO: handle exception
		e2.printStackTrace();
		JOptionPane.showMessageDialog(null, "Request failed", "WARNING", 
				JOptionPane.WARNING_MESSAGE);
	} 
	catch (Exception e2) {
		// TODO: handle exception
		e2.printStackTrace();
		JOptionPane.showMessageDialog(null, "Fields cannot be empty \n mark should be between 1 and 15",
				"WARNING", JOptionPane.WARNING_MESSAGE);
	}		
	
	}

}
