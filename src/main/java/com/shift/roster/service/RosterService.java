package com.shift.roster.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shift.roster.business.bean.Employee;
import com.shift.roster.business.bean.ShiftDetails;
import com.shift.roster.entity.EmployeeEntity;
import com.shift.roster.entity.ShiftDetailsEntity;
import com.shift.roster.repository.RosterRepository;
@Service
public class RosterService {

	
	private EmployeeEntity empEntity;
	@Autowired
	private RosterRepository rosterRepo;
	public Integer addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		empEntity = new EmployeeEntity();
		BeanUtils.copyProperties(emp, empEntity);
		List<ShiftDetails> shftDt=(List<ShiftDetails>) emp.getShiftDetails();
		List<ShiftDetailsEntity> shftEntList= new ArrayList<ShiftDetailsEntity> ();
		shftDt.forEach(shft->{
			ShiftDetailsEntity shftEn= new ShiftDetailsEntity();
			BeanUtils.copyProperties(shft, shftEn);
			shftEntList.add(shftEn);
		});
		empEntity.setShiftDetails(shftEntList);
		
		EmployeeEntity emp1=rosterRepo.save(empEntity);
		return emp1.getEmployeeId();
	}

	public Collection<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		Collection<EmployeeEntity> empEntList = rosterRepo.findAll();
		List<Employee> empList = new ArrayList<Employee>();
		empEntList.forEach(emp->{
			Employee empDt = new Employee();
			BeanUtils.copyProperties(emp, empDt);
			
			empList.add(empDt);
		});
		return empList;
	}

	public Employee updateEmployee(Employee emp) {
			
		Employee employee2 =null;
		//Implementation of the DAO method will be provided  by the run time proxy
		EmployeeEntity employeeEntity= rosterRepo.findOne(emp.getEmployeeId());
		List<ShiftDetailsEntity> shftDtLst = (List<ShiftDetailsEntity>) employeeEntity.getShiftDetails();
		if(employeeEntity!=null){
			List<ShiftDetails> shftDt = new ArrayList<ShiftDetails>();
			shftDtLst.forEach(shtDtEnt->{
				ShiftDetails shft = new ShiftDetails();
				BeanUtils.copyProperties(shtDtEnt, shft);
				shftDt.add(shft);
			});
			//update operation
			emp.setShiftDetails(shftDt);
			BeanUtils.copyProperties(emp, employeeEntity);
			//Implementation of the DAO method will be provided  by the run time proxy
			rosterRepo.save(employeeEntity);
			
			//copying the properties back to EmployeeDTO Object 
			employee2= new Employee();
			BeanUtils.copyProperties(employeeEntity, employee2);
		}
		return employee2;
		
	}

	public Employee deleteEmployee(int empId) {
		Employee employee =null;
		//Implementation of the DAO method will be provided  by the run time proxy
		EmployeeEntity employeeEntity= rosterRepo.findOne(empId);
		
		if(employeeEntity!=null){
			//Implementation of the DAO method will be provided  by the run time proxy
			rosterRepo.delete(employeeEntity);
			
			employee= new Employee();
			BeanUtils.copyProperties(employeeEntity, employee);
		}
		return employee;
	}

	public Employee getEmployeeById(int empId) {
		Employee employee =null;
		
		//Implementation of the DAO method will be provided  by the run time proxy
		EmployeeEntity employeeEntity= rosterRepo.findOne(empId);
		
		if(employeeEntity!=null){
			employee= new Employee();
			BeanUtils.copyProperties(employeeEntity, employee);
		}
		return employee;
	}


}
