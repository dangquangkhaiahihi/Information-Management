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
public class BusinessType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "type", columnDefinition = "NVARCHAR(100)", unique = true, nullable = false)
	private String type;

	// not a column in table
	@OneToMany(mappedBy = "bussinessType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<BusinessPremises> businessPremises;
}
