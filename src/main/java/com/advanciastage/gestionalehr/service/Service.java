package com.advanciastage.gestionalehr.service;

import java.util.List;

import com.advanciastage.gestionalehr.entity.Employee;
import com.advanciastage.gestionalehr.repository.EmployeeRepository;

public class Service {
	private EmployeeRepository employeeRepo = new EmployeeRepository();

	public boolean checkLogin(Employee emp, String password) {

		String phone = emp.getPhoneNumber().replace(".", "");
		if (password.equals(phone)) {
			return true;
		} else {
			return false;
		}

	}

	public int checkStatus(Employee emp) {
		List<String> managers=employeeRepo.selectAllManagers();

		if (emp.getJobId().equals("AD_PRES") || emp.getJobId().equals("AD_VP")) {
			return 1;
		} else if (managers.contains(emp.getEmail())) {
			return 2;
		}
		return 3;

	}
}