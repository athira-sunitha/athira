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

public class Fillintheblanks extends JDialog {

	private final JPanel FIB_P = new JPanel();
	private JTextField fib_tf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Fillintheblanks dialog = new Fillintheblanks();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Fillintheblanks() {
		setTitle("Fill In The Blanks");
		setBounds(100, 100, 829, 632);
		getContentPane().setLayout(new BorderLayout());
		FIB_P.setBackground(new Color(255, 182, 193));
		FIB_P.setName("fib_p");
		FIB_P.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(FIB_P, BorderLayout.CENTER);
		FIB_P.setLayout(null);
		{
			JLabel fib_l = new JLabel("Question");
			fib_l.setForeground(new Color(0, 100, 0));
			fib_l.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
			fib_l.setBounds(38, 84, 152, 54);
			FIB_P.add(fib_l);
		}
		{
			JTextArea fib_ta = new JTextArea();
			fib_ta.setName("ta_fib");
			fib_ta.setBounds(230, 52, 470, 169);
			FIB_P.add(fib_ta);
		}
		{
			JLabel fib_l1 = new JLabel("Answer");
			fib_l1.setForeground(new Color(0, 128, 0));
			fib_l1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
			fib_l1.setName("fib_l1");
			fib_l1.setBounds(38, 300, 152, 54);
			FIB_P.add(fib_l1);
		}
		{
			fib_tf = new JTextField();
			fib_tf.setName("fib_tf");
			fib_tf.setBounds(230, 291, 461, 82);
			FIB_P.add(fib_tf);
			fib_tf.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton F_ins = new JButton("Insert");
				F_ins.setName("f ins");
				F_ins.setForeground(new Color(0, 0, 128));
				F_ins.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 20));
				F_ins.setActionCommand("OK");
				buttonPane.add(F_ins);
				getRootPane().setDefaultButton(F_ins);
			}
			{
				JButton f_cancel = new JButton("Cancel");
				f_cancel.addActionListener(new Cancelbutton(getContentPane()));
				f_cancel.setForeground(new Color(0, 0, 128));
				f_cancel.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 20));
				f_cancel.setName("f cancel");
				f_cancel.setActionCommand("Cancel");
				buttonPane.add(f_cancel);
			}
		}
	}

}
