package com.advanciastage.gestionalehr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "REGIONS")
public class Region {

	@Id
	@Column(name = "region_id")
	private long id;

	public Region() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(name = "region_name")
	private String regionName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Region(long id, String regionName) {
		super();
		this.id = id;
		this.regionName = regionName;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	@Override
	public String toString() {
		return "Regions [id=" + id + ", regionName=" + regionName + "]";
	}
}
