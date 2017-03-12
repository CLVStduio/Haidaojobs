package com.clv.model.parttime;

import java.util.List;

public class PartTimeShow {
	private int partTimeId;
	/**
	 * 兼职图片
	 */
	private String photoName;
	/**
	 * 兼职标题
	 */
	private String title;
	/**
	 * 兼职类型
	 */
	private int type;
	/**
	 * 结算方式
	 */
	private String settlementMethod;
	/**
	 * 薪资
	 */
	private String salary;
	/**
	 * 报名截止日期
	 */
	private String deadline;
	/**
	 * 工作日期
	 */
	private String workDate;
	/**
	 * 工作地点
	 */
	private String location;
	/**
	 * 公司id
	 */
	private String companyId;
	/**
	 * 需要人数
	 */
	private String needNumber;
	/**
	 * 报名人数
	 */
	private String numberOfapplicants;
	/**
	 * 工作简介
	 */
	private String jobDescription;
	/**
	 * 基本要求
	 */
	private String claim;
	/**
	 * 兼职状态
		101：审核中
	  	102：审核不通过
	  	201：审核通过/招募中
	  	202：招募完成/等待兼职进行
	  	203：工作中/兼职进行中
	  	301：待结算
 	  	302：结算结束/待评价和工作周期无投诉（8小时内）
	  	401：已完结
	  	402：已撤销
 	  	403：用户投诉中
 	  	405: 投诉处理中
 	  	406：投诉处理结束
	 */
	private int partTimeStatus;
	private List<PartTimeDescription> description;
	
	public PartTimeShow(PartTimeInformation information,List<PartTimeDescription> description){
		this.partTimeId = information.getPartTimeId();
		this.photoName = information.getPhotoName();
		this.title = information.getTitle();
		this.type = information.getType();
		this.settlementMethod = information.getSettlementMethod();
		this.salary = information.getSalary();
		this.deadline = information.getDeadline();
		this.workDate = information.getWorkDate();
		this.location = information.getLocationProvince()+information.getLocationCity()+information.getLocationDistailed()+information.getLocationDetailed();
		this.companyId = information.getCompanyId();
		this.needNumber = information.getNeedNumber();
		this.numberOfapplicants = information.getNumberOfapplicants();
		this.jobDescription = information.getJobDescription();
		this.claim = information.getClaim();
		this.partTimeStatus = information.getPartTimeStatus();
		this.description = description;
	}
	public int getPartTimeId() {
		return partTimeId;
	}
	public String getPhotoName() {
		return photoName;
	}
	public String getTitle() {
		return title;
	}
	public int getType() {
		return type;
	}
	public String getSettlementMethod() {
		return settlementMethod;
	}
	public String getSalary() {
		return salary;
	}
	public String getDeadline() {
		return deadline;
	}
	public String getWorkDate() {
		return workDate;
	}
	public String getLocation() {
		return location;
	}
	public String getCompanyId() {
		return companyId;
	}
	public String getNeedNumber() {
		return needNumber;
	}
	public String getNumberOfapplicants() {
		return numberOfapplicants;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public String getClaim() {
		return claim;
	}
	public int getPartTimeStatus() {
		return partTimeStatus;
	}
	public List<PartTimeDescription> getDescription() {
		return description;
	}
	@Override
	public String toString() {
		return "PartTimeShow [partTimeId=" + partTimeId + ", photoName=" + photoName + ", title=" + title + ", type="
				+ type + ", settlementMethod=" + settlementMethod + ", salary=" + salary + ", deadline=" + deadline
				+ ", workDate=" + workDate + ", location=" + location + ", companyId=" + companyId + ", needNumber="
				+ needNumber + ", numberOfapplicants=" + numberOfapplicants + ", jobDescription=" + jobDescription
				+ ", claim=" + claim + ", partTimeStatus=" + partTimeStatus + ", description=" + description + "]";
	}
	
}
