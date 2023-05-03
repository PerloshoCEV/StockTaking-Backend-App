package com.stocktaking.ApiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stocktaking.ApiControllerInterface.Client_ControllerInterface;
import com.stocktaking.ApiService.Client_Service;
import com.stocktaking.EntityBBDD.T_Client;
import com.stocktaking.Entity_DTO.Client_Dto;
import com.stocktaking.Enum.MessageResult;
import com.stocktaking.Response.ApiResponse;
import com.stocktaking.Response.Metadata;

@RestController
public class Client_Controller implements Client_ControllerInterface
{
	@Autowired
	Client_Service clientService;

	public Client_Controller()
	{
		super();
	}
	
	@Override
	@PostMapping(path = "/client")
	public ApiResponse<Client_Dto> createEntityController(T_Client newClient) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Client_Dto> response = new ApiResponse<Client_Dto>(meta);
				
		if (newClient != null)
		{
			// Si no tiene id
			if(newClient.getId() == null)
			{
				response.setResponse(clientService.createBaseService(newClient));
				
				if (response.getResponse() != null)
				{
					response.setMessage(MessageResult.Success);
				}
			}
		}
		return response;
	}

	@Override
	@GetMapping(path = "/allclients")
	public ApiResponse<List<Client_Dto>> readAllEntityController() 
	{
		Metadata meta = new Metadata();
		ApiResponse<List<Client_Dto>> response = 
			new ApiResponse<List<Client_Dto>>
				(clientService.readBaseAllService(), meta);
		
		return response;
	}

	@Override
	@GetMapping(path = "/client")
	public ApiResponse<Client_Dto> readEntityIdController(Long id) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Client_Dto> response = new ApiResponse<Client_Dto>(meta);

		response.setResponse(clientService.findBaseByIdService(id));

		if (response.getResponse() != null)
		{
			response.setMessage(MessageResult.Success);
		}
		
		return response;
	}

	@PutMapping(path = "/client")
	@Override
	public ApiResponse<Client_Dto> updateEntityController(T_Client clientToModify) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Client_Dto> response = new ApiResponse<Client_Dto>(meta);
		
		response.setResponse(clientService.updateBase(clientToModify));
		
		if (response.getResponse() != null)
		{
			response.setMessage(MessageResult.Success);
		}
		
		return response;
	}

	@Override
	@DeleteMapping(path = "/client")
	public ApiResponse<Client_Dto> deleteEntityId(Long id) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Client_Dto> response = new ApiResponse<Client_Dto>(meta);
		
		
		if(id != null)
		{
			Client_Dto clientToDelete = clientService.findBaseByIdService(id);
				
			response.setResponse(clientService.deleteBaseId(clientToDelete));
			
			if (response.getResponse() != null)
			{
				response.setMessage(MessageResult.Success);
			}
		}
		return response;
	}
}
