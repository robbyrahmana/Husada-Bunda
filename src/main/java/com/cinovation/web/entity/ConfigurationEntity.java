package com.cinovation.web.entity;

import java.io.Serializable;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "ConfigurationEntity")
@Table(name = "t_cfg_val", indexes = { @Index(name = "idx_code_locale", columnList = "code, locale") })
public class ConfigurationEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7127762108018059702L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "ID", unique = true)
	private String ID;

	@Column(name = "code")
	private String code;

	@Column(name = "locale")
	private Locale locale;

	@Column(name = "type")
	private String type;

	@Column(name = "text1", length=500)
	private String text1;

	@Column(name = "text2", length=500)
	private String text2;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getText1() {
		return text1;
	}

	public void setText1(String text1) {
		this.text1 = text1;
	}

	public String getText2() {
		return text2;
	}

	public void setText2(String text2) {
		this.text2 = text2;
	}

}
