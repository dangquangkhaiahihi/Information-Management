package com.InformationManagement.model;

import java.sql.Date;
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
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", columnDefinition = "NVARCHAR(50)", nullable = false)
	private String name;

	@Column(name = "socialsercuritynumber", unique = true, columnDefinition = "CHAR(12)", nullable = false)
	private String socialsercuritynumber;

	@Column(name = "dob",columnDefinition = "DATE", nullable = false)
	private Date dob;

	@Column(name = "phonenumber", unique = true, columnDefinition = "CHAR(10)", nullable = false)
	private String phonenumber;

	@Column(name = "email", unique = true, columnDefinition = "VARCHAR(50)", nullable = false)
	private String email;

	@Lob
	@Column(name = "image", columnDefinition = "BLOB", nullable = false)
	private byte[] image;

	@ManyToOne
	@JoinColumn(name = "position",columnDefinition = "BIGINT", nullable = false)
	private Position position;

	// not a column in table
	@ManyToMany(mappedBy = "people", fetch = FetchType.LAZY)
	private List<BusinessPremises> BusinessPremises;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Notis_People", joinColumns = {
			@JoinColumn(name = "personid", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "notiid", referencedColumnName = "id") })
	private List<Noti> notis;
}
