package com.shift.roster.business.bean;

import java.util.Collection;

public class Employee {

	private String employeeName;
	private Collection<ShiftDetails> shiftDetails;
	private Integer employeeId;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String employeeName, Collection<ShiftDetails> shiftDetails, Integer employeeId) {
		super();
		this.employeeName = employeeName;
		this.shiftDetails = shiftDetails;
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Collection<ShiftDetails> getShiftDetails() {
		return shiftDetails;
	}
	public void setShiftDetails(Collection<ShiftDetails> shiftDetails) {
		this.shiftDetails = shiftDetails;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	 
}
