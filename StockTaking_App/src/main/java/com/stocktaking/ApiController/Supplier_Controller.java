package com.stocktaking.ApiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stocktaking.ApiControllerInterface.Supplier_ControllerInterface;
import com.stocktaking.ApiService.Supplier_Service;
import com.stocktaking.EntityBBDD.T_Supplier;
import com.stocktaking.Entity_DTO.Supplier_Dto;
import com.stocktaking.Enum.MessageResult;
import com.stocktaking.Response.ApiResponse;
import com.stocktaking.Response.Metadata;

@RestController
public class Supplier_Controller implements Supplier_ControllerInterface
{
	@Autowired
	Supplier_Service supplierService;

	public Supplier_Controller()
	{
		super();
	}
	
	@Override
	@PostMapping(path = "/supplier")
	public ApiResponse<Supplier_Dto> createEntityController(T_Supplier newSupplier) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Supplier_Dto> response = new ApiResponse<Supplier_Dto>(meta);
				
		if (newSupplier != null)
		{
			// Si no tiene id
			if(newSupplier.getId() == null)
			{
				response.setResponse(supplierService.createBaseService(newSupplier));
				
				if (response.getResponse() != null)
				{
					response.setMessage(MessageResult.Success);
				}
			}
		}
		return response;
	}

	@Override
	@GetMapping(path = "/allsuppliers")
	public ApiResponse<List<Supplier_Dto>> readAllEntityController() 
	{
		Metadata meta = new Metadata();
		ApiResponse<List<Supplier_Dto>> response = 
			new ApiResponse<List<Supplier_Dto>>
				(supplierService.readBaseAllService(), meta);
		
		return response;
	}

	@Override
	@GetMapping(path = "/supplier")
	public ApiResponse<Supplier_Dto> readEntityIdController(Long id) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Supplier_Dto> response = new ApiResponse<Supplier_Dto>(meta);

		response.setResponse(supplierService.findBaseByIdService(id));

		if (response.getResponse() != null)
		{
			response.setMessage(MessageResult.Success);
		}
		
		return response;
	}

	@PutMapping(path = "/supplier")
	@Override
	public ApiResponse<Supplier_Dto> updateEntityController(T_Supplier supplierToModify) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Supplier_Dto> response = new ApiResponse<Supplier_Dto>(meta);
		
		response.setResponse(supplierService.updateBase(supplierToModify));
		
		if (response.getResponse() != null)
		{
			response.setMessage(MessageResult.Success);
		}
		
		return response;
	}

	@Override
	@DeleteMapping(path = "/supplier")
	public ApiResponse<Supplier_Dto> deleteEntityId(Long id) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Supplier_Dto> response = new ApiResponse<Supplier_Dto>(meta);
		
		
		if(id != null)
		{
			Supplier_Dto supplierToDelete = supplierService.findBaseByIdService(id);
				
			response.setResponse(supplierService.deleteBaseId(supplierToDelete));
			
			if (response.getResponse() != null)
			{
				response.setMessage(MessageResult.Success);
			}
		}
		return response;
	}
}
