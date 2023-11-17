package com.advanciastage.gestionalehr.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.advanciastage.gestionalehr.entity.Department;
import com.advanciastage.gestionalehr.entity.EmployeeDTO;
import com.advanciastage.gestionalehr.entity.Job;
import com.advanciastage.gestionalehr.entity.Location;
import com.advanciastage.gestionalehr.util.JPAUtil;
import com.mysql.cj.util.StringUtils;

public class GeneralRepository {

	public List<Location> selectAllLocations() {

		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			entityManager.getTransaction().begin();

			Query query = entityManager.createQuery("FROM Location");
			@SuppressWarnings("unchecked")
			List<Location> locations = (List<Location>) query.getResultList();

			return locations;
		} catch (NoResultException e) {
			return null;
		} finally {
			entityManager.getTransaction().commit();
			entityManager.close();
		}

	}
	
	
	public List<Department> selectAllDepartments() {

		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			entityManager.getTransaction().begin();

			Query query = entityManager.createQuery("FROM Department");
			@SuppressWarnings("unchecked")
			List<Department> departments = (List<Department>) query.getResultList();

			return departments;
		} catch (NoResultException e) {
			return null;
		} finally {
			entityManager.getTransaction().commit();
			entityManager.close();
		}

	}
	
	public List<Job> selectAllJobs() {

		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			entityManager.getTransaction().begin();

			Query query = entityManager.createQuery("FROM Job");
			@SuppressWarnings("unchecked")
			List<Job> jobs = (List<Job>) query.getResultList();

			return jobs;
		} catch (NoResultException e) {
			return null;
		} finally {
			entityManager.getTransaction().commit();
			entityManager.close();
		}

	}

	
	
	public List<EmployeeDTO> selectGeneric(Long id, String nome, String cognome, String email, String nomeDipartimento,String location, String jobTitle, String data){
		
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
		entityManager.getTransaction().begin();
		String sql=
		"SELECT e.employeeId,e.firstName,e.lastName,e.email FROM Employee e, Department d, Location l, Job j  WHERE"
 		+ " e.departmentId = d.departmentId AND d.locationId = l.locationId AND e.jobId = j.jobId ";
		if (id>0) {
			sql = sql + " AND e.employeeId LIKE '%" + id + "%'";
		}
		if (!StringUtils.isNullOrEmpty(nome)) {
			sql = sql + " AND e.firstName LIKE '%" + nome + "%'";
		}if (!StringUtils.isNullOrEmpty(cognome)) {
			sql = sql + " AND e.lastName LIKE '%" + cognome + "%'";
		}if (!StringUtils.isNullOrEmpty(email)) {
			sql = sql + " AND e.email LIKE '%" + email + "%' ";
		}if (!StringUtils.isNullOrEmpty(nomeDipartimento)) {
			sql = sql + " AND d.departmentName LIKE '%" + nomeDipartimento + "%'";
		}if (!StringUtils.isNullOrEmpty(location)) {
			sql = sql + " AND l.countryId LIKE '%" + location + "%'";
		}if (!StringUtils.isNullOrEmpty(jobTitle)) {
			sql = sql + " AND e.jobId LIKE '%" + jobTitle + "%'";
		}if (!StringUtils.isNullOrEmpty(data)) {
		sql= sql + " AND e.hireDate >TO_DATE('" + data+"','dd/MM/YYYY HH24:mi:ss')";
		}
		
		 Query query = entityManager.createQuery(sql);
		 
		 List<Object[]> resultQuery = entityManager.createQuery(sql, Object[].class).getResultList();
		 List<EmployeeDTO> resultList = new ArrayList<>();

		 for (Object[] result : resultQuery) {
		     Long idEmp = (Long) result[0];
		     String firstName = (String) result[1];
		     String lastName = (String) result[2];
		     String pippo = (String) result[3];
		     EmployeeDTO dto = new EmployeeDTO(idEmp, firstName, lastName, pippo);
		     resultList.add(dto);
		 }
		 
		 return resultList;
		
		}
		catch(NoResultException e) {
			return null;
		} finally {
			
			entityManager.close();
		}
		
	}
	
public List<EmployeeDTO> selectGenericByManager(Long managerId,Long id, String nome, String cognome, String email,  String jobTitle, String data){
		
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
		entityManager.getTransaction().begin();
		String sql=
		"SELECT e.employeeId,e.firstName,e.lastName,e.email FROM Employee e, Department d, Location l, Job j  WHERE"
 		+ " e.departmentId = d.departmentId AND d.locationId = l.locationId AND e.jobId = j.jobId AND d.managerId=" + managerId+" AND e.employeeId !=" +managerId ;
		if (id>0) {
			sql = sql + " AND e.employeeId LIKE '%" + id + "%'";
		}
		if (!StringUtils.isNullOrEmpty(nome)) {
			sql = sql + " AND e.firstName LIKE '%" + nome + "%'";
		}if (!StringUtils.isNullOrEmpty(cognome)) {
			sql = sql + " AND e.lastName LIKE '%" + cognome + "%'";
		}if (!StringUtils.isNullOrEmpty(email)) {
			sql = sql + " AND e.email LIKE '%" + email + "%' ";
			}
		if (!StringUtils.isNullOrEmpty(jobTitle)) {
			sql = sql + " AND e.jobId LIKE '%" + jobTitle + "%'";
		}if (!StringUtils.isNullOrEmpty(data)) {
		sql= sql + " AND e.hireDate >TO_DATE('" + data+"','dd/MM/YYYY HH24:mi:ss')";
		}
		
		 Query query = entityManager.createQuery(sql);
		 
		 List<Object[]> resultQuery = entityManager.createQuery(sql, Object[].class).getResultList();
		 List<EmployeeDTO> resultList = new ArrayList<>();

		 for (Object[] result : resultQuery) {
		     Long idEmp = (Long) result[0];
		     String firstName = (String) result[1];
		     String lastName = (String) result[2];
		     String pippo = (String) result[3];
		     EmployeeDTO dto = new EmployeeDTO(idEmp, firstName, lastName, pippo);
		     resultList.add(dto);
		 }
		 
		 return resultList;
		
		}
		catch(NoResultException e) {
			return null;
		} finally {
			
			entityManager.close();
		}
		
	}
	public List<EmployeeDTO> cercaEmpInDep(Long id){
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			
			Query query = entityManager.createQuery("SELECT e.firstName, e.employeeId,e.lastName,j.jobTitle FROM Employee e, Department d,Job j "
					+ "WHERE e.jobId=j.jobId AND e.departmentId=d.departmentId AND e.departmentId= :id "
					+ " AND e.employeeId != d.managerId");
			query.setParameter("id", id);
			
			List<Object[]> resultQuery = query.getResultList();
			List<EmployeeDTO> emp = new ArrayList<>();
			for (Object[] result : resultQuery) {
			     Long idEmp = (Long) result[1];
			     String firstName = (String) result[0];
			     String lastName = (String) result[2];
			     String pippo = (String) result[3];
			     EmployeeDTO dto = new EmployeeDTO(firstName,idEmp, lastName, pippo);
			    emp.add(dto);
			 }
			return emp;
		}catch(NoResultException e) {
			return null;
		} finally {
			
			entityManager.close();
		}
		
	}
}
