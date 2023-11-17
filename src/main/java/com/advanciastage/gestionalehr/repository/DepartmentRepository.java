package com.advanciastage.gestionalehr.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;


import com.advanciastage.gestionalehr.entity.DepartmentDTO;

import com.advanciastage.gestionalehr.util.JPAUtil;
import com.mysql.cj.util.StringUtils;

public class DepartmentRepository {
	
	
	public List<DepartmentDTO> departmentSearchDinamic(Long id, String departmentName, Long idLocalita){
		
		EntityManager entityManager= JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			entityManager.getTransaction().begin();
			String sql=
					 "SELECT d.departmentId,d.departmentName,e.firstName,e.lastName,l.city FROM Department d, Employee e, Location l"
					+ " WHERE d.managerId = e.employeeId"
					+ " AND d.locationId=l.locationId";
			if(id>0) {
				sql = sql + " AND d.departmentId=" + id;
			}if(!StringUtils.isNullOrEmpty(departmentName)) {
				sql = sql+ " AND d.departmentName LIKE '%"+departmentName+"%'";
			}if(idLocalita>0) {
				sql = sql +" AND d.locationId="+idLocalita;
			}
		
			List<Object[]> resultQuery = entityManager.createQuery(sql, Object[].class).getResultList();
			 List<DepartmentDTO> resultList = new ArrayList<>();

			 for (Object[] result : resultQuery) {
			     Long idEmp = (Long) result[0];
			     String depName = (String) result[1];
			     String managerName = (String) result[2];
			     String managerLastName = (String) result[3];
			     String city = (String) result[4];
			     DepartmentDTO dto = new DepartmentDTO(idEmp, depName, managerName, managerLastName,city);
			     resultList.add(dto);
			 }
			 
			 return resultList;
			
		}catch(NoResultException e) {
            return null;
			
		}finally {
			entityManager.close();
		}
	}
	
	public DepartmentDTO findDepartment(Long id){
		EntityManager entityManager= JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
		entityManager.getTransaction().begin();
		Query query= entityManager.createQuery(
				 "SELECT d.departmentId,d.departmentName,e.firstName,e.lastName,l.city FROM Department d, Employee e, Location l"
				+ " WHERE d.managerId = e.employeeId"
				+ " AND d.locationId=l.locationId "
				+ " AND d.departmentId= :id");
		query.setParameter("id",id);
		
		List<Object> list = query.getResultList();
		DepartmentDTO depDTO = new DepartmentDTO((Object[])list.get(0));
		return depDTO;
	}
	catch(NoResultException e) {
        return null;
		
	}finally {
		entityManager.close();
	}
}
	}
