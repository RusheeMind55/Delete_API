package com.jbk.SimpleProjectRestApl.Service;


import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.SimpleProjectRestApl.Dao.MainDao;
import com.jbk.SimpleProjectRestApl.entity.Country;
import com.jbk.SimpleProjectRestApl.entity.Employee;

@Service
public class MainService {
	
	@Autowired
	MainDao dao;

	public String addCountry(Country c) {
		String msg= dao.addCountry(c);
		
		if(Objects.isNull(msg)) {
			msg="Data is not Addedd Succefully..";
		}
		
		return msg;
	}

	public String updateCountry(Country c) {
		String msg= dao.updateCountry(c);
		
		if(Objects.isNull(msg)) {
			msg="Data is Not Updatated...";
		}
		
		return msg;
		
	}

	public String addEmployee(Employee e) {
			String msg= dao.addEmployee(e);
			
			if(Objects.isNull(msg)) {
				msg="Record is not be Added...";
			}
			
		return msg;
	}
	public String updateEmployee(Employee e) {
		String msg= dao.updateEmployee(e);
		
		if(Objects.isNull(msg)) {
			msg="Data is Not Updatated...";
		}
		
		return msg;
	
	}	
	public List<Country> getAllRecord(){
		 List<Country> list= dao.getAllRecord();
		 return list;
	}
	public List<Employee>getAllRecordEmp(){
		List<Employee> list=dao.getAllRecordEmp();
		return list;
	}
	
	public Country getParticularRecord(Country c) {
		Country c2= dao.getParticularRecord(c);
		return c2;
	}
	
	// employee
	public Employee getParticularRecord(Employee Emp) {
		Employee Emp1= dao.getParticularRecord(Emp);
		return Emp1;
	}

public String DeleteData(Employee e) {
		
		String msg= dao.deleteData(e);
		if(Objects.isNull(msg)) {
			msg="data deleted";}
		return msg;
		
	}
public String DeleteData(Country c) {
	
	String msg= dao.deleteData(c);
	return msg;
	
}
}
