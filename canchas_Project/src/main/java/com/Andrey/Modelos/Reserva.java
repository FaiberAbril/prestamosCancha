package com.Andrey.Modelos;


import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="reserva")
public class Reserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="fecha")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	
	@Column(nullable = false)
	private Integer horasReservadas;
	
	@Column(nullable = false)
	private Double precioTotal;
	
	@JoinColumn(name="usuario")
	@ManyToOne(fetch = FetchType.EAGER)
	private Usuario usuario;
	
	@JoinColumn(name="cancha")
	@ManyToOne(fetch = FetchType.EAGER)
	private Cancha canchaSintetica;

	public Reserva() {
		// TODO Auto-generated constructor stub
	}

	public Reserva(Long id, Date fecha, Integer horasReservadas, Double precioTotal, Usuario usuario,
			Cancha canchaSintetica) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.horasReservadas = horasReservadas;
		this.precioTotal = precioTotal;
		this.usuario = usuario;
		this.canchaSintetica = canchaSintetica;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getHorasReservadas() {
		return horasReservadas;
	}

	public void setHorasReservadas(Integer horasReservadas) {
		this.horasReservadas = horasReservadas;
	}

	public Double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Cancha getCanchaSintetica() {
		return canchaSintetica;
	}

	public void setCanchaSintetica(Cancha canchaSintetica) {
		this.canchaSintetica = canchaSintetica;
	}

	
	
	

}
