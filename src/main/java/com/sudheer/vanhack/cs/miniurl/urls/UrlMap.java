package com.sudheer.vanhack.cs.miniurl.urls;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author SUDHESHA
 *
 */
@Entity
@Table(name = "URLS_MAP")
@JsonPropertyOrder({ "shotrurl", "fullurl" })
public class UrlMap implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(value = "id")
	private long id;

	@Column(name = "shotrurl")
	private String shotrurl;

	@Override
	public String toString() {
		return "MiniUrl ["+ shotrurl +"]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getShotrurl() {
		return shotrurl;
	}

	public void setShotrurl(String shotrurl) {
		this.shotrurl = shotrurl;
	}

	/**
	 * @return
	 */
	public String getFullurl() {
		return fullurl;
	}

	public void setFullurl(String fullurl) {
		this.fullurl = fullurl;
	}

	/**
	 * @return
	 */
	public Calendar getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn
	 */
	public void setCreatedOn(Calendar createdOn) {
		this.createdOn = createdOn;
	}

	@Column(name = "fullurl")
	private String fullurl;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_on")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Calendar createdOn;

}
