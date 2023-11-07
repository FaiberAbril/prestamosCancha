package com.Andrey.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Andrey.Modelos.Cancha;


@Repository
public interface CanchaSinteticaRepository extends JpaRepository<Cancha, Long> {
	}

