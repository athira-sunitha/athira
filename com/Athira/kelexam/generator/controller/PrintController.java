package com.Athira.kelexam.generator.controller;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class PrintController implements ActionListener {

	// to print the file
	
	public void actionPerformed(ActionEvent e) {

		File file=SaveContorller.getSAVE_FILE();
		try {
			Desktop.getDesktop().print(file);
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "Couldn't print the file","WARNING",
					JOptionPane.WARNING_MESSAGE);
		}

	}

}
