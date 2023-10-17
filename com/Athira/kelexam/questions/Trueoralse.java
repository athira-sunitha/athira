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
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Trueoralse extends JDialog {

	private final JPanel TF_P = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Trueoralse dialog = new Trueoralse();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Trueoralse() {
		setTitle("True or False");
		setBounds(100, 100, 922, 671);
		getContentPane().setLayout(new BorderLayout());
		TF_P.setBackground(new Color(255, 228, 225));
		TF_P.setName("TF P");
		TF_P.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(TF_P, BorderLayout.CENTER);
		TF_P.setLayout(null);
		{
			JLabel TF_L = new JLabel("Question");
			TF_L.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 20));
			TF_L.setForeground(new Color(128, 0, 128));
			TF_L.setName("TF L");
			TF_L.setBounds(33, 57, 125, 44);
			TF_P.add(TF_L);
		}
		{
			JTextArea TF_TA = new JTextArea();
			TF_TA.setName("TF TA");
			TF_TA.setBounds(168, 57, 480, 201);
			TF_P.add(TF_TA);
		}
		{
			JLabel Ans_l = new JLabel("Answer");
			Ans_l.setForeground(new Color(255, 0, 0));
			Ans_l.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 20));
			Ans_l.setName("ans l");
			Ans_l.setBounds(33, 348, 96, 35);
			TF_P.add(Ans_l);
		}
		
		JRadioButton True = new JRadioButton("True");
		buttonGroup.add(True);
		True.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 20));
		True.setName("true rb");
		True.setBounds(179, 339, 114, 44);
		TF_P.add(True);
		
		JRadioButton False_rb = new JRadioButton("False");
		buttonGroup.add(False_rb);
		False_rb.setName("false_rb");
		False_rb.setAutoscrolls(true);
		False_rb.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 20));
		False_rb.setBounds(386, 339, 114, 44);
		TF_P.add(False_rb);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton Insert_b = new JButton("Insert");
				Insert_b.setForeground(new Color(0, 0, 205));
				Insert_b.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
				Insert_b.setActionCommand("OK");
				buttonPane.add(Insert_b);
				getRootPane().setDefaultButton(Insert_b);
			}
			{
				JButton CB = new JButton("Cancel");
		
				CB.addActionListener(new Cancelbutton(getContentPane()));
				CB.setName("CB");
				CB.setForeground(new Color(0, 0, 205));
				CB.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
				CB.setActionCommand("Cancel");
				buttonPane.add(CB);
			}
		}
	}
}
