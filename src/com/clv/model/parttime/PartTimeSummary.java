package com.clv.model.parttime;

/**
 * 兼职概要
 * @author evanglist
 *
 */
public class PartTimeSummary {
	private int partTimeId;
	private String photoName;
	private String title;
	private String location;
	private String locationProvince;
	private String locationCity;
	private String locationDistrict;
	private String locationDetailed;
	private String workDate;
	private String salary;
	private int partTimeQualification;
	private String lastTime;
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
	public String getLocationDistrict() {
		return locationDistrict;
	}
	public void setLocationDistrict(String locationDistrict) {
		this.locationDistrict = locationDistrict;
	}
	public String getLocationDetailed() {
		return locationDetailed;
	}
	public void setLocationDetailed(String locationDetailed) {
		this.locationDetailed = locationDetailed;
	}
	public String getWorkDate() {
		return workDate;
	}
	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public int getPartTimeQualification() {
		return partTimeQualification;
	}
	public void setPartTimeQualification(int partTimeQualification) {
		this.partTimeQualification = partTimeQualification;
	}
	
	public String getLastTime() {
		return lastTime;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation() {
		this.location = getLocationProvince()+getLocationCity()+getLocationDistrict()+getLocationDetailed();
	}
	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}
	@Override
	public String toString() {
		return "PartTimeSummary [partTimeId=" + partTimeId + ", photoName=" + photoName + ", title=" + title
				+ ", locationProvince=" + locationProvince + ", locationCity=" + locationCity + ", locationDistrict="
				+ locationDistrict + ", locationDetailed=" + locationDetailed + ", workDate=" + workDate + ", salary="
				+ salary + ", partTimeQualification=" + partTimeQualification + ", lastTime=" + lastTime + "]";
	}
	
	
}
