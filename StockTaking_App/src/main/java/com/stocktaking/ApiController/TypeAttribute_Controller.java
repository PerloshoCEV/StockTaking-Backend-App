package com.stocktaking.ApiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stocktaking.ApiControllerInterface.TypeAttribute_ControllerInterface;
import com.stocktaking.ApiService.Attribute_Service;
import com.stocktaking.ApiService.TypeAttribute_Service;
import com.stocktaking.ApiService.Type_Service;
import com.stocktaking.Entity_DTO.TypeAttribute_Dto;
import com.stocktaking.Enum.MessageResult;
import com.stocktaking.Response.ApiResponse;
import com.stocktaking.Response.Metadata;

@RestController
public class TypeAttribute_Controller implements TypeAttribute_ControllerInterface 
{
	@Autowired
	TypeAttribute_Service typeAttribute_Service;
	@Autowired
	Type_Service type_Service;
	@Autowired
	Attribute_Service attribute_Service;
	
	@Override
	@PostMapping(path = "/typeattribute")
	public ApiResponse<TypeAttribute_Dto> create(TypeAttribute_Dto newTypeAttribute) 
	{
		Metadata meta = new Metadata();
		ApiResponse<TypeAttribute_Dto> response = new ApiResponse<TypeAttribute_Dto>(meta);
		
		/*
			Chequeos de valores
		*/
		Long typeId = newTypeAttribute.getTypeId();
		Long attributeId = newTypeAttribute.getAttributeId();
		
		if (checkAllValues(typeId, attributeId))
		{
			response.setResponse(typeAttribute_Service.createService(typeId, attributeId));
			if (response.getResponse() != null)
			{
				response.setMessage(MessageResult.Success);
			}
		}
		return response;
	}

	@Override
	@GetMapping(path = "/alltypeattributes")
	public ApiResponse<List<TypeAttribute_Dto>> readAll(TypeAttribute_Dto entity) 
	{
		Metadata meta = new Metadata();
		ApiResponse<List<TypeAttribute_Dto>> response = 
			new ApiResponse<List<TypeAttribute_Dto>>(meta);
		
		Long typeId = entity.getTypeId();
		Long attributeId = entity.getAttributeId();
		
		//¿Han llegado los dos ID relacionados?
		if (typeId != null && attributeId != null)
		{
			// Busco el registro por ambos ID
			response.setResponse(typeAttribute_Service.findOne(typeId, attributeId));
		}
		else // No han llegado los dos registros relacionados.
		{
			// ¿Faltan ambos ID?
			if (typeId == null && attributeId == null) 
			{
				// Busco todos los registros
				response.setResponse(typeAttribute_Service.findAll());
			}
			else // No han llegado ambos, tampoco faltan ambos
			{				
				// ¿el que ha llegado es el de Type?
				if (typeId != null)
				{
					// Busco por Type
					response.setResponse(typeAttribute_Service.findByTypeId(typeId));
				}
				
				// ¿El que ha llegado es el de attribute?
				if (attributeId != null)
				{
					// Busco por attribute
					response.setResponse(typeAttribute_Service.findByAttributeId(attributeId));
				}
			}
		}
		
		return response;
	}

	@Override
	@GetMapping(path = "/typeattribute")
	public ApiResponse<TypeAttribute_Dto> readOne(TypeAttribute_Dto readTypeAttribute) 
	{
		
		return null;
	}


	@Override
	@DeleteMapping(path = "/typeattribute")
	public ApiResponse<TypeAttribute_Dto> Delete(TypeAttribute_Dto deleteTypeAttribute) 
	{
		Metadata meta = new Metadata();
		ApiResponse<TypeAttribute_Dto> response = 
			new ApiResponse<TypeAttribute_Dto>(meta);
		
		
		if (deleteTypeAttribute.getTypeId() != null)
		{
			response.setResponse(typeAttribute_Service.deleteId(deleteTypeAttribute));
			
			if (response.getResponse() != null)
			{
				response.setMessage(MessageResult.Success);
			}
		}
		
		return response;
	}

	// Para este casom el update no tiene sentido
	@Override
	public ApiResponse<TypeAttribute_Dto> Update(TypeAttribute_Dto updateTypeAttribute) 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	private boolean checkAllValues(Long typeId, Long attributeId)
	{
		
		// Compruebo el Type:
		if (typeId != null)
		{
			if (type_Service.findBaseByIdService(typeId) == null)
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		
		if (attributeId != null)
		{
			if (attribute_Service.findBaseByIdService(attributeId) == null)
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		
		return true;
	}
}
