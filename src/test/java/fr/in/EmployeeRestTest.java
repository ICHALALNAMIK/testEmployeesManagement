package fr.in;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;



import fr.in.entities.Employee;
import fr.in.repositories.EmployeeRepository;
import fr.in.services.EmployeeService;

/**
 * @author namik
 *
 */
@SpringBootTest
public class EmployeeRestTest {
	 @Autowired (required = true)
	 public EmployeeService employeeService;
	 @Autowired (required = true)
	 public EmployeeRepository employeeRepo;

	 
	  /**
	 * test saved list of employee 
	 */
	@Test
	 public void testsavedListOfEmployees() {
		  ArrayList<Employee> employees = new ArrayList<Employee>();
		  employees.add(new Employee(1,"Namik","ICHALAL",31,32));
		  employees.add(new Employee( 2,"Sabrina","CHAOUI",27, 31));
		  employees.add(new Employee(3,"Karine","DUBOIS", 31, 31));
		  employees.add(new Employee(4,"Marc","DELBERG", 31, 31));
		  employees.add(new Employee(5,"Frédéric","LEROI",  32, 43));
		  employees.add(new Employee(6,"Salim","BEN MOUSA", 23, 31));
		  employees.add(new Employee(7,"Antony","OUDOU", 32, 32));
		  employees.add(new Employee(8,"Kamel","ICHALAL", 57, 98));
		  employees.add(new Employee(9,"Sabrina","AIT ADBELLAH", 27, 43));
	 
	employees.forEach(e->{
	employeeService.addEmployee(e);		
	});
	
	    assertEquals(employeeService.getEmployeesById(1), new Employee(1,"Namik","ICHALAL",31,32));
	    assertEquals(employeeService.getAllEmployees().size(), 9);
	   
	  }

	
	
 /** Test
 * deduplicate the list of employees by last name
 */
@Test
 public void testDeduplicateListByName() {
	 ArrayList< Employee> employees = employeeService.getEmployeesDeduplicateByCriteria("lastName");
	 assertEquals(employees.size(), 8);
	 assertNotNull(employees);
	
	 
 }
 
 /** Test
 * deduplicate the list of employees by salary
 */
@Test
 public void testDeduplicateListSalary() {
	 ArrayList< Employee> employees = employeeService.getEmployeesDeduplicateByCriteria("salary");
	 assertEquals(employees.size(), 4);
	 assertNotNull(employees);
	
	 
 }
	   

}
