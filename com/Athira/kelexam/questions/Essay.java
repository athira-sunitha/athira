package com.Athira.kelexam.questions;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.Athira.kelexam.generator.controller.Cancelbutton;

import java.awt.Font;
import java.awt.Cursor;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Essay extends JDialog {

	private final JPanel Essay_p = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Essay dialog = new Essay();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Essay() {
		setTitle("Essay");
		setBounds(100, 100, 887, 648);
		getContentPane().setLayout(new BorderLayout());
		Essay_p.setBackground(SystemColor.inactiveCaption);
		Essay_p.setName("eaay p");
		Essay_p.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(Essay_p, BorderLayout.CENTER);
		Essay_p.setLayout(null);
		{
			JLabel essay_l = new JLabel("Question");
			essay_l.setForeground(new Color(255, 0, 255));
			essay_l.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 22));
			essay_l.setName("essay_l");
			essay_l.setBounds(27, 189, 124, 33);
			Essay_p.add(essay_l);
		}
		{
			JTextArea textArea = new JTextArea();
			textArea.setBounds(135, 83, 673, 255);
			Essay_p.add(textArea);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton Essayins = new JButton("Insert");
				Essayins.setForeground(new Color(165, 42, 42));
				Essayins.setName("Essayins");
				Essayins.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
				Essayins.setFont(new Font("Tw Cen MT Condensed", Font.BOLD | Font.ITALIC, 20));
				Essayins.setActionCommand("OK");
				buttonPane.add(Essayins);
				getRootPane().setDefaultButton(Essayins);
			}
			{
				JButton Essaycancel = new JButton("Cancel");
				Essaycancel.addActionListener(new Cancelbutton(getContentPane()));
				Essaycancel.setName("Esscancel");
				Essaycancel.setForeground(new Color(139, 0, 0));
				Essaycancel.setFont(new Font("Tw Cen MT Condensed", Font.BOLD | Font.ITALIC, 20));
				Essaycancel.setActionCommand("Cancel");
				buttonPane.add(Essaycancel);
			}
		}
	}

}
