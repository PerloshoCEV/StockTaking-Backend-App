package com.stocktaking.ApiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.stocktaking.ApiControllerInterface.Bill_ControllerInterface;
import com.stocktaking.ApiService.Bill_Service;
import com.stocktaking.Entity_DTO.Bill_Dto;
import com.stocktaking.Response.ApiResponse;

@RestController
public class Bill_Controller implements Bill_ControllerInterface
{
	@Autowired
	Bill_Service billService;

	@Override
	public ApiResponse<Bill_Dto> create(Bill_Dto entity) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse<List<Bill_Dto>> readAll() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse<Bill_Dto> readOne(Bill_Dto entity) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse<Bill_Dto> Update(Bill_Dto entity) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse<Bill_Dto> Delete(Bill_Dto entity) 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
