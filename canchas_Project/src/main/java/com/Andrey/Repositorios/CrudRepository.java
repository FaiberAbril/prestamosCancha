package com.Andrey.Repositorios;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Andrey.Modelos.event;

public interface CrudRepository extends JpaRepository<event, Integer> {
	
		List<event> findAll();
		event save(event event);
		void delete(event event);

		@Query(value = "select b from Event b " +
		         "where b.start between ?1 and ?2 and b.end between ?1 and ?2")
		 List<event> findByDatesBetween(Date start, Date end);
	
}
