/**
 * 
 */
package model.dao;

import model.Department;
import model.Employee;

/**
 * @author WEIQIANG LIANG
 *
 */
public interface EmployeeDao {
	public void saveEmployee(Employee emp);

	public Employee getEmployee(int empId);

	public void updateEmployee(Employee employee, int empId);

	public void deleteEmployee(int empId);

	public Department getEmployeeDept(int empId, int deptId);

	public void saveEmployeeDept(int empId, Department dept);

	public void updateEmployeeDept(int empId, Department dept, int deptId);

	public void deleteEmployeeDept(int empId, int deptId);
}
