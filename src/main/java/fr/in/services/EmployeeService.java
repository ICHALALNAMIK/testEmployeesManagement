package fr.in.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
	 * 
	 * @param id
	 * @return Optional<Employee>
	 */
	public Employee getEmployeesById(int id) {
		return employeeRepository.getEmployeeById(id);

	}

	/**
	 * Add employee
	 * 
	 * @param employee
	 * @return employee
	 */
	public Employee addEmployee(Employee employee) {
		ArrayList<Employee> employees = (ArrayList<Employee>) employeeRepository.findAll();
		if (employees.size() != 0) {
			int index = employees.get(employees.size() - 1).getId();
			employee.setId(index + 1);
		}

		employeeRepository.save(employee);
		return employeeRepository.getEmployeeById(employee.getId());
	}

	/**
	 * DELETE mployee
	 * 
	 * @param employee
	 * @return Boolean
	 */
	public boolean deleteEmployee(int id) {
		boolean isDeleted = true;
		try {
			Employee employee = employeeRepository.getEmployeeById(id);

			employeeRepository.delete(employee);

		} catch (Exception e) {
			isDeleted = false;
		}
		return isDeleted;
	}

	/**
	 * Add employee
	 * 
	 * @param employee
	 * @return employee
	 */
	public Optional<Employee> updateEmployee(Employee employee, String id) {

		employeeRepository.save(employee);
		return employeeRepository.findById(id);
	}

	/**
	 * get Employees Deduplicate By Criteria Add employee
	 * 
	 * @param employee
	 * @return employee
	 */
	public ArrayList<Employee> getEmployeesDeduplicateByCriteria(String param) {
		ArrayList<Employee> employees = (ArrayList<Employee>) employeeRepository.findAll();
		ArrayList<Employee> employeesDeduplicate = new ArrayList<Employee>();
		HashSet<Integer> paramsInt = new HashSet<Integer>();
		HashSet<String> paramsStr = new HashSet<String>();
		int index = 0;
		switch (param) {
		case "salary":
			for (Employee employee : employees) {
				index = paramsInt.size();
				paramsInt.add(employee.getSalary());
				if (paramsInt.size() > index) {
					employeesDeduplicate.add(employee);
				}
			}
			break;
		case "age":
			for (Employee employee : employees) {
				index = paramsInt.size();
				paramsInt.add(employee.getAge());
				if (paramsInt.size() > index) {
					employeesDeduplicate.add(employee);
				}
			}
			break;
		case "fname":
			for (Employee employee : employees) {
				index = paramsStr.size();
				paramsStr.add(employee.getFName());
				if (paramsStr.size() > index) {
					employeesDeduplicate.add(employee);
				}
			}
			break;
		case "lastName":
			for (Employee employee : employees) {
				index = paramsStr.size();
				paramsStr.add(employee.getLastName());
				if (paramsStr.size() > index) {
					employeesDeduplicate.add(employee);
				}
			}
			break;

		}
		return employeesDeduplicate;
	}

}
