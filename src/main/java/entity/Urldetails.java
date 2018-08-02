package entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Urldetails {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int urlDetailsID;
	
	private String url;
	
	private Date createdDate;
	
	private Date expiryDate;

	public int getUrlDetailsID() {
		return urlDetailsID;
	}

	public void setUrlDetailsID(int urlDetailsID) {
		this.urlDetailsID = urlDetailsID;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
}
