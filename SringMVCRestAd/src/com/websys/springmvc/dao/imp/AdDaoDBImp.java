package com.websys.springmvc.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.websys.springmvc.dao.AdDao;
import com.websys.springmvc.model.AdEntity;

@Repository
public class AdDaoDBImp implements AdDao {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public AdEntity findAdById(String id) {
		AdEntity ad = em.find(AdEntity.class, id);
		return ad;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AdEntity> findAllAds() {
		String hql = "SELECT a FROM ad a";
		return em.createQuery(hql).getResultList();
	}

	@Override
	public void addAdEntity(AdEntity ad) {
		em.persist(ad);
	}

}
