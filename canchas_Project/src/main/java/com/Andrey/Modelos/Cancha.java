package com.Andrey.Modelos;

import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="canchas")
public class Cancha {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 15, nullable = false)
	private String tipoCancha;
	
	@Column(length = 8, nullable = false)
	private String estado;
	
	@Column(nullable = false)
	private double precioPorHora;
	
	@Column(nullable = false)
	private LocalTime horaInicio;
	
	@Column(nullable = false)
	private LocalTime horaFin;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Reserva> reservas;
	
	@Column
	private String imagen;
	
	public Cancha() {
		// TODO Auto-generated constructor stub
	}

	public Cancha(Long id, String tipoCancha, String estado, double precioPorHora, LocalTime horaInicio,
			LocalTime horaFin, List<Reserva> reservas, String imagen) {
		super();
		this.id = id;
		this.tipoCancha = tipoCancha;
		this.estado = estado;
		this.precioPorHora = precioPorHora;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.reservas = reservas;
		this.imagen = imagen;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoCancha() {
		return tipoCancha;
	}

	public void setTipoCancha(String tipoCancha) {
		this.tipoCancha = tipoCancha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public double getPrecioPorHora() {
		return precioPorHora;
	}

	public void setPrecioPorHora(double precioPorHora) {
		this.precioPorHora = precioPorHora;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


}
