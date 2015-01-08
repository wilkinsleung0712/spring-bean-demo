package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee implements Serializable{
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="empId",unique=true,nullable=false)
	private int empId;
	@Column(name="fname",length=20,nullable=false)
	private String fname;
	@Column(name="lname",length=20,nullable=false)
	private String lname;
	
	@OneToMany
	@ElementCollection(fetch=FetchType.EAGER)
	private List<Department> listOfDepts;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public List<Department> getListOfDepts() {
		return listOfDepts;
	}

	public void setListOfDepts(List<Department> listOfDepts) {
		this.listOfDepts = listOfDepts;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
