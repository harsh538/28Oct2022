package com.vele.service1;

import java.util.List;

import com.vele.businessbean.Employeebean;

public interface EmployeeService {

	public Integer addEmployee(Employeebean employeebean) throws Exception;

	public Employeebean getEmployeeById(int id) throws Exception;

	public List<Employeebean> getEmployeeDetails() throws Exception;

}
