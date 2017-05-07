package org.mi.ot.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class OTInfo implements Serializable{

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = -3026822034547908183L;

	@Id
	@GeneratedValue
	private long id;
	
	@Column(length=8, nullable=false)
	private long staffID;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Valid
	@Column(nullable=false)
	private Date date;
	
	@Column(nullable=false, scale=1)
	private BigDecimal hours;
	
	@Column(length=400)
	private String reason;
	
	@Column
	private long supportProject = -1;
	
	@Column(nullable=false)
	private long currentProject;
	
	@Column
	private long approval = -1;
	
	@Column(updatable=false)
	private Date createTime = Calendar.getInstance().getTime();
	
	@Column
	private Date modifyTime = Calendar.getInstance().getTime();
	
	@Version
	private long version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getStaffID() {
		return staffID;
	}

	public void setStaffID(long staffID) {
		this.staffID = staffID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getHours() {
		return hours;
	}

	public void setHours(BigDecimal hours) {
		this.hours = hours;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public long getSupportProject() {
		return supportProject;
	}

	public void setSupportProject(long supportProject) {
		this.supportProject = supportProject;
	}

	public long getCurrentProject() {
		return currentProject;
	}

	public void setCurrentProject(long currentProject) {
		this.currentProject = currentProject;
	}

	public long getApproval() {
		return approval;
	}

	public void setApproval(long approval) {
		this.approval = approval;
	}
}
