package com.Andrey.Modelos;


import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
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
	
	@DateTimeFormat(pattern = "HH:mm:ss")
	private LocalTime  horasReservadas;
	
	@Column(nullable = true)
	private Double precioTotal;
	
	
   @JoinColumn
	@ManyToOne(fetch = FetchType.EAGER)
	private Usuario IdUsuario;
	
   @JoinColumn
	@ManyToOne(fetch = FetchType.EAGER)
	private Cancha canchaSintetica;

	public Reserva() {
	}

	public Reserva(Long id, Date fecha, LocalTime horasReservadas, Double precioTotal, Usuario idUsuario,
			Cancha canchaSintetica) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.horasReservadas = horasReservadas;
		this.precioTotal = precioTotal;
		IdUsuario = idUsuario;
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

	public LocalTime getHorasReservadas() {
		return horasReservadas;
	}

	public void setHorasReservadas(LocalTime horasReservadas) {
		this.horasReservadas = horasReservadas;
	}

	public Double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public Usuario getIdUsuario() {
		return IdUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		IdUsuario = idUsuario;
	}

	public Cancha getCanchaSintetica() {
		return canchaSintetica;
	}

	public void setCanchaSintetica(Cancha canchaSintetica) {
		this.canchaSintetica = canchaSintetica;
	}

	

	
	
	
	

}
