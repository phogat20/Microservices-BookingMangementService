package com.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Table(name = "ms_users")
@Data
public class User {
	@Id
	@Column(name = "ID")
	private String userId;
	
	@Column(name = "NAME",length = 20)
	private String name;

	@Column(name = "EMAIL",length = 20)
	private String email;
	
	@Column(name = "ABOUT",length = 50)
	private String about;
	
	@Transient
	private List<Rating> ratings;
	
}
