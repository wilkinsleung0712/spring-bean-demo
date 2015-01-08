package model.service;

import model.Employee;
import model.dao.EmployeeDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao dao;
	public void saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		dao.saveEmployee(emp);
	}

	public Employee getEmployee(int empId) {
		// TODO Auto-generated method stub
		return dao.getEmployee(empId);
	}

	public void updateEmployee(Employee employee, int empId) {
		// TODO Auto-generated method stub
		dao.updateEmployee(employee, empId);
	}

	public void deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		dao.deleteEmployee(empId);
	}

}
