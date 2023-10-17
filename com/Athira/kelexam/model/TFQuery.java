package com.Athira.kelexam.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Athira.kelexam.questions.model.TFmodel;

public class TFQuery implements QuestionDao<TFmodel> {
	private Connection connection=null;
	public TFQuery() throws SQLException {
		connection=new DBconnection().dbConnection();
	}

	public void insertQuestion(TFmodel model) throws SQLException {
		// TODO Auto-generated method stub
        String insertSql="insert into tf_questions values(?,?,?)";
		
		PreparedStatement insertStatement=connection.prepareStatement(insertSql);
		insertStatement.setString(1, model.getQuestionId());
		insertStatement.setString(2, model.getQuestion());
		insertStatement.setBoolean(3, model.isAnswer());
		
		insertStatement.executeUpdate();
		connection.close();
	}

	public void deleteQuestion(TFmodel model) throws SQLException {
		// TODO Auto-generated method stub
		String deleteSql="delete FROM keltronexam.tf_questions where question_id = ?";
		PreparedStatement deleteStatement=connection.prepareStatement(deleteSql);
		deleteStatement.setString(1, model.getQuestionId());
		deleteStatement.executeUpdate();
		connection.close();

	}

	public void updateQuestion(TFmodel model) throws SQLException {
		// TODO Auto-generated method stub
		String insertSql="update tf_questions set questions=? , answer=? where question_id=?";
		
		PreparedStatement insertStatement=connection.prepareStatement(insertSql);
		insertStatement.setString(3, model.getQuestionId());
		insertStatement.setString(1, model.getQuestion());
		insertStatement.setBoolean(2, model.isAnswer());
		
		insertStatement.executeUpdate();
		connection.close();
	}

	public List<TFmodel> retriveQuestion(String paper,int count) throws SQLException {
		// TODO Auto-generated method stub
		String retriveSql=null;
		if (count==0) {
			retriveSql="SELECT * FROM keltronexam.tf_questions where question_id like ?";
		} else {
			retriveSql="SELECT * FROM keltronexam.tf_questions where question_id like ?"
					+ " order by rand() limit "+count;
		}
		 
		PreparedStatement retriveStatement=connection.prepareStatement(retriveSql);
		retriveStatement.setString(1, paper+"%");
		ResultSet tfSet=retriveStatement.executeQuery();
		TFmodel tf=null;
		List<TFmodel> list=new ArrayList<TFmodel>();
		while(tfSet.next()) {
			tf=new TFmodel();
			tf.setQuestionId(tfSet.getString(1));
			tf.setQuestion(tfSet.getString(2));
			tf.setAnswer(tfSet.getBoolean(3));
			list.add(tf);
		}
		connection.close();
		return list;
	}

	
}
