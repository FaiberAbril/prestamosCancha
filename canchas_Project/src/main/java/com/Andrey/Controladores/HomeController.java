package com.Andrey.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Inicio")
public class HomeController {

	@GetMapping("/")
	public String goHome(Model model) {
		model.addAttribute("titulo", "Bienvenid@ Pagina de inicio");
		return "inicio";
	}
	
}
