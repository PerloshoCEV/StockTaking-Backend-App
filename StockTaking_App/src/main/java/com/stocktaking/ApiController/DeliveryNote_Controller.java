package com.stocktaking.ApiController;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stocktaking.ApiControllerInterface.DeliveryNote_ControllerInterface;
import com.stocktaking.Entity_DTO.DeliveryNote_Dto;
import com.stocktaking.Response.ApiResponse;

@RestController
public class DeliveryNote_Controller implements DeliveryNote_ControllerInterface
{

	@Override
	@PostMapping(path = "/deliverynote")
	public ApiResponse<DeliveryNote_Dto> create(DeliveryNote_Dto entity) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping(path = "/alldeliverynotes")
	public ApiResponse<List<DeliveryNote_Dto>> readAll() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping(path = "/deliverynote")
	public ApiResponse<DeliveryNote_Dto> readOne(DeliveryNote_Dto entity) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PutMapping(path = "/deliverynote")
	public ApiResponse<DeliveryNote_Dto> Update(DeliveryNote_Dto entity) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@DeleteMapping(path = "/deliverynote")
	public ApiResponse<DeliveryNote_Dto> Delete(DeliveryNote_Dto entity) 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
