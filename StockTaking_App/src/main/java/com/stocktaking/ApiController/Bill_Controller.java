package com.stocktaking.ApiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stocktaking.ApiControllerInterface.Bill_ControllerInterface;
import com.stocktaking.ApiService.Bill_Service;
import com.stocktaking.ApiService.Client_Service;
import com.stocktaking.ApiService.Product_Service;
import com.stocktaking.ApiService.Sale_Service;
import com.stocktaking.Entity_DTO.Bill_Dto;
import com.stocktaking.Enum.MessageResult;
import com.stocktaking.Response.ApiResponse;
import com.stocktaking.Response.Metadata;

@RestController
public class Bill_Controller implements Bill_ControllerInterface
{
	@Autowired
	Bill_Service bill_Service;
	@Autowired
	Sale_Service sale_Service;
	@Autowired
	Product_Service product_Service;
	@Autowired
	Client_Service client_Service;

	@Override
	@PostMapping(path = "/bill")
	public ApiResponse<Bill_Dto> create(Bill_Dto entity) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Bill_Dto> response = new ApiResponse<Bill_Dto>(meta);
		
		/*
			Chequeos de valores
		*/
		Long saleId = entity.getSaleId();
		Long productId = entity.getProductId();
		Long clientId = entity.getClientId();
		Integer quantity = entity.getQuantity();
		
		if (checkAllValues(saleId, productId, clientId))
		{
			response.setResponse(bill_Service.createService(saleId, productId, clientId, quantity));
			if (response.getResponse() != null)
			{
				response.setMessage(MessageResult.Success);
			}
		}
		return response;
	}



	@Override
	@GetMapping(path = "/allbills")
	public  ApiResponse<List<Bill_Dto>> readAll(Bill_Dto entity) 
	{
		Metadata meta = new Metadata();
		ApiResponse<List<Bill_Dto>> response = 
			new ApiResponse<List<Bill_Dto>>(meta);
		
		Long saleId = entity.getSaleId();
		Long productId = entity.getProductId();
		Long clientId = entity.getClientId();
		Integer quantity = entity.getQuantity();
		
		//¿Han llegado los 4 ID relacionados?
		if (saleId != null && productId != null && clientId != null && quantity != null)
		{
			// Busco el registro por los 4 ID
			response.setResponse(bill_Service.findOne(saleId, productId, clientId, quantity));
		}
		else // No han llegado los 4 registros relacionados.
		{
			// ¿Faltan los4 ID?
			if (saleId != null && productId != null && clientId != null && quantity != null) 
			{
				// Busco todos los registros
				response.setResponse(bill_Service.findAll());
			}
			else // No han llegado ambos, tampoco faltan ambos
			{				
				// ¿el que ha llegado es el de sale?
				if (saleId != null)
				{
					// Busco por sale
					response.setResponse(bill_Service.findBySaleId(saleId));
				}
				
				// ¿El que ha llegado es el de product?
				if (productId != null)
				{
					// Busco por product
					response.setResponse(bill_Service.findByProductId(productId));
				}
				// ¿El que ha llegado es el de client?
				if (clientId != null)
				{
					// Busco por client
					response.setResponse(bill_Service.findByClientId(clientId));
				}
				/*// ¿El que ha llegado es el de quantity?
				if (attributeId != null)
				{
					// Busco por quantity
					response.setResponse(bill_Service.findByAttributeId(attributeId));
				}*/
			}
		}
		
		return response;
	}
	
	@Override
	@GetMapping(path = "/bill")
	public ApiResponse<Bill_Dto> readOne(Bill_Dto readBill) 
	{
		return null;
	}

	@Override
	@PutMapping(path = "/bill")
	public ApiResponse<Bill_Dto> Update(Bill_Dto entity) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@DeleteMapping(path = "/bill")
	public ApiResponse<Bill_Dto> Delete(Bill_Dto entity) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Bill_Dto> response = 
			new ApiResponse<Bill_Dto>(meta);
		
		
		if (entity.getSaleId() != null)
		{
			response.setResponse(bill_Service.deleteId(entity));
			
			if (response.getResponse() != null)
			{
				response.setMessage(MessageResult.Success);
			}
		}
		
		return response;
	}
	
	private boolean checkAllValues(Long saleId, Long productId, Long clientId)
	{
		
		// Compruebo el Sale:
		if (saleId != null)
		{
			if (sale_Service.findBaseByIdService(saleId) == null)
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		
		// Compruebo el Product:
		if (productId != null)
		{
			if (product_Service.findBaseByIdService(productId) == null)
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		
		// Compruebo el Client:
		if (productId != null)
		{
			if (client_Service.findBaseByIdService(clientId) == null)
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		
		
		/* No se evalua el quantity
		 Compruebo el quantity:
		  if (quantity != null)
		{
			if (bill_Service.findBaseByIdService(quantity) == null)
			{
				return false;
			}
		}
		else
		{
			return false;
		}*/
		
		return true;
	}

}
