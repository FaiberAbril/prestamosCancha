package com.Andrey.Repositorios;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Andrey.Modelos.event;


@Repository
public interface eventRepository extends JpaRepository<event, Integer> {
		
		/* Note these two methods do the same thing.  The @Repository annotation handles both*/
		
		/* This one uses a JPQL */
		public List<event> findByStartGreaterThanEqualAndFinishLessThanEqual(LocalDateTime start, LocalDateTime finish);
		
		
		/* This one uses an @Query */
		@Query
		public List<event> findBystartBetween(LocalDateTime start, LocalDateTime finish);
		

		
		

		
	
}
