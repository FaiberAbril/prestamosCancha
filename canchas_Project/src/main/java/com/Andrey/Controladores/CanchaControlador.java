package com.Andrey.Controladores;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Andrey.Modelos.Cancha;
import com.Andrey.Repositorios.CanchaSinteticaRepository;
import com.Andrey.Services.CanchaServicios;

@RestController
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
				return "FormularioCancha";
			}
			
			@PostMapping("/guardarCanchas")
			public String GuardarCanchas(Model model,@RequestParam("file") MultipartFile imagen ) {
				
				if(!imagen.isEmpty()) {
					Path directorioImagenes = Paths.get("src//main//resources//static/images");
					String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
					
					try {
						byte[] bytesImg = imagen.getBytes();
						Path rutaCompleta = Paths.get(rutaAbsoluta + "//"+ imagen.getOriginalFilename());
						Files.write(rutaCompleta, bytesImg);
						
						
					} catch (IOException e) {
					
			        e.printStackTrace();
					}
				}
				
				return "FormularioCancha";
			}
			
			@GetMapping("/eliminarCancha/{id}")
			public String EliminarCancha(@PathVariable("id") Long id) {
				canchaServicios.EliminarCancha(id);
				return "FormularioCancha";
			}
			
			@GetMapping("/formActuActualizarCancha/{id}")
			public String formularioActualizarCancha(Model model, @PathVariable("ids") Long id) {
				model.addAttribute("ObjCanchaActualizado", canchaServicios.CapturarCancha(id));
				return "FormularioCancha";
			}
			
			@PostMapping("/actualizarCancha")
			public String ActualizarCancha(@ModelAttribute("ObjCanchaActualizado") Cancha cancha) {
				canchaServicios.ActualizarCancha(cancha);
				return "FormularioCancha";
			}
			
		  
		  @PostMapping("/{id}/imagen")
		   public ResponseEntity<Cancha> subirImagen(@PathVariable Long id, @RequestParam("imagen") MultipartFile imagen) {
			     Optional<Cancha> cancha = Optional.ofNullable(canchaServicios.CapturarCancha(id));

			        if (!cancha.isPresent()) {
			            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			        }

			        try {
			            canchaServicios.subirImagenCancha(cancha.get(), imagen);
			            return new ResponseEntity<>(cancha.get(), HttpStatus.OK);
			        } catch (IOException e) {
			            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			        }
			    }
			}
			

