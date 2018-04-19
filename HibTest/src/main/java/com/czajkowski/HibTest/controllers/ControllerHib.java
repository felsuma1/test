package com.czajkowski.HibTest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.czajkowski.HibTest.model.User;
import com.czajkowski.HibTest.repository.UserRepository;

@Controller
@RequestMapping ("/")
public class ControllerHib {

	@Autowired
	UserRepository userRepository;
	User user;
	@RequestMapping (method=RequestMethod.GET, value="/all")
	public String ListAllUsers(Model model) {
		model.addAttribute("users",userRepository.findAll());
		return "index";
	}
	@RequestMapping (method=RequestMethod.GET, value="/findByName/{name}")
	public String findByName(Model model, @PathVariable String name) {
		model.addAttribute("users",userRepository.findByFirstName(name));
		return "index";
	}
	@RequestMapping (method=RequestMethod.GET, value="/edit/{id}")
	public String edit(Model model,@PathVariable int id) {
		model.addAttribute("user", userRepository.findByUserId(id));		
		return "edit";
	}
	@RequestMapping (method=RequestMethod.GET, value="/add")
	public String add(Model model) {
		model.addAttribute("user", new User());		
		return "edit";
	}
	
	@RequestMapping (method=RequestMethod.POST, value="/edit/{id}")
	public String edit(@ModelAttribute("user") User user) {
		userRepository.save(user);
		return "redirect:/all";
	}
	@RequestMapping (method=RequestMethod.POST, value="/add")
	public String add(@ModelAttribute("user") User user) {
		userRepository.save(user);
		return "redirect:/all";
	}
	@RequestMapping (method=RequestMethod.GET, value="/age")
	public String age(Model model) {
		model.addAttribute("age",userRepository.age().get());
		return "index";
	}
	@RequestMapping (method=RequestMethod.GET, value="/delete/{id}")
	public String ListAllUsers(Model model, @PathVariable int id) {
		userRepository.deleteByUserId(id);
		model.addAttribute("users",userRepository.findAll());
		return "redirect:/all";
	}
}
