package com.shift.roster.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="shiftdetails")
public class ShiftDetailsEntity {
	
	@Column(name="empId")
	private Integer empId;
	@Column(name="shiftDate")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date shiftDate;
	@Column(name="shift")
	private String shift;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="shiftId")
	private Integer shiftId;
	
	
	public ShiftDetailsEntity(Integer shiftId,Integer empId, Date shiftDate, String shift) {
		super();
		this.shiftId =shiftId;
		this.empId = empId;
		this.shiftDate = shiftDate;
		this.shift = shift;
	}
	
	


	public Integer getShiftId() {
		return shiftId;
	}




	public void setShiftId(Integer shiftId) {
		this.shiftId = shiftId;
	}




	public ShiftDetailsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Integer getEmpId() {
		return empId;
	}




	public void setEmpId(Integer empId) {
		this.empId = empId;
	}




	public Date getShiftDate() {
		return shiftDate;
	}




	public void setShiftDate(Date shiftDate) {
		this.shiftDate = shiftDate;
	}




	public String getShift() {
		return shift;
	}




	public void setShift(String shift) {
		this.shift = shift;
	}




	@Override
	public String toString() {
		return "ShiftDetails [empId=" + empId + ", shiftDate=" + shiftDate + ", shift=" + shift + "]";
	}
	
	

}
