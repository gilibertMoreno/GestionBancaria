package com.banco.redsuelva.form.app.service;

import java.util.List;
import java.util.Optional;

import com.banco.redsuelva.form.app.entities.Person;

public interface PersonServices {
	
	public Person create(Person person);
	public List<Person> getAllPerson();
	public boolean delete(Person person);
	public Optional<Person> findByID(Long id);
	public Person update(Person person);

}
