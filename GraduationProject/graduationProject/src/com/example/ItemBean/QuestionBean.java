package com.example.ItemBean;

public class QuestionBean {
	private Integer QB_ID;
	private int CategorID;
	private int ChapterNum;
	private String Question;
	private int QuestionType;
	private int ChoiceNum;
	private String ChoiceStr;
	private String Answer;
	private String Explaination;
	private int SourceID;
	private String UserAnswer;
	public Integer getQB_ID() {
		return QB_ID;
	}
	public void setQB_ID(Integer qB_ID) {
		QB_ID = qB_ID;
	}
	public int getCategorID() {
		return CategorID;
	}
	public void setCategorID(int categorID) {
		CategorID = categorID;
	}
	public int getChapterNum() {
		return ChapterNum;
	}
	public void setChapterNum(int chapterNum) {
		ChapterNum = chapterNum;
	}
	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	public int getQuestionType() {
		return QuestionType;
	}
	public void setQuestionType(int questionType) {
		QuestionType = questionType;
	}
	public int getChoiceNum() {
		return ChoiceNum;
	}
	public void setChoiceNum(int choiceNum) {
		ChoiceNum = choiceNum;
	}
	public String getChoiceStr() {
		return ChoiceStr;
	}
	public void setChoiceStr(String choiceStr) {
		ChoiceStr = choiceStr;
	}
	public String getAnswer() {
		return Answer;
	}
	public void setAnswer(String answer) {
		Answer = answer;
	}
	public String getExplaination() {
		return Explaination;
	}
	public void setExplaination(String explaination) {
		Explaination = explaination;
	}
	public int getSourceID() {
		return SourceID;
	}
	public void setSourceID(int sourceID) {
		SourceID = sourceID;
	}
	public String getUserAnswer() {
		return UserAnswer;
	}
	public void setUserAnswer(String userAnswer) {
		UserAnswer = userAnswer;
	}
	public QuestionBean(Integer qB_ID, int categorID, int chapterNum,
			String question, int questionType, int choiceNum, String choiceStr,
			String answer, String explaination, int sourceID,String userAnswer) {
		super();
		QB_ID = qB_ID;
		CategorID = categorID;
		ChapterNum = chapterNum;
		Question = question;
		QuestionType = questionType;
		ChoiceNum = choiceNum;
		ChoiceStr = choiceStr;
		Answer = answer;
		Explaination = explaination;
		SourceID = sourceID;
		UserAnswer=userAnswer;
	}
	public QuestionBean() {
		super();
	}
}
