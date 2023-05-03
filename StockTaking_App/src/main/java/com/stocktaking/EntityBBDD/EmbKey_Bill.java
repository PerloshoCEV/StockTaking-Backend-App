package com.stocktaking.EntityBBDD;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class EmbKey_Bill implements Serializable
{
	private static final long serialVersionUID = 1L;

	/*
		Zona de Atributos
	*/
	@Column (name = "Sale_ID")
	private Long saleId;
	
	@Column (name = "Product_ID")
	private Long productId;
	
	@Column (name = "Client_ID")
	private Long clientId;

	/*
		Zona de Constructores
	*/
	public EmbKey_Bill
	(

	) 
	{
		super();
	}
	
	public EmbKey_Bill
	(
		Long saleId, 
		Long productId, 
		Long clientId
	) 
	{
		super();
		this.saleId = saleId;
		this.productId = productId;
		this.clientId = clientId;
	}

	/*
		Zona de Métodos Getters / Setters
	*/
	public Long getSaleId() 
	{
		return saleId;
	}

	public void setSaleId(Long saleId) 
	{
		this.saleId = saleId;
	}

	public Long getProductId() 
	{
		return productId;
	}

	public void setProductId(Long productId) 
	{
		this.productId = productId;
	}

	public Long getClientId() 
	{
		return clientId;
	}

	public void setClientId(Long clientId) 
	{
		this.clientId = clientId;
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
	    
	    EmbKey_Bill that = (EmbKey_Bill) other;
	    
	    return Objects.equals(this.saleId, that.saleId) &&
	    		Objects.equals(this.productId, that.productId) &&
	    		Objects.equals(this.clientId, that.clientId);
	    
	}
	
	@Override
    public int hashCode() 
	{
		return Objects.hash(this.saleId, this.productId, this.clientId);
	}
}
