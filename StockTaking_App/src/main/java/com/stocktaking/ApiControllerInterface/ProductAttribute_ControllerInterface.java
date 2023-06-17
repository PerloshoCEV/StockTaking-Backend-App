package com.stocktaking.ApiControllerInterface;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stocktaking.Entity_DTO.ProductAttribute_Dto;
import com.stocktaking.Response.ApiResponse;

@RequestMapping("/stocktaking")
public interface ProductAttribute_ControllerInterface 
{
	ApiResponse<ProductAttribute_Dto> create(@RequestBody ProductAttribute_Dto entity);
	ApiResponse<List<ProductAttribute_Dto>> readAll();
	ApiResponse<List<ProductAttribute_Dto>> readOneProduct(@RequestBody ProductAttribute_Dto entity);
	ApiResponse<List<ProductAttribute_Dto>> readOneProductAndroid(@RequestParam Long productId);
	ApiResponse<ProductAttribute_Dto> Update(@RequestBody ProductAttribute_Dto entity);
	ApiResponse<ProductAttribute_Dto> Delete(@RequestBody ProductAttribute_Dto entity);
}
