package com.stocktaking.EntityBBDD;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.NaturalId;

import com.stocktaking.Enum.Type_TypeValue;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity // Spring le dice al Gestor de Bases de Datos que la siguiente clase es una entidad (Tabla).
@Table(name = "T_Attribute")
public class T_Attribute 
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
	@Column (name = "Description",  unique = false, nullable = false)
	String description;
	
	// Spring JPA le dice al Gestor de Bases de Datos que la siguiente variable Java será un Atributo / Campo de la entidad.
	@Column (name = "ValueType",  unique = false, nullable = false)
	Type_TypeValue valueType;
	
	@OneToMany(mappedBy = "attribute")
	List<T_TypeAttribute> types = new ArrayList<>();
	
	/*
		Zona de Constructores
	*/
	public T_Attribute() 
	{
		super();
	}
	
	public T_Attribute(String name, String description) 
	{
		super();
		this.name = name;
		this.description = description;
	}
	
	public T_Attribute(Long id, String name, String description, Type_TypeValue valueType) 
	{
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.valueType = valueType;
	}
	
	public T_Attribute(Long id, String name, String description, Type_TypeValue valueType, List<T_TypeAttribute> types) 
	{
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.valueType = valueType;
		this.types = types;
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
	
	public String getDescription() 
	{
		return description;
	}
	
	public void setDescription(String description) 
	{
		this.description = description;
	}
	
	public List<T_TypeAttribute> getTypes() 
	{
		return types;
	}
	
	public Type_TypeValue getValueType() 
	{
		return valueType;
	}

	public void setValueType(Type_TypeValue valueType) 
	{
		this.valueType = valueType;
	}

	public void setTypes(List<T_TypeAttribute> types) 
	{
		this.types = types;
	}
	
	public void setAll(String newName, String newDescription) 
	{
		this.name = newName;
		this.description = newDescription;
	}
}
