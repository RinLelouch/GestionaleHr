package com.advanciastage.gestionalehr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOCATIONS")
public class Location {
	@Id
	@Column(name = "location_id")
	private long locationId;
	@Column(name = "street_address")
	private String streetAddress;
	@Column(name = "postal_code")
	private String postalCode;

	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Location(long locationId, String streetAddress, String postalCode, String city, String stateProvince,
			String countryId) {
		super();
		this.locationId = locationId;
		this.streetAddress = streetAddress;
		this.postalCode = postalCode;
		this.city = city;
		this.stateProvince = stateProvince;
		this.countryId = countryId;
	}

	@Column(name = "city")
	private String city;
	@Column(name = "state_province")
	private String stateProvince;
	@Column(name = "country_id")
	private String countryId;

	public long getLocationId() {
		return locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateProvince() {
		return stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
}
