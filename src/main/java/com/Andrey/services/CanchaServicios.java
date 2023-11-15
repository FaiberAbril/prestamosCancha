package com.Andrey.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
