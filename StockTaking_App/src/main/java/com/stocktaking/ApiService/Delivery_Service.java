package com.stocktaking.ApiService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocktaking.ApiRepository.Delivery_Repository;
import com.stocktaking.ApiServiceInterface.Base_ServiceInterface;
import com.stocktaking.EntityBBDD.T_Delivery;
import com.stocktaking.Entity_DTO.Delivery_Dto;

@Service
public class Delivery_Service implements Base_ServiceInterface<T_Delivery, Delivery_Dto>
{
	@Autowired
	Delivery_Repository repository;
	
	@Override
	public Delivery_Dto createBaseService(T_Delivery newDelivery) 
	{
		T_Delivery deliveryToSave = repository.save(newDelivery);
		
		Delivery_Dto deliveryDto = new Delivery_Dto(deliveryToSave);
		
		return deliveryDto;
	}

	@Override
	public List<Delivery_Dto> readBaseAllService() 
	{
		List<T_Delivery> listDeliverys =  repository.findAll();
		List<Delivery_Dto> listDeliverysDto = new ArrayList<Delivery_Dto>();
		
		for (T_Delivery t_Delivery : listDeliverys) 
		{
			Delivery_Dto deliveryDto = new Delivery_Dto(t_Delivery);
			listDeliverysDto.add(deliveryDto);
		}
		
		return listDeliverysDto;
		
	}

	@Override
	public Delivery_Dto readBaseId(Long id) 
	{
		T_Delivery deliveryToRead = repository.getReferenceById(id);
		
		Delivery_Dto deliveryDto = new Delivery_Dto(deliveryToRead);
		
		return deliveryDto;
	}

	@Override
	public Delivery_Dto updateBase(T_Delivery delivery) 
	{
		T_Delivery deliveryToUpdate = repository.getReferenceById(delivery.getId());
		deliveryToUpdate.setDate
			(
				delivery.getDate()
			);
		deliveryToUpdate = repository.save(deliveryToUpdate);
		
		Delivery_Dto deliveryDto = new Delivery_Dto(deliveryToUpdate);
		
		return deliveryDto;
		
	}

	@Override
	public Delivery_Dto deleteBaseId(Delivery_Dto deliveryToDelete) 
	{
		
		Long id = deliveryToDelete.getId();
		
		try
		{
			repository.delete(repository.getReferenceById(id));
		}
		catch (Exception e)
		{
			return null;
		}
		
		return deliveryToDelete;
	}

	@Override
	public Delivery_Dto findBaseByIdService(Long id) 
	{
		Delivery_Dto deliveryDto = null;
		Optional<T_Delivery> finder = repository.findById(id);
		if (finder.isPresent())
		{
			deliveryDto = new Delivery_Dto(finder.get());
		}
		
		return deliveryDto;
	}
}
