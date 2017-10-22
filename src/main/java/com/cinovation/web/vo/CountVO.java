package com.cinovation.web.vo;

public class CountVO {

	String id;

	Long count;
	
	public CountVO(String id, Long count) {
		this.id = id;
		this.count = count;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

}
