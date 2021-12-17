package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Status {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "status", columnDefinition = "CHAR(10)", unique = true, nullable = false)
	private String status;

	// not a column in table
	@OneToMany(mappedBy = "status", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<User> users;
}
