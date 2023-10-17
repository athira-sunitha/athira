package com.Athira.kelexam.generator.controller;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class PreviewController implements ActionListener {
	private File file=null;
	

	public PreviewController(File file) {
		this.file = file;
	}

	// to show the preview of the file
	
	public void actionPerformed(ActionEvent e) {
		try {
			Desktop.getDesktop().open(file);
		} catch (IOException e1) {	
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Couldn't open the file","WARNING",
					JOptionPane.WARNING_MESSAGE);
		}
	}

}
