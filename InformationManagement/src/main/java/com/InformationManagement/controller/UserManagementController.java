package com.InformationManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/")
@Controller
public class UserManagementController {
	@RequestMapping("/home")
	public String home() {
		return "home.html";
	}
}
