package com.Andrey.Services;

import java.sql.Date;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Andrey.Modelos.Reserva;
import com.Andrey.Repositorios.ReservaRepository;
import java.util.Optional;

@Service
public class ReservaServicios {

    @Autowired
    private ReservaRepository reservaRepository;

    // Generar una reserva con lógica adicional
    public void generarReserva(Reserva reserva) {
        // Lógica adicional antes de generar la reserva, por ejemplo, validaciones
        if (reserva.getFecha() == null || reserva.getHorasReservadas() == null || reserva.getPrecioTotal() == null) {
            throw new IllegalArgumentException("Campos obligatorios no pueden ser nulos");
        }

        // Puedes agregar más lógica adicional según tus necesidades

        // Calcular el precio total en base a la duración de las horas reservadas
        long duracionHoras = calcularDuracionHoras(reserva.getHorasReservadas());
        double precioPorHora = 10.0; // Precio por hora (ajusta según tus necesidades)
        double precioTotal = duracionHoras * precioPorHora;

        // Establecer el precio total calculado en la reserva
        reserva.setPrecioTotal(precioTotal);

        // Guardar la reserva en la base de datos
        reservaRepository.save(reserva);
    }

    // Obtener todas las reservas
    public List<Reserva> obtenerTodasLasReservas() {
        // Puedes agregar lógica adicional antes de obtener todas las reservas
        return reservaRepository.findAll();
    }

    
    // Obtener una reserva por ID
    public Reserva obtenerReservaPorId(Long id) {
        // Puedes agregar lógica adicional antes de obtener la reserva por ID
        Optional<Reserva> optionalReserva = reservaRepository.findById(id);
        return optionalReserva.orElse(null);
    }

    // Actualizar una reserva
    public void actualizarReserva(Long id, Reserva reservaActualizada) {
        // Puedes agregar lógica adicional antes de actualizar la reserva
        Optional<Reserva> optionalReserva = reservaRepository.findById(id);
        if (optionalReserva.isPresent()) {
            Reserva reservaExistente = optionalReserva.get();
            // Actualizar los campos de la reserva existente con los de la reserva actualizada
            reservaExistente.setFecha(reservaActualizada.getFecha());
            reservaExistente.setHorasReservadas(reservaActualizada.getHorasReservadas());
            reservaExistente.setPrecioTotal(reservaActualizada.getPrecioTotal());
            // Actualizar otros campos según sea necesario
            reservaRepository.save(reservaExistente);
        }
    }

    // Eliminar una reserva por ID
    public void eliminarReserva(Long id) {
        // Puedes agregar lógica adicional antes de eliminar la reserva
    	reservaRepository.deleteById(id);
    }

    // Puedes agregar más métodos según sea necesario

    // Método de ejemplo para calcular la duración en horas entre la hora actual y la hora reservada
    private long calcularDuracionHoras(LocalTime horasReservadas) {
        LocalTime horaActual = LocalTime.now();
        return ChronoUnit.HOURS.between(horaActual, horasReservadas);
    }
    public void CrearReserva(Reserva reserva) {
        reservaRepository.save(reserva);
    }
   
}






 
