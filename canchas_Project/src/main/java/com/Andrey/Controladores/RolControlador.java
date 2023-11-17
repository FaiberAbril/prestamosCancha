package com.Andrey.Controladores;
/*
import com.Andrey.controladores.Autowired;
import com.Andrey.controladores.Controller;
import com.Andrey.controladores.GetMapping;
import com.Andrey.controladores.Model;
import com.Andrey.controladores.ModelAttribute;
import com.Andrey.controladores.PathVariable;
import com.Andrey.controladores.PostMapping;
import com.Andrey.controladores.RequestMapping;
import com.Andrey.modelos.Roles;
import com.Andrey.servicios.RolesServicios;

@Controller
@RequestMapping("/rol")
public class RolControlador {


		@Autowired
		private RolesServicios rolesServicios;
		
		@GetMapping("/")
		public String PaginaRol(Model model) {
			model.addAttribute("listRoles", rolesServicios.ListarRoles());
			return "roles";
		}
		
		@GetMapping("/agregarRol")
		public String AgregarRol(Model model) {
			model.addAttribute("ObjRol", new Roles());
			return "formularioRol";
		}
		
		@PostMapping("/guardarRol")
		public String GuardarRol(@ModelAttribute("ObjRol") Roles roles) {
			rolesServicios.CrearRol(roles);
			return "redirect:/rol/";
		}
		
		@GetMapping("/eliminarRol/{IdRol}")
		public String EliminarRol(@PathVariable("IdRol") long IdRol) {
			rolesServicios.EliminarRol(IdRol);
			return "redirect:/rol/";
		}
		
		@GetMapping("/formActualziarRol/{IdRol}")
		public String FormuliarioActualizarRol(Model model, @PathVariable("IdRol") long IdRol) {
			model.addAttribute("ObjRolActualizado", rolesServicios.BuscarRol(IdRol));
			return "formularioActualizarRol";
		}
		
		@PostMapping("/actualziarRol")
		public String ActualizarRol(@ModelAttribute("ObjRolActualizado")Roles roles) {
			rolesServicios.ActualizarRol(roles);
			return "redirect:/rol/";
		}
		
	}

}
*/
