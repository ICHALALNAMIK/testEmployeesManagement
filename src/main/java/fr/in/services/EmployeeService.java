package fr.in.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.in.entities.Employee;
import fr.in.repositories.EmployeeRepository;

/**
 * @author namik
 *
 */
@Service
public class EmployeeService {
	
	/**
	 * Instantiation:EmployeeRepository
	 */
	@Autowired
	EmployeeRepository employeeRepository;
	
	/**
	 * @return ArrayList of the Employees 
	 */
	public ArrayList<Employee> getAllEmployees() {
		return (ArrayList<Employee>) employeeRepository.findAll();
		
	}
	
	/**
	 * GET employee by 
	 * @param id
	 * @return Optional<Employee> 
	 */
	public Employee getEmployeesById(int id) {
		return  employeeRepository.getEmployeeById(id);
		
	}
	
	/**
	 * Add List of employees
	 * @param employees
	 * @return list of employees without doubling
	 */
	public ArrayList<Employee> addEmployee(ArrayList<Employee>  employees) {
		System.out.println("employées:");
		employees.forEach(System.out::println);
		for (Employee employee : employees) {
			employeeRepository.save(employee);
		}
		return (ArrayList<Employee>) employeeRepository.findAll();
	}

	/**
	 *  DELETE mployee
	 * @param employee
	 * @return Boolean
	 */
	public Boolean deleteEmployee(Employee employee) {
		boolean isDeleted=true;
		try {
			employeeRepository.deleteById(String.valueOf(employee.getId()));
		} catch (Exception e) {
			isDeleted=false;
		} 
		return isDeleted;
	}
	
	
	
}
