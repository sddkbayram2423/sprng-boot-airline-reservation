 package com.bayram.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bayram.app.model.dto.UserDto;
import com.bayram.app.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@ModelAttribute("userDto")
	public UserDto userDto(){
		return new UserDto();
	}
	
	
	@RequestMapping(value = "/registerUser",method = RequestMethod.GET)
	public String register(Model model) {
		return "addUser";
	
	}
	
	@PostMapping("/saveUser")
	public String saveUser( Model model,@Valid @ModelAttribute("userDto") UserDto userDto,BindingResult result,RedirectAttributes attributes) {
		
		System.out.println(userDto);
		System.err.println(result);
		if(result.hasErrors()) {
			return "addUser";
		}
		
		userService.saveUser(userDto);
		
		attributes.addFlashAttribute("msg", "User created succesfully. Now you can login");
		
		return "redirect:/login.html";
	}

}
