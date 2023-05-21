package com.stocktaking.EntityBBDD;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class EmbKey_ProductAttribute implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	/*
		Zona de Atributos
	*/
	@Column (name = "Product_ID")
	private Long productId;
	
	@Column (name = "Attribute_ID")
	private Long attributeId;

	/*
		Zona de Constructores
	*/
	public EmbKey_ProductAttribute() 
	{
	}
	
	public EmbKey_ProductAttribute(Long productId, Long attributeId) 
	{
		this.productId = productId;
		this.attributeId = attributeId;
	}
	
	/*
		Zona de Getters & Setters
	*/
	public Long getProductId() 
	{
		return productId;
	}

	public void setProductId(Long productId) 
	{
		this.productId = productId;
	}

	public Long getAttributeId() 
	{
		return attributeId;
	}

	public void setAttributeId(Long attributeId) 
	{
		this.attributeId = attributeId;
	}

	public static long getSerialversionuid() 
	{
		return serialVersionUID;
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
        
        EmbKey_ProductAttribute that = 
        		(EmbKey_ProductAttribute) other;
        return Objects.equals(productId, that.productId) &&
        		Objects.equals(attributeId, that.attributeId);
	}
	
	@Override
    public int hashCode() 
	{
		return Objects.hash(this.productId, this.attributeId);
	}
	
}
