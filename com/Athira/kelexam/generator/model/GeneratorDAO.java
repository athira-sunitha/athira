package com.Athira.kelexam.generator.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface GeneratorDAO {
	ResultSet getQuestion(String tableName,String questionId)throws SQLException;
	int getQuestionCount(String rowName)throws SQLException;
	

}
