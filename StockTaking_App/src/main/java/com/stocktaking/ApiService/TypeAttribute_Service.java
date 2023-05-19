package com.stocktaking.ApiService;

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


	
}
