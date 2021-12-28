package com.example.demo.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class TrainingNoti {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	

	@Column(name = "title", columnDefinition = "NVARCHAR(255)")
	private String title;

	@Column(name = "content", columnDefinition = "NVARCHAR(255)", nullable = false)
	private String content;

	@Column(name = "createddate",columnDefinition = "DATETIME", nullable = false)
	private Timestamp createddate;

	// not a column in table
	@ManyToMany(mappedBy = "trainingNotis", fetch = FetchType.LAZY)
	private List<User> users;
}
