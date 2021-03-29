package com.banco.redsuelva.form.app.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.redsuelva.form.app.entities.Bank;
import com.banco.redsuelva.form.app.repository.BankRepository;
import com.banco.redsuelva.form.app.service.BankServices;

@Service
public class BankServicesImpl implements BankServices {
	
	@Autowired
	private BankRepository bankRepository;

	@Override
	public Bank create(Bank bank) {
		// TODO Auto-generated method stub
		Optional<Bank> temporal=bankRepository.findByNit(bank.getNit());
		if(temporal.isEmpty()) {
			bank.setRegistrationDate(LocalDateTime.now());
			return bankRepository.save(bank);
		}else {
			return null;
		}
	}

	@Override
	public List<Bank> getAllBank() {
		// TODO Auto-generated method stub
		return bankRepository.findAll();
	}

	@Override
	public boolean delete(Bank bank) {
		// TODO Auto-generated method stub
		Optional<Bank> temporal=bankRepository.findById(bank.getIdBank());
		if(temporal.isEmpty()) {
			return false;
		}else {
			bankRepository.delete(bank);
			return true;
		}
		
		
	}

	@Override
	public Optional<Bank> findByID(Long id) {
		// TODO Auto-generated method stub
		return bankRepository.findById(id);
	}

	@Override
	public Bank update(Bank bank) {
		// TODO Auto-generated method stub
		Optional<Bank>temporal=bankRepository.findById(bank.getIdBank());
		
		if(temporal.isEmpty()) {
			return null;
		}else {
			bank.setRegistrationDate(temporal.get().getRegistrationDate());
		return bankRepository.save(bank);
		}
	}
	
	

}
