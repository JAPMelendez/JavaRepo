package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employe;
import com.example.demo.repository.EmployeRepository;
import com.example.demo.service.EmployeService;

@Service
public class EmployeServiceImpl implements EmployeService {

	private EmployeRepository employeRepository;
	
	@Autowired
	public EmployeServiceImpl(EmployeRepository employeRepository) {
		super();
		this.employeRepository = employeRepository;
	}

	@Override
	public Employe saveEmploye(Employe employe) {
		return employeRepository.save(employe);
	}

	@Override
	public List<Employe> getAllEmploye() {
		return employeRepository.findAll();
	}

	@Override
	public Employe getEmployeById(long id) {
//		Optional<Employe> employe = employeRepository.findById(id);
//		if(employe.isPresent()) {
//			return employe.get();
//		}
//		else {
//			throw new ResourceNotFoundException("Employe", "Id", id);
//		}
		
		
		return employeRepository.findById(id).orElseThrow(() -> 
			new ResourceNotFoundException("", "Id", id));
	}

	@Override
	public Employe updateEmploye(Employe employe, long id) {

		// Revisar si ID empleado existe
		Employe existingEmploye = employeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employe", "Id", id));
		
		existingEmploye.setFirstName(employe.getFirstName());
		existingEmploye.setLastName(employe.getLastName());
		existingEmploye.setEmail(employe.getEmail());
		//Guardar empleado existente en BD
		employeRepository.save(existingEmploye);
		return existingEmploye;
	}

	@Override
	public void delteEmploye(long id) {
		//Revisar si existe el empleado
		employeRepository.findById(id).orElseThrow(() -> 
					new ResourceNotFoundException("Employee", "Id", id));
		employeRepository.deleteById(id);
	}

}
