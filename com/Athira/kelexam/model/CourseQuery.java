package com.Athira.kelexam.model;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseQuery implements CourseDAO {
	private Connection connection=null;
	public CourseQuery() throws SQLException {
		connection=new DBconnection().dbConnection();
	}

	public List<CourseModel> retriveCourse() throws SQLException {
		// TODO Auto-generated method stub
		ResultSet courseSet=connection.createStatement()
				.executeQuery("select * from courses");
		List<CourseModel> courses=new ArrayList<CourseModel>();
		courses.add(new CourseModel("","Select a course"));
		while (courseSet.next()) {
			CourseModel course=new CourseModel();
			course.setCourseCode(courseSet.getString(1));
			course.setCourseName(courseSet.getString(2));
			courses.add(course);
			
		}
		return courses;
	}

	public List<PaperModel> retrivePaper(String courseCode) throws SQLException {
		// TODO Auto-generated method stub
		ResultSet paperSet=connection.createStatement()
				.executeQuery("select * from paper where course_name='"+courseCode+"'");
		List<PaperModel> papers=new ArrayList<PaperModel>();
		papers.add(new PaperModel("","Select a subject"));
		while (paperSet.next()) {
		PaperModel paper=new PaperModel();
			paper.setPaperCode(paperSet.getString(1));
			paper.setPaperName(paperSet.getString(2));
			papers.add(paper);
			
		}
		return papers;
	}

	

}
