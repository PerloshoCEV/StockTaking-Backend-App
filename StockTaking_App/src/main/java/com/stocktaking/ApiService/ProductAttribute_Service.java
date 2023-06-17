package com.stocktaking.ApiService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocktaking.ApiRepository.ProductAttribute_Repository;
import com.stocktaking.Entity_DTO.ProductAttribute_Dto;

@Service
public class ProductAttribute_Service 
{


	@Autowired
	ProductAttribute_Repository repositorySql;
	
	/*
		Método CreateService.
	*/
	public ProductAttribute_Dto createValueAttribute(Long productId, Long attributeId, String value) 
	{
		ProductAttribute_Dto ProductAttributeToSave = null;
		try
		{
			ProductAttributeToSave = repositorySql.create(productId, attributeId, value);
		}
		catch (Exception e)
		{
			e.printStackTrace(); // Muestro por consola la pila detallada de errores.
		}
		
		return ProductAttributeToSave;
	}
	
	public ProductAttribute_Dto updateValueAttribute(Long productId, Long attributeId, String value) 
	{
		ProductAttribute_Dto ProductAttributeToSave = null;
		try
		{
			ProductAttributeToSave = repositorySql.update(productId, attributeId, value);
		}
		catch (Exception e)
		{
			e.printStackTrace(); // Muestro por consola la pila detallada de errores.
		}
		
		return ProductAttributeToSave;
	}

	
	/*
	Método findByProductId.
	*/
	
	public List<ProductAttribute_Dto> readByProductId(ProductAttribute_Dto id) 
	{
		return repositorySql.findByProductId(id.getProductId());
	}
	
	/*
	Método findByAttributeId.
	*/
	
	public List<ProductAttribute_Dto> findByAttributeId(ProductAttribute_Dto id) 
	{
		return repositorySql.findByAttributeId(id.getAttributeId());
	}
	
	public int countOfAttributeForProduct (Long productId, Long attributeId)
	{
		return repositorySql.countOfAttributeForProduct(productId, attributeId);
	}
	
	/*
	Aumentar, disminuir una unidad en value.
	*/

}
