package com.advanciastage.gestionalehr.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Embeddable;

@Embeddable
public class JobHistoryPK implements Serializable {

	private long id;
	private LocalDate startDate;

	public JobHistoryPK(long id, LocalDate startDate) {
		super();
		this.id = id;
		this.startDate = startDate;
	}

	public JobHistoryPK() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
}
