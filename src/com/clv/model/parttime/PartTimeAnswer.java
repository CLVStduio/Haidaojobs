package com.clv.model.parttime;

/**
 * 兼职用户答案数据的模型
 * @author evanglist
 *
 */
public class PartTimeAnswer {
	private int problemId;
	private String answerContent;
	private int userId;
	public PartTimeAnswer() {
		super();
	}
	public int getProblemId() {
		return problemId;
	}
	public void setProblemId(int problemId) {
		this.problemId = problemId;
	}
	public String getAnswerContent() {
		return answerContent;
	}
	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "PartTimeAnswer [problemId=" + problemId + ", answerContent=" + answerContent + ", userId=" + userId
				+ "]";
	}
}
