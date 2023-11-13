package com.advanciastage.gestionalehr.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DEPARTMENTS")
public class Department {
	@Id
	@Column(name="department_id")
	private long departmentId;
	public Department(long departmentId, String departmentName, Long managerId, long locationId) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.managerId = managerId;
		this.locationId = locationId;
	}
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Column(name="department_name")
	private String departmentName;
	@Column(name="manager_id")
	private Long managerId;
	@Column(name="location_id")
	private long locationId;
	public long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Long getManagerId() {
		return managerId;
	}
	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}
	public long getLocationId() {
		return locationId;
	}
	
	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}
}
