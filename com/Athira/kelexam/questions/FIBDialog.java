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
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import com.Athira.kelexam.questions.controller.InsertController;
import com.Athira.kelexam.questions.controller.UpdateController;
import com.Athira.kelexam.questions.model.FIBmodel;

@SuppressWarnings("serial")
public class FIBDialog extends JDialog {

	private final JPanel fibPanel = new JPanel();
	private JTextField answerTxt;
	private JTextArea questionTxtArea;
	

	/**
	 * Create the dialog.
	 */
	public FIBDialog(FIBmodel fib,JTable table) {
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
		setBounds((int)size.getWidth()/2-401, (int)size.getHeight()/2-273, 803, 547);
		setTitle("Fill In The Blanks");
		getContentPane().setLayout(new BorderLayout());
		fibPanel.setBackground(new Color(255, 228, 225));
		fibPanel.setName("fib_p");
		fibPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(fibPanel, BorderLayout.CENTER);
		fibPanel.setLayout(null);
		{
			JLabel questionLabel = new JLabel("Question");
			questionLabel.setName("questionlabel");
			questionLabel.setForeground(new Color(0, 0, 0));
			questionLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
			questionLabel.setBounds(38, 84, 152, 54);
			fibPanel.add(questionLabel);
		}
		{
			questionTxtArea = new JTextArea();
			questionTxtArea.setWrapStyleWord(true);
			questionTxtArea.setLineWrap(true);
			questionTxtArea.setName("ta_fib");
			questionTxtArea.setBounds(230, 52, 527, 169);
			fibPanel.add(questionTxtArea);
		}
		{
			JLabel answerLabel = new JLabel("Answer");
			answerLabel.setForeground(new Color(0, 128, 0));
			answerLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
			answerLabel.setName("fib_l1");
			answerLabel.setBounds(38, 300, 152, 54);
			fibPanel.add(answerLabel);
		}
		{
			answerTxt = new JTextField();
			answerTxt.setName("fib_tf");
			answerTxt.setBounds(230, 291, 461, 82);
			fibPanel.add(answerTxt);
			answerTxt.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 228, 225));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT,20,5));
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
			    updateBtn.addActionListener(new UpdateController( fib,this,table));
			    buttonPane.add(updateBtn);
			}
			{
				JButton insertBtn = new JButton("Insert");
				insertBtn.setPreferredSize(new Dimension(110, 30));
				insertBtn.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				insertBtn.setFocusPainted(false);
				insertBtn.setName("f ins");
				insertBtn.setForeground(new Color(0, 0, 128));
				insertBtn.setFont(new Font("Times New Roman", Font.BOLD, 25));
				insertBtn.setActionCommand("OK");
				insertBtn.addActionListener(new InsertController(this, table));
				buttonPane.add(insertBtn);
				getRootPane().setDefaultButton(insertBtn);
			}
			{
				JButton cancelBtn = new JButton("Cancel");
				cancelBtn.setPreferredSize(new Dimension(110, 30));
				cancelBtn.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				cancelBtn.setFocusPainted(false);
				cancelBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelBtn.setForeground(new Color(0, 0, 128));
				cancelBtn.setFont(new Font("Times New Roman", Font.BOLD, 25));
				cancelBtn.setName("f cancel");
				cancelBtn.setActionCommand("Cancel");
				buttonPane.add(cancelBtn);
			}
		}
		if (fib!=null) {
			questionTxtArea.setText(fib.getQuestion());
			answerTxt.setText(fib.getAnswer());
			
		}
	}

}
