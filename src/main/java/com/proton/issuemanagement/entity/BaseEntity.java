package com.proton.issuemanagement.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;


@MappedSuperclass
@Getter //@Data Otomatik getter ve Setterleri oluşturuyor
@Setter
public abstract class BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Column(name = "created_by", length = 100)
	private String createdBy;
	
	@Column(name = "updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
	
	@Column(name = "updated_by", length = 100)
	private String updatedBy;
	
	@Column(name = "status")
	private Boolean status;
	
	
	
}
