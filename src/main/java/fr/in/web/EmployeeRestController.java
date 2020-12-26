package fr.in.web;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import fr.in.entities.Employee;
import fr.in.services.EmployeeService;

/**
 * @author namik
 * 
 * 
 */
@CrossOrigin
@RestController
public class EmployeeRestController {
 
	@Autowired
  private EmployeeService employeeService;
	@GetMapping ("/employees")
	public ArrayList<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@PostMapping(path = "/employees", consumes = "application/json", produces = "application/json")
	public ArrayList<Employee> saveEmployees(@RequestBody ArrayList<Employee> employees){
		return employeeService.addEmployee(employees);
	}
	@DeleteMapping (path = "/employees", consumes = "application/json")
	public Boolean deleteEmployees(@RequestBody Employee employee){
		return employeeService.deleteEmployee(employee);
	}
}
