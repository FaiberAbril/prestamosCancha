package com.Andrey.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Andrey.Modelos.Usuario;
import com.Andrey.Repositorios.UsuarioRepository;

@Service
public class usuarioservicios {
	
	@Autowired
	private UsuarioRepository repository;
	
	public void agregarusuario(Usuario usuario) {
		repository.save(usuario);
	}
	
	public List<Usuario> ListarUsuarios(){
		return repository.findAll();
	}
	
	public void eliminarUsuario(int IdCliente) {
		repository.deleteById(IdCliente);
	}
	
	public void actualizarUsuario(Usuario usuario) {
		repository.save(usuario);
	}
	
	public Usuario capturarUsuario(int IdCliente) {
		return repository.findById(IdCliente).get();
	}

}
