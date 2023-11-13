package com.advanciastage.gestionalehr.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.advanciastage.gestionalehr.entity.Employee;
import com.advanciastage.gestionalehr.util.JPAUtil;

public class EmployeeRepository {

	public Employee findByEmail(String email) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			entityManager.getTransaction().begin();

			Query query = entityManager.createQuery("FROM Employee e WHERE e.email = :email");

			query.setParameter("email", email);

			 try {
		            Employee employee = (Employee) query.getSingleResult();
		            return employee;
		        } catch (NoResultException e) {
		            return null;
		        }
		} finally {
			entityManager.getTransaction().commit();
			entityManager.close();
		}
	}

	public List<Employee> selectAllEmployee() {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		try{
			entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("FROM Employee");

		@SuppressWarnings("unchecked")
		List<Employee> employees = (List<Employee>) query.getResultList();
		return employees;
	} finally {
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	}

	public List<String> selectAllManagers() {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			entityManager.getTransaction().begin();

			Query query = entityManager.createQuery("SELECT e.email FROM Employee e JOIN Department d ON e.employeeId = d.managerId");

			@SuppressWarnings("unchecked")
			List<String> employees = (List<String>) query.getResultList();

			return employees;
		} finally {
			entityManager.getTransaction().commit();
			entityManager.close();
		}

	}

}
