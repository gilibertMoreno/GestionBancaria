package com.banco.redsuelva.form.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.redsuelva.form.app.entities.Person;
import com.banco.redsuelva.form.app.repository.PersonRepository;
import com.banco.redsuelva.form.app.service.PersonServices;

@Service
public class PersonServicesImpl implements PersonServices{
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public Person create(Person person) {
		// TODO Auto-generated method stub
		Optional<Person> temporal=personRepository.findByIdentification(person.getIdentification());
		if(temporal.isEmpty()) {
			return personRepository.save(person);
		}else {
			return null;
		}
		
	}

	@Override
	public List<Person> getAllPerson() {
		// TODO Auto-generated method stub
		return personRepository.findAll();
	}

	@Override
	public boolean delete(Person person) {
		// TODO Auto-generated method stub
		Optional<Person>temporal=personRepository.findById(person.getIdPerson());
		if(temporal.isEmpty()) {
		 return false;
		}else {
			personRepository.delete(person);
			return true;
		}
		
		
	}

	@Override
	public Optional<Person> findByID(Long id) {
		// TODO Auto-generated method stub
		return personRepository.findById(id);
	}

	@Override
	public Person update(Person person) {
		// TODO Auto-generated method stub
		Optional<Person>temporal=personRepository.findById(person.getIdPerson());
		if(temporal.isEmpty()) {
			return null;
		}else {
			return personRepository.save(person);
		}
		
	}

}
