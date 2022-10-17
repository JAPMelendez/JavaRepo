package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employe;
import com.example.demo.service.EmployeService;

/**
 * @author Juan Agustin
 *
 */
@RestController
@RequestMapping("/api/employe")
public class EmployeController {
	
	private EmployeService employeService;

	public EmployeController(EmployeService employeService) {
		super();
		this.employeService = employeService;
	}
	
	//Build crear empleado API REST
	@PostMapping()
	public ResponseEntity<Employe> saveEmploye(@RequestBody  Employe employe){
		return new ResponseEntity<Employe>(employeService.saveEmploye(employe), HttpStatus.CREATED); 
	}
	
	//Build get all employees REST API
	@GetMapping
	public List<Employe> getAllEmployes(){
		return employeService.getAllEmploye();
	}
	
	//Build get employe by Id REST API
	// http://localhost:8080/api/employe/id
	@GetMapping("{id}")
	public ResponseEntity<Employe> getEmployeById(@PathVariable("id") long employeId){
		return new ResponseEntity<Employe>(employeService.getEmployeById(employeId), HttpStatus.OK);
	}
	
	//Build UPDATE employe by Id REST API
	// http://localhost:8080/api/employe/id
	@PutMapping("{id}")
	public ResponseEntity<Employe> updateEmploye(@PathVariable("id") long id, @RequestBody Employe employe){
		return new ResponseEntity<Employe>(employeService.updateEmploye(employe, id), HttpStatus.OK);
		
	}
	
	//Build delete employee REST API
	// http://localhost:8080/api/employe/id
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmploye(@PathVariable("id") long id){
		//Delete employe from db
		employeService.delteEmploye(id);
		return new ResponseEntity<String>("Employe deleted successfully!.", HttpStatus.OK);
	}
}
