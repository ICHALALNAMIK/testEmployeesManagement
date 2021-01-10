package fr.in.web;

import java.util.ArrayList;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping("/employees")
	public ArrayList<Employee> getEmployeesDeduplicateByCriteria(@RequestParam(value = "param") String param) {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		if (param.equals("")) {
			employees = employeeService.getAllEmployees();
		} else {
			employees = employeeService.getEmployeesDeduplicateByCriteria(param);
		}
		return employees;
	}

	@PostMapping(path = "/employees", consumes = "application/json", produces = "application/json")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}

	@PutMapping(path = "/employees/{id}", consumes = "application/json", produces = "application/json")
	public Optional<Employee> updateEmployee(@PathVariable String id, @RequestBody Employee employee) {
		return employeeService.updateEmployee(employee, id);
	}

	@DeleteMapping("/employees/{id}")
	public Boolean deleteEmployees(@PathVariable(value = "id") int id) {
		return employeeService.deleteEmployee(id);
	}

}
