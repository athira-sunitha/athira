package com.Athira.kelexam.model;



import java.sql.SQLException;
import java.util.List;

import com.Athira.kelexam.questions.model.Model;

public interface QuestionDao<T extends Model> {
	void insertQuestion(T model)throws SQLException;
	void deleteQuestion(T model)throws SQLException;
	void updateQuestion(T model)throws SQLException;
	List<T> retriveQuestion(String paper,int count)throws SQLException;
}
