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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", columnDefinition = "NVARCHAR(50)", nullable = false)
	@NotBlank(message = "Name should not be null or empty or blank")
	//check for both null as well as empty value
	private String name;
	
	@Column(name = "socialsercuritynumber", unique = true, columnDefinition = "CHAR(12)", nullable = false)
	private String socialsercuritynumber;
	
	@Column(name = "dob", columnDefinition = "DATE", nullable = false)
	private Date dob;
	
	@Column(name = "gender",columnDefinition = "BIT(1)", nullable = false)
	private boolean gender;
	
	@Column(name = "address", columnDefinition = "NVARCHAR(255)", nullable = false)
	private String address;
	
	@Column(name = "phonenumber", unique = true, columnDefinition = "CHAR(10)", nullable = false)
	private String phonenumber;
	
	@Column(name = "email", unique = true, columnDefinition = "VARCHAR(50)", nullable = false)
	private String email;
	
	@Column(name = "username", unique = true, columnDefinition = "VARCHAR(50)", nullable = false)
	private String username;
	
	@Column(name = "password", columnDefinition = "VARCHAR(255)", nullable = false)
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "roleid",columnDefinition = "BIGINT", nullable = false)
	private Role role;
	
	@ManyToOne
	@JoinColumn(name = "statusid",columnDefinition = "BIGINT", nullable = false)
	private Status status;
	
	//not a column in table
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "Users_TrainingNotis", 
		joinColumns = {@JoinColumn(name = "userid", referencedColumnName = "id")}, 
		inverseJoinColumns = {@JoinColumn(name = "trainingnotiid", referencedColumnName = "id")}
	)
	private List<TrainingNoti> trainingNotis;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "Users_Areas", 
			joinColumns = {@JoinColumn(name = "userid", referencedColumnName = "id")}, 
			inverseJoinColumns = {@JoinColumn(name = "areaid", referencedColumnName = "id")}
		)
	private List<Area> areas;
}
