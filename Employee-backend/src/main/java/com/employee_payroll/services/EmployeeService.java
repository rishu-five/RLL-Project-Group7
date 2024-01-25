package com.employee_payroll.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee_payroll.DTO.CredentialsDTO;
import com.employee_payroll.entities.Credentials;
import com.employee_payroll.entities.Employee;
import com.employee_payroll.repositories.CredentialsRepo;
import com.employee_payroll.repositories.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepo empRepo;
	
	public List<Employee>  getAllEmployees(){
		return empRepo.findAll();
	}
	
	public Employee getEmployeeId(int id) {
		return empRepo.findById(id).get();
	}
 	
	public void updateEmployee(int id, Employee employee) {
		Optional<Employee> details = empRepo.findById(id);
		if(details.isPresent()) {
			Employee newEmp =  details.get();
			newEmp.setName(employee.getName());
			newEmp.setMail_id(employee.getMail_id());
			newEmp.setGender(employee.getGender());
			newEmp.setRole(employee.getRole());
			newEmp.setCategory(employee.getCategory());
			empRepo.save(newEmp);
			System.out.println("Updated");
		}else {
			System.out.println("Update Not occured");
		}
	}
	
	
	public void insertEmployee(Employee employee) {
		empRepo.save(employee);
		System.out.println("Inserted Employeee");
	}
	
	public void deleteEmployee(int id) {
		empRepo.deleteById(id);
	}

	 

	    @Autowired
	    private CredentialsRepo credentialsRepo; 

	 

	    public void changePassword(int employeeId, CredentialsDTO credentialsDTO) {
	        Optional<Employee> employeeOptional = empRepo.findById(employeeId);
	        if (employeeOptional.isPresent()) {
	            Employee employee = employeeOptional.get();
	            Credentials credentials = credentialsRepo.findByEmployeeId(employeeId)
	                    .orElseThrow(() -> new RuntimeException("Credentials not found for employeeId: " + employeeId));

	            // Update the password
	            credentials.setPassword(credentialsDTO.getPassword());
	            credentialsRepo.save(credentials);
	        } else {
	            throw new RuntimeException("Employee not found with id: " + employeeId);
	        }
	    }
	    
	    public String getPasswordByEmployeeId(int employeeId) {
	        Credentials credentials = credentialsRepo.findByEmployeeId(employeeId)
	                .orElseThrow(() -> new RuntimeException("Credentials not found for employeeId: " + employeeId));
	        return credentials.getPassword();
	    }
	
}
