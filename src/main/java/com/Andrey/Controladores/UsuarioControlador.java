package com.Andrey.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Andrey.Modelos.Usuario;
import com.Andrey.Services.UsuarioServicios;

@Controller
@RequestMapping("/usuario")
public class UsuarioControlador {

	@Autowired
	private UsuarioServicios usuarioServicios;
	
	@GetMapping("/")
	public String PaginaUsuario(Model model) {
		model.addAttribute("listaUsuario", usuarioServicios.ListarUsuarios());
		return "usuarios";
	}
	
	@GetMapping("/agregarUsuario")
	public String AgregarUsuario(Model model) {
		model.addAttribute("ObjUsuario", new Usuario());
		return "formularioAgregarUsuario";
	}
	
	@PostMapping("/guardarUsuario")
	public String GuardarUsuario(@ModelAttribute("ObjUsuario") Usuario usuario) {
		usuarioServicios.CrearUsuario(usuario);
		return "redirect:/usuario/";
	}
	
	@GetMapping("/eliminarUsuario/{IdUsuario}")
	public String EliminarUsuario(@PathVariable("IdUsuario") Long IdUsuario) {
		usuarioServicios.EliminarUsuario(IdUsuario);
		return "redirect:/usuario/";
	}
	
	@GetMapping("/formActuActualizarUsuario/{idUsuario}")
	public String formularioActualizarUsuario(Model model, @PathVariable("idCliente") Long IdUsuario) {
		model.addAttribute("ObjUsuarioActualizado", usuarioServicios.BuscarUsuario(IdUsuario));
		return "formularioActualizarUsuario";
	}
	
	@PostMapping("/actualizarUsuario")
	public String ActualizarUsuario(@ModelAttribute("ObjUsuarioActualizado") Usuario usuario) {
		usuarioServicios.ActualizarUsuario(usuario);
		return "redirect:/usuario/";
	}
	
}
