package com.banco.redsuelva.form.app.service;

import java.util.List;

import com.banco.redsuelva.form.app.dto.CreateBankPersonDto;
import com.banco.redsuelva.form.app.dto.ListBankPersonDto;
import com.banco.redsuelva.form.app.entities.BankPerson;

public interface BankPersonServices {
	
	public ListBankPersonDto createAccountBank(CreateBankPersonDto createBankPerson);
	public List<ListBankPersonDto> getallBankPerson();
	public boolean delete(BankPerson bankPErson);
	public ListBankPersonDto updateAccountBank(CreateBankPersonDto createBankPersonDto);

}
