package com.Andrey.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Andrey.Modelos.Reserva;
import com.Andrey.Services.CanchaServicios;
import com.Andrey.Services.ReservaServicios;

@Controller
@RequestMapping("/reserva")
public class ReservaControlador {

		@Autowired
		private CanchaServicios canchaServicios;
	
		@Autowired
		private ReservaServicios reservaServicios;
		
		@GetMapping("/")
		public String PaginaReserva(Model model) {
			model.addAttribute("listaCanchas", canchaServicios.ListarCanchas());
			model.addAttribute("listaReserva", reservaServicios.ListarReservas());
			model.addAttribute("ObjReserva", new Reserva());
			return "Reserva";
		}
		
		@PostMapping("/guardarReserva")
		public String GuardarReserva(@ModelAttribute("ObjReserva") Reserva reserva) {
			reservaServicios.AgregarReserva(reserva);
			return "redirect:/reserva/";
		}
		
		@GetMapping("/eliminarReserva/{id}")
		public String EliminarReserva(@PathVariable("id") Long id) {
			reservaServicios.EliminarReserva(id);
			return "redirect:/usuario/";
		}
		
		@GetMapping("/formActuActualizarReserva/{id}")
		public String formularioActualizarReserva(Model model, @PathVariable("ids") Long id) {
			model.addAttribute("ObjUsuarioActualizado", reservaServicios.CapturarReserva(id));
			return "formularioActualizarReserva";
		}
		
		@PostMapping("/actualizarReserva")
		public String ActualizarReserva(@ModelAttribute("ObjUsuarioActualizado") Reserva reserva) {
			reservaServicios.ActualizarReserva(reserva);
			return "redirect:/reserva/";
		}
    }
		
		

