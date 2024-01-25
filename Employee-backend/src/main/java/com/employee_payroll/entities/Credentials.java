package com.employee_payroll.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Credentials {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String password;
	
	@OneToOne
	@JoinColumn(name="employee_id", unique=true)
	private Employee employee;

	public int getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	 @Transient
	    private String newPassword;  // New field to store the updated password

	    // ... existing methods

	    public String getNewPassword() {
	        return newPassword;
	    }

	    public void setNewPassword(String newPassword) {
	        this.newPassword = newPassword;
	    }
}
