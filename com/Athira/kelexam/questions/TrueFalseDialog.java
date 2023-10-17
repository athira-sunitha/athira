package com.Athira.kelexam.questions;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import com.Athira.kelexam.questions.controller.InsertController;
import com.Athira.kelexam.questions.controller.UpdateController;
import com.Athira.kelexam.questions.model.TFmodel;

@SuppressWarnings("serial")
public class TrueFalseDialog extends JDialog {

	private final JPanel TFPanel = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextArea questionTxtArea=null;
	/**
	 * Create the dialog.
	 */
	public TrueFalseDialog(TFmodel tf,JTable table) {
		Image iconImage=null;
		try {
			URL url=getClass().getResource("/resources/keltron.jpg");
			iconImage=ImageIO.read(url)
					.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		} catch (Exception e) {
			//e.printStackTrace();
		}
		setIconImage(iconImage);
		setResizable(false);
		setModal(true);
		Dimension size=Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int)size.getWidth()/2-461, (int)size.getHeight()/2-273, 922, 547);
		setTitle("True/False");
		getContentPane().setLayout(new BorderLayout());
		TFPanel.setBackground(new Color(255, 228, 225));
		TFPanel.setName("TF P");
		TFPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(TFPanel, BorderLayout.CENTER);
		TFPanel.setLayout(null);
		{
			JLabel questionLabel = new JLabel("Question");
			questionLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
			questionLabel.setForeground(new Color(0, 0, 0));
			questionLabel.setName("TF L");
			questionLabel.setBounds(33, 57, 125, 44);
			TFPanel.add(questionLabel);
		}
		{
			questionTxtArea = new JTextArea();
			questionTxtArea.setLineWrap(true);
			questionTxtArea.setWrapStyleWord(true);
			questionTxtArea.setName("TF TA");
			questionTxtArea.setBounds(168, 57, 683, 201);
			TFPanel.add(questionTxtArea);
		}
		{
			JLabel answerLabel = new JLabel("Answer");
			answerLabel.setForeground(new Color(0, 128, 0));
			answerLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
			answerLabel.setName("ans l");
			answerLabel.setBounds(33, 348, 96, 35);
			TFPanel.add(answerLabel);
		}
		
		JRadioButton trueRB = new JRadioButton("True");
		trueRB.setFocusPainted(false);
		trueRB.setOpaque(false);
		buttonGroup.add(trueRB);
		trueRB.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 20));
		trueRB.setName("true rb");
		trueRB.setBounds(179, 339, 114, 44);
		TFPanel.add(trueRB);
		
		JRadioButton falseRB = new JRadioButton("False");
		falseRB.setFocusPainted(false);
		falseRB.setForeground(new Color(0, 0, 0));
		falseRB.setOpaque(false);
		buttonGroup.add(falseRB);
		falseRB.setName("false_rb");
		falseRB.setAutoscrolls(true);
		falseRB.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 20));
		falseRB.setBounds(386, 339, 114, 44);
		TFPanel.add(falseRB);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 228, 225));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT,20,5));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
			    JButton updateBtn = new JButton("Update");
			    updateBtn.setForeground(new Color(0, 0, 205));
			    updateBtn.setName("update");
			    updateBtn.setFocusPainted(false);
			    updateBtn.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			    updateBtn.setPreferredSize(new Dimension(110, 30));
			    updateBtn.setFont(new Font("Times New Roman", Font.BOLD, 25));
			    updateBtn.setActionCommand("OK");
			    updateBtn.addActionListener(new UpdateController( tf,this,table));
			    buttonPane.add(updateBtn);
			}
			{
				JButton insertBtn = new JButton("Insert");
				insertBtn.setFocusPainted(false);
				insertBtn.addActionListener(new InsertController(this, table));
				insertBtn.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				insertBtn.setPreferredSize(new Dimension(110, 30));
				insertBtn.setName("insert");
				insertBtn.setForeground(new Color(0, 0, 205));
				insertBtn.setFont(new Font("Times New Roman", Font.BOLD, 25));
				insertBtn.setActionCommand("OK");
				buttonPane.add(insertBtn);
				getRootPane().setDefaultButton(insertBtn);
			}
			{
				JButton cancelBtn = new JButton("Cancel");
				cancelBtn.setFocusPainted(false);
				cancelBtn.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				cancelBtn.setPreferredSize(new Dimension(110, 30));
				cancelBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelBtn.setName("CB");
				cancelBtn.setForeground(new Color(0, 0, 205));
				cancelBtn.setFont(new Font("Times New Roman", Font.BOLD, 25));
				cancelBtn.setActionCommand("Cancel");
				buttonPane.add(cancelBtn);
			}
		}
		if (tf!=null) {
			questionTxtArea.setText(tf.getQuestion());
			if (tf.isAnswer()) {
				trueRB.setSelected(true);
			} else {
				falseRB.setSelected(true);
			}
		}
	}
}
