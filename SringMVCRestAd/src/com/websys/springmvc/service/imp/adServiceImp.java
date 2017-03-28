package com.websys.springmvc.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.websys.springmvc.dao.AdDao;
import com.websys.springmvc.dto.AdDto;
import com.websys.springmvc.model.AdEntity;
import com.websys.springmvc.service.AdService;

@Service
public class adServiceImp implements AdService {
	
	@Autowired
	@Qualifier("adDaoImp")
	//@Qualifier("adDaoDBImp")
	AdDao adDao;

	@Override
	public AdDto findAdById(String id) {
		AdDto adDto = new AdDto();
		AdEntity ad = adDao.findAdById(id);
		adDto.setPartnerId(ad.getPartnerId());
		adDto.setDuration(ad.getDuration());
		adDto.setAdContent(ad.getAdContent());
		return adDto;
	}

	@Override
	public List<AdDto> findAllAds() {
		List<AdDto> adDtos = new ArrayList<AdDto>();
		List<AdEntity> ads = adDao.findAllAds();
		for (AdEntity ad : ads) {
			AdDto adDto = new AdDto();
			adDto.setPartnerId(ad.getPartnerId());
			adDto.setDuration(ad.getDuration());
			adDto.setAdContent(ad.getAdContent());
			adDtos.add(adDto);
		}
		return adDtos;
	}

	@Override
	public void addAd(AdDto adDto) {
		AdEntity ad = new AdEntity();
		ad.setPartnerId(adDto.getPartnerId());
		ad.setDuration(adDto.getDuration());
		ad.setAdContent(adDto.getAdContent());
		
		adDao.addAdEntity(ad);
	}

}
