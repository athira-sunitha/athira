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

import com.Athira.kelexam.generator.controller.Componentfinder;
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

public class UpdateController implements ActionListener {

	private Model model=null;
	private Componentfinder finder=null;
	private JDialog dialog=null;
	private JTable table=null;

	public UpdateController(Model model,JDialog dialog,JTable table) {
		this.model=model;
		finder=new Componentfinder(dialog.getContentPane());
		this.dialog=dialog;
		this.table=table;
	}
private void questionType() throws SQLException
{
if(model instanceof MCQmodel) {
	MCQmodel mcq=(MCQmodel)model;
	mcq.setQuestion(((JTextArea)finder.findComponent("question")).getText());
	mcq.setAnswer(((JTextField)finder.findComponent("Ca")).getText());
	mcq.setOption1(((JTextField) finder.findComponent("oop1")).getText());
	mcq.setOption2(((JTextField) finder.findComponent("oop2")).getText());
	mcq.setOption3(((JTextField) finder.findComponent("oop3")).getText());
	if (mcq.Empty()) {
		throw new NullPointerException();
	}
	new MCQQuery().updateQuestion(mcq);
	new SelectionController(table).setTable("mcq");
}
else if(model instanceof TFmodel) {
	TFmodel tf=(TFmodel)model;
	tf.setQuestion(((JTextArea)finder.findComponent("TF TA")).getText());
	tf.setAnswer(Boolean.parseBoolean(((JRadioButton) finder.findComponent("true rb")).getModel().getGroup().getSelection().getActionCommand()));
	new TFQuery().updateQuestion(tf);
	new SelectionController(table).setTable("t/f");
}
else if (model instanceof MTFmodel ) {
	MTFmodel mtf=(MTFmodel)model;
	mtf.setQuestion(((JTextArea)finder.findComponent("mtf question")).getText());
	mtf.setAnswer(((JTextField)finder.findComponent("ans tf 1")).getText());
	if (mtf.Empty()) {
		throw new NullPointerException();
	}	
	new MTFQuery().updateQuestion(mtf);
	new SelectionController(table).setTable("mtf");
}
else if(model instanceof FIBmodel) {
	FIBmodel fib=(FIBmodel)model;
	fib.setQuestion(((JTextArea)finder.findComponent("ta_fib")).getText());
	fib.setAnswer(((JTextField)finder.findComponent("fib_tf")).getText());
	if (fib.Empty()) {
		throw new NullPointerException();
	}
	new FIBQuery().updateQuestion(fib);
	new SelectionController(table).setTable("fib");
}
else if (model instanceof Essaymodel) {
	Essaymodel essay =(Essaymodel)model;
	essay.setQuestion(((JTextArea)finder.findComponent("question")).getText());
	try {
		essay.setMark(Integer.parseInt(((JTextField)finder.findComponent("mark")).getText()));
	} catch (Exception e) {
		// TODO: handle exception
		JOptionPane.showMessageDialog(null, "Enter number", "WARNING", 
				JOptionPane.WARNING_MESSAGE);
	}
	if (essay.Empty()) {
		throw new NullPointerException();
	}
	new EssayQuery().updateQuestion(essay);
	new SelectionController(table).setTable("essay");
}
}
	public void actionPerformed(ActionEvent e) {
	try {
		questionType();	
		JOptionPane.showMessageDialog(null, "Question updated successfully", "UPDATED", 
				JOptionPane.PLAIN_MESSAGE);
		dialog.dispose();
	}catch (SQLException e2) {
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
