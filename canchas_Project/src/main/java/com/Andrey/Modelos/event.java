package com.Andrey.Modelos;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="event")
public class event {
	
		@Id 
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id")
		private int id;
		
		@Column(name="title")
		private String title; 
		
		@Column(name="description")
		private String description;
		
		@Column(name="start")
		private LocalDateTime start; 
		
		@Column(name="finish")
		private LocalDateTime finish;
		
		public event() {
			// TODO Auto-generated constructor stub
		}

		public event(int id, String title, String description, LocalDateTime start, LocalDateTime finish) {
			super();
			this.id = id;
			this.title = title;
			this.description = description;
			this.start = start;
			this.finish = finish;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public LocalDateTime getStart() {
			return start;
		}

		public void setStart(LocalDateTime start) {
			this.start = start;
		}

		public LocalDateTime getFinish() {
			return finish;
		}

		public void setFinish(LocalDateTime finish) {
			this.finish = finish;
		}
		
		
		
		
	
		
	
		
		
}
