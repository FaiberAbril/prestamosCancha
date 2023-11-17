package com.Andrey.Controladores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.Andrey.Modelos.event;
import com.Andrey.Repositorios.eventRepository;

@Controller
public class CalendarControlador {
	
	
	@Autowired
	private eventRepository eventrespository;
	
	

	@RequestMapping(value = "/", method = RequestMethod.GET) 
		public ModelAndView index() {
			ModelAndView modelAndView = new ModelAndView("index");
			return modelAndView;
	}

	@RequestMapping(value = "/events", method = RequestMethod.GET)
	public List<event> getEventsInRange(@RequestParam(value = "start", required = true) String start,
			@RequestParam(value = "finish", required = true) String finish) {
		
		Date startDate = null;
		Date finishDate = null;
		
		
		SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {
			startDate = inputDateFormat.parse(start);
		} catch (ParseException e) {
			throw new BadDateFormatException("bad start date: " + start);
		}

		try {
			finishDate = inputDateFormat.parse(finish);
		} catch (ParseException e) {
			throw new BadDateFormatException("bad end date: " + finish);
		}

		LocalDateTime startDateTime = LocalDateTime.ofInstant(startDate.toInstant(), ZoneId.systemDefault());

		LocalDateTime finishDateTime = LocalDateTime.ofInstant(finishDate.toInstant(), ZoneId.systemDefault());

		return eventrespository.findBystartBetween(startDateTime, finishDateTime);
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST )
	class BadDateFormatException extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public BadDateFormatException(String dateString) {
			super(dateString);
		}
	}

	
	
	@RequestMapping(value = "/event", method = RequestMethod.POST)
	public event addEvent(@RequestBody event event) {
		event created = eventrespository.save(event);
		return created;
	}

	@RequestMapping(value = "/event", method = RequestMethod.PATCH)
	public event updateEvent(@RequestBody event event) {
		return eventrespository.save(event);
	}

	@RequestMapping(value = "/event", method = RequestMethod.DELETE)
	public void removeEvent(@RequestBody event event) {
		eventrespository.delete(event);
	}
}
