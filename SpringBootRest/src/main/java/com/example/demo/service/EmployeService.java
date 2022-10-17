package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employe;

public interface EmployeService {
	Employe saveEmploye(Employe employe);
	List<Employe> getAllEmploye();
	Employe getEmployeById(long id);
	Employe updateEmploye(Employe employe, long id);
	void delteEmploye(long id);
}


