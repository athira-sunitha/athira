package com.Athira.kelexam.questions;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.Athira.kelexam.BeanTableModel;
import com.Athira.kelexam.PaperController;
import com.Athira.kelexam.WindowLoading;
import com.Athira.kelexam.generator.controller.Componentfinder;
import com.Athira.kelexam.model.CourseModel;
import com.Athira.kelexam.model.PaperModel;
import com.Athira.kelexam.questions.controller.DeleteController;
import com.Athira.kelexam.questions.controller.Newcontroller;
import com.Athira.kelexam.questions.controller.SelectionController;
import com.Athira.kelexam.questions.model.Model;

import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.SQLException;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;
import javax.swing.SwingConstants;
import javax.swing.ListSelectionModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;



@SuppressWarnings("serial")
public class Question extends JFrame {

	private JPanel Questions_F;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox<CourseModel> courseCombo;
	private JTable questionTable=null;;
	private JComboBox<PaperModel> paperCombo=null;

	
	
	/**
	 * Create the frame.
	 */
	public Question() {
		Image iconImage=null;
		try {
			URL url=getClass().getResource("/resources/keltron.jpg");
			iconImage=ImageIO.read(url)
					.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		} catch (Exception e) {
			//e.printStackTrace();
		}
		setIconImage(iconImage);
		setTitle("Questions");
		Dimension size=Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, (int)size.getWidth(), (int)size.getHeight()-60);
		
		Questions_F = new JPanel();
		Questions_F.setBackground(SystemColor.info);
		Questions_F.setName("Question f");
		Questions_F.setForeground(new Color(0, 0, 205));
		Questions_F.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(Questions_F);
		
	    courseCombo = new JComboBox<CourseModel>();
		courseCombo.setName("course combo");
		courseCombo.setModel(new DefaultComboBoxModel<CourseModel>());
		
		JLabel label1 = new JLabel("Course Name");
		label1.setHorizontalTextPosition(SwingConstants.CENTER);
		label1.setHorizontalAlignment(SwingConstants.TRAILING);
		label1.setName("Course name l");
		label1.setForeground(new Color(75, 0, 130));
		label1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JLabel label2 = new JLabel("Paper Name");
		label2.setHorizontalAlignment(SwingConstants.TRAILING);
		label2.setName("paper");
		label2.setForeground(new Color(75, 0, 130));
		label2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		paperCombo = new JComboBox<PaperModel>();
		paperCombo.setName("paper combo");
		courseCombo.addItemListener(new PaperController(paperCombo));
		
		JLabel label3 = new JLabel("Question Type");
		label3.setName("question type");
		label3.setForeground(new Color(0, 0, 139));
		label3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JRadioButton mcqRB = new JRadioButton("MCQ");
		mcqRB.setFocusPainted(false);
		mcqRB.setBackground(SystemColor.info);
		mcqRB.setName("MCQB");
		mcqRB.setForeground(new Color(139, 0, 0));
		mcqRB.setFont(new Font("Tahoma", Font.BOLD, 17));
		buttonGroup.add(mcqRB);
		
		JRadioButton tfRB = new JRadioButton("T/F");
		tfRB.setFocusPainted(false);
		tfRB.setBackground(SystemColor.info);
		tfRB.setName("TF RB");
		tfRB.setForeground(new Color(128, 0, 0));
		tfRB.setFont(new Font("Tahoma", Font.BOLD, 17));
		buttonGroup.add(tfRB);
		
		JRadioButton mtfRB = new JRadioButton("MTF");
		mtfRB.setFocusPainted(false);
		mtfRB.setBackground(SystemColor.info);
		mtfRB.setName("MTF RB");
		mtfRB.setFont(new Font("Tahoma", Font.BOLD, 17));
		mtfRB.setForeground(new Color(128, 0, 0));
		buttonGroup.add(mtfRB);
		
		JRadioButton fibRB = new JRadioButton("FIB");
		fibRB.setFocusPainted(false);
		fibRB.setBackground(SystemColor.info);
		fibRB.setName("FIB RB");
		fibRB.setForeground(new Color(128, 0, 0));
		fibRB.setFont(new Font("Tahoma", Font.BOLD, 17));
		buttonGroup.add(fibRB);
		
		JRadioButton essayRB = new JRadioButton("Essay");
		essayRB.setFocusPainted(false);
		essayRB.setBackground(SystemColor.info);
		essayRB.setName("Essay  RB");
		essayRB.setForeground(new Color(128, 0, 0));
		essayRB.setFont(new Font("Tahoma", Font.BOLD, 17));
		buttonGroup.add(essayRB);
		
		JButton newBtn = new JButton("New");
		newBtn.setFocusPainted(false);
		newBtn.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		newBtn.setForeground(new Color(220, 20, 60));
		newBtn.setFont(new Font("Times New Roman", Font.BOLD, 25));
		newBtn.setName("new b");
		
		JButton editBtn = new JButton("Edit");
		editBtn.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		editBtn.setFocusPainted(false);
		editBtn.setPreferredSize(new Dimension(50, 25));
		editBtn.setForeground(new Color(220, 20, 60));
		editBtn.setFont(new Font("Times New Roman", Font.BOLD, 25));
		editBtn.setName("edit b");
		
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		deleteBtn.setFocusPainted(false);
		deleteBtn.setPreferredSize(new Dimension(50, 25));
		deleteBtn.setForeground(new Color(220, 20, 60));
		deleteBtn.setFont(new Font("Times New Roman", Font.BOLD, 25));
		deleteBtn.setName("del b");
		deleteBtn.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		
		JScrollPane questionScroll = new JScrollPane();
		
		JLabel headLabel = new JLabel("QUESTION");
		headLabel.setMaximumSize(new Dimension(32767, 32767));
		headLabel.setOpaque(true);
		headLabel.setName("head label");
		headLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		headLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		headLabel.setBackground(new Color(255, 182, 193));
		headLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		headLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_Questions_F = new GroupLayout(Questions_F);
		gl_Questions_F.setHorizontalGroup(
			gl_Questions_F.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Questions_F.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Questions_F.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Questions_F.createSequentialGroup()
							.addComponent(label1, GroupLayout.PREFERRED_SIZE, 140, Short.MAX_VALUE)
							.addGap(26)
							.addComponent(courseCombo, GroupLayout.PREFERRED_SIZE, 258, Short.MAX_VALUE)
							.addGap(35)
							.addComponent(label2, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(paperCombo, 0, 183, Short.MAX_VALUE)
							.addGap(140))
						.addGroup(gl_Questions_F.createSequentialGroup()
							.addComponent(label3, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(mcqRB, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
							.addGap(14)
							.addComponent(tfRB, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(mtfRB, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(fibRB, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(essayRB, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
							.addContainerGap())))
				.addGroup(gl_Questions_F.createSequentialGroup()
					.addGap(405)
					.addComponent(newBtn, GroupLayout.PREFERRED_SIZE, 129, Short.MAX_VALUE)
					.addGap(43)
					.addComponent(editBtn, GroupLayout.PREFERRED_SIZE, 116, Short.MAX_VALUE)
					.addGap(33)
					.addComponent(deleteBtn, GroupLayout.PREFERRED_SIZE, 134, Short.MAX_VALUE)
					.addGap(88))
				.addGroup(gl_Questions_F.createSequentialGroup()
					.addComponent(headLabel, GroupLayout.PREFERRED_SIZE, 881, Short.MAX_VALUE)
					.addGap(0))
				.addGroup(gl_Questions_F.createSequentialGroup()
					.addComponent(questionScroll, GroupLayout.PREFERRED_SIZE, 872, Short.MAX_VALUE)
					.addGap(0))
		);
		gl_Questions_F.setVerticalGroup(
			gl_Questions_F.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Questions_F.createSequentialGroup()
					.addComponent(headLabel, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_Questions_F.createParallelGroup(Alignment.BASELINE)
						.addComponent(label1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(courseCombo, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(paperCombo, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(label2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_Questions_F.createParallelGroup(Alignment.BASELINE)
						.addComponent(label3, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(mcqRB, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(mtfRB, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfRB, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(fibRB, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(essayRB, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(questionScroll, GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_Questions_F.createParallelGroup(Alignment.BASELINE)
						.addComponent(newBtn, GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE)
						.addComponent(editBtn, GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE)
						.addComponent(deleteBtn, GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE))
					.addGap(15))
		);
		
		questionTable = new JTable();
		questionTable.setSelectionBackground(new Color(74, 74, 255));
		questionTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		questionTable.setModel(new BeanTableModel<Model>(Model.class));
		JTableHeader header= questionTable.getTableHeader();
		header.setBackground(new Color(50, 205, 50));
		header.setForeground(new Color(0));
		header.setFont(new Font("Times New Roman", Font.BOLD, 20));

		mcqRB.addItemListener(new SelectionController(questionTable,courseCombo,paperCombo));
		fibRB.addItemListener(new SelectionController(questionTable,courseCombo,paperCombo));
		mtfRB.addItemListener(new SelectionController(questionTable,courseCombo,paperCombo));
		tfRB.addItemListener(new SelectionController(questionTable,courseCombo,paperCombo));
		essayRB.addItemListener(new SelectionController(questionTable,courseCombo,paperCombo));
		deleteBtn.addActionListener(new DeleteController(questionTable));
		editBtn.addActionListener(new Newcontroller(Questions_F, questionTable));
		newBtn.addActionListener(new Newcontroller(Questions_F,questionTable));
		questionScroll.setViewportView(questionTable);
		Questions_F.setLayout(gl_Questions_F);
		paperCombo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				SelectionController selectionController=
						new SelectionController(questionTable, courseCombo, paperCombo);
				try {
					selectionController.setPaper();
					
					selectionController.setTable(new Componentfinder().getSelectedButtonText(buttonGroup));
				} catch (SQLException e2) {
					// TODO: handle exception
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Request failed", "WARNING", 
							JOptionPane.WARNING_MESSAGE);
				} 
				catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Something went wrong try again",
							"WARNING", JOptionPane.WARNING_MESSAGE);
				}	
			}
		});
			
		addWindowListener(new WindowLoading(this, courseCombo));
	}
}
