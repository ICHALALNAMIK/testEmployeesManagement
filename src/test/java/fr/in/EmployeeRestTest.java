package fr.in;

import static org.assertj.core.api.Assertions.*;
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
	 * test saved list of employee without doubling
	 */
	@Test
	 public void testsavedListOfEmployeeWithoutDoubling() {
		  ArrayList<Employee> employees = new ArrayList<Employee>();
		  employees.add(new Employee(1,"Namik","ICHALAL",31,32));
		  employees.add(new Employee( 2,"Sabrina","CHAOUI",27, 31));
		  employees.add(new Employee(3,"Karine","DUBOIS", 31, 31));
		  employees.add(new Employee(3,"Marc","DELBERG", 31, 31));
		  ArrayList<Employee> savedEmployeeList= employeeService.addEmployee(employees);
	    assertThat(savedEmployeeList).isNotNull();
	    assertEquals(savedEmployeeList.size(), 4);
	    assertEquals(employeeService.getEmployeesById(1), new Employee(1,"Namik","ICHALAL",31,32));
	  }


	  /**
	 * Test saved list of employee with doubling..
	 * 8 Employees with 4 doubling..
	 */ 
	  @Test
	 public void testsavedListOfEmployeeWithDoubling() {
		  ArrayList<Employee> employees = new ArrayList<Employee>();
		  employees.add(new Employee(1,"Namik","ICHALAL",31,32));
		  employees.add(new Employee(1,"Namik","ICHALAL",31,32));
		  employees.add(new Employee( 2,"Sabrina","CHAOUI",27, 31));
		  employees.add(new Employee( 2,"Sabrina","CHAOUI",27, 31));
		  employees.add(new Employee( 2,"Sabrina","CHAOUI",27, 31));
		  employees.add(new Employee(3,"Karine","DUBOIS", 31, 31));
		  employees.add(new Employee(3,"Marc","DELBERG", 31, 31));
		  employees.add(new Employee(4,"Marc","DELBERG", 31, 31));
		  ArrayList<Employee> savedEmployeeList= employeeService.addEmployee(employees);
	    assertThat(savedEmployeeList).isNotNull();
	    assertEquals(savedEmployeeList.size(), 4);
	    assertEquals(employeeService.getEmployeesById(1), new Employee(1,"Namik","ICHALAL",31,32));
	  }

}
