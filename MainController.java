package com.jbk.SimpleProjectRestApl.Controller;
import com.jbk.SimpleProjectRestApl.entity.Country;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.SimpleProjectRestApl.entity.Country;
import com.jbk.SimpleProjectRestApl.entity.Employee;
import com.jbk.SimpleProjectRestApl.Service.MainService;
import 	com.jbk.SimpleProjectRestApl.Dao.MainDao;
@RestController
@RequestMapping("/api")
public class MainController {
	
	@Autowired
	MainService service;
	//API 1
	@PostMapping("/addcountry")
	public String addCountry(@RequestBody Country c) {
		String msg= service.addCountry(c);
		return msg;
	}
	
	//API 2
	@PutMapping("/updateCountry")
	public String updateCountry(@RequestBody Country c) {
		 String msg= service.updateCountry(c);
		 return msg;		
	}
	
	
	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody Employee e) {
		String msg= service.addEmployee(e);
		return msg;
	}
	
	@PutMapping("/updateEmployee")
	public String updateEmployee(@RequestBody Employee e) {
		 String msg= service.updateEmployee(e);
		 return msg;		
	}
	
	@GetMapping("/GetAllCounrty")
	public List<Country> getAllRecord(){
		
		List<Country> list= service.getAllRecord();
		return list;
		
	}
	
	@DeleteMapping("/deleteDataEmp")
	public String deleteData(@RequestBody Employee e) {
		String msg= service.DeleteData(e);
		return msg;
	}
	
	
	@DeleteMapping("/deleteDataCon")
	public String deleteData(@RequestBody Country c) {
		String msg= service.DeleteData(c);
		return msg;
	}
	
	@GetMapping("/getparticulardata")
	public Country getParticularRecordById(@RequestBody Country c) {
		
		Country c3= service.getParticularRecord(c);
		return c3;		
	}
	
	@GetMapping("/getparticulardataEmp")
	public Employee getParticularRecordById(@RequestBody Employee Emp) {
		
		Employee e4= service.getParticularRecord(Emp);
		return e4;		
	}
	
	@GetMapping ("/getAllDataEmployee")
	public List<Employee> getAllrecordEmp(){
		 List<Employee> list=service.getAllRecordEmp();
	 return list;
	}

}