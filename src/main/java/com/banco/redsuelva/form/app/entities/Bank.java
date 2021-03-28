package com.banco.redsuelva.form.app.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="bank")
@Data
public class Bank {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idBank;
	@Column(unique = true)
	private String nit;
	private String nameBank;
	private String watchword;
	private LocalDateTime registrationDate;
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "bank")
	private List<BankPerson> accounts;
	
	
	

}
