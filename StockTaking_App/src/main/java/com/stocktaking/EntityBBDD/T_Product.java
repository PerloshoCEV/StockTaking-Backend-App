package com.stocktaking.EntityBBDD;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity // Spring le dice al Gestor de Bases de Datos que la siguiente clase es una entidad (Tabla).
@Table(name = "T_Product")
public class T_Product 
{
	/*
		Zona de Atributos
	*/
	@Id // Spring JPA le dice al Gestor de Bases de Datos que la siguiente variable java será el Atributo / Campo clave de la entidad.
	@GeneratedValue(strategy = GenerationType.TABLE) // Spring JPA le dice al Gestor de Bases de Datos que el Atributo será autogenerado.
	Long id; // Variable - Atributo / Campo -> id (Primary Key).
	
	// Spring JPA le dice al Gestor de Bases de Datos que la siguiente variable Java será un Atributo / Campo de la entidad.
	@Column (name = "Name", unique = true, nullable = false)
	String name;
	
	// Spring JPA le dice al Gestor de Bases de Datos que la siguiente variable Java será un Atributo / Campo de la entidad.
	@Column (name = "Description", unique = false, nullable = true)
	String description;
	
	// Spring JPA le dice al Gestor de Bases de Datos que la siguiente variable Java será un Atributo / Campo de la entidad.
	@Column (name = "Stock", unique = false, nullable = false)
	Integer stock;
	
	@ManyToOne()
	@JsonBackReference
	T_Type type;
	
	@OneToMany(mappedBy = "product")
	@JsonIgnoreProperties("product")
	List<T_Bill> clients = new ArrayList<>();
	
	@OneToMany(mappedBy = "product")
	@JsonIgnoreProperties("product")
	List<T_DeliveryNote> suppliers = new ArrayList<>();
	
	/*
		Zona de Constructores
	*/
	public T_Product() 
	{
		super();
	}
	
	public T_Product(String name, Integer stock, T_Type type) 
	{
		super();
		this.name = name;
		this.stock = stock;
		this.type = type;
	}
	
	public T_Product(Long id, String name, Integer stock, T_Type type) 
	{
		super();
		this.id = id;
		this.name = name;
		this.stock = stock;
		this.type = type;
	}
	
	public T_Product(Long id, String name, Integer stock, T_Type type, 
			List<T_Bill> clients,
			List<T_DeliveryNote> suppliers) 
	{
		super();
		this.id = id;
		this.name = name;
		this.stock = stock;
		this.type = type;
		this.clients = clients;
		this.suppliers = suppliers;
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
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStock() 
	{
		return this.stock;
	}
	
	public void setStock(Integer stock) 
	{
		this.stock = stock;
	}
	
	public T_Type getType() 
	{
		return type;
	}
	
	public void setType(T_Type type) 
	{
		this.type = type;
	}
	
	public List<T_Bill> getClients() 
	{
		return clients;
	}
	
	public void setClients(List<T_Bill> clients) 
	{
		this.clients = clients;
	}
	
	public List<T_DeliveryNote> getSuppliers() 
	{
		return suppliers;
	}
	
	public void setSuppliers(List<T_DeliveryNote> suppliers) 
	{
		this.suppliers = suppliers;
	}
	
	public void setAll(String name, String description, Integer stock) 
	{
		this.name = name;
		this.description = description;
		this.stock = stock;
	}
}
