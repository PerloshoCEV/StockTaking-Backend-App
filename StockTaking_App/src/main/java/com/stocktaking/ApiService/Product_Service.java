package com.stocktaking.ApiService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocktaking.ApiRepository.Product_Repository;
import com.stocktaking.ApiServiceInterface.Base_ServiceInterface;
import com.stocktaking.EntityBBDD.T_Product;
import com.stocktaking.Entity_DTO.Product_Dto;

@Service
public class Product_Service implements Base_ServiceInterface<T_Product, Product_Dto>
{
	@Autowired
	Product_Repository repository;
	
	@Override
	public Product_Dto createBaseService(T_Product newProduct) 
	{
		try
		{
			T_Product productToSave = repository.save(newProduct);
			
			Product_Dto productDto = new Product_Dto(productToSave);
			
			return productDto;			
		}
		catch (Exception e)
		{
			e.printStackTrace(); // Muestro por consola la pila detallada de errores.
		}
		
		return null;
	}

	@Override
	public List<Product_Dto> readBaseAllService() 
	{
		List<T_Product> listProducts =  repository.findAll();
		List<Product_Dto> listProductsDto = new ArrayList<Product_Dto>();
		
		for (T_Product t_Product : listProducts) 
		{
			Product_Dto productDto = new Product_Dto(t_Product);
			listProductsDto.add(productDto);
		}
		
		return listProductsDto;
	}

	@Override
	public Product_Dto readBaseId(Long id) 
	{
		try
		{
			T_Product productToRead = repository.getReferenceById(id);
			
			Product_Dto productDto = new Product_Dto(productToRead);
			
			return productDto;			
		}
		catch (Exception e)
		{
			e.printStackTrace(); // Muestro por consola la pila detallada de errores.
		}
		
		return null;
	}

	@Override
	public Product_Dto updateBase(T_Product product) 
	{
		try
		{
			T_Product productToUpdate = repository.getReferenceById(product.getId());
			productToUpdate.setAll
			(
					product.getName(), 
					product.getDescription(),
					product.getStock()
					);
			productToUpdate = repository.save(productToUpdate);
			
			Product_Dto productDto = new Product_Dto(productToUpdate);
			
			return productDto;			
		}
		catch (Exception e)
		{
			e.printStackTrace(); // Muestro por consola la pila detallada de errores.
		}
		
		return null;
	}

	@Override
	public Product_Dto deleteBaseId(Product_Dto productToDelete) 
	{
		
		Long id = productToDelete.getId();
		
		try
		{
			repository.delete(repository.getReferenceById(id));
		}
		catch (Exception e)
		{
			return productToDelete;
		}
		
		return null;
	}

	@Override
	public Product_Dto findBaseByIdService(Long id) 
	{
		Product_Dto productDto = null;
		Optional<T_Product> finder = repository.findById(id);
		if (finder.isPresent())
		{
			productDto = new Product_Dto(finder.get());
		}
		
		return productDto;
	}
}
