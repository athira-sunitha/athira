package com.Athira.kelexam.model;

import java.sql.SQLException;
import java.util.List;

public interface CourseDAO {
	List<CourseModel> retriveCourse()throws SQLException;
	List<PaperModel> retrivePaper(String courseCode)throws SQLException;
}
