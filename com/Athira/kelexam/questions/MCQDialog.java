package com.Athira.kelexam.questions;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.net.URL;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import com.Athira.kelexam.questions.controller.InsertController;
import com.Athira.kelexam.questions.controller.UpdateController;
import com.Athira.kelexam.questions.model.MCQmodel;

@SuppressWarnings("serial")
public class MCQDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField answerTxt;
	private JTextField option1Txt;
	private JTextField option2Txt;
	private JTextField option3Txt;

	
	/**
	 * Create the dialog.
	 */
	public MCQDialog(MCQmodel mcq,JTable table) {
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
		setTitle("Multiple Choice Question");
		Dimension size=Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int)size.getWidth()/2-464, (int)size.getHeight()/2-311, 928, 622);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.activeCaptionBorder);
		contentPanel.setName("mcq dialog");
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel questionLabel = new JLabel("Question");
			questionLabel.setName("question label");
			questionLabel.setForeground(new Color(0, 0, 0));
			questionLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
			questionLabel.setBounds(40, 20, 105, 31);
			contentPanel.add(questionLabel);
		}
		
		JTextArea questionTxtArea = new JTextArea();
		questionTxtArea.setWrapStyleWord(true);
		questionTxtArea.setLineWrap(true);
		questionTxtArea.setName("question");
		questionTxtArea.setBounds(215, 10, 651, 153);
		contentPanel.add(questionTxtArea);
		
		JLabel answerLabel = new JLabel("Correct Answer");
		answerLabel.setForeground(new Color(0, 128, 0));
		answerLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		answerLabel.setName("answer label");
		answerLabel.setBounds(40, 186, 200, 54);
		contentPanel.add(answerLabel);
		
		answerTxt = new JTextField();
		answerTxt.setName("Ca");
		answerTxt.setBounds(40, 250, 316, 60);
		contentPanel.add(answerTxt);
		answerTxt.setColumns(10);
		
		JLabel otherOptionLabel = new JLabel("Other Options");
		otherOptionLabel.setForeground(new Color(255, 69, 0));
		otherOptionLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		otherOptionLabel.setName("O OP");
		otherOptionLabel.setBounds(488, 195, 168, 37);
		contentPanel.add(otherOptionLabel);
		
		option1Txt = new JTextField();
		option1Txt.setName("oop1");
		option1Txt.setBounds(453, 250, 316, 60);
		contentPanel.add(option1Txt);
		option1Txt.setColumns(10);
		
		option2Txt = new JTextField();
		option2Txt.setName("oop2");
		option2Txt.setBounds(453, 345, 316, 60);
		contentPanel.add(option2Txt);
		option2Txt.setColumns(10);
		
		option3Txt = new JTextField();
		option3Txt.setName("oop3");
		option3Txt.setBounds(453, 440, 316, 60);
		contentPanel.add(option3Txt);
		option3Txt.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.activeCaptionBorder);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT,20, 5));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
			    JButton updateBtn = new JButton("Update");
			    updateBtn.setForeground(new Color(0, 0, 128));
			    updateBtn.setName("update");
			    updateBtn.setFocusPainted(false);
			    updateBtn.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			    updateBtn.setPreferredSize(new Dimension(110, 30));
			    updateBtn.setFont(new Font("Times New Roman", Font.BOLD, 25));
			    updateBtn.setActionCommand("OK");
			    updateBtn.addActionListener(new UpdateController( mcq,this,table));
			    buttonPane.add(updateBtn);
			}
			{
				JButton insertBtn = new JButton("Insert");
				insertBtn.addActionListener(new InsertController(this, table));
				insertBtn.setPreferredSize(new Dimension(90, 30));
				insertBtn.setFocusPainted(false);
				insertBtn.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				insertBtn.setForeground(new Color(0, 0, 128));
				insertBtn.setFont(new Font("Times New Roman", Font.BOLD, 25));
				insertBtn.setName("Insert_b");
				insertBtn.setActionCommand("OK");
				buttonPane.add(insertBtn);
				getRootPane().setDefaultButton(insertBtn);
			}
			{
				JButton cancelBtn = new JButton("Cancel");
				cancelBtn.setPreferredSize(new Dimension(90, 30));
				cancelBtn.setFocusPainted(false);
				cancelBtn.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				cancelBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelBtn.setForeground(new Color(0, 0, 128));
				cancelBtn.setFont(new Font("Times New Roman", Font.BOLD, 25));
				cancelBtn.setActionCommand("Cancel");
				buttonPane.add(cancelBtn);
			}
		}
		
		if (mcq!=null) {
			questionTxtArea.setText(mcq.getQuestion());
			answerTxt.setText(mcq.getAnswer());
			option1Txt.setText(mcq.getOption1());
			option2Txt.setText(mcq.getOption2());
			option3Txt.setText(mcq.getOption3());
		}
	}
}
