package com.websys.springmvc.dto;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AdDto implements Serializable {

	private static final long serialVersionUID = 1317939735241030222L;
	
	@NotNull(message = "")
	private String partnerId;
	@Min(value = 1, message = "")
	private int duration;
	@NotNull(message = "")
	private String adContent;

	
	public String getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getAdContent() {
		return adContent;
	}
	public void setAdContent(String adContent) {
		this.adContent = adContent;
	}
	


}
