package com.stocktaking.EntityBBDD;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity // Spring le dice al Gestor de Bases de Datos que la siguiente clase es una entidad (Tabla).
@Table(name = "T_Sale")
public class T_Sale 
{
	/*
		Zona de Atributos
	*/
	@Id // Spring JPA le dice al Gestor de Bases de Datos que la siguiente variable java será el Atributo / Campo clave de la entidad.
	@GeneratedValue(strategy = GenerationType.TABLE) // Spring JPA le dice al Gestor de Bases de Datos que el Atributo será autogenerado.
	private Long id; // Variable - Atributo / Campo -> id (Primary Key).

	// Spring JPA le dice al Gestor de Bases de Datos que la siguiente variable Java será un Atributo / Campo de la entidad.
	@Column (name = "Date", unique = false, nullable = true)
	private Date date;
	
	@OneToMany(mappedBy = "sale")
	@JsonIgnoreProperties("sale")
	private List<T_Bill> bill = new ArrayList<T_Bill>();

	/*
		Zona de Constructores
	*/
	public T_Sale() 
	{
		super();


	}
	
	public T_Sale(Long id, Date date) 
	{
		super();
		this.id = id;
		this.date = date;
	}
	
	public T_Sale(Long id, Date date, List<T_Bill> bill) 
	{
		super();
		this.id = id;
		this.date = date;
		this.bill = bill;
	}

	/*
		Zona de Métodos Getters / Setters
	*/
	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Date getDate() 
	{
		return date;
	}

	public void setDate(Date date) 
	{
		this.date = date;
	}

	public List<T_Bill> getBill() 
	{
		return bill;
	}

	public void setBill(List<T_Bill> bill) 
	{
		this.bill = bill;
	}
	
	
}
