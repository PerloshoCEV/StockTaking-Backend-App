package com.stocktaking.ApiControllerInterface;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stocktaking.Entity_DTO.DeliveryNote_Dto;
import com.stocktaking.Response.ApiResponse;

@RequestMapping("/stocktaking")
public interface DeliveryNote_ControllerInterface 
{
	ApiResponse<DeliveryNote_Dto> create(@RequestBody DeliveryNote_Dto entity);
	ApiResponse<List<DeliveryNote_Dto>> readAll();
	ApiResponse<DeliveryNote_Dto> readOne(@RequestBody DeliveryNote_Dto entity);
	ApiResponse<DeliveryNote_Dto> Update(@RequestBody DeliveryNote_Dto entity);
	ApiResponse<DeliveryNote_Dto> Delete(@RequestBody DeliveryNote_Dto entity);

}
