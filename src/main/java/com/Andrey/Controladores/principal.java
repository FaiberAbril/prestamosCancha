package com.Andrey.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Principal")
public class principal {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
}