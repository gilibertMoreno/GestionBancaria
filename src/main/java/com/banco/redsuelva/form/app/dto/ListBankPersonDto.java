package com.banco.redsuelva.form.app.dto;

import lombok.Data;

@Data
public class ListBankPersonDto {
	
	private Long id;
	private String account;
	private String personIdentification;
	private String personName;
	private String personLastName;
	private String bankName;

}
