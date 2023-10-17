package com.Athira.kelexam.generator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.Athira.kelexam.generator.controller.PreviewController;
import com.Athira.kelexam.generator.controller.PrintController;
import com.Athira.kelexam.generator.controller.SaveContorller;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Generated_Request extends JFrame {

	private JPanel contentPane;
    private File outFile=null;
	

	/**
	 * Create the frame.
	 */
	public Generated_Request(File outFile) {
		setResizable(false);
		this.outFile=outFile;
		setTitle("Result ");
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int)size.getWidth()/2-237,(int)size.getHeight()/2-201, 474, 402);
		
		contentPane = new JPanel();
		contentPane.setName("result req contentpane");
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton savebtn = new JButton("Save");
		savebtn.setFocusPainted(false);
		try {
			savebtn.addActionListener(new SaveContorller(getOutFile()));
		} catch (ClassNotFoundException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		savebtn.setBounds(141, 310, 90, 25);
		savebtn.setName("result save");
		savebtn.setBackground(new Color(240, 240, 240));
		savebtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		savebtn.setForeground(new Color(0, 0, 0));
		
		JButton printbtn = new JButton("Print");
		printbtn.setFocusPainted(false);
		printbtn.addActionListener(new PrintController());
		printbtn.setBounds(260, 310, 90, 25);
		printbtn.setName("result print");
		printbtn.setBackground(new Color(240, 240, 240));
		printbtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton cancelbtn = new JButton("Cancel");
		cancelbtn.setFocusPainted(false);
		cancelbtn.setBounds(360, 310, 90, 25);
		cancelbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Generated_Request.this.outFile.delete();
			}
		});
		cancelbtn.setName("result req cancel");
		cancelbtn.setBackground(new Color(240, 240, 240));
		cancelbtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton previewbtn = new JButton("Preview");
		previewbtn.setFocusPainted(false);
		previewbtn.addActionListener(new PreviewController(getOutFile()));
		previewbtn.setBounds(24, 310, 107, 25);
		previewbtn.setName("preview");
		contentPane.setLayout(null);
		contentPane.add(savebtn);
		contentPane.add(printbtn);
		contentPane.add(cancelbtn);
		contentPane.add(previewbtn);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("src/main/resources/excel sheets/excel.png"));
		lblNewLabel.setBounds(9, 6, 441, 293);
		contentPane.add(lblNewLabel);
	}


	public File getOutFile() {
		return outFile;
	}


	public void setOutFile(File outFile) {
		this.outFile = outFile;
	}
}
