package com.banco.redsuelva.form.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banco.redsuelva.form.app.dto.CreateBankPersonDto;
import com.banco.redsuelva.form.app.dto.ListBankPersonDto;
import com.banco.redsuelva.form.app.entities.BankPerson;
import com.banco.redsuelva.form.app.service.BankPersonServices;

@RestController
@RequestMapping("/api/bankperson")
public class BankPersonRes {
	
	@Autowired
	private BankPersonServices bankPersonServices;
	
	@PostMapping
	public ResponseEntity<Object> resgistro(@RequestBody CreateBankPersonDto createBankPersonDto){
		
		ListBankPersonDto temporal=bankPersonServices.createAccountBank(createBankPersonDto);
		try {
			if(temporal!=null) {
				return ResponseEntity.ok(temporal);
			}else {
				return ResponseEntity.status(HttpStatus.CONFLICT).body("Asignacion No Exitosa");
			}
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
	@GetMapping
	public ResponseEntity<List<ListBankPersonDto>> listarBankPerson(){
		return ResponseEntity.ok(bankPersonServices.getallBankPerson());
	}
	
	
	@DeleteMapping
	public ResponseEntity<String> eliminarBankPerson(@RequestBody BankPerson bankPerson){
		
		if(bankPersonServices.delete(bankPerson)) {
			return ResponseEntity.ok().body("Fue Eliminado Exitosamente");
		}else {
			return ResponseEntity.status(HttpStatus.GONE).body("No Fue Eliminada");
		}
	}
	

}
