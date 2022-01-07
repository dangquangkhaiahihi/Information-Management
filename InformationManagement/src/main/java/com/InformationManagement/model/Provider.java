package com.InformationManagement.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Provider {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", columnDefinition = "NVARCHAR(100)",unique = true, nullable = false)
	private String name;

	// not a column in table
	@OneToMany(mappedBy = "provider", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<License> licenses;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "Providers_LicenseTypes", 
		joinColumns = {@JoinColumn(name = "providerid", referencedColumnName = "id")}, 
		inverseJoinColumns = {@JoinColumn(name = "licensetypeid", referencedColumnName = "id")}
	)
	private List<LicenseType> licenseTypes;
}
