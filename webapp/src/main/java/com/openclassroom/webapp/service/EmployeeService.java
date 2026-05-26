package com.openclassroom.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.webapp.model.Employee;
import com.openclassroom.webapp.repository.EmployeeProxy;

import lombok.Data;

@Data
@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeProxy employeeProxy;
	
	public Employee getEmployee(final int id) {
		
		return employeeProxy.getEmployee(id);
	}
	
	public Iterable<Employee> getEmployees(){
		return employeeProxy.getEmployees();
	}
	
	public void deleteEmployee(final int id) {
		employeeProxy.deleteEmployee(id);
	}
	
	public Employee savedEmployee(Employee employee) {
		Employee savedEmployee = null;
		employee.setLastName(employee.getLastName().toUpperCase());
		
		if(employee.getId() == null) {
			savedEmployee = employeeProxy.createEmployee(employee);
			
		}
		//else mettre à jour
		
		return savedEmployee;
	}
}
