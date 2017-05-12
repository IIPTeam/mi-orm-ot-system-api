package org.mi.ot.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="staff_ot")
@JsonIgnoreProperties(ignoreUnknown = true)
public class OTInfo implements Serializable{

	@Transient
	private static final long serialVersionUID = -3026822034547908183L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length=8)
	private String staffID;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	@Valid
	@Column
	private Date startTime;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	@Valid
	@Column
	private Date endTime;
	
	@Column(scale=1)
	private Double duration;
	
	@Column(length=400)
	private String reason;
	
	@Column
	private Long approval = 1L;
	
	@Column
	private Integer type = 1;
	
	@Column
	private String field1;
	
	@Column
	private String field2;

	@Column
	private String field3;

	@Column
	private String field4;

	@Column
	private String field5;
	
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

	public String getStaffID() {
		return staffID;
	}

	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public String getField3() {
		return field3;
	}

	public void setField3(String field3) {
		this.field3 = field3;
	}

	public String getField4() {
		return field4;
	}

	public void setField4(String field4) {
		this.field4 = field4;
	}

	public String getField5() {
		return field5;
	}

	public void setField5(String field5) {
		this.field5 = field5;
	}

	public Long getApproval() {
		return approval;
	}

	public void setApproval(Long approval) {
		this.approval = approval;
	}
}
