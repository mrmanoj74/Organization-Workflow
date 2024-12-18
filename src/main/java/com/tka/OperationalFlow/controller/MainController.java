package com.tka.OperationalFlow.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.OperationalFlow.entity.Country;
import com.tka.OperationalFlow.entity.Employee;
import com.tka.OperationalFlow.service.MainService;

@RestController
@RequestMapping("api")
public class MainController {
	
	@Autowired
	MainService service;

	@PostMapping("addcountry")
	public ResponseEntity<String> addCountry(@RequestBody Country c) {
		String msg= service.addCountry(c);
		return ResponseEntity.ok(msg);
	}
	
	@PutMapping("updatecountry/{id}")
	public ResponseEntity<String> updateCountry(@RequestBody Country c, @PathVariable int id) {
		String str = service.updateCountry(c, id);
		return ResponseEntity.ok(str);
	}
	
	@DeleteMapping("deletecountry/{cid}")
	public ResponseEntity<String> deleteCountry(@PathVariable int cid) {
		String str = service.deleteCountry(cid);
		return ResponseEntity.ok(str);
	}
	
	@GetMapping("getallcountry")
	public ResponseEntity<List<Country>> getAllCountry() {
		List<Country> list = service.getAllCountry();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("getcountryById/{cid}")
	public ResponseEntity<Country> getparticularCountryById(@PathVariable int cid) {
		Country country = service.getparticularCountryById(cid);
//		return ResponseEntity.ok(country); 
		return ResponseEntity.status(201).body(country);
	}
	
	@PostMapping("addEmp")
	public ResponseEntity<String> addEmployee(@RequestBody Employee emp) {
		String str = service.addEmployee(emp);
		return ResponseEntity.ok(str);
	}
	
	@PutMapping("updateEmp/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable int id, @RequestBody Employee emp) {
		String msg = service.updateEmployee(id, emp);
		return ResponseEntity.ok(msg);
	}
	
	@DeleteMapping("deleteemp/{id}") 
	public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
		String msg = service.deleteEmployee(id);
		return ResponseEntity.ok(msg);
	}
	
	@GetMapping("getAllEmp")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> list = service.getAllEmployee();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("getparticularEmpById/{id}")
	public ResponseEntity <Employee> getParticularById(@PathVariable int id) {
		Employee emp = service.getParticularById(id);
		return ResponseEntity.ok(emp);
	}
	
	@GetMapping("login")
	public Map login(@RequestBody Employee e) {
		Map map = service.login(e);
		return map;
	}
	
	@GetMapping("salaryRange/{startSal}/{endSal}")
	public ResponseEntity<List<Employee>> salaryRange(@PathVariable double startSal,@PathVariable double endSal){
		List<Employee> list=service.salaryRange(startSal,endSal);
		return ResponseEntity.ok(list);
	}
}
