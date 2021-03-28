package com.banco.redsuelva.form.app.service;

import java.util.List;
import java.util.Optional;

import com.banco.redsuelva.form.app.entities.Bank;


public interface BankServices {
	
	public Bank create(Bank bank);
	public List<Bank> getAllBank();
	public boolean delete(Bank bank);
	public Optional<Bank> findByID(Long id);
	public Bank update(Bank bank);

}
