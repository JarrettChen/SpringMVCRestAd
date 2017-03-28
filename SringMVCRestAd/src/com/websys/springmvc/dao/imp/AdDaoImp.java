package com.websys.springmvc.dao.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.websys.springmvc.dao.AdDao;
import com.websys.springmvc.model.AdEntity;

@Repository
public class AdDaoImp implements AdDao {

	private static Map<String, AdEntity> adMap;
	
	static {
		adMap = dummyAds();
	}

	private static Map<String, AdEntity> dummyAds() {
		List<AdEntity> ads = new ArrayList<AdEntity>();
		ads.add(new AdEntity("100",10,"Apple Ad"));
		ads.add(new AdEntity("200",20,"Sony Ad"));
		ads.add(new AdEntity("300",15,"Common Ad"));
		ads.add(new AdEntity("400",5,"Child Ad"));
		ads.add(new AdEntity("500",3,"Milk Ad"));
		Map<String, AdEntity> adMap = new HashMap<String, AdEntity>();
		for (AdEntity ad : ads) {
			adMap.put(ad.getPartnerId(), ad);
		}
		return adMap;
	}
	
	@Override
	public AdEntity findAdById(String id) {
		return adMap.get(id);
	}
	@Override
	public List<AdEntity> findAllAds() {
		return new ArrayList<AdEntity>(adMap.values());
	}

	@Override
	public void addAdEntity(AdEntity ad) {
		adMap.put(ad.getPartnerId(), ad);
	}

}
