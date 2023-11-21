package com.advanciastage.gestionalehr.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.advanciastage.gestionalehr.entity.Job;
import com.advanciastage.gestionalehr.util.JPAUtil;

public class JobRepository {
	
	public Long getMinSalary(String job) {
		
		EntityManager entityManager=JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			entityManager.getTransaction().begin();
			
			Query query= entityManager.createQuery("SELECT j.minSalary FROM Job j WHERE j.jobId= :job");
			query.setParameter("job", job);
			Long salary = (Long) query.getSingleResult();
			return salary;
	
			
		}catch(NoResultException e) {
			return null;
		}finally {
			entityManager.close();
		}
		
	}
	
	public void salaryChange( Long id, Long salario) {
		EntityManager entityManager= JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			entityManager.getTransaction().begin();
			Query query= entityManager.createQuery("UPDATE Employee SET salary=:salario WHERE employee_id=:id ");
			query.setParameter("salario", salario);
			query.setParameter("id", id);
			query.executeUpdate();
			entityManager.getTransaction().commit();
		}catch(NoResultException e) {
			System.out.print(e);
		}finally {
			entityManager.close();
		}
	}
	
	public List<Job> selectJobsByDepNotManagers(Long id){
		EntityManager entityManager= JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
		Query query = entityManager.createQuery("SELECT DISTINCT j FROM Employee e, Job j WHERE e.jobId=j.jobId AND e.departmentId=:id AND e.jobId NOT LIKE '%MAN%'");
		query.setParameter("id", id);
		List<Job> jobs = query.getResultList();
		return jobs;}
		catch(NoResultException e) {
			return null;
		}finally {
			entityManager.close();
		}
	}
	
	public List<Job> selectJobsByManager(Long id){
		EntityManager entityManager= JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
		Query query = entityManager.createQuery("SELECT DISTINCT j FROM Employee e, Job j WHERE e.jobId=j.jobId AND e.departmentId=:id");
		query.setParameter("id", id);
		List<Job> jobs = query.getResultList();
		return jobs;}
		catch(NoResultException e) {
			return null;
		}finally {
			entityManager.close();
		}
	}

	
	public Job selectJobById(String id) {
		
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			entityManager.getTransaction().begin();
			Query query = entityManager.createQuery("SELECT j FROM Job j WHERE j.jobId=:id");
			query.setParameter("id", id);
			Job job = (Job) query.getSingleResult();
			entityManager.getTransaction().commit();
			return job;
			
		}catch(NoResultException e) {
			return null;

		} finally {
			entityManager.close();
		}
	}
	
	
	public void updateSalary(Long min,Long max,String id) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			
		entityManager.getTransaction().begin();
		String sql = "UPDATE Job SET ";
		if(min>0) {
			sql = sql + "minSalary="+min;
		}if(max>0) {
			if(min>0) {
				sql=sql+ ",";
			}
			sql=sql +" maxSalary="+max;
		}
		sql=sql+" WHERE jobId='"+id+"'";
		Query query = entityManager.createQuery(sql);
		query.executeUpdate();
		entityManager.getTransaction().commit();
			
		}catch(NoResultException e) {
			System.out.print(e);
		}finally {
			entityManager.close();
		}
	}
	
}
