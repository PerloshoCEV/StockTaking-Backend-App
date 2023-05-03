package com.stocktaking.ApiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stocktaking.ApiControllerInterface.Delivery_ControllerInterface;
import com.stocktaking.ApiService.Delivery_Service;
import com.stocktaking.EntityBBDD.T_Delivery;
import com.stocktaking.Entity_DTO.Delivery_Dto;
import com.stocktaking.Enum.MessageResult;
import com.stocktaking.Response.ApiResponse;
import com.stocktaking.Response.Metadata;

@RestController
public class Delivery_Controller implements Delivery_ControllerInterface
{
	@Autowired
	Delivery_Service deliveryService;

	public Delivery_Controller()
	{
		super();
	}
	
	@Override
	@PostMapping(path = "/delivery")
	public ApiResponse<Delivery_Dto> createEntityController(T_Delivery newDelivery) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Delivery_Dto> response = new ApiResponse<Delivery_Dto>(meta);
				
		if (newDelivery != null)
		{
			// Si no tiene id
			if(newDelivery.getId() == null)
			{
				response.setResponse(deliveryService.createBaseService(newDelivery));
				
				if (response.getResponse() != null)
				{
					response.setMessage(MessageResult.Success);
				}
			}
		}
		return response;
	}

	@Override
	@GetMapping(path = "/alldeliverys")
	public ApiResponse<List<Delivery_Dto>> readAllEntityController() 
	{
		Metadata meta = new Metadata();
		ApiResponse<List<Delivery_Dto>> response = 
			new ApiResponse<List<Delivery_Dto>>
				(deliveryService.readBaseAllService(), meta);
		
		return response;
	}

	@Override
	@GetMapping(path = "/delivery")
	public ApiResponse<Delivery_Dto> readEntityIdController(Long id) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Delivery_Dto> response = new ApiResponse<Delivery_Dto>(meta);

		response.setResponse(deliveryService.findBaseByIdService(id));

		if (response.getResponse() != null)
		{
			response.setMessage(MessageResult.Success);
		}
		
		return response;
	}

	@PutMapping(path = "/delivery")
	@Override
	public ApiResponse<Delivery_Dto> updateEntityController(T_Delivery deliveryToModify) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Delivery_Dto> response = new ApiResponse<Delivery_Dto>(meta);
		
		response.setResponse(deliveryService.updateBase(deliveryToModify));
		
		if (response.getResponse() != null)
		{
			response.setMessage(MessageResult.Success);
		}
		
		return response;
	}

	@Override
	@DeleteMapping(path = "/delivery")
	public ApiResponse<Delivery_Dto> deleteEntityId(Long id) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Delivery_Dto> response = new ApiResponse<Delivery_Dto>(meta);
		
		
		if(id != null)
		{
			Delivery_Dto deliveryToDelete = deliveryService.findBaseByIdService(id);
				
			response.setResponse(deliveryService.deleteBaseId(deliveryToDelete));
			
			if (response.getResponse() != null)
			{
				response.setMessage(MessageResult.Success);
			}
		}
		return response;
	}
}
