package com.banco.redsuelva.form.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banco.redsuelva.form.app.entities.Bank;

public interface BankRepository extends JpaRepository<Bank, Long>{

	Optional<Bank> findByNit(String nit);

}
