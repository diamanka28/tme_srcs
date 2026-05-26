package com.openclassroom.webapp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.openclassroom.webapp.CustomProperties;
import com.openclassroom.webapp.model.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EmployeeProxy{
	
	@Autowired
	CustomProperties props;
	
	/**
	 * Get all employees
	 */
	
	public Iterable<Employee> getEmployees(){
		String baseApiUrl = props.getApiUrl();
		String getEmployeesUrl= baseApiUrl + "/employees";
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Iterable<Employee>> response = restTemplate.exchange(getEmployeesUrl, 
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<Iterable<Employee>>() {}
		); 
		/**debug("Get employees cal" + response.getStatusCode().toString());
		*/
		return response.getBody();
	}
	
	public Employee getEmployee(int id) {
		String baseApiUrl = props.getApiUrl();
		String getEmployeesUrl= baseApiUrl + "/employees/" + id;
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Employee> response  = restTemplate.exchange(
				getEmployeesUrl,
				HttpMethod.GET,
				null,
				Employee.class
			);
		
		return response.getBody();
	}
	
	public void deleteEmployee(int id) {
		String baseApiUrl = props.getApiUrl();
		String getEmployeesUrl= baseApiUrl + "/employees/" + id;
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.exchange(getEmployeesUrl, HttpMethod.DELETE, null, void.class);
	}
	
	public Employee createEmployee(Employee e) {
		String baseUrl = props.getApiUrl();
		String createEmployeeUrl = baseUrl + "/employee";
		
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Employee> resquest = new HttpEntity<Employee>(e);
		ResponseEntity<Employee> response = restTemplate.exchange(
				createEmployeeUrl,
				HttpMethod.POST,
				resquest,
				Employee.class
		);
		
		return response.getBody();
				
	}

}
