package com.advanciastage.gestionalehr.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "JOB_HISTORY")
public class JobHistory implements Serializable{
	
	private JobHistoryPK jobhistoryPk;
	@Id
	@Column(name = "employee_id")
	private long employeeId;
	@Column(name = "start_date")
	private LocalDate startDate;
	@Column(name = "end_date")
	private LocalDate endDate;
	@Column(name = "job_id")
	private long jobId;
	@Column(name = "department_id")
	private long departmentId;

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public long getJobId() {
		return jobId;
	}

	public void setJobId(long jobId) {
		this.jobId = jobId;
	}

	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public JobHistory(long employeeId, LocalDate startDate, LocalDate endDate, long jobId, long departmentId) {
		super();
		this.employeeId = employeeId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.jobId = jobId;
		this.departmentId = departmentId;
	}

	public JobHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
}
