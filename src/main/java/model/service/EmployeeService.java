package model.service;

import model.Employee;

public interface EmployeeService {
	public void saveEmployee(Employee emp);

	public Employee getEmployee(int empId);

	public void updateEmployee(Employee employee, int empId);

	public void deleteEmployee(int empId);

}
