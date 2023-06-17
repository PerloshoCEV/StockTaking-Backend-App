package com.stocktaking.ApiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stocktaking.ApiControllerInterface.ProductAttribute_ControllerInterface;
import com.stocktaking.ApiService.ProductAttribute_Service;
import com.stocktaking.ApiService.Product_Service;
import com.stocktaking.Entity_DTO.ProductAttribute_Dto;
import com.stocktaking.Enum.MessageResult;
import com.stocktaking.Response.ApiResponse;
import com.stocktaking.Response.Metadata;

@RestController
public class ProductAttribute_Controller implements ProductAttribute_ControllerInterface
{
	@Autowired
	ProductAttribute_Service service;
	@Autowired
	Product_Service productService;

	@Override
	@PutMapping(path = "/productattribute")
	public ApiResponse<ProductAttribute_Dto> createUpdate(ProductAttribute_Dto entity) 
	{
		Metadata meta = new Metadata();
		ApiResponse<ProductAttribute_Dto> response = new ApiResponse<ProductAttribute_Dto>(meta);
		if (entity != null)
		{
			if (entity.getProductId() != null && entity.getAttributeId() != null)
			{
				// Si no encuentra una tupla ProductAttribute Where productId AND attributeID -> Crear
				if (service.countOfAttributeForProduct(entity.getProductId(),entity.getAttributeId()) == 0)
				{
					response.setResponse(service.createValueAttribute(entity.getProductId(), entity.getAttributeId(), entity.getValue()));
				}
				else // Si existe: Modificar
				{
					response.setResponse(service.updateValueAttribute(entity.getProductId(), entity.getAttributeId(), entity.getValue()));
					
				}
				
				if (response.getResponse() != null)
				{
					response.setMessage(MessageResult.Success);
				}
				
			}
		}
		return response;
	}
	
	
	@Override
	@GetMapping(path = "/allproductattribute")
	public ApiResponse<List<ProductAttribute_Dto>> readAll() 
	{
		
		return null;
	}

	@Override
	@GetMapping(path = "/productattribute")
	public ApiResponse<List<ProductAttribute_Dto>> readOneProduct(ProductAttribute_Dto entity) 
	{
		Metadata meta = new Metadata();
		ApiResponse<List<ProductAttribute_Dto>> response = new ApiResponse<List<ProductAttribute_Dto>>(meta);

		response.setResponse(service.readByProductId(entity));
		
		if (response.getResponse() != null)
		{
			response.setMessage(MessageResult.Success);
		}
		
		return response;
	}

	@Override
	@GetMapping(path = "/productattributeAndroid")
	public ApiResponse<List<ProductAttribute_Dto>> readOneProductAndroid(Long productId) 
	{
		Metadata meta = new Metadata();
		ApiResponse<List<ProductAttribute_Dto>> response = new ApiResponse<List<ProductAttribute_Dto>>(meta);
		ProductAttribute_Dto entity = new ProductAttribute_Dto();
		entity.setProductId(productId);
		response.setResponse(service.readByProductId(entity));
		
		if (response.getResponse() != null)
		{
			response.setMessage(MessageResult.Success);
		}
		
		return response;
	}
	
	@GetMapping(path = "/prueba")
	public Integer countOfAttributeForProduct (@RequestParam Long productId, @RequestParam Long attributeId)
	{
		return service.countOfAttributeForProduct(productId, attributeId);
	}

	/*
	@Override
	@PutMapping(path = "/productattribute")
	public ApiResponse<ProductAttribute_Dto> Update(ProductAttribute_Dto entity) 
	{
		// TODO Auto-generated method stub
		return null;
	}
	*/
	
	@Override
	@DeleteMapping(path = "/productattribute")
	public ApiResponse<ProductAttribute_Dto> Delete(ProductAttribute_Dto entity) 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
