package fr.in.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import fr.in.entities.Employee;
@ Repository
public interface EmployeeRepository extends MongoRepository<Employee, String>{

Employee getEmployeeById(int id);

}