package com.Andrey.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Andrey.Modelos.Cancha;
import com.Andrey.Services.CanchaServicios;

@Controller
@RequestMapping("/cancha")
public class CanchaControlador {
	




			@Autowired
			private CanchaServicios canchaServicios;
			
			@GetMapping("/")
			public String PaginaCancha(Model model) {
				model.addAttribute("listaCancha", canchaServicios.ListarCanchas());
				return "canchas";
			}
			
			@GetMapping("/agregarCancha")
			public String AgregarCancha(Model model) {
				return "formularioAgregarCancha";
			}
			
			@PostMapping("/guardarCanchas")
			public String GuardarCanchas(@ModelAttribute("ObjCancha") Cancha cancha) {
				canchaServicios.AgregarCancha(cancha);
				return "redirect:/cancha/";
			}
			
			@GetMapping("/eliminarCancha/{id}")
			public String EliminarCancha(@PathVariable("id") Long id) {
				canchaServicios.EliminarCancha(id);
				return "redirect:/cancha/";
			}
			
			@GetMapping("/formActuActualizarCancha/{id}")
			public String formularioActualizarCancha(Model model, @PathVariable("ids") Long id) {
				model.addAttribute("ObjCanchaActualizado", canchaServicios.CapturarCancha(id));
				return "formularioActualizarCancha";
			}
			
			@PostMapping("/actualizarCancha")
			public String ActualizarCancha(@ModelAttribute("ObjCanchaActualizado") Cancha cancha) {
				canchaServicios.ActualizarCancha(cancha);
				return "redirect:/cancha/";
			}
			
}
