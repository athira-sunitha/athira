package com.Athira.kelexam.generator.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Athira.kelexam.model.DBconnection;
import com.Athira.kelexam.questions.model.Essaymodel;
import com.Athira.kelexam.questions.model.FIBmodel;
import com.Athira.kelexam.questions.model.MCQmodel;
import com.Athira.kelexam.questions.model.MTFmodel;
import com.Athira.kelexam.questions.model.TFmodel;

public class Generator implements GeneratorDAO {
	Connection connection=null;
	/*
	 * private CourseModel course=null; private PaperModel paper=null;
	 * 
	 * 
	 * public Generator(CourseModel course, PaperModel paper) throws SQLException {
	 * super(); this.course = course; this.paper = paper; connection=new
	 * DBconnection().dbConnection(); }
	 */

	public Generator() throws SQLException {
		super();
		connection=new DBconnection().dbConnection();
		
				
	}

	public ResultSet getQuestion(String tableName,String questionId) throws SQLException {
		// TODO Auto-generated method stub
		String questionSql="select * from ? where Question_ID=?";
		
		
	PreparedStatement questionStatement=connection .prepareStatement(questionSql);
	questionStatement.setString(1, tableName);
	questionStatement.setString(2, questionId);
	ResultSet questionSet=questionStatement.executeQuery();
	connection.close();
		return  questionSet;
	}
	public int getQuestionCount(String rowName) throws SQLException {
		// TODO Auto-generated method stub
		String countSql="select count from question_counts where question_type=?";
		PreparedStatement countStatement=connection.prepareStatement(countSql);
		countStatement.setString(1, rowName);
		ResultSet countSet=countStatement.executeQuery();
		while(countSet.next()) {
			return countSet.getInt(1)-1000;
		}
		return 0;
	}
	public MCQmodel mcqQuestionCreator(String QuestionId) throws SQLException {
		 ResultSet mcqSet=getQuestion("mcq_questions", QuestionId);
		 MCQmodel mcq=new MCQmodel();
		 while(mcqSet.next()) {
			 mcq.setQuestion(mcqSet.getString(2));
			 mcq.setAnswer(mcqSet.getString(3));
			 mcq.setOption1(mcqSet.getString(4));
			 mcq.setOption2(mcqSet.getString(5));
			 mcq.setOption3(mcqSet.getString(6));
		 }
		 return mcq;
	}
	public TFmodel tfQuestionCreator(String QuestionId) throws SQLException {
		 ResultSet tfSet=getQuestion("tf_questions", QuestionId);
		TFmodel tf=new TFmodel();
		 while(tfSet.next()) {
			 tf.setQuestion(tfSet.getString(2));
			 tf.setAnswer(tfSet.getBoolean(3));
			 
		 }
		 return tf;
	}
	public MTFmodel mtfQuestionCreator(String QuestionId) throws SQLException {
		 ResultSet mtfSet=getQuestion("mtf_questions", QuestionId);
		MTFmodel mtf=new MTFmodel();
		 while(mtfSet.next()) {
			 mtf.setQuestion(mtfSet.getString(2));
			 mtf.setAnswer(mtfSet.getString(3));
			 
		 }
		 return mtf;
	}
	public FIBmodel fibQuestionCreator(String QuestionId) throws SQLException {
		 ResultSet fibSet=getQuestion("fib_questions", QuestionId);
		FIBmodel fib=new FIBmodel();
		 while(fibSet.next()) {
			 fib.setQuestion(fibSet.getString(2));
			 fib.setAnswer(fibSet.getString(3));
			 
		 }
		 return fib;
	}
	public Essaymodel mtfQuestionCreator(String QuestionId,String tableName) throws SQLException {
		 ResultSet essaySet=getQuestion(tableName, QuestionId);
		Essaymodel essay=new Essaymodel();
		 while(essaySet.next()) {
			 essay.setQuestion(essaySet.getString(2));
			 essay.setMark(essaySet.getInt(3));
			 
		 }
		 return essay;
	}

	
	
}
