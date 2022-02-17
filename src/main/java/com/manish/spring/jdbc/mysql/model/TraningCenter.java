package com.manish.spring.jdbc.mysql.model;

public class TraningCenter {

	private long id;
	private String centerName;
	private String centerCode;
	private String address;
	private long studentCapacity;
	private String coursesOffered;
	private String contactEmail;
	private String contactPhone;
	private String createdOn;

	public TraningCenter() {

	}

	public TraningCenter(long id, 
			String centerName, String centerCode, String address, long studentCapacity, 
			String coursesOffered, String contactEmail, String contactPhone) {
		this.id = id;
		this.centerName = centerName;
		this.centerCode = centerCode;
		this.address = address;
		this.studentCapacity = studentCapacity;
		this.coursesOffered = coursesOffered;
		this.contactEmail = contactEmail;
		this.contactPhone = contactPhone;
	}

	public TraningCenter(
			String centerName, String centerCode, String address, long studentCapacity, 
			String coursesOffered, String contactEmail, String contactPhone) {
		this.centerName = centerName;
		this.centerCode = centerCode;
		this.address = address;
		this.studentCapacity = studentCapacity;
		this.coursesOffered = coursesOffered;
		this.contactEmail = contactEmail;
		this.contactPhone = contactPhone;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public String getCenterCode() {
		return centerCode;
	}

	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getStudentCapacity() {
		return studentCapacity;
	}

	public void setStudentCapacity(long studentCapacity) {
		this.studentCapacity = studentCapacity;
	}

	public String getCoursesOffered() {
		return coursesOffered;
	}

	public void setCoursesOffered(String coursesOffered) {
		this.coursesOffered = coursesOffered;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "TraningCenter [id=" + id + ", "
				+ "centerName=\" + centerName + \", centerCode=\" + centerCode + \", address=\" + address + \", studentCapacity=\" + studentCapacity + \", \"\n"
				+ "				+ \"coursesOffered=\" + coursesOffered + \", contactEmail=\" + contactEmail + \", contactPhone=\" + contactPhone + \"]";
	}

}
