package com.czajkowski.HibTest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.czajkowski.HibTest.model.User;
import com.czajkowski.HibTest.repository.UserRepository;

@RestController
@RequestMapping ("/rest/users")
public class UsersController {

	@Autowired
	UserRepository userRepository;
	
	@RequestMapping (method=RequestMethod.GET, value="/all")
	public List<User> ListAllUsers() {
		return userRepository.findAll();
	}
	@RequestMapping (method=RequestMethod.GET, value="/{name}")
	public List<User> findByName(@PathVariable String name) {
		return userRepository.findByFirstName(name);
	}
	/*@RequestMapping (method=RequestMethod.POST, value="/{id}")
	public List<User> updateById(@PathVariable String id, @RequestBody User user) {
		return userRepository.updateById(id);
	}*/
	@RequestMapping (method=RequestMethod.POST, value="/create")
	public List<User> create(@RequestBody User user) {
		userRepository.save(user);
		return userRepository.findAll();
	}
}
