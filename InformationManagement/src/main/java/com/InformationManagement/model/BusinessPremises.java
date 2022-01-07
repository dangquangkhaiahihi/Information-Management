package com.InformationManagement.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
public class BusinessPremises {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", columnDefinition = "NVARCHAR(255)", nullable = false)
	private String name;
	
	@Column(name = "address", columnDefinition = "NVARCHAR(255)", nullable = false)
	private String address;
	
	@Column(name = "warning_status", columnDefinition = "BOOLEAN", nullable = false)
	private boolean warningStatus;
	
	@Column(name = "warning_content", columnDefinition = "NVARCHAR(255)  default 'hiện tại chưa có'", nullable = false)
	private String warningContent;
	
	@Lob
	@Column(name = "image", columnDefinition = "BLOB")
	private byte[] image;
	
	@ManyToOne
	@JoinColumn(name = "area", columnDefinition = "BIGINT", nullable = false)
	private Area area;
	
	@ManyToOne
	@JoinColumn(name = "bussiness_type", columnDefinition = "BIGINT", nullable = false)
	private BusinessType bussinessType;
	
	// not a column in table
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "BusinessPremises_Licenses", 
		joinColumns = {@JoinColumn(name = "businesspremisesid", referencedColumnName = "id")}, 
		inverseJoinColumns = {@JoinColumn(name = "licenseid", referencedColumnName = "id")}
	)
	private List<License> licenses;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "BusinessPremises_People", 
		joinColumns = {@JoinColumn(name = "businesspremisesid", referencedColumnName = "id")}, 
		inverseJoinColumns = {@JoinColumn(name = "personid", referencedColumnName = "id")}
	)
	private List<Person> people;
	
}
