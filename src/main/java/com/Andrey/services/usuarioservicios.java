package com.Andrey.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Andrey.Modelos.Usuario;
import com.Andrey.Repositorios.clienteRepository;



@Service
public class UsuarioServicios {

	@Autowired
	private clienteRepository clienteRepository;
	
	public void CrearUsuario(Usuario cliente) {
		clienteRepository.save(cliente);
	}
	
	public void ActualizarUsuario(Usuario cliente) {
		clienteRepository.save(cliente);
	}
	
	public void EliminarUsuario(Long IdUsuario) {
		clienteRepository.deleteById(IdUsuario);
	}
	
	public Usuario BuscarUsuario(Long IdUsuario) {
		return clienteRepository.findById(IdUsuario).get();
	}
	
	public List<Usuario> ListarUsuarios(){
		return clienteRepository.findAll();
	}
	
}
