package com.Athira.kelexam.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Athira.kelexam.questions.model.MCQmodel;

public class MCQQuery implements QuestionDao<MCQmodel> {
	private Connection connection=null;
	public MCQQuery() throws SQLException {
		connection=new DBconnection().dbConnection();
	}

	public void insertQuestion(MCQmodel model) throws SQLException {
		// TODO Auto-generated method stub
		String insertSql="insert into mcq_questions values(?,?,?,?,?,?)";
				
		PreparedStatement insertStatement=connection.prepareStatement(insertSql);
		insertStatement.setString(1, model.getQuestionId());
		insertStatement.setString(2, model.getQuestion());
		insertStatement.setString(3, model.getAnswer());
		insertStatement.setString(4, model.getOption1());
		insertStatement.setString(5, model.getOption2());
		insertStatement.setString(6, model.getOption3());
		
		insertStatement.executeUpdate();
		connection.close();
	}

	public void deleteQuestion(MCQmodel model) throws SQLException {
		// TODO Auto-generated method stub
		String deleteSql="delete FROM keltronexam.mcq_questions where Question_ID = ?";
		PreparedStatement deleteStatement=connection.prepareStatement(deleteSql);
		deleteStatement.setString(1, model.getQuestionId());
		deleteStatement.executeUpdate();
		connection.close();
	}

	public void updateQuestion(MCQmodel model) throws SQLException {
		// TODO Auto-generated method stub
		String updateSql="update mcq_questions set Questions=?,Answer=?,Option_1=?,Option_2=?,Option_3=?"
				+ " where Question_ID=?";
		PreparedStatement updateStatement=connection.prepareStatement(updateSql);
		updateStatement.setString(1, model.getQuestion());
		updateStatement.setString(2, model.getAnswer());
		updateStatement.setString(3, model.getOption1());
		updateStatement.setString(4, model.getOption2());
		updateStatement.setString(5, model.getOption3());
		updateStatement.setString(6, model.getQuestionId());
		updateStatement.executeUpdate();
		connection.close();
	}

	public List<MCQmodel> retriveQuestion(String paper,int count) throws SQLException {
		// TODO Auto-generated method stub
		String retriveSql=null;
		if (count==0) {
			retriveSql="SELECT * FROM keltronexam.mcq_questions where Question_ID like ?";
		} else {
			retriveSql="SELECT * FROM keltronexam.mcq_questions where Question_ID like ?"
					+" order by rand() limit "+count;
		}
		
		PreparedStatement retriveStatement=connection.prepareStatement(retriveSql);
		retriveStatement.setString(1, paper+"%");
		ResultSet mcqSet=retriveStatement.executeQuery();
		MCQmodel mcq=null;
		List<MCQmodel> list=new ArrayList<MCQmodel>();
		while(mcqSet.next()) {
			mcq=new MCQmodel();
			mcq.setQuestionId(mcqSet.getString(1));
			mcq.setQuestion(mcqSet.getString(2));
			mcq.setAnswer(mcqSet.getString(3));
			mcq.setOption1(mcqSet.getString(4));
			mcq.setOption2(mcqSet.getString(5));
			mcq.setOption3(mcqSet.getString(6));
			list.add(mcq);
		}
		connection.close();
		return list;
	}

}
