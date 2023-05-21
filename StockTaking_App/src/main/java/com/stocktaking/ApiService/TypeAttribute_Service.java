package com.stocktaking.ApiService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.stocktaking.ApiRepository.TypeAttribute_Repository;
import com.stocktaking.Entity_DTO.TypeAttribute_Dto;


@Service
public class TypeAttribute_Service 
{
	@Autowired
	TypeAttribute_Repository repositorySql;
	
	
	/*
		Método CreateService.
	*/
	public TypeAttribute_Dto createService(Long typeId, Long attributeId) 
	{
		TypeAttribute_Dto typeAttributeToSave = null;
		try
		{
			typeAttributeToSave = repositorySql.create(typeId, attributeId);
		}
		catch (Exception e)
		{
			e.printStackTrace(); // Muestro por consola la pila detallada de errores.
		}
		
		return typeAttributeToSave;
	}


	/*
	Método deleteId.
	*/
	public TypeAttribute_Dto deleteId(TypeAttribute_Dto deleteEntity) 
	{
		return repositorySql.delete(deleteEntity.getTypeId(), deleteEntity.getAttributeId());
	}
	
	/*
	Método findBy
	*/
	
	public List<TypeAttribute_Dto> findByTypeId(Long id) 
	{
		return repositorySql.findByTypeId(id);
	}
	
	public List<TypeAttribute_Dto> findByAttributeId(Long id) 
	{
		return repositorySql.findByAttributeId(id);
	}
	
	public List<TypeAttribute_Dto> findAll() 
	{
		return repositorySql.findByAttributeId(null);
	}
	
}
