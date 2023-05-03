package com.stocktaking.ApiController;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.stocktaking.ApiControllerInterface.DeliveryNote_ControllerInterface;
import com.stocktaking.Entity_DTO.DeliveryNote_Dto;
import com.stocktaking.Response.ApiResponse;

@RestController
public class DeliveryNote_Controller implements DeliveryNote_ControllerInterface
{

	@Override
	public ApiResponse<DeliveryNote_Dto> create(DeliveryNote_Dto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse<List<DeliveryNote_Dto>> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse<DeliveryNote_Dto> readOne(DeliveryNote_Dto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse<DeliveryNote_Dto> Update(DeliveryNote_Dto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse<DeliveryNote_Dto> Delete(DeliveryNote_Dto entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
