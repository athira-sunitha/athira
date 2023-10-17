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
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;

import com.Athira.kelexam.questions.controller.InsertController;
import com.Athira.kelexam.questions.controller.UpdateController;
import com.Athira.kelexam.questions.model.Essaymodel;

import javax.swing.JTextField;

@SuppressWarnings("serial")
public class EssayDialog extends JDialog {

	private final JPanel essayPanel = new JPanel();
	private JTextField markTxt;
	private JTextArea questionTxtArea ;


	/**
	 * Create the dialog.
	 */
	public EssayDialog(Essaymodel essay,JTable table) {
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
		setBounds((int)size.getWidth()/2-443, (int)size.getHeight()/2-252, 887, 505);
		setTitle("Essay");
		getContentPane().setLayout(new BorderLayout());
		essayPanel.setBackground(SystemColor.inactiveCaption);
		essayPanel.setName("eaay p");
		essayPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(essayPanel, BorderLayout.CENTER);
		essayPanel.setLayout(null);
		{
			JLabel questionLabel = new JLabel("Question");
			questionLabel.setForeground(new Color(0, 0, 0));
			questionLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
			questionLabel.setName("essay_l");
			questionLabel.setBounds(10, 190, 124, 33);
			essayPanel.add(questionLabel);
		}
		{
			questionTxtArea = new JTextArea();
			questionTxtArea.setWrapStyleWord(true);
			questionTxtArea.setLineWrap(true);
			questionTxtArea.setName("question");
			questionTxtArea.setBounds(173, 83, 690, 255);
			essayPanel.add(questionTxtArea);
		}
		{
			JLabel markLabel = new JLabel("Mark");
			markLabel.setName("mark label");
			markLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
			markLabel.setBounds(10, 363, 124, 33);
			essayPanel.add(markLabel);
		}
		
		markTxt = new JTextField();
		markTxt.setName("mark");
		markTxt.setBounds(173, 363, 159, 44);
		essayPanel.add(markTxt);
		markTxt.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.inactiveCaption);
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
			    updateBtn.addActionListener(new UpdateController( essay,this,table));
			    buttonPane.add(updateBtn);
			}
			{
				JButton insertBtn = new JButton("Insert");
				insertBtn.setPreferredSize(new Dimension(110, 30));
				insertBtn.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				insertBtn.setFocusPainted(false);
				insertBtn.setForeground(new Color(0, 0, 0));
				insertBtn.setName("Essayins");
				insertBtn.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
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
				cancelBtn.setName("Esscancel");
				cancelBtn.setForeground(new Color(0, 0, 0));
				cancelBtn.setFont(new Font("Times New Roman", Font.BOLD, 25));
				cancelBtn.setActionCommand("Cancel");
				buttonPane.add(cancelBtn);
			}
		}
		if (essay!=null) {
			questionTxtArea.setText(essay.getQuestion());
			markTxt.setText(essay.getMark()+"");
			
		}
	}
}
