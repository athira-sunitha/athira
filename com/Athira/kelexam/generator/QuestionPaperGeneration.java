package com.Athira.kelexam.generator;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.Athira.kelexam.PaperController;
import com.Athira.kelexam.generator.controller.Cancelbutton;
import com.Athira.kelexam.generator.controller.GenerateQuestionPaper;
import com.Athira.kelexam.model.CourseModel;
import com.Athira.kelexam.model.CourseQuery;
import com.Athira.kelexam.model.PaperModel;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.io.IOException;
import java.sql.SQLException;
import java.time.OffsetDateTime;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import java.awt.ComponentOrientation;
import java.awt.Dimension;

import com.toedter.components.JSpinField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ItemListener;


@SuppressWarnings("serial")
public class QuestionPaperGeneration extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public QuestionPaperGeneration() {
		setResizable(false);
	
		Dimension size=Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, 1000, (int)size.getHeight()-60);
		contentPane = new JPanel();
		contentPane.setName("hai");
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel headLabel = new JLabel("QUESTION PAPER GENERATION");
		headLabel.setForeground(new Color(255, 0, 0));
		headLabel.setName("head");
		headLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		headLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		headLabel.setBackground(new Color(0, 206, 209));
		headLabel.setOpaque(true);
		headLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		JLabel courselbl = new JLabel("Course Name :");
		courselbl.setName("course label");
		courselbl.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		
		
		JComboBox<CourseModel> courseCombo = new JComboBox<CourseModel>();
		
		courseCombo.setName("course");
		DefaultComboBoxModel<CourseModel> courseListModel=new DefaultComboBoxModel<CourseModel> ();
		try {
			courseListModel.addAll(new CourseQuery().retriveCourse());
		} catch (SQLException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(this, "Couldn't load properly","DATABASE ERROR",
					JOptionPane.WARNING_MESSAGE);
		}
		courseCombo.setModel(courseListModel);
		courseCombo.setSelectedIndex(0);
		courseCombo.setFont(new Font("Monospaced", Font.PLAIN, 16));
		
		
		JLabel subjectlbl = new JLabel("Subject Name :");
		subjectlbl.setName("subject label");
		subjectlbl.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		
	
		JComboBox<PaperModel> subjectCombo = new JComboBox<PaperModel>();
		subjectCombo.setName("subject");
		subjectCombo.setModel(new DefaultComboBoxModel<PaperModel> ());
		subjectCombo.addItem(new PaperModel("","Select a subject"));
		courseCombo.addItemListener(new PaperController(subjectCombo,contentPane));
		subjectCombo.setFont(new Font("Monospaced", Font.PLAIN, 16));
		
		JLabel monthlbl = new JLabel("Month  :");
		monthlbl.setName("month label");
		monthlbl.setLabelFor(this);
		monthlbl.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		final String months[]= {"JANUARY","FEBRUARY","MARCH","APRIL", 
				"MAY","JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER" , "DECEMBER"
		};
	
		JComboBox<String> monthCombo = new JComboBox<String>();
		monthCombo.setName("month");
		monthCombo.setModel(new DefaultComboBoxModel<String> (months));
		final String years[]=new String[5];
		years[0]=(OffsetDateTime.now().getYear()-2)+"";
		years[1]=(OffsetDateTime.now().getYear()-1)+"";
		years[2]=(OffsetDateTime.now().getYear())+"";
		years[3]=(OffsetDateTime.now().getYear()+1)+"";
		years[4]=(OffsetDateTime.now().getYear()+2)+"";
		JComboBox<String> yearCombo = new JComboBox<String>();
		yearCombo.setName("year");
		yearCombo.setModel(new DefaultComboBoxModel<String> (years));
		yearCombo.setSelectedIndex(2);
		
		JLabel yearlbl = new JLabel("Year :");
		yearlbl.setName("year label");
		yearlbl.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		
		JButton generateBtn = new JButton("Generate Question Paper");
		generateBtn.setForeground(new Color(0, 100, 0));
		generateBtn.setFocusPainted(false);
		generateBtn.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		generateBtn.setBackground(new Color(0, 206, 209));
		generateBtn.setName("generate");
		
		generateBtn.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JCheckBox tfCB = new JCheckBox("T/F Questions      ");
		tfCB.setOpaque(false);
		tfCB.setName("checkbox 2");
		tfCB.setHorizontalTextPosition(SwingConstants.LEFT);
		tfCB.setHorizontalAlignment(SwingConstants.LEFT);
		tfCB.setFont(new Font("Monospaced", Font.BOLD, 16));
		tfCB.setFocusPainted(false);
		tfCB.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		JCheckBox mtfCB = new JCheckBox("MTF Questions      ");
		mtfCB.setOpaque(false);
		mtfCB.setName("checkbox 3");
		mtfCB.setHorizontalTextPosition(SwingConstants.LEFT);
		mtfCB.setHorizontalAlignment(SwingConstants.LEFT);
		mtfCB.setFont(new Font("Monospaced", Font.BOLD, 16));
		mtfCB.setFocusPainted(false);
		mtfCB.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		JCheckBox fibCB = new JCheckBox("FIB Questions      ");
		fibCB.setOpaque(false);
		fibCB.setName("checkbox 4");
		fibCB.setHorizontalTextPosition(SwingConstants.LEFT);
		fibCB.setHorizontalAlignment(SwingConstants.LEFT);
		fibCB.setFont(new Font("Monospaced", Font.BOLD, 16));
		fibCB.setFocusPainted(false);
		fibCB.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		JCheckBox essayCB = new JCheckBox("Essay Questions    ");
		essayCB.setOpaque(false);
		essayCB.setName("checkbox 5");
		essayCB.setHorizontalTextPosition(SwingConstants.LEFT);
		essayCB.setHorizontalAlignment(SwingConstants.LEFT);
		essayCB.setFont(new Font("Monospaced", Font.BOLD, 16));
		essayCB.setFocusPainted(false);
		essayCB.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		JCheckBox mark2CB = new JCheckBox("2 Mark Questions   ");
		mark2CB.setOpaque(false);
		mark2CB.setName("checkbox 6");
		mark2CB.setHorizontalTextPosition(SwingConstants.LEFT);
		mark2CB.setHorizontalAlignment(SwingConstants.LEFT);
		mark2CB.setFont(new Font("Monospaced", Font.BOLD, 16));
		mark2CB.setFocusPainted(false);
		mark2CB.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		JCheckBox mark4CB = new JCheckBox("4 Mark Questions   ");
		mark4CB.setOpaque(false);
		mark4CB.setName("checkbox 7");
		mark4CB.setHorizontalTextPosition(SwingConstants.LEFT);
		mark4CB.setHorizontalAlignment(SwingConstants.LEFT);
		mark4CB.setFont(new Font("Monospaced", Font.BOLD, 16));
		mark4CB.setFocusPainted(false);
		mark4CB.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		JCheckBox mark5CB = new JCheckBox("5 Mark Questions   ");
		mark5CB.setOpaque(false);
		mark5CB.setName("checkbox 8");
		mark5CB.setHorizontalTextPosition(SwingConstants.LEFT);
		mark5CB.setHorizontalAlignment(SwingConstants.LEFT);
		mark5CB.setFont(new Font("Monospaced", Font.BOLD, 16));
		mark5CB.setFocusPainted(false);
		mark5CB.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		JCheckBox chckbxNewCheckBox_7 = new JCheckBox("10 Mark Questions  ");
		chckbxNewCheckBox_7.setOpaque(false);
		chckbxNewCheckBox_7.setName("checkbox 9");
		chckbxNewCheckBox_7.setHorizontalTextPosition(SwingConstants.LEFT);
		chckbxNewCheckBox_7.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxNewCheckBox_7.setFont(new Font("Monospaced", Font.BOLD, 16));
		chckbxNewCheckBox_7.setFocusPainted(false);
		chckbxNewCheckBox_7.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		JCheckBox mcqCB = new JCheckBox("MCQ Questions     ");
		mcqCB.setIconTextGap(10);
		mcqCB.setOpaque(false);
		mcqCB.setName("checkbox 1");
		mcqCB.setHorizontalAlignment(SwingConstants.LEFT);
		mcqCB.setFont(new Font("Monospaced", Font.BOLD, 16));
		mcqCB.setFocusPainted(false);
		mcqCB.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		JLabel label1 = new JLabel("Question Type");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label1.setName("lbl1");
		
		JLabel label2 = new JLabel("Max Question Count");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label2.setName("lbl2");
		
		JLabel lblNewLabel = new JLabel("Max Total Mark");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setName("lbl3");
		
		JSpinner countSpinner1 = new JSpinner();
		countSpinner1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		countSpinner1.setName("spiner1");
		countSpinner1.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		
		JSpinner countSpinner2 = new JSpinner();
		countSpinner2.setModel(new SpinnerNumberModel(0, 0, 20, 1));
		countSpinner2.setName("spiner2");
		countSpinner2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JSpinner countSpinner3 = new JSpinner();
		countSpinner3.setModel(new SpinnerNumberModel(0, 0, 20, 1));
		countSpinner3.setName("spiner3");
		countSpinner3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JSpinner countSpinner4 = new JSpinner();
		countSpinner4.setModel(new SpinnerNumberModel(0, 0, 20, 1));
		countSpinner4.setName("spiner4");
		countSpinner4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JSpinner countSpinner5 = new JSpinner();
		countSpinner5.setModel(new SpinnerNumberModel(0, 0, 20, 1));
		countSpinner5.setName("spiner5");
		countSpinner5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JSpinner countSpinner6 = new JSpinner();
		countSpinner6.setModel(new SpinnerNumberModel(0, 0, 20, 1));
		countSpinner6.setName("spiner6");
		countSpinner6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JSpinner countSpinner7 = new JSpinner();
		countSpinner7.setModel(new SpinnerNumberModel(0, 0, 20, 1));
		countSpinner7.setName("spiner7");
		countSpinner7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JSpinner countSpinner8 = new JSpinner();
		countSpinner8.setModel(new SpinnerNumberModel(0, 0, 20, 1));
		countSpinner8.setName("spiner8");
		countSpinner8.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JSpinner countSpinner9 = new JSpinner();
		countSpinner9.setModel(new SpinnerNumberModel(0, 0, 20, 1));
		countSpinner9.setName("spiner9");
		countSpinner9.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JSpinner markSpinner1 = new JSpinner();
		markSpinner1.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		markSpinner1.setName("spiner10");
		markSpinner1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JSpinner markSpinner2 = new JSpinner();
		markSpinner2.setModel(new SpinnerNumberModel(0, 0, 20, 1));
		markSpinner2.setName("spiner11");
		markSpinner2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JSpinner markSpinner3 = new JSpinner();
		markSpinner3.setModel(new SpinnerNumberModel(0, 0, 20, 1));
		markSpinner3.setName("spiner12");
		markSpinner3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JSpinner markSpinner4 = new JSpinner();
		markSpinner4.setModel(new SpinnerNumberModel(0, 0, 20, 1));
		markSpinner4.setName("spiner13");
		markSpinner4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JSpinner markSpinner5 = new JSpinner();
		markSpinner5.setModel(new SpinnerNumberModel(0, 0, 300, 15));
		markSpinner5.setName("spiner14");
		markSpinner5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JSpinner markSpinner6 = new JSpinner();
		markSpinner6.setModel(new SpinnerNumberModel(0, 0, 40, 2));
		markSpinner6.setName("spiner15");
		markSpinner6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JSpinner markSpinner7 = new JSpinner();
		markSpinner7.setModel(new SpinnerNumberModel(0, 0, 80, 4));
		markSpinner7.setName("spiner16");
		markSpinner7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JSpinner markSpinner8 = new JSpinner();
		markSpinner8.setModel(new SpinnerNumberModel(0, 0, 100, 5));
		markSpinner8.setName("spiner17");
		markSpinner8.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JSpinner markSpinner9 = new JSpinner();
		markSpinner9.setModel(new SpinnerNumberModel(0, 0, 200, 10));
		markSpinner9.setName("spiner18");
		markSpinner9.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(headLabel, GroupLayout.PREFERRED_SIZE, 976, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(54)
					.addComponent(courselbl, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
					.addGap(34)
					.addComponent(courseCombo, 0, 213, Short.MAX_VALUE)
					.addGap(480))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(54)
					.addComponent(subjectlbl, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
					.addGap(34)
					.addComponent(subjectCombo, 0, 213, Short.MAX_VALUE)
					.addGap(480))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(54)
					.addComponent(monthlbl, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
					.addGap(34)
					.addComponent(monthCombo, 0, 158, Short.MAX_VALUE)
					.addGap(93)
					.addComponent(yearlbl, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
					.addGap(22)
					.addComponent(yearCombo, 0, 120, Short.MAX_VALUE)
					.addGap(180))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(54)
					.addComponent(label1, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
					.addGap(55)
					.addComponent(label2, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
					.addGap(52)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
					.addGap(234))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(54)
					.addComponent(mcqCB, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
					.addGap(65)
					.addComponent(countSpinner1, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
					.addGap(153)
					.addComponent(markSpinner1, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
					.addGap(267))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(54)
					.addComponent(tfCB, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
					.addGap(65)
					.addComponent(countSpinner2, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
					.addGap(153)
					.addComponent(markSpinner2, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
					.addGap(267))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(54)
					.addComponent(mtfCB, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
					.addGap(65)
					.addComponent(countSpinner3, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
					.addGap(153)
					.addComponent(markSpinner3, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
					.addGap(267))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(54)
					.addComponent(fibCB, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
					.addGap(65)
					.addComponent(countSpinner4, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
					.addGap(153)
					.addComponent(markSpinner4, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
					.addGap(267))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(54)
					.addComponent(essayCB, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
					.addGap(65)
					.addComponent(countSpinner5, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
					.addGap(153)
					.addComponent(markSpinner5, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
					.addGap(267))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(54)
					.addComponent(mark2CB, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
					.addGap(65)
					.addComponent(countSpinner6, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
					.addGap(153)
					.addComponent(markSpinner6, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
					.addGap(267))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(54)
					.addComponent(mark4CB, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
					.addGap(65)
					.addComponent(countSpinner7, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
					.addGap(153)
					.addComponent(markSpinner7, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
					.addGap(267))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(54)
					.addComponent(mark5CB, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
					.addGap(65)
					.addComponent(countSpinner8, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
					.addGap(153)
					.addComponent(markSpinner8, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
					.addGap(267))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(54)
					.addComponent(chckbxNewCheckBox_7, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
					.addGap(65)
					.addComponent(countSpinner9, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
					.addGap(153)
					.addComponent(markSpinner9, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
					.addGap(267))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(302)
					.addComponent(generateBtn, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
					.addGap(403))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(headLabel, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(courselbl, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
							.addGap(2))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(courseCombo, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(subjectlbl, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
							.addGap(5))
						.addComponent(subjectCombo, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
					.addGap(9)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(monthlbl, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
							.addGap(5))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(9)
							.addComponent(monthCombo, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
						.addComponent(yearlbl, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(9)
							.addComponent(yearCombo, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)))
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label1, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
						.addComponent(label2, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(mcqCB, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(countSpinner1, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(markSpinner1, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE)))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(tfCB, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE)
							.addGap(6))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(countSpinner2, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(markSpinner2, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE)))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(mtfCB, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE)
							.addGap(6))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(countSpinner3, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(markSpinner3, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE)))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(fibCB, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE)
							.addGap(6))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(countSpinner4, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(markSpinner4, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE)))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(essayCB, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE)
							.addGap(6))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(countSpinner5, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(markSpinner5, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE)))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(mark2CB, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(countSpinner6, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(markSpinner6, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE)))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(mark4CB, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(countSpinner7, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(markSpinner7, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE)))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(mark5CB, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(countSpinner8, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(markSpinner8, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE)))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(chckbxNewCheckBox_7, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(countSpinner9, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(markSpinner9, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE)))
					.addGap(20)
					.addComponent(generateBtn, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		try {
			generateBtn.addActionListener(new GenerateQuestionPaper(contentPane));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
}
