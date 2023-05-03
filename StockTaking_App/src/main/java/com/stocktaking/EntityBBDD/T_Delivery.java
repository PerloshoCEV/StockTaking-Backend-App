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
@Table(name = "T_Delivery")
public class T_Delivery 
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
	
	@OneToMany(mappedBy = "delivery")
	@JsonIgnoreProperties("delivery")
	private List<T_DeliveryNote> deliveryNote = new ArrayList<T_DeliveryNote>();
	
	/*
		Zona de Constructores
	*/
	public T_Delivery() 
	{
		super();
	}
	
	public T_Delivery(Long id, Date date) 
	{
		super();
		this.id = id;
		this.date = date;
	}
	
	public T_Delivery(Long id, Date date, List<T_DeliveryNote> deliveryNote) 
	{
		super();
		this.id = id;
		this.date = date;
		this.deliveryNote = deliveryNote;
	}

	/*
		Zona de Getters & Setters
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

	public List<T_DeliveryNote> getDeliveryNote() 
	{
		return deliveryNote;
	}

	public void setDeliveryNote(List<T_DeliveryNote> deliveryNote) 
	{
		this.deliveryNote = deliveryNote;
	}
}
