package com.advanciastage.gestionalehr.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.advanciastage.gestionalehr.entity.Region;
import com.advanciastage.gestionalehr.util.JPAUtil;

public class RegionRepository {
	public void findById(long id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        System.out.println("Finding region...");
        Region region = entityManager.find(Region.class, id);
        System.out.println("region id :: " + region.getId());
        System.out.println("region name :: " + region.getRegionName());
        entityManager.close();
    }
	
	@SuppressWarnings("unchecked")
	public void findAll() {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		System.out.println("Returning all regions...");
		List<Region> regions = (List<Region>) entityManager.createQuery("from Region").getResultList();
		regions.stream().forEach(region -> System.out.println(region));
		entityManager.close();
	}
}
