package com.stocktaking.ApiControllerInterface;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stocktaking.Entity_DTO.ProductAttribute_Dto;
import com.stocktaking.Response.ApiResponse;

@RequestMapping("/stocktaking")
public interface ProductAttribute_ControllerInterface 
{
	ApiResponse<ProductAttribute_Dto> create(@RequestBody ProductAttribute_Dto entity);
	ApiResponse<List<ProductAttribute_Dto>> readAll();
	ApiResponse<ProductAttribute_Dto> readOne(@RequestBody ProductAttribute_Dto entity);
	ApiResponse<ProductAttribute_Dto> Update(@RequestBody ProductAttribute_Dto entity);
	ApiResponse<ProductAttribute_Dto> Delete(@RequestBody ProductAttribute_Dto entity);
}
