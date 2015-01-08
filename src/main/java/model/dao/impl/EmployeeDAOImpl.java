package model.dao.impl;
import java.util.ArrayList;
import java.util.List;

import model.Department;
import model.Employee;
import model.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("employeeDao")
public class EmployeeDAOImpl implements EmployeeDao{

	//logging function
	private static final Logger LOG=LoggerFactory.getLogger(EmployeeDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Autowired
	public EmployeeDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public Employee getEmployee(int empId) {
		// TODO Auto-generated method stub
		LOG.info("In Dao, request to fetch employee details for employee Id:{}",empId);
		Employee emp = (Employee) sessionFactory.getCurrentSession().get(Employee.class, empId);
		List<Department> depts = new ArrayList<Department>();
		int size = emp.getListOfDepts().size();
		for(int i=0;i<size;i++){
			depts.add(emp.getListOfDepts().get(i));
		}
		emp.setListOfDepts(depts);
		LOG.info("Employee Details retrieved successfully from DB");
		return emp;
	}

	public void updateEmployee(Employee employee, int empId) {
		// TODO Auto-generated method stub
		LOG.info("In Dao, reequest to update employee details Id: {}",empId);
		Employee emp = (Employee) sessionFactory.getCurrentSession().get(Employee.class, empId);
		emp.setFname(employee.getFname());
		emp.setLname(employee.getLname());
		LOG.debug("Employee Details updated successfully from DB");
	}

	public void deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		LOG.info("In Dao, reequest to delete employee details Id: {}",empId);
		Session session = sessionFactory.getCurrentSession();
		Employee emp = (Employee) session.get(Employee.class, empId);
		session.delete(emp);
		LOG.debug("Employee Details deleted successfully from DB");
	}

	public Department getEmployeeDept(int empId, int deptId) {
		// TODO Auto-generated method stub
		LOG.info("In Dao, Request to fetch Dept details deptId:{} for employee Id:{}",deptId,empId);
		Employee emp = (Employee) sessionFactory.getCurrentSession().get(Employee.class, empId);
		List<Department> depts = emp.getListOfDepts();
		Department dept = depts.get(deptId-1);
		LOG.debug("Employee Details retrieved successfully from DB");
		return dept;
	}

	public void saveEmployeeDept(int empId, Department dept) {
		// TODO Auto-generated method stub
		LOG.info("In Dao, Request to save new Department de");
		Session session = sessionFactory.getCurrentSession();
		Employee emp = (Employee)session.get(Employee.class, empId);
		List<Department> depts = emp.getListOfDepts();
		depts.add(dept);
		session.save(dept);
		LOG.info("Deparment Details successfully added into DB");
	}

	public void updateEmployeeDept(int empId, Department dept, int deptId) {
		// TODO Auto-generated method stub
		LOG.info("In Dao, Request to update Dept details deptId:{} for employee Id:{}",deptId,empId);
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Employee emp=(Employee) session.get(Employee.class, empId);
		session.save(emp);
		emp.getListOfDepts().set(deptId-1, dept);
		LOG.info("Department Details updated successfully in DB");
		
	}

	public void deleteEmployeeDept(int empId, int deptId) {
		// TODO Auto-generated method stub
		LOG.info("In Dao, Request to delete Dept details deptId:{} for employee Id:{}",deptId,empId);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Employee emp = (Employee) session.get(Employee.class, empId);
		session.delete(emp.getListOfDepts().remove(deptId-1));
		LOG.info("Department Details deleted successfully from DB");
	}

	public void saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		LOG.info("In Dao, request to add new employee details into the database empName:{}",emp.getFname());
		sessionFactory.getCurrentSession().save(emp);
		LOG.info("Employee Details saved successfully in DB");
	}



}
