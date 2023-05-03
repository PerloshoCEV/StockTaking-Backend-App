package com.stocktaking.ApiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stocktaking.ApiControllerInterface.Sale_ControllerInterface;
import com.stocktaking.ApiService.Sale_Service;
import com.stocktaking.EntityBBDD.T_Sale;
import com.stocktaking.Entity_DTO.Sale_Dto;
import com.stocktaking.Enum.MessageResult;
import com.stocktaking.Response.ApiResponse;
import com.stocktaking.Response.Metadata;

@RestController
public class Sale_Controller implements Sale_ControllerInterface
{
	@Autowired
	Sale_Service saleService;

	public Sale_Controller()
	{
		super();
	}
	
	@Override
	@PostMapping(path = "/sale")
	public ApiResponse<Sale_Dto> createEntityController(T_Sale newSale) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Sale_Dto> response = new ApiResponse<Sale_Dto>(meta);
				
		if (newSale != null)
		{
			// Si no tiene id
			if(newSale.getId() == null)
			{
				response.setResponse(saleService.createBaseService(newSale));
				
				if (response.getResponse() != null)
				{
					response.setMessage(MessageResult.Success);
				}
			}
		}
		return response;
	}

	@Override
	@GetMapping(path = "/allsales")
	public ApiResponse<List<Sale_Dto>> readAllEntityController() 
	{
		Metadata meta = new Metadata();
		ApiResponse<List<Sale_Dto>> response = 
			new ApiResponse<List<Sale_Dto>>
				(saleService.readBaseAllService(), meta);
		
		return response;
	}

	@Override
	@GetMapping(path = "/sale")
	public ApiResponse<Sale_Dto> readEntityIdController(Long id) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Sale_Dto> response = new ApiResponse<Sale_Dto>(meta);

		response.setResponse(saleService.findBaseByIdService(id));

		if (response.getResponse() != null)
		{
			response.setMessage(MessageResult.Success);
		}
		
		return response;
	}

	@PutMapping(path = "/sale")
	@Override
	public ApiResponse<Sale_Dto> updateEntityController(T_Sale saleToModify) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Sale_Dto> response = new ApiResponse<Sale_Dto>(meta);
		
		response.setResponse(saleService.updateBase(saleToModify));
		
		if (response.getResponse() != null)
		{
			response.setMessage(MessageResult.Success);
		}
		
		return response;
	}

	@Override
	@DeleteMapping(path = "/sale")
	public ApiResponse<Sale_Dto> deleteEntityId(Long id) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Sale_Dto> response = new ApiResponse<Sale_Dto>(meta);
		
		
		if(id != null)
		{
			Sale_Dto saleToDelete = saleService.findBaseByIdService(id);
				
			response.setResponse(saleService.deleteBaseId(saleToDelete));
			
			if (response.getResponse() != null)
			{
				response.setMessage(MessageResult.Success);
			}
		}
		return response;
	}
}
