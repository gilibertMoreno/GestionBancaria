package com.banco.redsuelva.form.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banco.redsuelva.form.app.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

	Optional<Person> findByIdentification(String identification);

}
