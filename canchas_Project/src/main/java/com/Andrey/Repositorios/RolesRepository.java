package com.Andrey.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Andrey.Modelos.Rol;

@Repository
public interface RolesRepository extends JpaRepository<Rol, Long>{

}
