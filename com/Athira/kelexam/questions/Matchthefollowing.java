package com.Athira.kelexam.questions;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.Athira.kelexam.generator.controller.Cancelbutton;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Matchthefollowing extends JDialog {

	private final JPanel mtf_p = new JPanel();
	private JTextField ans_tf;
	private JTextField ans_tf1;
	private JButton b_cancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Matchthefollowing dialog = new Matchthefollowing();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Matchthefollowing() {
		setTitle("Match The Following");
		setBounds(100, 100, 847, 643);
		getContentPane().setLayout(new BorderLayout());
		mtf_p.setForeground(new Color(240, 255, 255));
		mtf_p.setBackground(new Color(144, 238, 144));
		mtf_p.setFont(new Font("Tw Cen MT Condensed", Font.BOLD | Font.ITALIC, 20));
		mtf_p.setName("mtf p");
		mtf_p.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(mtf_p, BorderLayout.CENTER);
		mtf_p.setLayout(null);
		{
			JLabel mtf_l = new JLabel("Question");
			mtf_l.setForeground(new Color(0, 0, 0));
			mtf_l.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			mtf_l.setName("mtf l");
			mtf_l.setBounds(43, 79, 128, 49);
			mtf_p.add(mtf_l);
		}
		{
			ans_tf = new JTextField();
			ans_tf.setName("ans_tf");
			ans_tf.setBounds(201, 49, 538, 114);
			mtf_p.add(ans_tf);
			ans_tf.setColumns(10);
		}
		{
			JLabel L_ans = new JLabel("Answer");
			L_ans.setForeground(new Color(0, 0, 0));
			L_ans.setName("l ans");
			L_ans.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 20));
			L_ans.setBounds(43, 304, 116, 38);
			mtf_p.add(L_ans);
		}
		{
			ans_tf1 = new JTextField();
			ans_tf1.setName("ans tf 1");
			ans_tf1.setBounds(201, 280, 538, 114);
			mtf_p.add(ans_tf1);
			ans_tf1.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton b_insert = new JButton("Insert");
				b_insert.setForeground(new Color(255, 0, 255));
				b_insert.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
				b_insert.setName("in_b");
				b_insert.setActionCommand("OK");
				buttonPane.add(b_insert);
				getRootPane().setDefaultButton(b_insert);
			}
			{
				b_cancel = new JButton("Cancel");
				b_cancel.addActionListener(new Cancelbutton(getContentPane()));
				b_cancel.setName("b cancel");
				b_cancel.setForeground(new Color(255, 0, 255));
				b_cancel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
				b_cancel.setActionCommand("Cancel");
				buttonPane.add(b_cancel);
			}
		}
	}

}
