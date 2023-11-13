package com.advanciastage.gestionalehr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "JOBS")
public class Job {
	@Id
	@Column(name = "job_id")
	private long jobId;
	@Column(name = "job_title")
	private String jobTitle;
	@Column(name = "min_salary")
	private long minSalary;
	@Column(name = "max_salary")
	private long maxSalary;

	public long getJobId() {
		return jobId;
	}

	public void setJobId(long jobId) {
		this.jobId = jobId;
	}

	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Job(long jobId, String jobTitle, long minSalary, long maxSalary) {
		super();
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public long getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(long minSalary) {
		this.minSalary = minSalary;
	}

	public long getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(long maxSalary) {
		this.maxSalary = maxSalary;
	}
}
