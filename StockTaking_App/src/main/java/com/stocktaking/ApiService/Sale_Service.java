package com.stocktaking.ApiService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocktaking.ApiRepository.Sale_Repository;
import com.stocktaking.ApiServiceInterface.Base_ServiceInterface;
import com.stocktaking.EntityBBDD.T_Sale;
import com.stocktaking.Entity_DTO.Sale_Dto;

@Service
public class Sale_Service implements Base_ServiceInterface<T_Sale, Sale_Dto> 
{
	@Autowired
	Sale_Repository repository;
	
	@Override
	public Sale_Dto createBaseService(T_Sale newSale) 
	{
		try
		{
			T_Sale saleToSave = repository.save(newSale);
			
			Sale_Dto saleDto = new Sale_Dto(saleToSave);
			
			return saleDto;			
		}
		catch (Exception e)
		{
			e.printStackTrace(); // Muestro por consola la pila detallada de errores.
		}
		
		return null;
	}

	@Override
	public List<Sale_Dto> readBaseAllService() 
	{
		List<T_Sale> listSales =  repository.findAll();
		List<Sale_Dto> listSalesDto = new ArrayList<Sale_Dto>();
		
		for (T_Sale t_Sale : listSales) 
		{
			Sale_Dto saleDto = new Sale_Dto(t_Sale);
			listSalesDto.add(saleDto);
		}
		
		return listSalesDto;
		
	}

	@Override
	public Sale_Dto readBaseId(Long id) 
	{
		try
		{
			T_Sale saleToRead = repository.getReferenceById(id);
			
			Sale_Dto saleDto = new Sale_Dto(saleToRead);
			
			return saleDto;			
		}
		catch (Exception e)
		{
			e.printStackTrace(); // Muestro por consola la pila detallada de errores.
		}
		
		return null;
	}

	@Override
	public Sale_Dto updateBase(T_Sale sale) 
	{
		try
		{
			T_Sale saleToUpdate = repository.getReferenceById(sale.getId());
			saleToUpdate.setDate
			(
					sale.getDate()
					);
			saleToUpdate = repository.save(saleToUpdate);
			
			Sale_Dto saleDto = new Sale_Dto(saleToUpdate);
			
			return saleDto;			
		}
		catch (Exception e)
		{
			e.printStackTrace(); // Muestro por consola la pila detallada de errores.
		}
		
		return null;
	}

	@Override
	public Sale_Dto deleteBaseId(Sale_Dto saleToDelete) 
	{
		
		Long id = saleToDelete.getId();
		
		try
		{
			repository.delete(repository.getReferenceById(id));
		}
		catch (Exception e)
		{
			return saleToDelete;
		}
		
		return null;
	}

	@Override
	public Sale_Dto findBaseByIdService(Long id) 
	{
		Sale_Dto saleDto = null;
		Optional<T_Sale> finder = repository.findById(id);
		if (finder.isPresent())
		{
			saleDto = new Sale_Dto(finder.get());
		}
		
		return saleDto;
	}
}
