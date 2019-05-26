package com.shift.roster.business.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


public class ShiftDetails {
	
	private Integer empId;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date shiftDate;
	private String shift;
	private Integer shiftId;
	
	public Integer getShiftId() {
		return shiftId;
	}




	public void setShiftId(Integer shiftId) {
		this.shiftId = shiftId;
	}




	public ShiftDetails(Integer shiftId,Integer empId, Date shiftDate, String shift) {
		super();
		this.shiftId = shiftId;
		this.empId = empId;
		this.shiftDate = shiftDate;
		this.shift = shift;
	}
	
	


	public ShiftDetails() {
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
