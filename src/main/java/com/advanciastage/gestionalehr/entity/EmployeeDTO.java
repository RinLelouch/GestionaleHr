package com.advanciastage.gestionalehr.entity;

public class EmployeeDTO {

	private Long id;
	public EmployeeDTO( String name,Long id, String lastName, String jobTitle) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.jobTitle = jobTitle;
	}

	private String name;
	private String lastName;
	private String email;
	private String phoneNumber;
	private long salary;
	private String nomeDipartimento;
	private String nomeManager;
	private String jobTitle;
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public EmployeeDTO(Object[] resultArray) {
	    this.id = (Long) resultArray[0];
	    this.name = (String) resultArray[1];
	    this.lastName = (String) resultArray[2];
	    this.email = (String) resultArray[3];
	    this.phoneNumber = (String) resultArray[4];
	    this.salary = (Long) resultArray[5];
	    this.nomeDipartimento = (String) resultArray[6];
	    this.nomeManager = (String) resultArray[7];
	    this.jobTitle = (String) resultArray[8];
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getNomeDipartimento() {
		return nomeDipartimento;
	}

	public void setNomeDipartimento(String nomeDipartimento) {
		this.nomeDipartimento = nomeDipartimento;
	}

	public String getNomeManager() {
		return nomeManager;
	}

	public void setNomeManager(String nomeManager) {
		this.nomeManager = nomeManager;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public EmployeeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeDTO(Long id, String name, String lastName, String email) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
