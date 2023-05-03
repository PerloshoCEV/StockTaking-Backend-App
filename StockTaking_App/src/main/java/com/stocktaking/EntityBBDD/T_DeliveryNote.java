package com.stocktaking.EntityBBDD;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity // Spring le dice al Gestor de Bases de Datos que la siguiente clase es una entidad (Tabla).
@Table(name = "T_DeliveryNote")
public class T_DeliveryNote 
{
	/*
		Zona de Atributos
	*/
	@EmbeddedId
	private EmbKey_DeliveryNote id;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("deliveryId")
	private T_Delivery delivery;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("productId")
	private T_Product product;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("supplierId")
	private T_Supplier supplier;
	
	@Column(name = "Quantity")
	private Integer quantity;

	/*
		Zona de Constructores
	*/
	public T_DeliveryNote() 
	{
		super();
	}
	
	public T_DeliveryNote
	(
		T_Delivery delivery, 
		T_Product product, 
		T_Supplier supplier,
		Integer quantity
	) 
	{
		super();
		this.delivery = delivery;
		this.product = product;
		this.supplier = supplier;
		this.quantity = quantity;
	}
	
	public T_DeliveryNote
	(
		EmbKey_DeliveryNote id, 
		T_Delivery delivery, 
		T_Product product, 
		T_Supplier supplier,
		Integer quantity
	) 
	{
		super();
		this.id = id;
		this.delivery = delivery;
		this.product = product;
		this.supplier = supplier;
		this.quantity = quantity;
	}

	/*
		Zona de Getters & Setters
	*/
	public EmbKey_DeliveryNote getId() 
	{
		return id;
	}

	public void setId(EmbKey_DeliveryNote id) 
	{
		this.id = id;
	}

	public T_Delivery getDelivery() 
	{
		return delivery;
	}

	public void setDelivery(T_Delivery delivery) 
	{
		this.delivery = delivery;
	}

	public T_Product getProduct() 
	{
		return product;
	}

	public void setProduct(T_Product product) 
	{
		this.product = product;
	}

	public T_Supplier getSupplier() 
	{
		return supplier;
	}

	public void setSupplier(T_Supplier supplier) 
	{
		this.supplier = supplier;
	}

	public Integer getQuantity() 
	{
		return quantity;
	}

	public void setQuantity(Integer quantity)
	{
		this.quantity = quantity;
	}
	
	
}
