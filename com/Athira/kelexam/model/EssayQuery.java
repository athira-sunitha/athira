package com.Athira.kelexam.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Athira.kelexam.questions.model.Essaymodel;

public class EssayQuery implements QuestionDao<Essaymodel> {
	private Connection connection=null;
	public EssayQuery() throws SQLException {
		connection=new DBconnection().dbConnection();
	}
	public void insertQuestion(Essaymodel model) throws SQLException {
		// TODO Auto-generated method stub
        String insertSql="insert into essay_questions values(?,?,?)";
		
		PreparedStatement insertStatement=connection.prepareStatement(insertSql);
		insertStatement.setString(1, model.getQuestionId());
		insertStatement.setString(2, model.getQuestion());
		insertStatement.setInt(3, model.getMark());
		
		insertStatement.executeUpdate();
		connection.close();
	}

	public void deleteQuestion(Essaymodel model) throws SQLException {
		// TODO Auto-generated method stub
		String deleteSql="delete FROM keltronexam.essay_questions where question_id = ?";
		PreparedStatement deleteStatement=connection.prepareStatement(deleteSql);
		deleteStatement.setString(1, model.getQuestionId());
		deleteStatement.executeUpdate();
		connection.close();

	}

	public void updateQuestion(Essaymodel model) throws SQLException {
		// TODO Auto-generated method stub
		String insertSql="update essay_questions set question=?,mark=? where question_id=? ";
		
		PreparedStatement insertStatement=connection.prepareStatement(insertSql);
		insertStatement.setString(3, model.getQuestionId());
		insertStatement.setString(1, model.getQuestion());
		insertStatement.setInt(2, model.getMark());
		
		insertStatement.executeUpdate();
		connection.close();
	}
	public List<Essaymodel> retriveQuestion(String paper,int count) throws SQLException {
		// TODO Auto-generated method stub
		String retriveSql=null;
		if (count==0) {
			retriveSql="SELECT * FROM keltronexam.essay_questions where question_id like ?";
		} else {
			retriveSql="SELECT * FROM keltronexam.essay_questions where question_id like ?"
					+ " AND mark=15 order by rand()  limit "+count;
		}
		
		PreparedStatement retriveStatement=connection.prepareStatement(retriveSql);
		retriveStatement.setString(1, paper+"%");
		ResultSet essaySet=retriveStatement.executeQuery();
		Essaymodel essay=null;
		List<Essaymodel> list=new ArrayList<Essaymodel>();
		while(essaySet.next()) {
			essay=new Essaymodel();
			essay.setQuestionId(essaySet.getString(1));
			essay.setQuestion(essaySet.getString(2));
			essay.setMark(essaySet.getInt(3));
			list.add(essay);
		}
		connection.close();
		return list;
	}



}
