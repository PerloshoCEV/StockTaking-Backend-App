package com.stocktaking.ApiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stocktaking.ApiControllerInterface.Attribute_ControllerInterface;
import com.stocktaking.ApiService.Attribute_Service;
import com.stocktaking.EntityBBDD.T_Attribute;
import com.stocktaking.Entity_DTO.Attribute_Dto;
import com.stocktaking.Enum.MessageResult;
import com.stocktaking.Response.ApiResponse;
import com.stocktaking.Response.Metadata;

@RestController
public class Attribute_Controller implements Attribute_ControllerInterface
{
	@Autowired
	Attribute_Service attributeService;

	public Attribute_Controller()
	{
		super();
	}
	
	@Override
	@PostMapping(path = "/attribute")
	public ApiResponse<Attribute_Dto> createEntityController(T_Attribute newAttribute) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Attribute_Dto> response = new ApiResponse<Attribute_Dto>(meta);
				
		if (newAttribute != null)
		{
			// Si no tiene id
			if(newAttribute.getId() == null)
			{
				response.setResponse(attributeService.createBaseService(newAttribute));
				
				if (response.getResponse() != null)
				{
					response.setMessage(MessageResult.Success);
				}
			}
		}
		return response;
	}

	@Override
	@GetMapping(path = "/allattributes")
	public ApiResponse<List<Attribute_Dto>> readAllEntityController() 
	{
		Metadata meta = new Metadata();
		ApiResponse<List<Attribute_Dto>> response = 
			new ApiResponse<List<Attribute_Dto>>
				(attributeService.readBaseAllService(), meta);
		
		return response;
	}

	@Override
	@GetMapping(path = "/attribute")
	public ApiResponse<Attribute_Dto> readEntityIdController(Long id) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Attribute_Dto> response = new ApiResponse<Attribute_Dto>(meta);

		response.setResponse(attributeService.findBaseByIdService(id));

		if (response.getResponse() != null)
		{
			response.setMessage(MessageResult.Success);
		}
		
		return response;
	}

	@PutMapping(path = "/attribute")
	@Override
	public ApiResponse<Attribute_Dto> updateEntityController(T_Attribute attributeToModify) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Attribute_Dto> response = new ApiResponse<Attribute_Dto>(meta);
		
		response.setResponse(attributeService.updateBase(attributeToModify));
		
		if (response.getResponse() != null)
		{
			response.setMessage(MessageResult.Success);
		}
		
		return response;
	}

	@Override
	@DeleteMapping(path = "/attribute")
	public ApiResponse<Attribute_Dto> deleteEntityId(Long id) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Attribute_Dto> response = new ApiResponse<Attribute_Dto>(meta);
		
		
		if(id != null)
		{
			Attribute_Dto attributeToDelete = attributeService.findBaseByIdService(id);
				
			response.setResponse(attributeService.deleteBaseId(attributeToDelete));
			
			if (response.getResponse() != null)
			{
				response.setMessage(MessageResult.Success);
			}
		}
		return response;
	}
}
