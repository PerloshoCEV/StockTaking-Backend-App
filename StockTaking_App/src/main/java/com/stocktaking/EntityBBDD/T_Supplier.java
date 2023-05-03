package com.stocktaking.EntityBBDD;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity // Spring le dice al Gestor de Bases de Datos que la siguiente clase es una entidad (Tabla).
@Table(name = "T_Supplier")
public class T_Supplier 
{
	/*
		Zona de Atributos
	*/
	@Id // Spring JPA le dice al Gestor de Bases de Datos que la siguiente variable java será el Atributo / Campo clave de la entidad.
	@GeneratedValue(strategy = GenerationType.TABLE) // Spring JPA le dice al Gestor de Bases de Datos que el Atributo será autogenerado.
	Long id; // Variable - Atributo / Campo -> id (Primary Key).
	
	// Spring JPA le dice al Gestor de Bases de Datos que la siguiente variable Java será un Atributo / Campo de la entidad.
	@Column (name = "Name", unique = false, nullable = false)
	String name;
	
	// Spring JPA le dice al Gestor de Bases de Datos que la siguiente variable Java será un Atributo / Campo de la entidad.
	@Column (name = "Email", unique = true, nullable = false)
	@NaturalId
	String email;
	
	// Spring JPA le dice al Gestor de Bases de Datos que la siguiente variable Java será un Atributo / Campo de la entidad.
	@Column (name = "Address", unique = true, nullable = false)
	@NaturalId
	String address;
	
	// Spring JPA le dice al Gestor de Bases de Datos que la siguiente variable Java será un Atributo / Campo de la entidad.
	@Column (name = "Description", unique = false, nullable = true)
	String description;
	
	@OneToMany(mappedBy = "supplier")
	List<T_DeliveryNote> products = new ArrayList<>();
	
	/*
		Zona de Constructores
	*/
	public T_Supplier() 
	{
		super();
	}
	
	public T_Supplier(String name, String email, String address, String description) 
	{
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.description = description;
	}
	
	public T_Supplier(Long id, String name, String email, String address, String description) 
	{
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.description = description;
	}
	
	public T_Supplier(Long id, String name, String email, String address, String description,
			List<T_DeliveryNote> products) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.description = description;
		this.products = products;
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
	
	public String getEmail() 
	{
		return email;
	}
	
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	public String getAddress() 
	{
		return address;
	}
	
	public void setAddress(String address) 
	{
		this.address = address;
	}
	
	public String getDescription() 
	{
		return description;
	}
	
	public void setDescription(String description) 
	{
		this.description = description;
	}
	
	public List<T_DeliveryNote> getProducts() 
	{
		return products;
	}
	
	public void setProducts(List<T_DeliveryNote> products) 
	{
		this.products = products;
	}
	
	
	public void setAll(String name, String email, String address, String description) 
	{
		this.name = name;
		this.email = email;
		this.address = address;
		this.description = description;
	}
}
