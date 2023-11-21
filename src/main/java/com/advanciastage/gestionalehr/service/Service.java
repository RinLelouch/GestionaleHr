package com.advanciastage.gestionalehr.service;

import java.util.List;
import java.util.regex.Pattern;

import com.advanciastage.gestionalehr.entity.Employee;
import com.advanciastage.gestionalehr.entity.Job;
import com.advanciastage.gestionalehr.repository.EmployeeRepository;
import com.advanciastage.gestionalehr.repository.JobRepository;

public class Service {
	private EmployeeRepository employeeRepo = new EmployeeRepository();
	private JobRepository jobRepo = new JobRepository();
	
	
	public boolean controlloNumeroTelefono(String numero) {
		String regex= "^[0-9]+(\\.[0-9]+)*$";
		return Pattern.matches(regex, numero);		
	}
	
	
	
	public boolean checkLogin(Employee emp, String password) {

		String phone = emp.getPhoneNumber().replace(".", "");
		if (password.equals(phone)) {
			return true;
		} else {
			return false;
		}

	}

	public int checkStatus(Employee emp) {
		List<String> managers = employeeRepo.selectAllManagersEmail();

		if (emp.getJobId().equals("AD_PRES") || emp.getJobId().equals("AD_VP")) {
			return 1;
		} else if (managers.contains(emp.getEmail())) {
			return 2;
		}
		return 3;

	}

	public Boolean numbPercentageMin(Long min, String id) {

		Job job = jobRepo.selectJobById(id);
		Long minSalary = job.getMinSalary();
		if (min > 0 && min >= minSalary * 0.9 && min <= minSalary / 0.9) {
			return true;
		} else {
			return false;
		}

	}

    public Boolean numbPercentageMax(Long max,String id) {
		
		Job job= jobRepo.selectJobById(id);
		Long maxSalary=job.getMaxSalary();
		if(max>0 && max>=maxSalary*0.9 && max<=maxSalary/0.9) {
			return true;
		}else { 
			return false;
		} 
		}
	
    public void checkSalary(String jobId) {
    	Job job = jobRepo.selectJobById(jobId);
    	Long minSalary=job.getMinSalary();
    	Long maxSalary=job.getMaxSalary();
    	List<Employee> employees = employeeRepo.findEmployeeByJobId(jobId);
    	for(Employee emp : employees) {
    		Long empId= emp.getEmployeeId();
    		if(emp.getSalary()<minSalary) {
    			jobRepo.salaryChange(empId, minSalary);
    		}if(emp.getSalary()>maxSalary) {
    			jobRepo.salaryChange(empId, maxSalary);
    		}
    	}
    }
}