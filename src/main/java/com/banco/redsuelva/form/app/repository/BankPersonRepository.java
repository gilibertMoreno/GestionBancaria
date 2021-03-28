package com.banco.redsuelva.form.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banco.redsuelva.form.app.entities.BankPerson;

public interface BankPersonRepository extends JpaRepository<BankPerson, Long>{

}
