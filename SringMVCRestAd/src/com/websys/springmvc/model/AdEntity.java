package com.websys.springmvc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ad")
public class AdEntity implements Serializable {

	private static final long serialVersionUID = 302623130823206071L;
	
	private String partnerId;
	private int duration;
	private String adContent;

	public AdEntity() {
	}

	public AdEntity(String partner_id, int duration, String ad_content) {
		this.partnerId = partner_id;
		this.duration = duration;
		this.adContent = ad_content;
	}

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")	
	@Column(name="partner_id")
	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partner_id) {
		this.partnerId = partner_id;
	}

	@Column(name="duration")
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	@Column(name="ad_content")
	public String getAdContent() {
		return adContent;
	}

	public void setAdContent(String ad_content) {
		this.adContent = ad_content;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((partnerId == null) ? 0 : partnerId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdEntity other = (AdEntity) obj;
		if (partnerId == null) {
			if (other.partnerId != null)
				return false;
		} else if (!partnerId.equals(other.partnerId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ad [partner_id=" + partnerId + ", duration=" + duration + ", ad_content=" + adContent + "]";
	}

}
