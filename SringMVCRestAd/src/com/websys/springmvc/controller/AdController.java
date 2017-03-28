package com.websys.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.websys.springmvc.dto.AdDto;
import com.websys.springmvc.service.AdService;

@RestController
public class AdController {
	
	@Autowired
	AdService adService;
	
	@RequestMapping(value = "/ad/{partnerId}", method = RequestMethod.GET)
	public ResponseEntity<AdDto> getAd(@PathVariable("partnerId") String partnerId) {
		AdDto adDto = adService.findAdById(partnerId);
		if (adDto == null) {
			return new ResponseEntity<AdDto>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<AdDto>(adDto, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"/ad/", "/ad"}, method = RequestMethod.GET)
	public ResponseEntity<List<AdDto>> getAllAds() {
		List<AdDto> adDtos = adService.findAllAds();
		if (adDtos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(adDtos, HttpStatus.OK);
	}

	@RequestMapping(value = "/ad/", method = RequestMethod.POST)
	public ResponseEntity<Void> addAd(@RequestBody AdDto adDto, 
			UriComponentsBuilder ucBuilder) {
		adService.addAd(adDto);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/ad/{partnerId}").buildAndExpand(adDto.getPartnerId()).toUri());
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
