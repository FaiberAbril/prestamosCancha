package com.Andrey.Controladores;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Andrey.Modelos.Reserva;
import com.Andrey.Services.CanchaServicios;
import com.Andrey.Services.ReservaServicios;


@Controller
@RequestMapping("/reserva")
public class ReservaControlador {

    @Autowired
    private ReservaServicios reservaServicios;

    // Mostrar el formulario para crear una reserva
    @GetMapping("/formulario")
    public String mostrarFormularioReserva(Model model) {
        model.addAttribute("reserva", new Reserva());
        // Puedes agregar lógica adicional antes de mostrar el formulario
        return "Usuario";
    }

    // Procesar la creación de una reserva
    @PostMapping("/crear")
    public String procesarReserva(@ModelAttribute Reserva reserva, Model model) {
        // Validar los datos de la reserva antes de insertarla en la base de datos
        if (reserva.getFecha() == null || reserva.getHorasReservadas() == null || reserva.getPrecioTotal() == null) {
            // Manejar la validación fallida, por ejemplo, redirigir al formulario con un mensaje de error
            model.addAttribute("error", "Campos obligatorios no pueden ser nulos");
            return "redirect:/reserva/mostrar";
        }

        // Calcular el precio total en base a la duración de las horas reservadas (ejemplo)
        long duracionHoras = ChronoUnit.HOURS.between(reserva.getHorasReservadas(), LocalTime.now());
        double precioPorHora = 10.0; // Precio por hora (ajusta según tus necesidades)
        double precioTotal = duracionHoras * precioPorHora;

        // Establecer el precio total calculado en la reserva
        reserva.setPrecioTotal(precioTotal);

        // Lógica adicional antes de insertar la reserva
        // ...

        reservaServicios.CrearReserva(reserva);

        // Puedes agregar lógica adicional después de insertar la reserva
        model.addAttribute("success", "La reserva se ha creado correctamente");
        return "redirect:/reserva/mostrar";
    }

    // Mostrar todas las reservas
    @GetMapping("/mostrar")
    public String mostrarReservas(Model model) {
        List<Reserva> reservas = reservaServicios.obtenerTodasLasReservas();
        model.addAttribute("reservas", reservas);
        // Puedes agregar lógica adicional antes de mostrar las reservas
        return "mostrar_reservas";
    }

    @PostMapping("/Guardarreserva")
	public String guardarreserva(@ModelAttribute("reserva") Reserva nuevoReserva) {
		reservaServicios.CrearReserva(nuevoReserva);
		return "redirect:/reserva/mostrar";
	}
    
    // Mostrar el formulario para editar una reserva por ID
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarReserva(@PathVariable Long id, Model model) {
        // Obtener la reserva por ID
        Reserva reserva = reservaServicios.obtenerReservaPorId(id);
        model.addAttribute("reserva", reserva);
        // Puedes agregar lógica adicional antes de mostrar el formulario de edición
        return "Usuario";
    }

    // Procesar la actualización de una reserva
    @PostMapping("/editar/{id}")
    public String procesarEditarReserva(@PathVariable Long id, @ModelAttribute Reserva reserva, Model model) {
        // Validar los datos de la reserva antes de actualizarla en la base de datos
        if (reserva.getFecha() == null || reserva.getHorasReservadas() == null || reserva.getPrecioTotal() == null) {
            // Manejar la validación fallida, por ejemplo, redirigir al formulario con un mensaje de error
            model.addAttribute("error", "Campos obligatorios no pueden ser nulos");
            return "Usuario";
        }

        // Calcular el precio total en base a la duración de las horas reservadas (ejemplo)
        long duracionHoras = ChronoUnit.HOURS.between(reserva.getHorasReservadas(), LocalTime.now());
        double precioPorHora = 50.000; // Precio por hora (ajusta según tus necesidades)
        double precioTotal = duracionHoras * precioPorHora;

        // Establecer el precio total calculado en la reserva
        reserva.setPrecioTotal(precioTotal);

        // Lógica adicional antes de actualizar la reserva
        // ...

        reservaServicios.actualizarReserva(id, reserva);

        // Puedes agregar lógica adicional después de actualizar la reserva
        model.addAttribute("success", "La reserva se ha actualizado correctamente");
        return "redirect:/reserva/mostrar";
    }

    // Eliminar una reserva por ID
    @GetMapping("/eliminar/{id}")
    public String eliminarReserva(@PathVariable Long id, Model model) {
        // Lógica adicional antes de eliminar la reserva
        // ...

        reservaServicios.eliminarReserva(id);

        // Puedes agregar lógica adicional después de eliminar la reserva
        model.addAttribute("success", "La reserva se ha eliminado correctamente");
        return "redirect:/reserva/mostrar";
    }

    // Puedes agregar más métodos según sea necesario
}
