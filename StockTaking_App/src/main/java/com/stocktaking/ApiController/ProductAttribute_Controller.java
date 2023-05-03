package com.stocktaking.ApiController;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.stocktaking.ApiControllerInterface.ProductAttribute_ControllerInterface;
import com.stocktaking.Entity_DTO.ProductAttribute_Dto;
import com.stocktaking.Response.ApiResponse;

@RestController
public class ProductAttribute_Controller implements ProductAttribute_ControllerInterface
{

	@Override
	public ApiResponse<ProductAttribute_Dto> create(ProductAttribute_Dto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse<List<ProductAttribute_Dto>> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse<ProductAttribute_Dto> readOne(ProductAttribute_Dto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse<ProductAttribute_Dto> Update(ProductAttribute_Dto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse<ProductAttribute_Dto> Delete(ProductAttribute_Dto entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
