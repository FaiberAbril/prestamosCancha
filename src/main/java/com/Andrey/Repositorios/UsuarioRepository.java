package com.Andrey.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Andrey.Modelos.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

    
