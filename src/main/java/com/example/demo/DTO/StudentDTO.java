package com.example.demo.DTO;

public class StudentDTO {
	
	private Long studentId;
	private Long semester;
	private Long admissionYear;
	private String branchCode;
	private String course;
	private Integer page;
	private Integer pageSize;
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public Long getSemester() {
		return semester;
	}
	public void setSemester(Long semester) {
		this.semester = semester;
	}
	public Long getAdmissionYear() {
		return admissionYear;
	}
	public void setAdmissionYear(Long admissionYear) {
		this.admissionYear = admissionYear;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	

}
