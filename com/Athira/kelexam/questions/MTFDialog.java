package com.Athira.kelexam.questions;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import com.Athira.kelexam.questions.controller.InsertController;
import com.Athira.kelexam.questions.controller.UpdateController;
import com.Athira.kelexam.questions.model.MTFmodel;

import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class MTFDialog extends JDialog {

	private final JPanel mtfPanel = new JPanel();
	private JTextField answerTxt;
	private JButton cancelBtn;

	

	/**
	 * Create the dialog.
	 */
	public MTFDialog(MTFmodel mtf,JTable table) {
		Image iconImage=null;
		try {
			URL url=getClass().getResource("/resources/keltron.jpg");
			iconImage=ImageIO.read(url)
					.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		} catch (Exception e) {
		//	e.printStackTrace();
		}
		setIconImage(iconImage);
		setResizable(false);
		setModal(true);
		Dimension size=Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int)size.getWidth()/2-401, (int)size.getHeight()/2-273, 803, 547);
		setTitle("Match The Following");
		getContentPane().setLayout(new BorderLayout());
		mtfPanel.setForeground(new Color(240, 255, 255));
		mtfPanel.setBackground(new Color(193, 255, 193));
		mtfPanel.setFont(new Font("Tw Cen MT Condensed", Font.BOLD | Font.ITALIC, 20));
		mtfPanel.setName("mtf p");
		mtfPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(mtfPanel, BorderLayout.CENTER);
		mtfPanel.setLayout(null);
		{
			JLabel questionLabel = new JLabel("Question");
			questionLabel.setForeground(new Color(0, 0, 0));
			questionLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
			questionLabel.setName("mtf l");
			questionLabel.setBounds(43, 79, 128, 49);
			mtfPanel.add(questionLabel);
		}
		{
			JLabel answerLabel = new JLabel("Answer");
			answerLabel.setForeground(new Color(0, 128, 0));
			answerLabel.setName("l ans");
			answerLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
			answerLabel.setBounds(43, 304, 116, 38);
			mtfPanel.add(answerLabel);
		}
		{
			answerTxt = new JTextField();
			answerTxt.setName("ans tf 1");
			answerTxt.setBounds(201, 280, 538, 114);
			mtfPanel.add(answerTxt);
			answerTxt.setColumns(10);
		}
		
		JTextArea questionTxtArea = new JTextArea();
		questionTxtArea.setName("mtf question");
		questionTxtArea.setWrapStyleWord(true);
		questionTxtArea.setLineWrap(true);
		questionTxtArea.setBounds(201, 34, 538, 138);
		mtfPanel.add(questionTxtArea);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(193, 255, 193));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT,20,5));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
			    JButton updateBtn = new JButton("Update");
			    updateBtn.setForeground(new Color(0, 0, 0));
			    updateBtn.setName("update");
			    updateBtn.setFocusPainted(false);
			    updateBtn.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			    updateBtn.setPreferredSize(new Dimension(110, 30));
			    updateBtn.setFont(new Font("Times New Roman", Font.BOLD, 25));
			    updateBtn.setActionCommand("OK");
			    updateBtn.addActionListener(new UpdateController( mtf,this,table));
			    buttonPane.add(updateBtn);
			}
			{
				JButton insertBtn = new JButton("Insert");
				insertBtn.setPreferredSize(new Dimension(110, 30));
				insertBtn.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				insertBtn.setFocusPainted(false);
				insertBtn.setForeground(new Color(0, 0, 0));
				insertBtn.setFont(new Font("Times New Roman", Font.BOLD, 25));
				insertBtn.setName("in_b");
				insertBtn.setActionCommand("OK");
				insertBtn.addActionListener(new InsertController(this, table));
				buttonPane.add(insertBtn);
				getRootPane().setDefaultButton(insertBtn);
			}
			{
				cancelBtn = new JButton("Cancel");
				cancelBtn.setPreferredSize(new Dimension(110, 30));
				cancelBtn.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				cancelBtn.setFocusPainted(false);
				cancelBtn.setName("b cancel");
				cancelBtn.setForeground(new Color(0, 0, 0));
				cancelBtn.setFont(new Font("Times New Roman", Font.BOLD, 25));
				cancelBtn.setActionCommand("Cancel");
				cancelBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				buttonPane.add(cancelBtn);
			}
		}
		if (mtf!=null) {
			questionTxtArea.setText(mtf.getQuestion());
			answerTxt.setText(mtf.getAnswer());
			
		}
	}
}
