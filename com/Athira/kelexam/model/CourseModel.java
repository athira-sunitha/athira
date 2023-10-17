package com.Athira.kelexam.model;

public class CourseModel {
	private String courseName=null;
	private String courseCode=null;
	
	public CourseModel() {
		super();
	}
	public CourseModel(String courseName, String courseCode) {
		super();
		this.courseName = courseName;
		this.courseCode = courseCode;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	@Override
	public String toString() {
		return  courseCode + " - " +courseName;
	}
	

}
