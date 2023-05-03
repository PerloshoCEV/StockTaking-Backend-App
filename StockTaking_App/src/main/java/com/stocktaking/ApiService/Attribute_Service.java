package com.stocktaking.ApiService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocktaking.ApiRepository.Attribute_Repository;
import com.stocktaking.ApiServiceInterface.Base_ServiceInterface;
import com.stocktaking.EntityBBDD.T_Attribute;
import com.stocktaking.Entity_DTO.Attribute_Dto;

@Service
public class Attribute_Service implements Base_ServiceInterface<T_Attribute, Attribute_Dto>
{
	@Autowired
	Attribute_Repository repository;
	
	@Override
	public Attribute_Dto createBaseService(T_Attribute newAttribute) 
	{
		T_Attribute attributeToSave = repository.save(newAttribute);
		
		Attribute_Dto attributeDto = new Attribute_Dto(attributeToSave);
		
		return attributeDto;
	}

	@Override
	public List<Attribute_Dto> readBaseAllService() 
	{
		List<T_Attribute> listAttributes =  repository.findAll();
		List<Attribute_Dto> listAttributesDto = new ArrayList<Attribute_Dto>();
		
		for (T_Attribute t_Attribute : listAttributes) 
		{
			Attribute_Dto attributeDto = new Attribute_Dto(t_Attribute);
			listAttributesDto.add(attributeDto);
		}
		
		return listAttributesDto;
		
	}

	@Override
	public Attribute_Dto readBaseId(Long id) 
	{
		T_Attribute attributeToRead = repository.getReferenceById(id);
		
		Attribute_Dto attributeDto = new Attribute_Dto(attributeToRead);
		
		return attributeDto;
	}

	@Override
	public Attribute_Dto updateBase(T_Attribute attribute) 
	{
		T_Attribute attributeToUpdate = repository.getReferenceById(attribute.getId());
		attributeToUpdate.setAll
			(
				attribute.getName(), 
				attribute.getDescription()
			);
		attributeToUpdate = repository.save(attributeToUpdate);
		
		Attribute_Dto attributeDto = new Attribute_Dto(attributeToUpdate);
		
		return attributeDto;
		
	}

	@Override
	public Attribute_Dto deleteBaseId(Attribute_Dto attributeToDelete) 
	{
		
		Long id = attributeToDelete.getId();
		
		try
		{
			repository.delete(repository.getReferenceById(id));
		}
		catch (Exception e)
		{
			return null;
		}
		
		return attributeToDelete;
	}

	@Override
	public Attribute_Dto findBaseByIdService(Long id) 
	{
		Attribute_Dto attributeDto = null;
		Optional<T_Attribute> finder = repository.findById(id);
		if (finder.isPresent())
		{
			attributeDto = new Attribute_Dto(finder.get());
		}
		
		return attributeDto;
	}
}
