package com.Athira.kelexam.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Athira.kelexam.questions.model.FIBmodel;


public class FIBQuery implements QuestionDao<FIBmodel> {
	private Connection connection=null;
	public FIBQuery() throws SQLException {
		connection=new DBconnection().dbConnection();
	}

	public void insertQuestion(FIBmodel model) throws SQLException {
		// TODO Auto-generated method stub
		String insertSql="insert into fib_questions values(?,?,?)";
		
		PreparedStatement insertStatement=connection.prepareStatement(insertSql);
		insertStatement.setString(1, model.getQuestionId());
		insertStatement.setString(2, model.getQuestion());
		insertStatement.setString(3, model.getAnswer());
		
		insertStatement.executeUpdate();
		connection.close();
	}

	public void deleteQuestion(FIBmodel model) throws SQLException {
		// TODO Auto-generated method stub
		String deleteSql="delete FROM keltronexam.fib_questions where question_id = ?";
		PreparedStatement deleteStatement=connection.prepareStatement(deleteSql);
		deleteStatement.setString(1, model.getQuestionId());
		deleteStatement.executeUpdate();
		connection.close();
	}

	public void updateQuestion(FIBmodel model) throws SQLException {
		// TODO Auto-generated method stub
        String updateSql="update fib_questions set question=? , answer=? where question_id=?";
		
		PreparedStatement updateStatement=connection.prepareStatement(updateSql);
		updateStatement.setString(3, model.getQuestionId());
		updateStatement.setString(1, model.getQuestion());
		updateStatement.setString(2, model.getAnswer());
		
		updateStatement.executeUpdate();
		connection.close();
	}

	public List<FIBmodel> retriveQuestion(String paper,int count) throws SQLException {
		// TODO Auto-generated method stub
		String retriveSql=null;
		if (count==0) {
			retriveSql="SELECT * FROM keltronexam.fib_questions where question_id like ?";
		}else {
			retriveSql="SELECT * FROM keltronexam.fib_questions where question_id like ?"
					+" order by rand() limit "+count;
		}
		
		PreparedStatement retriveStatement=connection.prepareStatement(retriveSql);
		retriveStatement.setString(1, paper+"%");
		ResultSet fibSet=retriveStatement.executeQuery();
		FIBmodel fib=null;
		List<FIBmodel> list=new ArrayList<FIBmodel>();
		while(fibSet.next()) {
			fib=new FIBmodel();
			fib.setQuestionId(fibSet.getString(1));
			fib.setQuestion(fibSet.getString(2));
			fib.setAnswer(fibSet.getString(3));
			list.add(fib);
		}
		connection.close();
		return list;
	}


}
