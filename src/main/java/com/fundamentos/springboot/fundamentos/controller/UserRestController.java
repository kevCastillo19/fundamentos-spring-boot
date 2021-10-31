package com.fundamentos.springboot.fundamentos.controller;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.fundamentos.springboot.fundamentos.CaseUse.CreateUser;
import com.fundamentos.springboot.fundamentos.CaseUse.DeleteUser;
import com.fundamentos.springboot.fundamentos.CaseUse.GetUser;
import com.fundamentos.springboot.fundamentos.CaseUse.UpdateUser;
import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
	
	private GetUser getUser;
	private CreateUser createUser;
	private UpdateUser updateUser;
	private DeleteUser deleteUser;
	private UserRepository userRepository;
	
	public UserRestController(GetUser getUser, CreateUser createUser,
							UpdateUser updateUser, DeleteUser deleteUser,
							UserRepository userRepository) {
		this.getUser = getUser;
		this.createUser = createUser;
		this.updateUser = updateUser;
		this.deleteUser = deleteUser;
		this.userRepository = userRepository;
	}
	
	@GetMapping("/")
	List<User> get(){
		return getUser.getAll();
	}
	
	@PostMapping("/")
	ResponseEntity<User> newUser(@RequestBody User newUser){
		return new ResponseEntity<>(createUser.save(newUser), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity deleteUser(@PathVariable Long id){
		deleteUser.delete(id);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	ResponseEntity<User> editUser(@RequestBody User newUser, @PathVariable Long id){
		return new ResponseEntity<>(updateUser.update(newUser, id), HttpStatus.OK);
	}
	
	@GetMapping("/pageable")
	List<User> getUserPageable(@RequestParam int page, @RequestParam int size){
		return this.userRepository.findAll(PageRequest.of(page, size)).getContent();
	}
}
