package com.Athira.kelexam;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.Athira.kelexam.generator.QuestionPaperGeneration;
import com.Athira.kelexam.questions.Question;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.io.File;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

@SuppressWarnings("serial")
public class KeltronExam extends JFrame {

	private JPanel contentPane;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KeltronExam frame = new KeltronExam();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "couldn't load window", "WARNING", 
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public KeltronExam() {
		Image iconImage=null;
		try {
			iconImage=ImageIO.read(new File("src/main/resources/keltron.jpg"))
					.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setIconImage(iconImage);
		setTitle("KELTRON EXAM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0, 1022, 750);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.scrollbar);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		label1 = new JLabel("QUESTION GENERATOR FOR");
		label1.setBackground(new Color(240, 240, 240));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setForeground(new Color(0, 0, 255));
		label1.setFont(new Font("Wide Latin", Font.BOLD, 12));
		
		label2 = new JLabel("KELTRON KNOWLEDGE ");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setForeground(new Color(0, 0, 255));
		label2.setFont(new Font("Wide Latin", Font.BOLD, 12));
		
		label3 = new JLabel(" CENTER EXAM");
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setForeground(new Color(0, 0, 255));
		label3.setFont(new Font("Wide Latin", Font.BOLD, 12));
		
		JPanel subPanel1 = new JPanel();
		subPanel1.setBackground(SystemColor.info);
		
		JButton generatorBtn = new JButton("Question Generator");
		generatorBtn.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		generatorBtn.setFocusPainted(false);
		generatorBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
				try {
					QuestionPaperGeneration frame = new QuestionPaperGeneration();
					frame.setVisible(true);
					
				} catch (Exception f) {
					f.printStackTrace();
					JOptionPane.showMessageDialog(null, "couldn't load window", "WARNING", 
							JOptionPane.WARNING_MESSAGE);
				}
					}
				});
			}
				
			
		});
		generatorBtn.setForeground(new Color(255, 0, 0));
		generatorBtn.setBackground(SystemColor.menu);
		generatorBtn.setFont(new Font("Wide Latin", Font.BOLD | Font.ITALIC, 17));
		
		JButton insertBtn = new JButton("Insert Question");
		insertBtn.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		insertBtn.setFocusPainted(false);
		insertBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
                try {
					
					Question frame = new Question();
					frame.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
					JOptionPane.showMessageDialog(null,
							"LOADING ERROR","Question Loader",JOptionPane.INFORMATION_MESSAGE);
				}
					}
				});
			}
		});
		
		insertBtn.setForeground(new Color(255, 0, 0));
		insertBtn.setBackground(SystemColor.menu);
		insertBtn.setFont(new Font("Wide Latin", Font.BOLD | Font.ITALIC, 17));
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				int width=getWidth();
				label1.setFont(new Font("Wide Latin", Font.BOLD, width/60));
				label2.setFont(new Font("Wide Latin", Font.BOLD, width/60));
				label3.setFont(new Font("Wide Latin", Font.BOLD, width/60));
			}
		});
		
		GroupLayout gl_subPanel1 = new GroupLayout(subPanel1);
		gl_subPanel1.setHorizontalGroup(
			gl_subPanel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_subPanel1.createSequentialGroup()
					.addGap(83)
					.addGroup(gl_subPanel1.createParallelGroup(Alignment.LEADING)
						.addComponent(generatorBtn, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
						.addComponent(insertBtn, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
					.addGap(56))
		);
		gl_subPanel1.setVerticalGroup(
			gl_subPanel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_subPanel1.createSequentialGroup()
					.addGap(140)
					.addComponent(generatorBtn, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
					.addGap(112)
					.addComponent(insertBtn, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
					.addGap(128))
		);
		subPanel1.setLayout(gl_subPanel1);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(label2, GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)))
					.addGap(55)
					.addComponent(subPanel1, GroupLayout.PREFERRED_SIZE, 448, GroupLayout.PREFERRED_SIZE)
					.addGap(9))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(198)
					.addComponent(label1, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(label2, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(label3, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
					.addGap(278))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(59)
					.addComponent(subPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(78))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
