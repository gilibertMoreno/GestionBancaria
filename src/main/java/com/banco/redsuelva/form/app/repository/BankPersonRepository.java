package com.banco.redsuelva.form.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banco.redsuelva.form.app.entities.Bank;
import com.banco.redsuelva.form.app.entities.BankPerson;
import com.banco.redsuelva.form.app.entities.Person;

public interface BankPersonRepository extends JpaRepository<BankPerson, Long>{

	Optional<BankPerson> findByBankAndPerson(Bank bank, Person person);

}
