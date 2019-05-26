package com.shift.roster.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class EmployeeEntity {
	@Column(name="empName")
	private String employeeName;
	
	@OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
 	@JoinColumn(name="empId")
	private Collection<ShiftDetailsEntity> shiftDetails;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="empId")
	private Integer employeeId;
	
	public EmployeeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeEntity(String employeeName, Collection<ShiftDetailsEntity> shiftDetails, Integer employeeId) {
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
	public Collection<ShiftDetailsEntity> getShiftDetails() {
		return shiftDetails;
	}
	public void setShiftDetails(Collection<ShiftDetailsEntity> shiftDetails) {
		this.shiftDetails = shiftDetails;
	}
	public Integer getEmployeeId() {
		// TODO Auto-generated method stub
		return this.employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	
}
