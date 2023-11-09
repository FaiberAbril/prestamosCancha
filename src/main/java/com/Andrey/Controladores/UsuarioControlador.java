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
import com.Andrey.services.usuarioservicios;

@Controller
@RequestMapping("/usuario")
public class UsuarioControlador {

	@Autowired
	private usuarioservicios usuarioservicios;
	
	@GetMapping("/")
	public String paginausuarios(Model model) {
		model.addAttribute("listaUsuarios", usuarioservicios.ListarUsuarios());
		return "usuario";
	}
	
	@GetMapping("/formAgrgarUsuario")
	public String agregarUsuario(Model model) {
		model.addAttribute("ObjUsuario", new Usuario());
		return "formUsuario";
	}

	@PostMapping("/guardarUsuario")
	public String guardarUsuario(@ModelAttribute("ObjUsuario") Usuario usuario) {
		usuarioservicios.agregarusuario(usuario);
		return "redirect:/usuario/";
	}
	
	@GetMapping("/eliminarUsuario/{IdCliente}")
	public String eliminarUsuario(@PathVariable("IdCliente") int IdCliente) {
		usuarioservicios.eliminarUsuario(IdCliente);
		return "redirect:/usuario/";
	}
	
	@GetMapping("/formActualizarUsuario/{IdCliente}")
	public String formActualizarUsuario(Model model,@PathVariable("IdCliente")int IdCliente) {
		model.addAttribute("ObjUsuarioActualizado", usuarioservicios.capturarUsuario(IdCliente));
		return "formActualizarUsuario";
	}
	
	@PostMapping("/actualizarUsuario")
	public String actualizarUsuario(@ModelAttribute("ObjUsuarioActualizado")Usuario usuario) {
		usuarioservicios.actualizarUsuario(usuario);
		return "redirect:/usuario/";
	}
	
}
