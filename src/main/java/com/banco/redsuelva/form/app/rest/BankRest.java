package com.banco.redsuelva.form.app.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banco.redsuelva.form.app.entities.Bank;
import com.banco.redsuelva.form.app.service.impl.BankServicesImpl;

@RestController
@RequestMapping("/api/bank")
public class BankRest {
	
	@Autowired
	private BankServicesImpl bankService;
	
	@PostMapping
	public ResponseEntity<Object> guardar(@RequestBody Bank bank){
		
		Bank temporal=bankService.create(bank);
		
		try {
			if(temporal!=null) {
				return ResponseEntity.ok(temporal);
			}else {
				return ResponseEntity.status(HttpStatus.CONFLICT).body("BANCO YA EXISTE");
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Bank>> listar(){
		return ResponseEntity.ok(bankService.getAllBank());
	}
	
	@DeleteMapping
	public ResponseEntity<String> eliminar(@RequestBody Bank bank){
		if(bankService.delete(bank)) {
			return ResponseEntity.ok().body("Eliminado Exitosamente");
		}else {
			return ResponseEntity.status(HttpStatus.GONE).body("El Usuario No Existe");
		}
		
	}
	
	@GetMapping(value="{id}")
	public ResponseEntity<Optional<Bank>> buscarBank(@PathVariable ("id") Long id){
		return ResponseEntity.ok(bankService.findByID(id));
	}
	
	@PutMapping
	public ResponseEntity<Object> actualizar(@RequestBody Bank bank){
		Bank temporal=bankService.update(bank);
		try {
			if(temporal!=null){
				return ResponseEntity.ok(temporal);
			}else {
				return ResponseEntity.status(HttpStatus.CONFLICT).body("El Usuario No Existe");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	

}
