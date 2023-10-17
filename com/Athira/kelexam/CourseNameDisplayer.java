package com.Athira.kelexam;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import com.Athira.kelexam.model.CourseModel;
import com.Athira.kelexam.model.DBconnection;


public class CourseNameDisplayer implements ActionListener {
	DefaultComboBoxModel<CourseModel> model=new DefaultComboBoxModel<CourseModel>();
	private List<CourseModel> courseData() throws SQLException{
		List<CourseModel> courses=new ArrayList<CourseModel>();
		CourseModel courseModel=new CourseModel();
		Connection connection=new DBconnection().dbConnection();
		ResultSet courseSet=connection.createStatement().executeQuery("select * from courses");
		while (courseSet.next()) {
			courseModel.setCourseCode(courseSet.getString(1));
			courseModel.setCourseName(courseSet.getString(2));
			courses.add(courseModel);
		}
		return courses;
		
	}

	public void actionPerformed(ActionEvent e) {
		
		
		try {
			model.addAll(courseData());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
				
			
		
		

	}

}
