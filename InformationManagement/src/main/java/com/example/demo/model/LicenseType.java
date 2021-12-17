package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class LicenseType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "type", columnDefinition = "NVARCHAR(100)", unique = true, nullable = false)
	private String name;

	// not a column in table

	@ManyToMany(mappedBy = "licenseTypes", fetch = FetchType.LAZY)
	private List<Provider> providers;
}
