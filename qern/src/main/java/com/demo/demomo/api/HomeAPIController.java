package com.demo.demomo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeAPIController {
	
	@GetMapping({"", "/index"})
	public String home() {
		
		return "<h1> HOME </h1>";
	}

}
