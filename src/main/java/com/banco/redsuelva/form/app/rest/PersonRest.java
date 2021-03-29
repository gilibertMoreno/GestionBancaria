package com.banco.redsuelva.form.app.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banco.redsuelva.form.app.entities.Person;
import com.banco.redsuelva.form.app.service.impl.PersonServicesImpl;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/person")
public class PersonRest {
	
	@Autowired
	private PersonServicesImpl personServices;
	
	@PostMapping
	public ResponseEntity<Object> registrar(@RequestBody Person person){
		
		Person temporal= personServices.create(person);
		
		try {
			if(temporal!=null) {
				return ResponseEntity.ok(temporal);
			}
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuario ya existe");
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Person>> listarPerson(){
		return ResponseEntity.ok(personServices.getAllPerson());
	}
	
	@DeleteMapping
	public ResponseEntity<Object>eliminar(@RequestBody Person person){
		if(personServices.delete(person)) {
			return ResponseEntity.ok().body("Eliminado Exitosamente");
		}else {
			return ResponseEntity.status(HttpStatus.GONE).body("Usuario No Existe");
		}
		
	}
	
	@GetMapping(value="{id}")
	public ResponseEntity<Optional<Person>> buscarPerson(@PathVariable ("id") Long id){
		return ResponseEntity.ok(personServices.findByID(id));
	}
	
	@PutMapping
	public ResponseEntity<Object> actualizarPerson(@RequestBody Person person){
		Person temporal=personServices.update(person);
		try {
			if(temporal!=null) {
				return ResponseEntity.ok(temporal);
			}else {
				return ResponseEntity.status(HttpStatus.GONE).body("La Persona No Esta Registrada");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	

}
