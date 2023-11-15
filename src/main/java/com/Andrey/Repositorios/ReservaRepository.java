package com.Andrey.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Andrey.Modelos.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

}
