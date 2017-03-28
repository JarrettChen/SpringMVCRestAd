package com.websys.springmvc.service;

import java.util.List;

import com.websys.springmvc.dto.AdDto;

public interface AdService {
	public AdDto findAdById(String id);
	public List<AdDto> findAllAds();
	public void addAd(AdDto ad);
}
