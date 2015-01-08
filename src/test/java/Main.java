import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import model.Employee;
import model.configuration.AppConfig;
import model.service.EmployeeService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        EmployeeService service = (EmployeeService) ctx.getBean("employeeService");
 
        Employee e =new Employee();
        e.setEmpId(1);
        e.setFname("wilkins");
        e.setLname("leung");
        
        service.saveEmployee(e);
        
        System.out.println("details of the employee: "+service.getEmployee(1).getFname()+service.getEmployee(1).getLname());
        /*
        List<Contact> contacts = employeeDao.getEmployee(empId)  
        for (Contact con : contacts) {
            System.out.println("---------------------------------------------------");
            System.out.println(con.toString());            
            Set<Address> addresses = con.getContactAddress();            
            int i=1;
            for (Address a : addresses) {
                System.out.printf("Address %d: %s", i, a.toString());
                System.out.println();                
                i++;
            }
            
        }*/
        ctx.close();
	}

}
