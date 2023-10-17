package com.Athira.kelexam;



import com.Athira.kelexam.questions.model.Model;

public interface QuestionDao {
	void insertQuestion(Model model);
	void deleteQuestion(String id);
	void updateQuestion(String id);
	void retreiveQuestion(String id);
	

}
