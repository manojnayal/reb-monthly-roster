package com.shift.roster.presentation;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shift.roster.business.bean.Employee;
import com.shift.roster.service.RosterService;

@RestController
public class RosterController {

	@Autowired
	private RosterService rosterService;
	
	@RequestMapping(value="roster/addEmp",
			method=RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<String> addEmployee(@RequestBody Employee emp) {
		Integer id = rosterService.addEmployee(emp);
		return new ResponseEntity<String>("Employee added successfully with id:"+id,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="roster/getAllEmployee", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Employee>> getAllEmployee(){
		Collection<Employee> listEmp = rosterService.getAllEmployee();
		return new ResponseEntity<Collection<Employee>>(listEmp, HttpStatus.OK);
	}
	
	@RequestMapping(value="roster/updateEmployee", 
			method=RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp){
		Employee updatedEmp = rosterService.updateEmployee(emp);
		if(updatedEmp == null) {
			return new ResponseEntity<Employee>(updatedEmp,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Employee>(updatedEmp, HttpStatus.OK);
	}
	
	@RequestMapping(value="roster/deleteEmployee/{empId}", 
			method=RequestMethod.DELETE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> deleteEmployee(@PathVariable String empId){
		Employee updatedEmp = rosterService.deleteEmployee(Integer.parseInt(empId));
		if(updatedEmp == null) {
			return new ResponseEntity<Employee>(updatedEmp,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Employee>(updatedEmp, HttpStatus.OK);
	}
	
	@RequestMapping(value="roster/getEmployeeById/{empId}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("empId")  String empId){
		Employee emp = rosterService.getEmployeeById(Integer.parseInt(empId));
		if(emp == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
}
