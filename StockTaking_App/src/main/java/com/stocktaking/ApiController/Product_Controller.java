package com.stocktaking.ApiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stocktaking.ApiControllerInterface.Product_ControllerInterface;
import com.stocktaking.ApiService.Product_Service;
import com.stocktaking.EntityBBDD.T_Product;
import com.stocktaking.Entity_DTO.Product_Dto;
import com.stocktaking.Enum.MessageResult;
import com.stocktaking.Response.ApiResponse;
import com.stocktaking.Response.Metadata;

@RestController
public class Product_Controller implements Product_ControllerInterface
{
	@Autowired
	Product_Service productService;

	public Product_Controller()
	{
		super();
	}
	
	@Override
	@PostMapping(path = "/product")
	public ApiResponse<Product_Dto> createEntityController(T_Product newProduct) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Product_Dto> response = new ApiResponse<Product_Dto>(meta);
				
		if (newProduct != null)
		{
			// Si no tiene id
			if(newProduct.getId() == null)
			{
				response.setResponse(productService.createBaseService(newProduct));
				
				if (response.getResponse() != null)
				{
					response.setMessage(MessageResult.Success);
				}
			}
		}
		return response;
	}

	@Override
	@GetMapping(path = "/allproducts")
	public ApiResponse<List<Product_Dto>> readAllEntityController() 
	{
		Metadata meta = new Metadata();
		ApiResponse<List<Product_Dto>> response = 
			new ApiResponse<List<Product_Dto>>
				(productService.readBaseAllService(), meta);
		
		return response;
	}

	@Override
	@GetMapping(path = "/product")
	public ApiResponse<Product_Dto> readEntityIdController(Long id) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Product_Dto> response = new ApiResponse<Product_Dto>(meta);

		response.setResponse(productService.findBaseByIdService(id));

		if (response.getResponse() != null)
		{
			response.setMessage(MessageResult.Success);
		}
		
		return response;
	}

	@PutMapping(path = "/product")
	@Override
	public ApiResponse<Product_Dto> updateEntityController(T_Product productToModify) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Product_Dto> response = new ApiResponse<Product_Dto>(meta);
		
		response.setResponse(productService.updateBase(productToModify));
		
		if (response.getResponse() != null)
		{
			response.setMessage(MessageResult.Success);
		}
		
		return response;
	}

	@Override
	@DeleteMapping(path = "/product")
	public ApiResponse<Product_Dto> deleteEntityId(Long id) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Product_Dto> response = new ApiResponse<Product_Dto>(meta);
		
		
		if(id != null)
		{
			Product_Dto productToDelete = productService.findBaseByIdService(id);
				
			response.setResponse(productService.deleteBaseId(productToDelete));
			
			if (response.getResponse() != null)
			{
				response.setMessage(MessageResult.Success);
			}
		}
		return response;
	}
}
