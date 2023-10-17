package com.Athira.kelexam.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Athira.kelexam.questions.model.MTFmodel;

public class MTFQuery implements QuestionDao<MTFmodel> {
	private Connection connection=null;
	public MTFQuery() throws SQLException {
		connection=new DBconnection().dbConnection();
	}

	public void insertQuestion(MTFmodel model) throws SQLException {
		// TODO Auto-generated method stub
        String insertSql="insert into mtf_questions values(?,?,?)";
		
		PreparedStatement insertStatement=connection.prepareStatement(insertSql);
		insertStatement.setString(1, model.getQuestionId());
		insertStatement.setString(2, model.getQuestion());
		insertStatement.setString(3, model.getAnswer());
		
		insertStatement.executeUpdate();
		connection.close();
	}

	public void deleteQuestion(MTFmodel model) throws SQLException {
		// TODO Auto-generated method stub
		String deleteSql="delete FROM keltronexam.mtf_questions where question_id = ?";
		PreparedStatement deleteStatement=connection.prepareStatement(deleteSql);
		deleteStatement.setString(1, model.getQuestionId());
		deleteStatement.executeUpdate();
		connection.close();
	}

	public void updateQuestion(MTFmodel model) throws SQLException {
		// TODO Auto-generated method stub
		String insertSql="update mtf_questions set question=? , answer=? where question_id=?";
		
		PreparedStatement insertStatement=connection.prepareStatement(insertSql);
		insertStatement.setString(3, model.getQuestionId());
		insertStatement.setString(1, model.getQuestion());
		insertStatement.setString(2, model.getAnswer());
		
		insertStatement.executeUpdate();
		connection.close();
	}

	public List<MTFmodel> retriveQuestion(String paper,int count) throws SQLException {
		// TODO Auto-generated method stub
		String retriveSql=null;
		if (count==0) {
			retriveSql="SELECT * FROM keltronexam.mtf_questions where question_id like ?";
		} else {
			retriveSql="SELECT * FROM keltronexam.mtf_questions where question_id like ?"
					+"order by rand() limit "+count;
		}
		PreparedStatement retriveStatement=connection.prepareStatement(retriveSql);
		retriveStatement.setString(1, paper+"%");
		ResultSet mtfSet=retriveStatement.executeQuery();
		MTFmodel mtf=null;
		List<MTFmodel> list=new ArrayList<MTFmodel>();
		while(mtfSet.next()) {
			mtf=new MTFmodel();
			mtf.setQuestionId(mtfSet.getString(1));
			mtf.setQuestion(mtfSet.getString(2));
			mtf.setAnswer(mtfSet.getString(3));
			list.add(mtf);
		}
		connection.close();
		return list;
	}

	

}
