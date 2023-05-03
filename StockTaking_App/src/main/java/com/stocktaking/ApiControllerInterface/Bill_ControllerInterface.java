package com.stocktaking.ApiControllerInterface;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.stocktaking.Entity_DTO.Bill_Dto;
import com.stocktaking.Response.ApiResponse;

@RequestMapping("/stocktaking")
public interface Bill_ControllerInterface
{
	ApiResponse<Bill_Dto> create(@RequestBody Bill_Dto entity);
	ApiResponse<List<Bill_Dto>> readAll();
	ApiResponse<Bill_Dto> readOne(@RequestBody Bill_Dto entity);
	ApiResponse<Bill_Dto> Update(@RequestBody Bill_Dto entity);
	ApiResponse<Bill_Dto> Delete(@RequestBody Bill_Dto entity);
}
