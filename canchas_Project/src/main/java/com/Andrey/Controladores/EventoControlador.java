package com.Andrey.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Andrey.Modelos.event;
import com.Andrey.Repositorios.eventRepository;

@RestController
public class EventoControlador {

	@Autowired
	private eventRepository eventRespository;

	@RequestMapping(value = "/events", method = RequestMethod.GET)
	public List<event> events() {
		return eventRespository.findAll();

	}

}
