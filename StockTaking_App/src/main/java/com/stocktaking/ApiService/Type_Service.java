package com.stocktaking.ApiService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocktaking.ApiRepository.Type_Repository;
import com.stocktaking.ApiServiceInterface.Base_ServiceInterface;
import com.stocktaking.EntityBBDD.T_Type;
import com.stocktaking.Entity_DTO.Type_Dto;

@Service
public class Type_Service implements Base_ServiceInterface<T_Type, Type_Dto>
{
	@Autowired
	Type_Repository repository;
	
	@Override
	public Type_Dto createBaseService(T_Type newType) 
	{
		try
		{
			T_Type typeToSave = repository.save(newType);
			
			Type_Dto typeDto = new Type_Dto(typeToSave);
			
			return typeDto;			
		}
		catch (Exception e)
		{
			e.printStackTrace(); // Muestro por consola la pila detallada de errores.
		}
		
		return null;
	}

	@Override
	public List<Type_Dto> readBaseAllService() 
	{
		List<T_Type> listTypes =  repository.findAll();
		List<Type_Dto> listTypesDto = new ArrayList<Type_Dto>();
		
		for (T_Type t_Type : listTypes) 
		{
			Type_Dto typeDto = new Type_Dto(t_Type);
			listTypesDto.add(typeDto);
		}
		
		return listTypesDto;
		
	}

	@Override
	public Type_Dto readBaseId(Long id) 
	{
		try
		{
			T_Type typeToRead = repository.getReferenceById(id);
			
			Type_Dto typeDto = new Type_Dto(typeToRead);
			
			return typeDto;			
		}
		catch (Exception e)
		{
			e.printStackTrace(); // Muestro por consola la pila detallada de errores.
		}
		
		return null;
	}

	@Override
	public Type_Dto updateBase(T_Type type) 
	{
		try
		{
			T_Type typeToUpdate = repository.getReferenceById(type.getId());
			typeToUpdate.setAll
			(
					type.getName(), 
					type.getDescription()
					);
			typeToUpdate = repository.save(typeToUpdate);
			
			Type_Dto typeDto = new Type_Dto(typeToUpdate);
			
			return typeDto;			
		}
		catch (Exception e)
		{
			e.printStackTrace(); // Muestro por consola la pila detallada de errores.
		}
		
		return null;
	}

	@Override
	public Type_Dto deleteBaseId(Type_Dto typeToDelete) 
	{
		
		Long id = typeToDelete.getId();
		
		try
		{
			repository.delete(repository.getReferenceById(id));
		}
		catch (Exception e)
		{
			return typeToDelete;
		}
		
		return null;
	}

	@Override
	public Type_Dto findBaseByIdService(Long id) 
	{
		Type_Dto typeDto = null;
		Optional<T_Type> finder = repository.findById(id);
		if (finder.isPresent())
		{
			typeDto = new Type_Dto(finder.get());
		}
		
		return typeDto;
	}
}
