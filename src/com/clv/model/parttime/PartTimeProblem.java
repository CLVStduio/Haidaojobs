package com.clv.model.parttime;

/**
 * 兼职问题设置
 * @author evanglist
 *
 */
public class PartTimeProblem {
	private int problemId;
	private String topic;
	/**
	 * 问题类型
	 * 1、问答题
	 * 2、单选题
	 * 3、多选题
	 * 
	 */
	private int type;
	private String content;
	private int partTimeId;
	public int getProblemId() {
		return problemId;
	}
	public void setProblemId(int problemId) {
		this.problemId = problemId;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPartTimeId() {
		return partTimeId;
	}
	public void setPartTimeId(int partTimeId) {
		this.partTimeId = partTimeId;
	}
	@Override
	public String toString() {
		return "PartTimeProblem [problemId=" + problemId + ", topic=" + topic + ", type=" + type + ", content="
				+ content + ", partTimeId=" + partTimeId + "]";
	}
	
}
