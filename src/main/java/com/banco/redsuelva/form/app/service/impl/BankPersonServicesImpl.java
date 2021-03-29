package com.banco.redsuelva.form.app.service.impl;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.redsuelva.form.app.dto.CreateBankPersonDto;
import com.banco.redsuelva.form.app.dto.ListBankPersonDto;
import com.banco.redsuelva.form.app.entities.Bank;
import com.banco.redsuelva.form.app.entities.BankPerson;
import com.banco.redsuelva.form.app.entities.Person;
import com.banco.redsuelva.form.app.repository.BankPersonRepository;
import com.banco.redsuelva.form.app.repository.BankRepository;
import com.banco.redsuelva.form.app.repository.PersonRepository;
import com.banco.redsuelva.form.app.service.BankPersonServices;

@Service
public class BankPersonServicesImpl implements BankPersonServices{
	
	@Autowired
	private BankPersonRepository bankPersonRepositori;
	
	@Autowired
	private BankRepository bankRepository;
	
	@Autowired
	private PersonRepository personRepository;
	

	@Override
	public ListBankPersonDto createAccountBank(CreateBankPersonDto createBankPerson) {
		// TODO Auto-generated method stub
		Optional<Bank> bank=bankRepository.findById(createBankPerson.getIdBank());
		Optional<Person> person =personRepository.findById(createBankPerson.getIdPerson());
		
		LocalDateTime createDate=LocalDateTime.now();
		
		if(!bank.isEmpty()&&!person.isEmpty()) {
			Optional<BankPerson> bankPerson=bankPersonRepositori.findByBankAndPerson(bank.get(),person.get());
			if(bankPerson.isPresent()) {
				return null;
			}
			
			BankPerson temporal=new BankPerson();
			temporal.setAcount(createBankPerson.getIdBank().toString()+createBankPerson.getIdPerson().toString());
			temporal.setCreateDate(createDate);
			temporal.setBank(bank.get());
			temporal.setPerson(person.get());
			
			BankPerson p=bankPersonRepositori.save(temporal);
			
			ListBankPersonDto listBankPerson=new ListBankPersonDto();
			listBankPerson.setId(p.getId());
			listBankPerson.setAccount(p.getAcount());
			listBankPerson.setPersonIdentification(p.getPerson().getIdentification());
			listBankPerson.setPersonName(p.getPerson().getNames());
			listBankPerson.setPersonLastName(p.getPerson().getLasName());
			listBankPerson.setBankName(p.getBank().getNameBank());
			
			return listBankPerson;
		}else {
			return null;
		}
	
	}

	@Override
	public List<ListBankPersonDto> getallBankPerson() {
		// TODO Auto-generated method stub
		List<BankPerson> listBankPerson=bankPersonRepositori.findAll();
		List<ListBankPersonDto> listBankPersonDto=new ArrayList<ListBankPersonDto>();
		
		for (BankPerson bankPerson : listBankPerson) {
			ListBankPersonDto bp=new ListBankPersonDto();
			bp.setAccount(bankPerson.getAcount());
			bp.setId(bankPerson.getId());
			bp.setPersonIdentification(bankPerson.getPerson().getIdentification());
			bp.setPersonName(bankPerson.getPerson().getNames());
			bp.setBankName(bankPerson.getBank().getNameBank());
			
			listBankPersonDto.add(bp);
			
		}
			return listBankPersonDto;

		
	}

	@Override
	public boolean delete(BankPerson bankPerson) {
		// TODO Auto-generated method stub
		
		Optional<BankPerson>  temporal=bankPersonRepositori.findById(bankPerson.getId());
		if(temporal.isEmpty()) {
			return false;
		}else {
			bankPersonRepositori.delete(bankPerson);
			return true;
		}
		
	}

	@Override
	public ListBankPersonDto updateAccountBank(CreateBankPersonDto createBankPersonDto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
