package com.cinovation.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	
	@RequestMapping(value = "/")
	public String welcome() {
		return "Welcome to spring";
	}
}
