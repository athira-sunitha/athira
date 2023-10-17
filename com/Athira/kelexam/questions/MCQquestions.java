package com.Athira.kelexam.questions;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.Athira.kelexam.generator.controller.Cancelbutton;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MCQquestions extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField CA;
	private JTextField oop1;
	private JTextField oop2;
	private JTextField oop3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MCQquestions dialog = new MCQquestions();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MCQquestions() {
		setTitle("Multiple Choice   Question");
		setBounds(100, 100, 928, 622);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(224, 255, 255));
		contentPanel.setName("ok b");
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel Q_L = new JLabel("Question");
			Q_L.setForeground(new Color(0, 128, 0));
			Q_L.setFont(new Font("Tw Cen MT Condensed", Font.BOLD | Font.ITALIC, 22));
			Q_L.setBounds(40, 20, 105, 31);
			contentPanel.add(Q_L);
		}
		
		JTextArea Q_PANEL = new JTextArea();
		Q_PANEL.setName("Q panel");
		Q_PANEL.setBounds(215, 10, 404, 123);
		contentPanel.add(Q_PANEL);
		
		JLabel Q_L = new JLabel("Correct Answer");
		Q_L.setForeground(new Color(255, 0, 0));
		Q_L.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		Q_L.setName("Q Lab");
		Q_L.setBounds(40, 186, 200, 54);
		contentPanel.add(Q_L);
		
		CA = new JTextField();
		CA.setName("Ca");
		CA.setBounds(40, 250, 316, 60);
		contentPanel.add(CA);
		CA.setColumns(10);
		
		JLabel O_OP = new JLabel("Other Options");
		O_OP.setForeground(new Color(255, 69, 0));
		O_OP.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		O_OP.setName("O OP");
		O_OP.setBounds(488, 195, 168, 37);
		contentPanel.add(O_OP);
		
		oop1 = new JTextField();
		oop1.setName("oop1");
		oop1.setBounds(453, 250, 316, 60);
		contentPanel.add(oop1);
		oop1.setColumns(10);
		
		oop2 = new JTextField();
		oop2.setName("oop2");
		oop2.setBounds(453, 345, 316, 60);
		contentPanel.add(oop2);
		oop2.setColumns(10);
		
		oop3 = new JTextField();
		oop3.setName("oop3");
		oop3.setBounds(453, 440, 316, 60);
		contentPanel.add(oop3);
		oop3.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton Insert_b = new JButton("Insert");
				Insert_b.setForeground(new Color(0, 0, 128));
				Insert_b.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 20));
				Insert_b.setName("Insert_b");
				Insert_b.setActionCommand("OK");
				buttonPane.add(Insert_b);
				getRootPane().setDefaultButton(Insert_b);
			}
			{
				JButton cancelButton = new JButton("Cancel");
	
				cancelButton.addActionListener(new Cancelbutton(getContentPane()));
				cancelButton.setForeground(new Color(0, 0, 128));
				cancelButton.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 20));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
