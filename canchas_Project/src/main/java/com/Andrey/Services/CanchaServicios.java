package com.Andrey.Services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Andrey.Modelos.Cancha;
import com.Andrey.Repositorios.CanchaSinteticaRepository;

@Service
public class CanchaServicios {

	@Autowired
	private CanchaSinteticaRepository canchaSinteticaRepository;
	
	
	public void AgregarCancha(Cancha cancha) {
		canchaSinteticaRepository.save(cancha);
	}
	
	public void ActualizarCancha(Cancha cancha) {
		canchaSinteticaRepository.save(cancha);
	} 
		

	 public void subirImagenCancha(Cancha cancha, MultipartFile imagen) throws IOException {
		        String nombreArchivo = cancha.getId() + "_" + imagen.getOriginalFilename();
		        String rutaDestino = "src\\main\\resources\\Static\\images\\Canchas" + nombreArchivo;
		        cancha.setImagen(rutaDestino);
		        canchaSinteticaRepository.save(cancha);
		    
		}
	
	public void EliminarCancha(long id) {
		canchaSinteticaRepository.deleteById(id);
	}
	
	public Cancha CapturarCancha(long id) {
		return canchaSinteticaRepository.findById(id).get();
	}
	
	public List<Cancha> ListarCanchas(){
		return canchaSinteticaRepository.findAll();
	}
	
}
