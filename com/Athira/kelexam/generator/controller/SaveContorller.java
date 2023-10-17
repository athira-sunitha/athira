package com.Athira.kelexam.generator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class SaveContorller implements ActionListener {

	private File file=null;
	private static File SAVE_FILE=null;
	private File currentDirectory=null;
	private  static File SAVEING_FILE=null;
	public SaveContorller(File file) throws FileNotFoundException, ClassNotFoundException, IOException {
		this.file = file;
		SAVEING_FILE=File.createTempFile("test", ".txt", new File(System.getProperty("user.home")));
		currentDirectory=readFile();
	}
	
	// to save the excel file
	
	public void actionPerformed(ActionEvent e) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if (currentDirectory!=null) {
			fileChooser.setCurrentDirectory(currentDirectory);
		}
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("word file", ".docx");
		fileChooser.addChoosableFileFilter(filter);
		fileChooser.setAcceptAllFileFilterUsed(false);
		if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
		  try {
			Files.copy(file.toPath(),fileChooser.getSelectedFile().toPath(),
					  StandardCopyOption.REPLACE_EXISTING);
			SAVE_FILE=fileChooser.getSelectedFile();
			writeFile(fileChooser.getSelectedFile().getParentFile());
		} catch (IOException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Couldn't save the file","WARNING",
					JOptionPane.WARNING_MESSAGE);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}

	}
	private File readFile() throws ClassNotFoundException {
		
		ObjectInputStream in;
		File newFile=null;
		try {
			in = new ObjectInputStream(new FileInputStream(SAVEING_FILE));
			 newFile=(File)in.readObject();
			in .close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return newFile; 	
	}

    private void writeFile(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(SAVEING_FILE));
			out.writeObject(file);
			out.close();
	}
	public static File getSAVE_FILE() {
		return SAVE_FILE;
	}

}
