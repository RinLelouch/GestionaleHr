package com.advanciastage.gestionalehr.entity;

public class DepartmentDTO {
	private Long id;
	private String departmentName;
	private String managerName;
	private String managerSurname;
	private String city;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	
	public DepartmentDTO(Object[] resultArray) {
	    this.id = (Long) resultArray[0];
	    this.departmentName = (String) resultArray[1];
	    this.managerName = (String) resultArray[2];
	    this.managerSurname = (String) resultArray[3];
	    this.city = (String) resultArray[4];
	   
	}
	
	public DepartmentDTO(Long id, String departmentName, String managerName, String managerSurname, String city
			) {
		super();
		this.id = id;
		this.departmentName = departmentName;
		this.managerName = managerName;
		this.managerSurname = managerSurname;
		this.city = city;
		
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerSurname() {
		return managerSurname;
	}
	public void setManagerSurname(String managerSurname) {
		this.managerSurname = managerSurname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
