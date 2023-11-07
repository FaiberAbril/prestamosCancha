package com.Andrey.Modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdCliente;
	
	@Column(length = 40, nullable = false)
	private String nombreCliente;
	
	@Column(length = 40, nullable = false)
	private String emailCliente;
	
	@Column(length = 10, nullable = false)
	private String telefonoCliente;
	
	@JoinColumn(name="rolCliente")
	@ManyToOne(fetch = FetchType.EAGER)
	private Rol RolCliente;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	public Usuario(Long idCliente, String nombreCliente, String emailCliente, String telefonoCliente, Rol rolCliente) {
		super();
		IdCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.emailCliente = emailCliente;
		this.telefonoCliente = telefonoCliente;
		RolCliente = rolCliente;
	}
	public Long getIdCliente() {
		return IdCliente;
	}

	public void setIdCliente(Long idCliente) {
		IdCliente = idCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getTelefonoCliente() {
		return telefonoCliente;
	}

	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}

	public Rol getRolCliente() {
		return RolCliente;
	}

	public void setRolCliente(Rol rolCliente) {
		RolCliente = rolCliente;
	}
	
}
 



