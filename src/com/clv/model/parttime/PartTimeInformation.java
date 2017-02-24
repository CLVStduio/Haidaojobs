package com.clv.model.parttime;

/**
 * 兼职信息
 * @author evanglist
 *
 */
public class PartTimeInformation {
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
	private String locationProvince;
	private String locationCity;
	private String locationDistrict;
	private String locationDetailed;
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
	 * 0：招募中
	 * 1：招募完成
	 * 2：进行中
	 * 3：结算中
	 * 4：完成
	 */
	private int partTimeStatus;
	private String lastTime;
	private int partTimeQualification;
	private int publisherId;
	public int getPartTimeId() {
		return partTimeId;
	}
	public void setPartTimeId(int partTimeId) {
		this.partTimeId = partTimeId;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getSettlementMethod() {
		return settlementMethod;
	}
	public void setSettlementMethod(String settlementMethod) {
		this.settlementMethod = settlementMethod;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public String getWorkDate() {
		return workDate;
	}
	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}
	public String getLocationProvince() {
		return locationProvince;
	}
	public void setLocationProvince(String locationProvince) {
		this.locationProvince = locationProvince;
	}
	public String getLocationCity() {
		return locationCity;
	}
	public void setLocationCity(String locationCity) {
		this.locationCity = locationCity;
	}
	public String getLocationDistailed() {
		return locationDistrict;
	}
	public void setLocationDistailed(String locationDistrict) {
		this.locationDistrict = locationDistrict;
	}
	public String getLocationDetailed() {
		return locationDetailed;
	}
	public void setLocationDetailed(String locationDetailed) {
		this.locationDetailed = locationDetailed;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getNeedNumber() {
		return needNumber;
	}
	public void setNeedNumber(String needNumber) {
		this.needNumber = needNumber;
	}
	public String getNumberOfapplicants() {
		return numberOfapplicants;
	}
	public void setNumberOfapplicants(String numberOfapplicants) {
		this.numberOfapplicants = numberOfapplicants;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public String getClaim() {
		return claim;
	}
	public void setClaim(String claim) {
		this.claim = claim;
	}
	public int getPartTimeStatus() {
		return partTimeStatus;
	}
	public void setPartTimeStatus(int partTimeStatus) {
		this.partTimeStatus = partTimeStatus;
	}
	public String getLastTime() {
		return lastTime;
	}
	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}
	public int getPartTimeQualification() {
		return partTimeQualification;
	}
	public void setPartTimeQualification(int partTimeQualification) {
		this.partTimeQualification = partTimeQualification;
	}
	public int getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}
	@Override
	public String toString() {
		return "PartTimeInformation [partTimeId=" + partTimeId + ", photoName=" + photoName + ", title=" + title
				+ ", type=" + type + ", settlementMethod=" + settlementMethod + ", salary=" + salary + ", deadline="
				+ deadline + ", workDate=" + workDate + ", locationProvince=" + locationProvince + ", locationCity="
				+ locationCity + ", locationDistailed=" + locationDistrict + ", locationDetailed=" + locationDetailed
				+ ", companyId=" + companyId + ", needNumber=" + needNumber + ", numberOfapplicants="
				+ numberOfapplicants + ", jobDescription=" + jobDescription + ", claim=" + claim + ", partTimeStatus="
				+ partTimeStatus + ", lastTime=" + lastTime + ", partTimeQualification=" + partTimeQualification
				+ ", publisherId=" + publisherId + "]";
	}
	
	
}
