package com.Andrey.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Andrey.Modelos.Reserva;
import com.Andrey.Repositorios.ReservaRepository;
@Service
public class ReservaServicios {

	

		@Autowired
		private ReservaRepository reservaRepository;
		
		
		
		
		
		
		public void AgregarReserva(Reserva reserva) {
			reservaRepository.save(reserva);
		}
		
		public void ActualizarReserva(Reserva reserva) {
			reservaRepository.save(reserva);
		}
		
		public void EliminarReserva(long id) {
			reservaRepository.deleteById(id);
		}
		
		public Reserva CapturarReserva(long id) {
			return reservaRepository.findById(id).get();
		}
		
		public List<Reserva> ListarReservas(){
			return reservaRepository.findAll();
		}
		
		
		
		
		
		
		
}
