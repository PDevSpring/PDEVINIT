package com.dari.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_Fourniture")
public class Fourniture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "F_ID")
	private long FournitureId ;
	
	@Column(name = "F_Type")
	@Enumerated(EnumType.STRING)
	private FournitureType type;
	
	@Column(name = "F_Desc")
	private String Description ; 
	
	@Column(name = "F_Price")
	private float Price ;
	
	@Column(name = "F_PubDate")
	private Date pubDate;
	
	private String Image1 ; 
	private String Image2 ; 

}

