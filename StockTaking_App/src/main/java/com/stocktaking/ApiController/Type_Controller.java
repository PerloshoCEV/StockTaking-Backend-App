package com.stocktaking.ApiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stocktaking.ApiControllerInterface.Type_ControllerInterface;
import com.stocktaking.ApiService.Type_Service;
import com.stocktaking.EntityBBDD.T_Type;
import com.stocktaking.Entity_DTO.Type_Dto;
import com.stocktaking.Enum.MessageResult;
import com.stocktaking.Response.ApiResponse;
import com.stocktaking.Response.Metadata;

@RestController
public class Type_Controller implements Type_ControllerInterface
{
	@Autowired
	Type_Service typeService;

	public Type_Controller()
	{
		super();
	}
	
	@Override
	@PostMapping(path = "/type")
	public ApiResponse<Type_Dto> createEntityController(T_Type newType) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Type_Dto> response = new ApiResponse<Type_Dto>(meta);
				
		if (newType != null)
		{
			// Si no tiene id
			if(newType.getId() == null)
			{
				response.setResponse(typeService.createBaseService(newType));
				
				if (response.getResponse() != null)
				{
					response.setMessage(MessageResult.Success);
				}
			}
		}
		return response;
	}

	@Override
	@GetMapping(path = "/alltypes")
	public ApiResponse<List<Type_Dto>> readAllEntityController() 
	{
		Metadata meta = new Metadata();
		ApiResponse<List<Type_Dto>> response = 
			new ApiResponse<List<Type_Dto>>
				(typeService.readBaseAllService(), meta);
		
		return response;
	}

	@Override
	@GetMapping(path = "/type")
	public ApiResponse<Type_Dto> readEntityIdController(Long id) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Type_Dto> response = new ApiResponse<Type_Dto>(meta);

		response.setResponse(typeService.findBaseByIdService(id));

		if (response.getResponse() != null)
		{
			response.setMessage(MessageResult.Success);
		}
		
		return response;
	}

	@PutMapping(path = "/type")
	@Override
	public ApiResponse<Type_Dto> updateEntityController(T_Type typeToModify) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Type_Dto> response = new ApiResponse<Type_Dto>(meta);
		
		response.setResponse(typeService.updateBase(typeToModify));
		
		if (response.getResponse() != null)
		{
			response.setMessage(MessageResult.Success);
		}
		
		return response;
	}

	@Override
	@DeleteMapping(path = "/type")
	public ApiResponse<Type_Dto> deleteEntityId(Long id) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Type_Dto> response = new ApiResponse<Type_Dto>(meta);
		
		
		if(id != null)
		{
			Type_Dto typeToDelete = typeService.findBaseByIdService(id);
				
			response.setResponse(typeService.deleteBaseId(typeToDelete));
			
			if (response.getResponse() != null)
			{
				response.setMessage(MessageResult.Success);
			}
		}
		return response;
	}
}
