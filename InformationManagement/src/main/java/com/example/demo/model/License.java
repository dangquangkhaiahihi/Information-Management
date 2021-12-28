package com.example.demo.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class License {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "regno", columnDefinition = "VARCHAR(30)", unique = true, nullable = false)
	private String regno;

	@Lob
	@Column(name = "image", columnDefinition = "BLOB")
	private byte[] image;

	@Column(name = "createddate", columnDefinition = "DATE", nullable = false)
	private Date createddate;

	@ManyToOne
	@JoinColumn(name = "provider", columnDefinition = "BIGINT", nullable = false)
	private Provider provider;

	// not a column in table
	@ManyToMany(mappedBy = "licenses", fetch = FetchType.LAZY)
	private List<BusinessPremises> businessPremises;
}
