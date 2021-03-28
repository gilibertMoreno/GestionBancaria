package com.banco.redsuelva.form.app.entities;

import java.time.LocalDate;
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
@Table(name="person")
@Data
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPerson;
	@Column(unique = true)
	private String identification;
	private String names;
	private String lasName;
	private LocalDate dateBird;
	private int age;
	private String email;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
	private List<BankPerson> acounts;

}
