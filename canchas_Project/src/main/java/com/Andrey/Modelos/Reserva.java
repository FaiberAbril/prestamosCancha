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
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String Nombre;
    
    @Column
    private String Correo;

    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;
    

    @Column(nullable = false)
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime horasReservadas;
    
    @Column
    private boolean Jornada;

    @Column(nullable = false)
    private Double precioTotal;

    @JoinColumn
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuario;

    @Column(nullable = true)
    private String canchaSintetica;

    // Constructor, getters, setters, etc.


	public Reserva() {
	}

	public Reserva(Long id, String nombre, String correo, Date fecha, LocalTime horasReservadas, boolean jornada,
			Double precioTotal, Usuario usuario, String canchaSintetica) {
		super();
		this.id = id;
		Nombre = nombre;
		Correo = correo;
		this.fecha = fecha;
		this.horasReservadas = horasReservadas;
		Jornada = jornada;
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

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		Correo = correo;
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

	public boolean isJornada() {
		return Jornada;
	}

	public void setJornada(boolean jornada) {
		Jornada = jornada;
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

	public String getCanchaSintetica() {
		return canchaSintetica;
	}

	public void setCanchaSintetica(String canchaSintetica) {
		this.canchaSintetica = canchaSintetica;
	}

}