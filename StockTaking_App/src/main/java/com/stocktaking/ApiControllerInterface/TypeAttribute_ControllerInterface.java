package com.stocktaking.ApiControllerInterface;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stocktaking.Entity_DTO.TypeAttribute_Dto;
import com.stocktaking.Response.ApiResponse;

@RequestMapping("/stocktaking")
public interface TypeAttribute_ControllerInterface
{
	ApiResponse<TypeAttribute_Dto> create(@RequestBody TypeAttribute_Dto entity);
	ApiResponse<List<TypeAttribute_Dto>> readAll(@RequestBody TypeAttribute_Dto entity);
	ApiResponse<List<TypeAttribute_Dto>> readAllAndroid(@RequestParam Long typeId, @RequestParam Long attributeId);
	ApiResponse<TypeAttribute_Dto> readOne(@RequestBody TypeAttribute_Dto entity);
	ApiResponse<TypeAttribute_Dto> readOneAndroid(@RequestParam Long typeId, @RequestParam Long attributeId);
	ApiResponse<TypeAttribute_Dto> Update(@RequestBody TypeAttribute_Dto entity);
	ApiResponse<TypeAttribute_Dto> Delete(@RequestBody TypeAttribute_Dto entity);

}
