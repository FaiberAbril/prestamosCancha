package com.Andrey.Modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="roles")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IdRol;
	
	@Column(length = 10, nullable = false)
	private String NombreRol;
	@Column(length = 10, nullable = false)
	private String DescripcionRol;
	
	public Rol() {
		// TODO Auto-generated constructor stub
	}

	public Rol(long idRol, String nombreRol, String descripcionRol) {
		super();
		IdRol = idRol;
		NombreRol = nombreRol;
		DescripcionRol = descripcionRol;
	}

	public long getIdRol() {
		return IdRol;
	}

	public void setIdRol(long idRol) {
		IdRol = idRol;
	}

	public String getNombreRol() {
		return NombreRol;
	}

	public void setNombreRol(String nombreRol) {
		NombreRol = nombreRol;
	}

	public String getDescripcionRol() {
		return DescripcionRol;
	}

	public void setDescripcionRol(String descripcionRol) {
		DescripcionRol = descripcionRol;
	}
	
	
	
}

