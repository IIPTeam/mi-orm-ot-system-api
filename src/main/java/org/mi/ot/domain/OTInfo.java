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

@Entity(name="staff_ot")
public class OTInfo implements Serializable{

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = -3026822034547908183L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length=8)
	private Long staffID;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Valid
	@Column
	private Date date;
	
	@Column(scale=1)
	private BigDecimal hours;
	
	@Column(length=400)
	private String reason;
	
	@Column
	private Long supportProject;
	
	@Column
	private Long currentProject;
	
	@Column
	private Long approval;
	
	@Column(updatable=false)
	private Date createTime = Calendar.getInstance().getTime();
	
	@Column
	private Date modifyTime = Calendar.getInstance().getTime();
	
	@Version
	private long version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStaffID() {
		return staffID;
	}

	public void setStaffID(Long staffID) {
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

	public Long getSupportProject() {
		return supportProject;
	}

	public void setSupportProject(Long supportProject) {
		this.supportProject = supportProject;
	}

	public Long getCurrentProject() {
		return currentProject;
	}

	public void setCurrentProject(Long currentProject) {
		this.currentProject = currentProject;
	}

	public Long getApproval() {
		return approval;
	}

	public void setApproval(Long approval) {
		this.approval = approval;
	}
	
	public long getVersion(){
		return version;
	}
}
