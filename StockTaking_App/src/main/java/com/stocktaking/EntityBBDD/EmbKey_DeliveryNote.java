package com.stocktaking.EntityBBDD;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class EmbKey_DeliveryNote implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	/*
		Zona de Atributos
	*/
	@Column (name = "Delivery_ID")
	private Long deliveryId;
	
	@Column (name = "Product_ID")
	private Long productId;
	
	@Column (name = "Supplier_ID")
	private Long supplierId;

	/*
		Zona de Constructores
	*/
	public EmbKey_DeliveryNote() 
	{
		super();
	}
	public EmbKey_DeliveryNote(Long deliveryId, Long productId, Long supplierId) 
	{
		super();
		this.deliveryId = deliveryId;
		this.productId = productId;
		this.supplierId = supplierId;
	}
	
	/*
		Zona de Getters & Setters
	*/
	public Long getDeliveryId() 
	{
		return deliveryId;
	}
	public void setDeliveryId(Long deliveryId) 
	{
		this.deliveryId = deliveryId;
	}
	public Long getProductId() 
	{
		return productId;
	}
	public void setProductId(Long productId) 
	{
		this.productId = productId;
	}
	public Long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Long supplierId) 
	{
		this.supplierId = supplierId;
	}
	
	
	/*
		Zona de Métodos a implementar
	*/
	@Override
	public boolean equals(Object other) 
	{
	    if (this == other) 
		{
	    	return true;
		}
	
	    if (other == null || getClass() != other.getClass())
	    {
	    	return false;	    	
	    }
	    
	    EmbKey_DeliveryNote that = 
	    		(EmbKey_DeliveryNote) other;
	    return Objects.equals(this.deliveryId, that.deliveryId) &&
	    		Objects.equals(this.productId, that.productId) &&
	    		Objects.equals(this.supplierId, that.supplierId);
	}
	
	@Override
    public int hashCode() 
	{
		return Objects.hash(this.deliveryId, this.productId, this.supplierId);
	}
	
}
