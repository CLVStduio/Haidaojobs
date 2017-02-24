package com.clv.model.parttime;

/**
 * 兼职说明
 * @author evanglist
 *
 */
public class PartTimeDescription {
	private int descriptionId;
	private String title;
	private String content;
	public int getDescriptionId() {
		return descriptionId;
	}
	public void setDescriptionId(int descriptionId) {
		this.descriptionId = descriptionId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "PartTimeDescription [descriptionId=" + descriptionId + ", title=" + title + ", content=" + content
				+"]";
	}
	
}
