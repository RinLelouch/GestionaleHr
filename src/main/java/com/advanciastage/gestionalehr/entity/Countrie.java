package com.advanciastage.gestionalehr.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="COUNTRIES")
public class Countrie {
 
	public Countrie(long countryId, String countryName, long region_id) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
		this.region_id = region_id;
	}
	public Countrie() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@Column(name="country_id")
	private long countryId;
	@Column(name="country_name")
	private String countryName;
	@Column(name="region_id")
	private long region_id;
	public long getCountryId() {
		return countryId;
	}
	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public long getRegion_id() {
		return region_id;
	}
	public void setRegion_id(long region_id) {
		this.region_id = region_id;
	}
}
