package com.advanciastage.gestionalehr.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.advanciastage.gestionalehr.entity.Employee;
import com.advanciastage.gestionalehr.entity.EmployeeDTO;
import com.advanciastage.gestionalehr.util.JPAUtil;

public class EmployeeRepository {
	
	public EmployeeDTO findManagerByIdDep(Long id) {
		EntityManager entityManager= JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			entityManager.getTransaction().begin();
			Query query = entityManager.createQuery("SELECT e.employeeId,e.firstName,e.lastName,e.email,e.phoneNumber,e.salary,d.departmentName,e.email,j.jobTitle"
					+ " FROM Employee e,Department d,Job j"
					+ " WHERE d.departmentId = :id"
					+ " AND d.managerId=e.employeeId"
					+ " AND e.jobId= j.jobId");
			query.setParameter("id",id);
			List<Object> resultQuery = query.getResultList();
			EmployeeDTO employee = new EmployeeDTO((Object[]) resultQuery.get(0));
			 entityManager.getTransaction().commit();
	            return employee;
		} catch(NoResultException e) {
            return null;
			
		}finally {
			entityManager.close();
		}
		
	}
	public EmployeeDTO findByIdEmployeeDTO(Long id) {
		EntityManager entityManager= JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			entityManager.getTransaction().begin();
			Query query = entityManager.createQuery("SELECT e.employeeId,e.firstName,e.lastName,e.email,e.phoneNumber,e.salary,d.departmentName,m.firstName,j.jobTitle"
					+ " FROM Employee e,Department d,Job j, Employee m"
					+ " WHERE e.employeeId = :id"
					+ " AND e.departmentId=d.departmentId"
					+ " AND e.managerId=m.employeeId"
					+ " AND e.jobId= j.jobId");
			query.setParameter("id",id);
			List<Object> resultQuery = query.getResultList();
			EmployeeDTO employee = new EmployeeDTO((Object[]) resultQuery.get(0));
			 entityManager.getTransaction().commit();
	            return employee;
		} catch(NoResultException e) {
            return null;
			
		}finally {
			entityManager.close();
		}
		
	}
	

	public Employee findById(Long id) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			entityManager.getTransaction().begin();

			Query query = entityManager.createQuery("FROM Employee e WHERE e.employeeId = :id");

			query.setParameter("id", id);

			 try {
		            Employee employee = (Employee) query.getSingleResult();
		            entityManager.getTransaction().commit();
		            return employee;
		        } catch (NoResultException e) {
		            return null;
		        }
		} finally {
			
			entityManager.close();
		}
	}
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

	public List<String> selectAllManagersEmail() {
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
	public List<Employee> selectAllManagers() {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			entityManager.getTransaction().begin();

			Query query = entityManager.createQuery("SELECT e FROM Employee e JOIN Department d ON e.employeeId = d.managerId");

			@SuppressWarnings("unchecked")
			List<Employee> employees = (List<Employee>) query.getResultList();

			return employees;
		} finally {
			entityManager.getTransaction().commit();
			entityManager.close();
		}

	}
	public List<Employee> selectOnlyEmployee() {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		try{
			entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("SELECT e FROM Employee e, Department d WHERE e.employeeId != d.managerId");

		@SuppressWarnings("unchecked")
		List<Employee> employees = (List<Employee>) query.getResultList();
		return employees;
	} finally {
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	}	
}
