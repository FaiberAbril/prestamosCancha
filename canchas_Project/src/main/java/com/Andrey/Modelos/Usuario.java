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
@Table(name="usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdUsuario;
	
	@Column(length = 40, nullable = false)
	private String nombreUsuario;
	
	@Column(length = 40, nullable = false)
	private String emailUsuario;
	
	@Column(length = 10, nullable = false)
	private String telefonoUsuario;
	
	@JoinColumn(name="rolCliente")
	@ManyToOne(fetch = FetchType.EAGER)
	private Rol RolCliente;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(Long idUsuario, String nombreUsuario, String emailUsuario, String telefonoUsuario, Rol rolCliente) {
		super();
		IdUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.emailUsuario = emailUsuario;
		this.telefonoUsuario = telefonoUsuario;
		RolCliente = rolCliente;
	}

	public Long getIdUsuario() {
		return IdUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		IdUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getTelefonoUsuario() {
		return telefonoUsuario;
	}

	public void setTelefonoUsuario(String telefonoUsuario) {
		this.telefonoUsuario = telefonoUsuario;
	}

	public Rol getRolCliente() {
		return RolCliente;
	}

	public void setRolCliente(Rol rolCliente) {
		RolCliente = rolCliente;
	}


}
 



