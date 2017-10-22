package com.cinovation.web.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "StatusEntity")
@Table(name = "t_mt_status")
public class StatusEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7351581220663323378L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "ID", unique = true)
	private String id;

	@Column(name = "cd")
	private String cd;

	@Column(name = "dscp")
	private String dscp;

	@Column(name = "segNo")
	private int segNo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCd() {
		return cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}

	public String getDscp() {
		return dscp;
	}

	public void setDscp(String dscp) {
		this.dscp = dscp;
	}

	public int getSegNo() {
		return segNo;
	}

	public void setSegNo(int segNo) {
		this.segNo = segNo;
	}

}
