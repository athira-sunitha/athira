package com.Athira.kelexam;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import com.Athira.kelexam.model.CourseModel;

@SuppressWarnings("serial")
public class CourseListCellViewer extends JLabel implements  ListCellRenderer<CourseModel> {
public CourseListCellViewer() {
	setOpaque(true);
}
	public Component getListCellRendererComponent(JList<? extends CourseModel> list,
			CourseModel value, int index,
			boolean isSelected, boolean cellHasFocus) {
		// TODO Auto-generated method stub
		Color background;
		Color foreground;
		JList.DropLocation dropLocation=list.getDropLocation();
		if(dropLocation!=null 
				&& !dropLocation.isInsert()
				&& dropLocation.getIndex()==index) {
			background=Color.BLUE;
			foreground=Color.WHITE;
		}
		else if (isSelected) {
			background=Color.BLUE;
			foreground=Color.WHITE;
			
		}
		else {
			background=Color.WHITE;
			foreground=Color.BLACK;
		}
		setForeground(foreground);
		setBackground(background);
		setText(value.getCourseCode()+" - "+value.getCourseName());
		return this;
	}

}
