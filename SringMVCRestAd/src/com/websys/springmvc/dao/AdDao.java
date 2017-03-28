package com.websys.springmvc.dao;

import java.util.List;

import com.websys.springmvc.model.AdEntity;

public interface AdDao {
	AdEntity findAdById(String id);
	public List<AdEntity> findAllAds();
	void addAdEntity(AdEntity ad);
}
